package gov.va.oit.vistaevolution.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ReflectionTest {
	private static final Logger logger = Logger.getLogger(ReflectionTest.class);

	@Test
	@SuppressWarnings("rawtypes")
	public void x() throws ClassNotFoundException, IOException {
		String packageName = "gov.va.oit.vistaevolution";
		Class[] clz = getClasses(packageName);

		for (Class aClass : clz) {
			String className = aClass.getName();
			// skip unit and integration tests
			if (className.endsWith("IT") || className.endsWith("Test")) {
				continue;
			}
			
			if (aClass.isInterface()) {
				continue;
			}
			Method[] methods = aClass.getMethods();

			// invoke getter/setter methods
			Object t;
			try {
				t = aClass.newInstance();
				for (Method m : methods) {
					if (m.getName().startsWith("get")) {
						Object o = m.invoke(t);
					} else if (m.getName().startsWith("set")) {
						Class[] parameterTypes = m.getParameterTypes();
						List<Object> args = new ArrayList<Object>();
						for (Class pt : parameterTypes) {
							Class<?> c = Class.forName(pt.getName());
							Object cl = invokeConstructor(c, null);
							args.add(cl);
						}
						Object o = m.invoke(t, args.toArray());
					}
				}
			} catch (InstantiationException e) {
				logger.error(e);
			} catch (IllegalAccessException e) {
				logger.error(e);
			} catch (IllegalArgumentException e) {
				logger.error(e);
			} catch (InvocationTargetException e) {
				logger.error(e);
			} catch (Exception e) {
				logger.error(e);
			}

		}
	}

	@SuppressWarnings("unused")
	public void testPojos() throws ClassNotFoundException {
		// Prepare.
		String packageName = "gov.va.oit.vistaevolution";
		findPackageNamesStartingWith(packageName);

		URL root = Thread.currentThread().getContextClassLoader()
				.getResource(packageName.replace(".", "/"));

		// Filter .class files.
		File[] files = new File(root.getFile()).listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".class");
			}
		});

		// Find classes implementing ICommand.
		for (File file : files) {
			String className = file.getName().replaceAll(".class$", "");
			Class<?> cls = Class.forName(packageName + "." + className);
		}
	}

	private List<String> findPackageNamesStartingWith(String prefix) {
		List<String> result = new ArrayList<String>();
		for (Package p : Package.getPackages()) {
			if (p.getName().startsWith(prefix)) {
				result.add(p.getName());
			}
		}
		return result;
	}

	/**
	 * Scans all classes accessible from the context class loader which belong
	 * to the given package and subpackages.
	 * 
	 * @param packageName
	 *            The base package
	 * @return The classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	private static Class[] getClasses(String packageName)
			throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes.toArray(new Class[classes.size()]);
	}

	/**
	 * Recursive method used to find all classes in a given directory and
	 * subdirs.
	 * 
	 * @param directory
	 *            The base directory
	 * @param packageName
	 *            The package name for classes found inside the base directory
	 * @return The classes
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	private static List<Class> findClasses(File directory, String packageName)
			throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file,
						packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName
						+ '.'
						+ file.getName().substring(0,
								file.getName().length() - 6)));
			}
		}
		return classes;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private Object invokeConstructor(Class c, Object[] args) {
		try {
			if (c.getName().equalsIgnoreCase("java.util.List")) {
				return new ArrayList<String>();
			}
			
			Constructor[] allctors = c.getConstructors();
			ArrayList ctors = new ArrayList();
			for (int i = 0; i < allctors.length; i++) {
				Constructor ctor = allctors[i];
				if (args == null || ctor.getParameterTypes().length == args.length) {
					ctors.add(ctor);
				}
			}

			if (ctors.isEmpty()) {
				throw new IllegalArgumentException("No matching ctor found"
						+ " for " + c);
			} else if (ctors.size() == 1) {
				Constructor ctor = (Constructor) ctors.get(0);
				return ctor
						.newInstance(boxArgs(ctor.getParameterTypes(), args));
			} else // overloaded w/same arity
			{
				for (Iterator iterator = ctors.iterator(); iterator.hasNext();) {
					Constructor ctor = (Constructor) iterator.next();
					Class[] params = ctor.getParameterTypes();
					if (isCongruent(params, args)) {
						Object[] boxedArgs = boxArgs(params, args);
						return ctor.newInstance(boxedArgs);
					}
				}

				throw new IllegalArgumentException("No matching ctor found"
						+ " for " + c);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	@SuppressWarnings("rawtypes") 
	static Object boxArg(Class paramType, Object arg) {
		if (!paramType.isPrimitive())
			return paramType.cast(arg);
		else if (paramType == boolean.class)
			return Boolean.class.cast(arg);
		else if (paramType == char.class)
			return Character.class.cast(arg);
		else if (arg instanceof Number) {
			Number n = (Number) arg;
			if (paramType == int.class)
				return n.intValue();
			else if (paramType == float.class)
				return n.floatValue();
			else if (paramType == double.class)
				return n.doubleValue();
			else if (paramType == long.class)
				return n.longValue();
			else if (paramType == short.class)
				return n.shortValue();
			else if (paramType == byte.class)
				return n.byteValue();
		}
		throw new IllegalArgumentException("Unexpected param type, expected: "
				+ paramType + ", given: " + arg.getClass().getName());
	}

	@SuppressWarnings("rawtypes")
	static Object[] boxArgs(Class[] params, Object[] args) {
		if (params.length == 0)
			return null;
		Object[] ret = new Object[params.length];
		for (int i = 0; i < params.length; i++) {
			Object arg = args[i];
			Class paramType = params[i];
			ret[i] = boxArg(paramType, arg);
		}
		return ret;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" }) 
	static public boolean paramArgTypeMatch(Class paramType, Class argType){
		if(argType == null)
			return !paramType.isPrimitive();
		if(paramType == argType || paramType.isAssignableFrom(argType))
			return true;
		if(paramType == int.class)
			return argType == Integer.class
			       || argType == long.class
					|| argType == Long.class
					|| argType == short.class
					|| argType == byte.class;// || argType == FixNum.class;
		else if(paramType == float.class)
			return argType == Float.class
					|| argType == double.class;
		else if(paramType == double.class)
			return argType == Double.class
					|| argType == float.class;// || argType == DoubleNum.class;
		else if(paramType == long.class)
			return argType == Long.class
					|| argType == int.class
					|| argType == short.class
					|| argType == byte.class;// || argType == BigNum.class;
		else if(paramType == char.class)
			return argType == Character.class;
		else if(paramType == short.class)
			return argType == Short.class;
		else if(paramType == byte.class)
			return argType == Byte.class;
		else if(paramType == boolean.class)
			return argType == Boolean.class;
		return false;
	}
	
	@SuppressWarnings("rawtypes") 
	static boolean isCongruent(Class[] params, Object[] args){
		boolean ret = false;
		if(args == null)
			return params.length == 0;
		if(params.length == args.length)
			{
			ret = true;
			for(int i = 0; ret && i < params.length; i++)
				{
				Object arg = args[i];
				Class argType = (arg == null) ? null : arg.getClass();
				Class paramType = params[i];
				ret = paramArgTypeMatch(paramType, argType);
				}
			}
		return ret;
	}
}

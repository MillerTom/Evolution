package gov.va.oit.vistaevolution.utils.vistalink;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URL;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Service;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public abstract class EvolutionIT<T> {
	private static Logger logger = Logger.getLogger(EvolutionIT.class);

	private static final String EVO_URL_PROPERTY = "evo.url";

	protected T service;

	protected abstract Class<T> getType();

	protected static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		if (System.getProperty(EVO_URL_PROPERTY) == null) {
			if (System.getProperty("java.security.auth.login.config") == null) {
				System.setProperty("java.security.auth.login.config",
						"file:src/test/resources/jaas.config");
			}
			applicationContext = new ClassPathXmlApplicationContext(
					"/applicationContext.xml");
		}
	}


	@Before
	public void before() {

		try {
			service = getEndpointImpl(getType());
		} catch (Exception e) {
			logger.error(e);
			fail();
		}
	}

	/**
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	protected <E> E getEndpointImpl(Class<E> clazz) throws Exception {
		if (System.getProperty(EVO_URL_PROPERTY) != null) {
			URL url = null;
			try {

				WebService webService = clazz.getAnnotation(
						WebService.class);

				String serviceName = webService.name() + "Service";

				String wsdlUrl = System.getProperty(EVO_URL_PROPERTY)
						+ serviceName + "?wsdl";

				logger.debug("wsdlUrl=" + wsdlUrl);

				url = new URL(wsdlUrl);
				QName qname = getQname(url);
				Service myService = Service.create(url, qname);
				return (E) myService.getPort(clazz);

			} catch (Exception e) {
				logger.error(e);
				throw e;
			}
		} else {
			return (E) applicationContext.getBean(clazz);
		}
	}
	
	
	/**
	 * @param url
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private static QName getQname(URL url)
			throws ParserConfigurationException, SAXException, IOException {
		String serviceName = getServiceNameFromWsdlUrl(url);
		String nameSpace = getServiceNamespaceFromWsdlUrl(url);
		QName qname = new QName(nameSpace, serviceName);
		return qname;
	}

	/**
	 * @param url
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private static String getServiceNameFromWsdlUrl(URL url)
			throws ParserConfigurationException, SAXException, IOException {
		String attributeName = "name";
		String tagName = "service";
		return getAttributeValueForTagNameFromWsdlURL(url, attributeName,
				tagName);
	}

	/**
	 * @param url
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private static String getServiceNamespaceFromWsdlUrl(URL url)
			throws ParserConfigurationException, SAXException, IOException {
		String attributeName = "xmlns:tns";
		String tagName = "definitions";
		return getAttributeValueForTagNameFromWsdlURL(url, attributeName,
				tagName);
	}

	/**
	 * @param url
	 * @param attributeName
	 * @param tagName
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private static String getAttributeValueForTagNameFromWsdlURL(URL url,
			String attributeName, String tagName)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(url.openStream());
		NodeList serviceTags = doc.getElementsByTagName(tagName);
		NamedNodeMap attributes = serviceTags.item(0).getAttributes();
		Node attribute = attributes.getNamedItem(attributeName);
		return attribute.getTextContent();

	}
}
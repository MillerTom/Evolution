package gov.va.oit.vistaevolution.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@SuppressWarnings("rawtypes")
public class StrUtils {

	public static boolean hasNoValue(String s) { 
		if(s == null || s.equals("")) 
			return true;
		else
			return false;
	}
	
	public static boolean hasAValue(String s) { 
		return !hasNoValue(s);
	}
	public static String join(List<?> lst, String delimiter) { 
		return getDelimitedStringFromList(lst, delimiter);
	}
	public static String getDelimitedStringFromList(List<?> lst, String delimiter) { 
		
		String retString = "";
		if(lst !=null)  { 
			if(lst.size() > 1) { 
				// StringBuffer a little slower but synchronized and thread safe
				StringBuffer sb = new StringBuffer();
				for(Object o : lst) { 
					sb.append(o.toString());
					sb.append(delimiter);
				}
				retString = sb.toString().substring(0, sb.length()-1);
			}else { 
				retString = lst.get(0).toString();
			}
		}
		return retString;
	}
	
	public static String listToString(List lstToDisplay) { 
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		if(lstToDisplay != null && !lstToDisplay.isEmpty()) { 
			int inx = 0;
			sb.append("\n");

			for(Object o : lstToDisplay) { 
				sb.append("Element " + inx++ + ": " +  o.toString() + "\n");
			}
		}else { 
			sb.append("no data in list\n");
		}
		
		return sb.toString();
	}
	
	public static String mapToString(Map hmToDisplay) { 
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		if(hmToDisplay != null && !hmToDisplay.isEmpty()) { 
			int inx = 0;
			sb.append("\n");
			String key;
			while( (key = (String) hmToDisplay.keySet().iterator().next()) != null) { 
				sb.append("Entry " + inx++ + ": key = " +  key + ", value = " + hmToDisplay.get(key) + "\n");
			}
		}else { 
			sb.append("no data in Map\n");
		}
		
		return sb.toString();
	}
	
	public static ArrayList<String> stringtoList(String rawString, String delimiter) throws StrUtilsException { 
		ArrayList<String> returnAry = new ArrayList<String>();
		String[] strgs = rawString.split(delimiter);
		if(strgs != null && strgs.length > 0){
			for(String strg:strgs){
				returnAry.add(strg);
			}
		}
		return returnAry;
	}
	
	public static boolean equalsOneOfThese(String s, List<String> items) { 
		
		if(hasAValue(s)) { 
			s = s.trim();
			if(items.contains(s)) { 
				return true; // single value
			}else {
				
				for(String ss : s.split("\\.")) { 
					if(items.contains(ss)) { 
						continue;
					}else { 
						return false;
					}
				}
				return true;
			}
			
		}else { return false;}
	}

}

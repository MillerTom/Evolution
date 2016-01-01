package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;


/**
 * 
 * @author bill.blackmon <bill.blackmon@medsphere.com>
 * 
 * Attempt to combine encode/decodetoHtmlDILFEndpoint interfaces and 
 * implementational classes
 * 
 * 
**/


@WebService(name = "DDR5HTMLRService", targetNamespace = "http://vistaevolution.va.gov")
public interface HTMLDILFEndPoint {
	
	
	
	/**
	 * HTML Encoder: Encodes caret ("^") and ampersands ("&") for use in HTML.
	 * 
	 * @param input
	 *            String with caret or ampersand values.
	 */
	@WebMethod(action="EncodeFromHTMLDILFAction" ,operationName="EncodeFromHTMLDILF")
	@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED)
	public String encodeToHTML(@WebParam(name = "inputString") String input);
	
	
	
	/**
	 * HTML Decodes: Decodes caret ("&#94;") and ampersands ("&amp;") from HTML.
	 * 
	 * @param input
	 *            String with caret or ampersand values.
	 */
	@WebMethod(action="DecodeFromHTMLDILFAction" ,operationName="DecodeFromHTMLDILF")
	@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED)
	public String decodeFromHTML(@WebParam(name = "inputString") String input);
	
	
	

}

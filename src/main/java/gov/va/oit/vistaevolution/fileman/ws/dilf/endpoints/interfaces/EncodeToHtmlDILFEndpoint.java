/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 *
 */
@WebService(name = "EncodeToHtmlDILF", targetNamespace = "http://vistaevolution.va.gov")
public interface EncodeToHtmlDILFEndpoint {
	/**
	 * HTML Encoder: Encodes caret ("^") and ampersands ("&") for use in HTML.
	 * 
	 * @param input
	 *            String with caret or ampersand values.
	 */
	@WebMethod(action="EncodeFromHTMLDILFAction" ,operationName="EncodeFromHTMLDILF")
	@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED)
	public String encodeToHTML(@WebParam(name = "inputString") String input);
}

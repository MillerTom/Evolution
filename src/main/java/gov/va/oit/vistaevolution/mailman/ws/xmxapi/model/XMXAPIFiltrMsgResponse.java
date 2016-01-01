/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/* XMWSOA FLTRMSGM
 * 
 * This RPC filters messages in a basket.
 * 
 *  NOTE: Only the user or a surrogate can use this API.
 *  
 *  Input Parameters
 * 
 *  DUZ		(Required) String - User's DUZ
 *  XMDUZ   (Required) String -The user (DUZ or name) whose messages are to be filtered.
 *  XMKZA   (Required) List - Identifies messages, using a list array of
 *  						  message numbers (xmz) in the MESSAGE file (#3.9) (xmk must not be
 *  						  specified and ranges are not allowed):
 *  
 *  							List array: ARRAY(1234567)=""
 *  				                        ARRAY(9763213)=""
 *  
 *  Returns (String):
 *  		
 *  <number of messages> filtered or
 *  -1^[error text]
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIFiltrMsgResponse {
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMXAPIFiltrMsgResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMXAPIFiltrMsgResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}

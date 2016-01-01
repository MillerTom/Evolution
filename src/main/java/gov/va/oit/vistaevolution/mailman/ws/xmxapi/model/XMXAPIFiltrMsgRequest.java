/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
public class XMXAPIFiltrMsgRequest {

	@XmlElement(required = true)
	private String duz;
	@XmlElement(required = true)
	private String xmDuz;

	
	private HashMap <String, String> xmkzas;


	/**
	 * @return the duz
	 */
	public String getDuz() {
		return duz;
	}

	/**
	 * @param duz the duz to set
	 */
	public void setDuz(String duz) {
		this.duz = duz;
	}

	/**
	 * @return the xmDuz
	 */
	public String getXmDuz() {
		return xmDuz;
	}

	/**
	 * @param xmDuz the xmDuz to set
	 */
	public void setXmDuz(String xmDuz) {
		this.xmDuz = xmDuz;
	}

	/**
	 * @return the xmkzas
	 */
	@XmlElementWrapper(name = "xmkzas", required = true)
	public HashMap <String, String> getXmkzas() {
		return xmkzas;
	}

	/**
	 * @param xmys the xmkzas to set
	 */
	public void setXmkzas(HashMap <String, String> xmkzas) {
		this.xmkzas = xmkzas;
	}

	public XMXAPIFiltrMsgRequest() {
		super();
	}

	public XMXAPIFiltrMsgRequest(String duz, String xmDuz, HashMap <String, String> xmkzas) {
		super();
		this.duz = duz;
		this.xmDuz = xmDuz;
		this.xmkzas = xmkzas;
	}
}

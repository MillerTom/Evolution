/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSRB1EncrypResponse {

	
	/**
	 * XU SOA ENCRYP
	 * 
	 * Kernel and the RPC Broker provide encryption functions that can be used to
	 * encrypt messages sent between the client and the server.
	 * 
	 * 
	 * Input Variables	
	 * 		st1:	(required) The string that needs to be encrypted.
	 * 
	 * Response
	 * 		Returns  Encrypted string.
	 *		
	 */
	@XmlElement(required = true)
	private String data;

	public XUSRB1EncrypResponse() {
		super();
	}

	public XUSRB1EncrypResponse(String data) {
		super();
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

}

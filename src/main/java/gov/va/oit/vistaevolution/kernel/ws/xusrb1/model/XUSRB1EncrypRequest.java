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

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSRB1EncrypRequest {

	@XmlElement(required = true)
	private String st1;

	public XUSRB1EncrypRequest() {
		super();
	}

	public XUSRB1EncrypRequest(String st1) {
		super();
		this.st1 = st1;
	}

	/**
	 * @return the st1
	 */
	public String getSt1() {
		return st1;
	}

	/**
	 * @param st1 the st1 to set
	 */
	public void setSt1(String st1) {
		this.st1 = st1;
	}


}

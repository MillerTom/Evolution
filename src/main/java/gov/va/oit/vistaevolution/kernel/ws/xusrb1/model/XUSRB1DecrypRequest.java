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
 * XU SOA DECRYP
 * 
 * Decrypts a string that was encrypted on a Client system. Kernal/RPC
 * Broker function.
 * 
 * 
 * Input Variables	
 * 		st1:	(required) The encrypted string that needs to be decrypted.
 * 
 * Response
 * 		Returns  Decrypted string.
 *		
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSRB1DecrypRequest {

	@XmlElement(required = true)
	private String st1;

	public XUSRB1DecrypRequest() {
		super();
	}

	public XUSRB1DecrypRequest(String st1) {
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

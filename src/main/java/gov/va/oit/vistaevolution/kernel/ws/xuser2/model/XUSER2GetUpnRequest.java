/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/**
 * XUS PKI GET UPN
 * 
 * This RPC gets the SUBJECT ALTERNATIVE NAME field from the New Person (#200) 
 * file field 501.2.  It is used to check that the correct PIV card has been 
 * put into the reader. 
 * 
 * Input Parameters:
 *   None
 * 
 * Returns:
 *   String Subject Alternative Name field
 *   
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSER2GetUpnRequest {
	
	@XmlElement(required = true)
	private String duz;

	public XUSER2GetUpnRequest() {
		super();
	}
	
	public XUSER2GetUpnRequest(String duz) {
		super();
		this.duz = duz;
	}

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
	
	
	
}

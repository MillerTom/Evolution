/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xustzip.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/**
 * 
 * XU SOA LKCHECK
 *
 *  This agreement allows the VistaLink package to use routine XUSTZIP
 *  to perform checks on Kernel IP/device locking during the VistaLink
 *  reauthentication process, which includes support for the login
 *  capabilities of FatKAAT and KAAJEE.
 *   
 * Input Parameters
 * 		LKCHECK1		(Required) IP Address
 * 
 * Response
 * 		Result on failure returns the FileMan date/time
 * 		that the IP address should be locked until.
 * 		
 * 		Result on success returns 0.
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSTZIPLkCheckRequest {

	@XmlElement(required = true)
	private String lcheck1;

	public XUSTZIPLkCheckRequest() {
		super();
	}

	public XUSTZIPLkCheckRequest(String lcheck1) {
		super();
		this.lcheck1 = lcheck1;
	}

	/**
	 * @return the lcheck1
	 */
	public String getLcheck1() {
		return lcheck1;
	}

	/**
	 * @param lcheck1 the lcheck1 to set
	 */
	public void setLcheck1(String lcheck1) {
		this.lcheck1 = lcheck1;
	}

}

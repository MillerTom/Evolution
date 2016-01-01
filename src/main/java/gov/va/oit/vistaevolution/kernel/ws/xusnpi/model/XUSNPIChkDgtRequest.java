/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/**
 * XU SOA CHKDGT
 * 
 * This RPC call is used to validate the format of an NPI number, checking the length
 * and if numeric. Also whether the check digit is valid.
 * 
 *  
 * Input Variables	
 * 	XUSNPI1:	(required) The National Provider Identifier.
 * 
 * Response
 * 		If check digit is valid 1, else 0.
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSNPIChkDgtRequest {

	@XmlElement(required = true)
	private String xusNpi;

	public XUSNPIChkDgtRequest() {
		super();
	}

	public XUSNPIChkDgtRequest(String xusNpi) {
		super();
		this.xusNpi = xusNpi;
	}

	/**
	 * @return the xusNpi
	 */
	public String getXusNpi() {
		return xusNpi;
	}

	/**
	 * @param xusNpi the xusNpi to set
	 */
	public void setXusNpi(String xusNpi) {
		this.xusNpi = xusNpi;
	}


}

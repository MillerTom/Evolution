package gov.va.oit.vistaevolution.kernel.ws.xusrb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Request Object for the Check Access\Verify Code. 
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSRBCheckAVRequest {

	/**Access/Verify Code separated by a semi-colon.*/
	@XmlElement(name = "access-verify-code", required = true)
	private String avCode;

	/**
	 * Default Empty Constructor
	 */
	public XUSRBCheckAVRequest() {
		super();
	}

	/**
	 * 
	 * Parameterized Constructor
	 * 
	 * @param avCode
	 */
	public XUSRBCheckAVRequest(String avCode) {
		super();
		this.avCode = avCode;
	}

	/**
	 * @return the avCode
	 */
	public String getAvCode() {
		return avCode;
	}

	/**
	 * @param avCode the avCode to set
	 */
	public void setAvCode(String avCode) {
		this.avCode = avCode;
	}

	

}

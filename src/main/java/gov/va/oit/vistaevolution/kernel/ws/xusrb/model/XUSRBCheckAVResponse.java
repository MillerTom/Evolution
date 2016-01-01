package gov.va.oit.vistaevolution.kernel.ws.xusrb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Return object for Check Access\Verify Codes
 * If a code pair can be validated an IEN (Internal Entry Number).
 * Should it fail, it will return a "0"
 * 
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSRBCheckAVResponse {

	@XmlElement(name = "return", required = false)
	private String ret;

	/**
	 * Default Empty Constructor
	 */
	public XUSRBCheckAVResponse() {
		super();
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param ret
	 */
	public XUSRBCheckAVResponse(String ret) {
		super();
		this.ret = ret;
	}

	/**
	 * @return the ret
	 */
	public String getRet() {
		return ret;
	}

	/**
	 * @param ret the ret to set
	 */
	public void setRet(String ret) {
		this.ret = ret;
	}

	
}

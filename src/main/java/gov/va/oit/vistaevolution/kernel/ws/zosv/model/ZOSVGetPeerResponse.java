/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.zosv.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ZOSVGetPeerResponse {

	@XmlElement(name = "return", required = false)
	private String ret;
	
	public ZOSVGetPeerResponse() { 
		super();
	}

	public ZOSVGetPeerResponse(String ret) {
		super();
		this.ret = ret;
	}

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	@Override
	public String toString() {
		return "ZOSVGetPeerResponse [toString()=" + super.toString() + "]";
	}
	
	
}

/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.zosv.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ZOSVGetPeerRequest {

	public ZOSVGetPeerRequest() {
		super();
	}

	@Override
	public String toString() {
		return "ZOSVGetPeerRequest [toString()=" + super.toString() + "]";
	}
	
}

/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusbse1.model;

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
public class XUSBSE1GetVisitRequest{
	
	@XmlElement(name="token", required = true)
	private String token;

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "XUSBSE1GetVisitRequest [toString()=" + super.toString() + "]";
	}

}

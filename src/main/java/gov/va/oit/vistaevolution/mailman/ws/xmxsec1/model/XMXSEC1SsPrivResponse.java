/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1SsPrivResponse {
	
	@XmlElement(name = "flag", required = true)
	private String flag;

	public XMXSEC1SsPrivResponse() {
		super();
	}

	public XMXSEC1SsPrivResponse(String flag) {
		super();
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}

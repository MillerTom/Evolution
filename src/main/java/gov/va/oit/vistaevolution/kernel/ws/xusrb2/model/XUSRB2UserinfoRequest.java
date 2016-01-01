/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSRB2UserinfoRequest {

	@XmlElementWrapper(name = "userinfo")
	@XmlElement(name = "field", required = true)
	private List<String> ret;

	public XUSRB2UserinfoRequest() {
		super();
	}

	public XUSRB2UserinfoRequest(List<String> ret) {
		super();
		this.ret = ret;
	}

	public List<String> getRet() {
		return ret;
	}

	public void setRet(List<String> ret) {
		this.ret = ret;
	}
	
}

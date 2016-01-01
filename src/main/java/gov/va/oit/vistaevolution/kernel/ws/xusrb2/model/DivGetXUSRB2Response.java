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
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DivGetXUSRB2Response {

	@XmlElementWrapper(name = "divInfo")
	@XmlElement(name = "field", required = false)
	private List<String> ret;
	
	public DivGetXUSRB2Response() {
		super();
	}

	public DivGetXUSRB2Response(List<String> ret) {
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

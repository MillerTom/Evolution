/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.model;

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
public class XMXEDITTextRequest {

	@XmlElement(required = true)
	private String xmz;
	
    @XmlElementWrapper(name = "xmbody")
    @XmlElement(name = "xmbody-param", required = false)
	private List<String> xmbody;
	
	public XMXEDITTextRequest() {
		super();
	}

	public XMXEDITTextRequest(String xmz, List<String> xmbody) {
		super();
		this.xmz = xmz;
		this.xmbody = xmbody;
	}

	public String getXmz() {
		return xmz;
	}

	public void setXmz(String xmz) {
		this.xmz = xmz;
	}

	public List<String> getXmbody() {
		return xmbody;
	}

	public void setXmbody(List<String> xmbody) {
		this.xmbody = xmbody;
	}
	
}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

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
public class XMXUTIL2InrespResponse {

	@XmlElementWrapper(name = "xmir")
	@XmlElement(name = "xmir-line", required = true)
	private List<String> xmir;
	
	public XMXUTIL2InrespResponse() {
		super();
	}

	public XMXUTIL2InrespResponse(List<String> xmir) {
		super();
		this.xmir = xmir;
	}

	public List<String> getXmir() {
		return xmir;
	}

	public void setXmir(List<String> xmir) {
		this.xmir = xmir;
	}

}

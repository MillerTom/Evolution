/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.model;

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
public class XUSNPIQiRequest {
	
	@XmlElement(required = true)
	private String xusnpi;

	public XUSNPIQiRequest() {
		super();
	}

	public XUSNPIQiRequest(String xusnpi) {
		super();
		this.xusnpi = xusnpi;
	}

	public String getXusnpi() {
		return xusnpi;
	}

	public void setXusnpi(String xusnpi) {
		this.xusnpi = xusnpi;
	}
	
}

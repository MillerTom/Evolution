/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFORefResponse {

	@XmlElement(required = true)
	private String openRoot;

	/**
	 * 
	 */
	public DILFORefResponse() {
		this(null);
	}

	/**
	 * @param openRoot
	 */
	public DILFORefResponse(String openRoot) {
		super();
		this.setOpenRoot(openRoot);
	}

	public String getOpenRoot() {
		return openRoot;
	}

	protected void setOpenRoot(String openRoot) {
		this.openRoot = openRoot;
	}

}

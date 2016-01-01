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
public class DILFIENSResponse {

	@XmlElement(name = "iensString", required = true)
	private String IENSString;

	/**
	 * @param iENSString
	 */
	public DILFIENSResponse(String iENSString) {
		super();
		IENSString = iENSString;
	}

	/**
	 * 
	 */
	public DILFIENSResponse() {
		super();
	}

	public String getIENSString() {
		return IENSString;
	}

	protected void setIENSString(String iENSString) {
		IENSString = iENSString;
	}
}

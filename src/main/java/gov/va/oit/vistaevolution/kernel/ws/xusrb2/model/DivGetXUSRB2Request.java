/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.model;

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
public class DivGetXUSRB2Request {

	@XmlElement(name = "ien", required = true)
	private String ien;

	public DivGetXUSRB2Request() {
		super();
	}

	public DivGetXUSRB2Request(String ien) {
		super();
		this.ien = ien;
	}
	
	public String getIEN() {
		return ien;
	}

	public void setIEN(String ien) {
		this.ien = ien;
	}
	
}

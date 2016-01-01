/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xus1a.model;

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
public class XUS1AProhibitRequest {
	
	@XmlElement(required = true)
	private String t;
	
	@XmlElement(required = true)
	private String r;

	public XUS1AProhibitRequest() {
		super();
	}

	public XUS1AProhibitRequest(String t, String r) {
		super();
		this.t = t;
		this.r = r;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

}

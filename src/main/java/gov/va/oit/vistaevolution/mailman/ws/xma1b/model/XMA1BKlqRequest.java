package gov.va.oit.vistaevolution.mailman.ws.xma1b.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Delete a Message from a Basket (into "WASTE" basket
 * Input Parameter Class:
 * 
 * xmduZ:       (Required, Sequence = 1) DUZ of the user
 * 
 * xmk:         (Required, Sequence = 2) IEN of basket
 * 
 * xmz:         (Required, Sequence = 3) Message Internal 
 *              Entry Number (IEN) in the MESSAGE file (#3.9).
 * 
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA1BKlqRequest {

	@XmlElement(required = true)
	private String xmduz;
	@XmlElement(required = true)
	private String xmk;
	@XmlElement(required = true)
	private String xmz;

	public XMA1BKlqRequest() {
		super();
	}

	public String getXmduz() {
		return this.xmduz;
	}

	public void setXmduz(final String xmduz) {
		this.xmduz = xmduz;
	}

	public String getXmk() {
		return this.xmk;
	}

	public void setXmk(final String xmk) {
		this.xmk = xmk;
	}

	public String getXmz() {
		return this.xmz;
	}

	public void setXmz(final String xmz) {
		this.xmz = xmz;
	}
}

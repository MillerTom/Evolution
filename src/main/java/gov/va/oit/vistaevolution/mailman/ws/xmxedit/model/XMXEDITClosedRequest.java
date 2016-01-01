package gov.va.oit.vistaevolution.mailman.ws.xmxedit.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Closed Flag Toggle
 * Input Parameter Class:
 * 
 * xmz:     (Required, Sequence = 1) Message Internal
 *          Entry Number (IEN) in the MESSAGE file (#3.9).
 * 
 * xminstr: (Required, Sequence = 2)  ("FLAGS") Message is any or
 *          all of the following:
 * 
 *          P-Priority.
 *          I-Information Only (cannot be replied to).
 *          X-Closed message (cannot be forwarded).
 *          C-Confidential message (surrogate cannot read).
 *          S-Send to sender (make sender a recipient).
 *          R-Confirm receipt (return receipt requested).
 *          F-Forward messages to users, if the users aren't already on the
 *          messages.
 * 
 * </pre>
 * 
 * @author rcollins
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXEDITClosedRequest extends AbstractVistaRequest {

	@XmlElement(required = true)
	private String xmz;

	@XmlElement(required = true)
	private String xminstr;

	/**
	 * @return the xmz
	 */
	public String getXmz() {
		return this.xmz;
	}

	/**
	 * @param xmz
	 *            the xmz to set
	 */
	public void setXmz(final String xmz) {
		this.xmz = xmz;
	}

	/**
	 * @return the xminstr
	 */
	public String getXminstr() {
		return this.xminstr;
	}

	/**
	 * @param xminstr
	 *            the xminstr to set
	 */
	public void setXminstr(final String xminstr) {
		this.xminstr = xminstr;
	}

	/**
	 * Default Bean Constructor
	 */
	public XMXEDITClosedRequest() {
		super();
	}

	public XMXEDITClosedRequest(String xmz, String xminstr) {
		super();
		this.xmz = xmz;
		this.xminstr = xminstr;
	}
}
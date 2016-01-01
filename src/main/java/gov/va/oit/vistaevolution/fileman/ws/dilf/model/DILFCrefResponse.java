package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFCrefResponse extends AbstractVistaResponse {

	/**
	 * closedRoot:
	 * 
	 * the closed-root format used by subscript indirection, with converted
	 * ending comma to a close parenthesis. and If the last character is an open
	 * parenthesis, the last character is dropped.
	 * 
	 */
	@XmlElement(required = true)
	private String closedRoot;

	/**
	 * No Arguments Constructor.
	 * 
	 */
	public DILFCrefResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param closedRoot
	 */
	public DILFCrefResponse(String closedRoot) {
		super();
		this.closedRoot = closedRoot;
	}

	/**
	 * @return the closedRoot
	 */
	public String getClosedRoot() {
		return closedRoot;
	}

	/**
	 * @param closedRoot
	 *            the closedRoot to set
	 */
	public void setClosedRoot(String closedRoot) {
		this.closedRoot = closedRoot;
	}

}

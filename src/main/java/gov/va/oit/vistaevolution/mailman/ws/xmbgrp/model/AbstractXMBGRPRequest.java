/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMBGRPRequest extends AbstractVistaRequest {

	/**
	 * xmgroup :
	 * 
	 * (required) Mail group Internal Entry Number (IEN) or full name (without
	 * the G.).
	 * 
	 * .xmy :
	 * 
	 * (required) Array of local users to delete from the mail group. Only DUZs
	 * are accepted (names are not).
	 */

	@XmlElement(required = true)
	protected String xmgroup;
	@XmlElementWrapper(name = "users")
	@XmlElement(name = "user", required = true)
	protected List<XMYEntry> xmy;

	/**
	 * No Arguments Constructor
	 */
	public AbstractXMBGRPRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmgroup
	 * @param xmy
	 */
	public AbstractXMBGRPRequest(String xmgroup, List<XMYEntry> xmy) {
		super();
		this.xmgroup = xmgroup;
		this.xmy = xmy;
	}

	/**
	 * @return the xmgroup
	 */
	public String getXmgroup() {
		return xmgroup;
	}

	/**
	 * @param xmgroup
	 *            the xmgroup to set
	 */
	public void setXmgroup(String xmgroup) {
		this.xmgroup = xmgroup;
	}

	/**
	 * @return the xmy
	 */
	public List<XMYEntry> getXmy() {
		return xmy;
	}

	/**
	 * @param xmy
	 *            the xmy to set
	 */
	public void setXmy(List<XMYEntry> xmy) {
		this.xmy = xmy;
	}

}

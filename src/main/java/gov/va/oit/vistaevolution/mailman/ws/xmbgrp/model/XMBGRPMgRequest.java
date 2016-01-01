package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMBGRPMgRequest extends AbstractXMBGRPRequest {

	/**
	 * xmgroup :
	 * 
	 * (required) This parameter can be either of the following:
	 * 
	 * • New Mail Group—Mail group name (without the G.).
	 * 
	 * • Existing Mail Group—Mail group Internal Entry Number (IEN) or full name
	 * (without the G.).
	 * 
	 * xmtype :
	 * 
	 * (required) Type of mail group. Used only for creating a mail group,
	 * otherwise it's ignored.
	 * 
	 * • 0 (default)—Public
	 * 
	 * • 1—Private
	 * 
	 * xmorg :
	 * 
	 * (required) DUZ of group organizer. Used only for creating a mail group,
	 * otherwise it's ignored.
	 * 
	 * xmself :
	 * 
	 * (required) Allow self-enrollment?
	 * 
	 * • 0—No
	 * 
	 * • 1—Yes
	 * 
	 * Used only for creating a new mail group, otherwise it's ignored.
	 * 
	 * .xmy :
	 * 
	 * (required) Array of local users to add to the mail group. Only DUZs are
	 * accepted (names are not).
	 * 
	 * .xmdesc :
	 * 
	 * (required) Array of text to put in the description field of the mail
	 * group. Used only for creating a mail group, otherwise it's ignored.
	 * 
	 * 
	 */

	@XmlElement(required = true)
	private String xmtype;
	@XmlElement(required = true)
	private String xmorg;
	@XmlElement(required = true)
	private String xmself;
	@XmlElementWrapper(name = "descriptions")
	@XmlElement(name = "description", required = true)
	private List<String> xmdesc;

	/**
	 * No Arguments Constructor
	 */
	public XMBGRPMgRequest() {
		super();
	}

	/**
	 * 
	 * Parameterised Constructor
	 * 
	 * @param xmgroup
	 * @param xmtype
	 * @param xmorg
	 * @param xmself
	 * @param xmy
	 * @param xmdesc
	 */
	public XMBGRPMgRequest(String xmgroup, String xmtype, String xmorg,
			String xmself, List<XMYEntry> xmy, List<String> xmdesc) {
		super(xmgroup, xmy);
		this.xmtype = xmtype;
		this.xmorg = xmorg;
		this.xmself = xmself;
		this.xmdesc = xmdesc;
	}

	/**
	 * @return the xmtype
	 */
	public String getXmtype() {
		return xmtype;
	}

	/**
	 * @return the xmorg
	 */
	public String getXmorg() {
		return xmorg;
	}

	/**
	 * @return the xmself
	 */
	public String getXmself() {
		return xmself;
	}

	/**
	 * @return the xmdesc
	 */
	public List<String> getXmdesc() {
		return xmdesc;
	}

	/**
	 * @param xmtype
	 *            the xmtype to set
	 */
	public void setXmtype(String xmtype) {
		this.xmtype = xmtype;
	}

	/**
	 * @param xmorg
	 *            the xmorg to set
	 */
	public void setXmorg(String xmorg) {
		this.xmorg = xmorg;
	}

	/**
	 * @param xmself
	 *            the xmself to set
	 */
	public void setXmself(String xmself) {
		this.xmself = xmself;
	}

	/**
	 * @param xmdesc
	 *            the xmdesc to set
	 */
	public void setXmdesc(List<String> xmdesc) {
		this.xmdesc = xmdesc;
	}

}

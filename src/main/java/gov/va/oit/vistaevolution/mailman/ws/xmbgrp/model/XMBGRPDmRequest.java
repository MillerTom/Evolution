package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMBGRPDmRequest extends AbstractXMBGRPRequest {

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
	 * 
	 * duz :
	 * 
	 * The DUZ of the user executing this RPC
	 */

	@XmlElement(required = true)
	private String duz;

	/**
	 * No Arguments Constructor
	 */
	public XMBGRPDmRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmgroup
	 * @param xmy
	 * @param duz
	 */
	public XMBGRPDmRequest(String xmgroup, List<XMYEntry> xmy, String duz) {
		super(xmgroup, xmy);
		this.duz = duz;
	}

	/**
	 * @return the duz
	 */
	public String getDuz() {
		return duz;
	}

	/**
	 * @param duz
	 *            the duz to set
	 */
	public void setDuz(String duz) {
		this.duz = duz;
	}

}

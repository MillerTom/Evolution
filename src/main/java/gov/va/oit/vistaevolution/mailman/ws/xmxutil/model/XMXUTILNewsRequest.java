/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/*
 * NAME: XMWSOA NEW MSG INFO
 * 
 * This RPC returns information on new messages in a user's mailbox.  If
 * there's an error, it returns an error message.
 * 
 * Input parameters:
 * 		XMDUZ		(Required) User DUZ.
 * 
 * 		XMTEST      (Optional) Is this a test?
 * 						1 (default)-Yes
 * 						0-No
 * 
 * If this is not a test, then the LAST NEW MSG NOTIFY DATE/TIME field
 * (#1.12) in the MAILBOX file (#3.7) can be updated for this user.
 * 
 * Response:
 * 		-1-If XMDUZ is not a valid user
 * 		 0-If the user has no new messages
 * 
 * Otherwise, it returns the following ^-delimited string:
 * 		Piece 1: Number of new messages in the mailbox.
 * 		Piece 2: Does the user have new priority mail?
 * 				 0-No
 * 				 1-Yes
 * 		Piece 3: Number of new messages in the "IN" basket.
 * 		Piece 4: Date/time (in VA FileMan format) that the last message was
 * 				 received.
 * 		Piece 5: Have there been any new messages since the last time this routine
 * 				 was called?
 * 				 0-No
 * 				 1-Yes
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILNewsRequest {

	@XmlElement(required = true)
	private String xmDuz;
	@XmlElement(required = false)
	private String xmTest;

	public XMXUTILNewsRequest() {
		super();
	}

	public XMXUTILNewsRequest(String xmDuz, String xmTest) {
		super();
		this.xmDuz = xmDuz;
		this.xmTest = xmTest;
	}

	/**
	 * @return the xmDuz
	 */
	public String getXmDuz() {
		return xmDuz;
	}

	/**
	 * @param xmDuz the xmDuz to set
	 */
	public void setXmDuz(String xmDuz) {
		this.xmDuz = xmDuz;
	}

	/**
	 * @return the xmTest
	 */
	public String getXmTest() {
		return xmTest;
	}

	/**
	 * @param xmTest the xmTest to set
	 */
	public void setXmTest(String xmTest) {
		this.xmTest = xmTest;
	}
}

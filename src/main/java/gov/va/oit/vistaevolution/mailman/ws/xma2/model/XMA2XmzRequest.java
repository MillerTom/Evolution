/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma2.model;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/*
 * NAME: XMWSOA EN1                        TAG: EN1
 * 
 * This RPC calls the XMZ^XMA2 API to create a message stub.  If this
 * fails, the RPC returns an error message.  If the call was successful,
 * the RPC then calls the API, EN1^XMD to add text and recipients and send
 * the message.
 * 
 * Returns:
 *   0^Successful
 *   -1^Error in required input
 *   -1^Failed to create message stub
 *   -1^DUZ not found
 *   -1^Subject names of this format (1"R"1.N) are RESERVED
 *   -1^SUBJECT must be at least 3 characters long.
 *   -1^Entered SUBJECT too long, <number> characters longer than 65.
 *   -1^Subject cannot contain control characters.
 *   
 *   Input Parameters:
 *   
 *   DUZ	(Required String) Sender's DUZ.
 *   MSG	(Required List) An array containing the text to be added to the message.
 *   XMY    (Required List) Addressee array, XMY(x)="", where x can be:
 *     			User's DUZ or enough of the user's name for a positive ID. For example:
 *     	         XMY(1301)="" OR XMY("lastname,first")=""
 *     		     G.group name (enough for positive ID). For example:
 *         		 XMY("G.group name")=""
 *         		 S.server name (enough for positive ID).
 *         		 D.device name (enough for positive ID).
 *              Prefix the above (except devices and servers) by:
 *              	I: for "Information Only" recipient (cannot reply). For example:
 *                        XMY("I:1301")="" or XMY("I:lastname,first")=""
 *                  C: for "Copy" recipient (not expected to reply). For example:
 *                        XMY("C:1301")="" or XMY("C:lastname,first")=""
 *                  L@datetime: for when (in future) to send to this recipient (datetime
 *                  	can be anything accepted by VA FileMan). For example:
 *                  	    XMY("L@25 DEC@0500:1301")="" or XMY("L@1 JAN:lastname,first")="" or
 *                            XMY("L@2981225.05:1301")=""
 *                            (Can combine IL@datetime: or CL@datetime:)
 *             To delete any recipient (including users, groups, devices, and
 *              	servers, prefix with a hyphen/dash ("-"). For example:
 *                        XMY(-1301)="" or XMY("-lastname,first")=""
 *             To address any recipient (including users, groups, devices, and
 *             		servers) at a remote site, just add the @site name. For example:
 *             			  XMY(recipient@site name)=""
 *  XMSUB	(Required String)Subject of the message.  It should be from 3 to 65 characters 
 *  		in length. If it is less than 3 characters,then three dots ("...") will be appended
 *  		to it.  If it is more than 65 characters, then it will be truncated.
 *  		Subject 'Rnnn' is reserved.
 *  XMSTRIP (Optional String) String containing characters that should be removed from 
 *  		the message text. The default is none.
 *  XMDF    (Optional String)If XMDF is defined, addressing restrictions are waived.
 *  		Addressing restrictions are:
 *  			> Restrict  "domain closed"
 *  			> Restrict  "keys required for domain"
 *  			> Restrict  "may not forward to domain"
 *  			> Restrict  "may not forward priority mail to groups"
 *  			> Restrict  "message length restrictions to remote addresses"
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA2XmzRequest {

	@XmlElement(required = false)
	private String duz;
	@XmlElementWrapper(name = "msgs")
	@XmlElement(name = "msg", required = true)
	private List<String> msgs;

	private HashMap <String, String> xmys = new HashMap <String, String> ();
	
	@XmlElement(required = true)
	private String xmSub;
	@XmlElement(required = false)
	private String xmStrip;
	@XmlElement(required = false)
	private String xmDf;

	public XMA2XmzRequest() {
		super();
	}

	public XMA2XmzRequest(String duz, List<String> msgs, HashMap <String, String> xmys,  
			String xmSub, String xmStrip, String xmDf) {
		super();
		this.duz = duz;
		this.msgs = msgs;
		this.xmys = xmys;
		this.xmSub = xmSub;
		this.xmStrip = xmStrip;
		this.xmDf = xmDf;
	}

	/**
	 * @return the duz
	 */
	public String getDuz() {
		return duz;
	}

	/**
	 * @param duz the duz to set
	 */
	public void setDuz(String duz) {
		this.duz = duz;
	}

	/**
	 * @return the xmSub
	 */
	public String getXmSub() {
		return xmSub;
	}

	/**
	 * @param xmSub the xmSub to set
	 */
	public void setXmSub(String xmSub) {
		this.xmSub = xmSub;
	}

	/**
	 * @return the msgs
	 */
	public List<String> getMsgs() {
		return msgs;
	}

	/**
	 * @param msgs the msgs to set
	 */
	public void setMsgs(List<String> msgs) {
		this.msgs = msgs;
	}

	/**
	 * @return the xmys
	 */
	@XmlElementWrapper(name = "xmys", required = true)
	public HashMap <String, String> getXmys() {
		return xmys;
	}

	/**
	 * @param xmys the xmys to set
	 */
	public void setXmys(HashMap <String, String> xmys) {
		this.xmys = xmys;
	}

	/**
	 * @return the xmStrip
	 */
	public String getXmStrip() {
		return xmStrip;
	}

	/**
	 * @param xmStrip the xmStrip to set
	 */
	public void setXmStrip(String xmStrip) {
		this.xmStrip = xmStrip;
	}

	/**
	 * @return the xmDf
	 */
	public String getXmDf() {
		return xmDf;
	}

	/**
	 * @param xmDf the xmDf to set
	 */
	public void setXmDf(String xmDf) {
		this.xmDf = xmDf;
	}
}

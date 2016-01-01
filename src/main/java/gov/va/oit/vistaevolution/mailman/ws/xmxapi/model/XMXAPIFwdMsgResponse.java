/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/* 
 * XMWSOA FWDMSGM
 * 
 * This RPC forward messages by message number.
 * 
 * NOTE: Only the user or a surrogate can use this API.
 * 
 * 
 *  Input Parameters
 * 
 *  DUZ		(Required) String - User's DUZ
 *  XMDUZ   (Required) String -The user (DUZ or name) whose messages are to be forwarded.
 *  XMKZA   (Required) List - Identifies messages, using a list array of
 *  						  message numbers (xmz) in the MESSAGE file (#3.9) (xmk must not be
 *  						  specified and ranges are not allowed):
 *  
 *  							List array: ARRAY(1234567)=""
 *  				                        ARRAY(9763213)=""
 *  XMTO   (Required) List - Addressee or addressee array. If it is an array, it must be passed by reference
 *  
 *  						User's DUZ, or enough of user's name for a positive ID. For example:
 *  						     1301, "lastname,first", ARRAY(1301)="", or
 *  									ARRAY("lastname,first")=""
 *  						G.group name (enough for positive ID)
 *  						S.server name (enough for positive ID)
 *  						D.device name (enough for positive ID)
 *  							Prefix the above (except devices and servers) by:
 *  								I:-For "Information Only" recipient (cannot reply).
 *  							For example:
 *  								"I:1301" or
 *  								"I:lastname,first"
 *  						C:-For "copy" recipient (not expected to reply).
 *  							For example:
 *  								"C:1301" or
 *  								"C:lastname,first"
 *  						L@datetime:-For when (in future) to send to this recipient (datetime
 *  								can be anything accepted by VA FileMan).
 *  							For example:
 *  								"L@25 DEC@0500:1301" or
 *  								"L@1 JAN:lastname,first" or
 *  								"L@2981225.05:1301"
 *  								(Can combine IL@datetime: or CL@datetime:)
 *  
 *  					To delete recipients, prefix the recipients' name with a minus sign ("-").
 *  						For example:
 *  							-1301 or
 *  							"-lastname,first"
 *  
 *   					To address any recipient (including users, groups, devices, and
 *   							servers) at a remote site, just add the @site name.
 *   						For example:
 *   							recipient@site name
 *   
 *   
 *  XMINSTR   (Optional) List - Array of special instructions:
 *  
 *  ("ADDR FLAGS") Special addressing instructions, any or all of the
 * following:
 *   I-Do not Initialize (KILL) the ^TMP addressee global, because it already
  *   contains addressees for this message, as a result of a previous call to an
 *    API.
 *   R-Do not Restrict message addressing:
 *    Ignore "domain closed."
 *    Ignore "keys required for domain."
 *    Ignore "may not forward to domain."
 *    Ignore "may not forward priority mail to groups."
 *    Ignore "message length restrictions to remote addressees." 
 *   X-Do not create the ^TMP addressee global, because addressees are only
 *     being checked for validity.
 *   
 *  ("FWD BY") String saying who forwarded the message. The default
 * is user. This string is placed in the FORWARDED BY
 * field (#8) in the RECIPIENT Multiple field in the
 * MESSAGE file (#3.9). It must not be any real person, except for the
 * Postmaster. The DUZ is not captured in FORWARDED BY field (#8) ,
 * "FORWARDED BY (XMDUZ)" in the RECIPIENT Multiple field of the MESSAGE file
 * (#3.9)
 * VistA software.
 *   
 *  ("LATER") Date/time (any format understood by VA FileMan) on
 * which to send this message. The default is now.
 *   
 *  ("SELF BSKT") Basket to deliver to, 
 * if sender is recipient. The default is the "IN" basket. 
 *   
 *  ("SHARE BSKT")
 * Basket to deliver to if SHARED,MAIL is recipient. The default is the "IN"
 * basket. 
 *   
 *  ("SHARE DATE") Date/time (any format understood by VA FileMan) to
 * delete this message from SHARED,MAIL if SHARED,MAIL is the recipient.
 *  
 *  Returns (String):
 *  <number of messages> filtered or
 *  -1^[error text]
 * 
 */


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIFwdMsgResponse {
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMXAPIFwdMsgResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMXAPIFwdMsgResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}

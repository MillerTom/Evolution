/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XmbResponse {
	
	/**
	 * XMWSOA XMB
	 * 
	 * This RPC creates and sends a bulletin in the background. The message
	 * number (XMZ) is not returned. The bulletin is sent to the mail
	 * groups defined for the bulletin in the BULLETIN file (#3.6), as well as to
	 * any additional recipients defined in XMY.
	 * 
	 * Input Parameters:
	 * XMDUZ    (Required String)
	 * 			User's DUZ or FREE TEXT.  This is the sender of the message.  If it is
	 * 			not defined, it defaults to DUZ.  If it is FREE TEXT, it must not be more
	 * 			than 70 characters.
	 *
	 * MSG		(Optional List)
	 * 			This is text, in addition to the text defined in the bulletin, to
	 * 			append to the bulletin.
	 *
	 * XMY      (Required List)
	 * 			Recipients, in addition to those defined in the bulletin.
	 * 
	 * XMBULL   (Required String)
	 * 			Full, exact name, of the bulletin. Case is important.
	 * 
	 * XMB		(Optional list)
	 * 			Bulletin parameter(s). For example:
	 * 			XMB(1)=<parm 1>, XMB(2)=<parm 2>, etc.
	 * 
	 * XMDF		(Optional String)
	 * 			If XMDF is defined, addressing restrictions are waived.
	 * 			Addressing restrictions are:
	 * 			  > Restrict  "domain closed"
	 * 			  > Restrict  "keys required for domain"
	 * 			  > Restrict  "may not forward to domain"
	 * 			  > Restrict  "may not forward priority mail to groups"
	 * 			  > Restrict  "message length restrictions to remote addresses"
	 * 
	 * 	XMDT	(Optional String)
	 * 			Date/time (in any format understood by VA FileMan) to send the bulletin.
	 * 			The default is now.
	 * 
	 * Returns:
	 *    0^[Name of Bulletin] if successful
	 *    -1^Error in required input
	 *    -1^Bulletin does not exit
	 *    -1^Operation failed
	 *    
	 */
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XmbResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XmbResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}

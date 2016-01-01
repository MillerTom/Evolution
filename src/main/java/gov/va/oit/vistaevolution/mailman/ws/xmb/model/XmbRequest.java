/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmb.model;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *
 */
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

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XmbRequest {

	@XmlElement(required = true)
	private String xmDuz;
	
	@XmlElementWrapper(name = "msgs")
	@XmlElement(name = "msg", required = false)
	private List<String> msgs;
	
	private HashMap<String,String> xmys = new HashMap<String,String>();
	
	@XmlElement(required = true)
	private String xmBull;

	@XmlElementWrapper(name = "xmbs")
	@XmlElement(name = "xmb", required = false)
	private List<String> xmbs;

	@XmlElement(required = false)
	private String xmDf;

	@XmlElement(required = false)
	private String xmDt;

	public XmbRequest() {
		super();
	}

	public XmbRequest(String xmDuz, List<String> msgs, HashMap<String,String> xmys, 
			String xmBull, List<String> xmbs, String xmDf, String xmDt) {
		super();
		this.xmDuz = xmDuz;
		this.msgs = msgs;
		this.xmys = xmys;
		this.xmBull = xmBull;
		this.xmbs = xmbs;
		this.xmDf = xmDf;
		this.xmDt = xmDt;
		
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

	
	@XmlElementWrapper(name = "xmys", required = true )
	public HashMap<String, String> getXmys() {
		return xmys;
	}

	public void setXmys(HashMap<String, String> xmys) {
		this.xmys = xmys;
	}

	/**
	 * @return the xmBull
	 */
	public String getXmBull() {
		return xmBull;
	}

	/**
	 * @param xmBull the xmBull to set
	 */
	public void setXmBull(String xmBull) {
		this.xmBull = xmBull;
	}

	/**
	 * @return the xmbs
	 */
	public List<String> getXmbs() {
		return xmbs;
	}

	/**
	 * @param xmbs the xmbs to set
	 */
	public void setXmbs(List<String> xmbs) {
		this.xmbs = xmbs;
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

	/**
	 * @return the xmDt
	 */
	public String getXmDt() {
		return xmDt;
	}

	/**
	 * @param xmDt the xmDt to set
	 */
	public void setXmDt(String xmDt) {
		this.xmDt = xmDt;
	}

}

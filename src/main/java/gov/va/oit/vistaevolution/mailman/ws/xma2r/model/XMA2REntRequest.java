package gov.va.oit.vistaevolution.mailman.ws.xma2r.model;

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
public class XMA2REntRequest extends AbstractXMA2RRequest {

	/**
	 * duz:
	 * 
	 * (optional) User's DUZ. If DUZ is not defined, it defaults to the
	 * Postmaster. This is who is really sending the message.
	 * 
	 * xmduz:
	 * 
	 * (required) User's DUZ or FREE TEXT. This is from whom the message will
	 * appear to be. If it is not defined, it defaults to DUZ. (If DUZ is not
	 * defined, it defaults to Postmaster.) If it is FREE TEXT, it must not be
	 * more than 70 characters.
	 * 
	 * xmtext :
	 * 
	 * (required) The name of the array (in open format) containing the text of
	 * the message. The array itself may be a local or a global variable, and it
	 * must be in a format acceptable to VA FileMan WORD-PROCESSING fields.
	 * 
	 * xmz :
	 * 
	 * (required) Message IEN in the MESSAGE file (#3.9), of the message to
	 * which you are replying.
	 * 
	 * 
	 * xmnet:
	 * 
	 * (optional) If the sender of the original message is at a remote site,
	 * should the reply be sent to the sender, too? (Ignored, unless message is
	 * from a remote sender.)
	 * 
	 * =0—no (default)
	 * 
	 * =1—yes
	 * 
	 * xmstrip :
	 * 
	 * (optional) String containing characters that should be removed from the
	 * answer text. Default is none.
	 * 
	 * xmsub:
	 * 
	 * (required) Subject of the message, It should be from 3 to 65 characters
	 * in length.
	 * 
	 * 
	 * xmz :
	 * 
	 * (required) Message IEN in the MESSAGE file (#3.9), of the message to
	 * which you are replying.
	 * 
	 */

	@XmlElement(required = false)
	private String xmnet;

	/**
	 * Default Empty Constructor
	 */
	public XMA2REntRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param duz
	 * @param xmduz
	 * @param xmsub
	 * @param xmtext
	 * @param xmz
	 * @param xmnet
	 * @param xmstrip
	 */
	public XMA2REntRequest(String duz, String xmduz, String xmsub,
			List<String> xmtext, String xmz, String xmnet, String xmstrip) {
		super(duz, xmduz, xmsub, xmtext, xmz, xmstrip);
		this.xmnet = xmnet;
	}
	
	// same order as the ENT RPC
	public XMA2REntRequest(
			String xmz, 
			String xmSub, 
			List<String> xmText,
			String xmStrip,
			String xmDuz,
			String xmNet
			)
	{
		super(xmDuz, xmDuz, xmSub, xmText, xmz, xmStrip);
		this.xmnet = xmNet;
	}
	

	/**
	 * Mandatory Parameters Constructor
	 * 
	 * @param xmsub
	 * @param xmtext
	 * @param xmz
	 */
	public XMA2REntRequest(String xmduz, String xmsub, List<String> xmtext,
			String xmz) {
		super(xmduz, xmsub, xmtext, xmz);
	}

	/**
	 * @return the xmnet
	 */
	public String getXmnet() {
		return xmnet;
	}

	/**
	 * @param xmnet
	 *            the xmnet to set
	 */
	protected void setXmnet(String xmnet) {
		this.xmnet = xmnet;
	}

}

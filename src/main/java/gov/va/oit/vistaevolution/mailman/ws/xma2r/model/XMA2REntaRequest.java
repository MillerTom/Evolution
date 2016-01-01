package gov.va.oit.vistaevolution.mailman.ws.xma2r.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA2REntaRequest extends AbstractXMA2RRequest {

	/**
	 * duz:
	 * 
	 * (optional) User's DUZ. If DUZ is not defined, it defaults to the
	 * Postmaster. This is who is really sending the message.
	 * 
	 * xmduz:
	 * 
	 * (optional) User's DUZ or FREE TEXT. This is from whom the message will
	 * appear to be. If it is not defined, it defaults to DUZ. (If DUZ is not
	 * defined, it defaults to Postmaster.) If it is FREE TEXT, it must not be
	 * more than 70 characters.
	 * 
	 * xmtext :
	 * 
	 * Text of the answer. The name of the array (in open format) containing the
	 * text of the message. The array itself may be a local or a global
	 * variable, and it must be in a format acceptable to VA FileMan
	 * WORD-PROCESSING fields.
	 * 
	 * xmz :
	 * 
	 * (required) Message IEN in the MESSAGE file (#3.9), of the message to
	 * which you are replying.
	 * 
	 * 
	 * xmstrip :
	 * 
	 * (optional) String containing characters that should be removed from the
	 * answer text. Default is none.
	 * 
	 * xmsub:
	 * 
	 * Subject of the message. It should be from 3 to 65 characters in length.
	 * If not, then an error message is returned.
	 * 
	 * 
	 * xmz :
	 * 
	 * Message IEN in the MESSAGE file (#3.9), of the message to which you are
	 * sending an answer.
	 * 
	 */

	/**
	 * Default Empty Constructor
	 */
	public XMA2REntaRequest() {
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
	 * @param xmstrip
	 */
	public XMA2REntaRequest(String duz, String xmduz, String xmsub,
			List<String> xmtext, String xmz, String xmstrip) {
		super(duz, xmduz, xmsub, xmtext, xmz, xmstrip);
	}
	
	public XMA2REntaRequest(
			String xmz, 
			String subj, 
			List<String> msgTxt, 
			String xmStrip,
			String duz			
			) { 
		
		super(duz,duz,subj,msgTxt,xmz,xmStrip);
	}
	
	

	/**
	 * Mandatory Parameters Constructor
	 * 
	 * @param xmduz
	 * @param xmsub
	 * @param xmtext
	 * @param xmz
	 */
	public XMA2REntaRequest(String xmduz, String xmsub, List<String> xmtext,
			String xmz) {
		super(xmduz, xmsub, xmtext, xmz);
	}

}

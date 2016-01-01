package gov.va.oit.vistaevolution.mailman.ws.xma2r.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
public abstract class AbstractXMA2RRequest {

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
	 * xmsub:
	 * 
	 * (required) Subject of the message, It should be from 3 to 65 characters
	 * in length.
	 * 
	 * xmtext :
	 * 
	 * (required) The name of the array (in open format) containing the text of
	 * the message. The array itself may be a local or a global variable, and it
	 * must be in a format acceptable to VA FileMan WORD-PROCESSING fields.
	 * 
	 * xmz :
	 * 
	 * (required) Message IEN in the MESSAGE file (#3.9)
	 * 
	 * xmstrip :
	 * 
	 * (optional) String containing characters that should be removed from the
	 * answer text. Default is none.
	 */

	@XmlElement(required = false)
	protected String duz;
	@XmlElement(required = true)
	protected String xmduz;
	@XmlElement(required = true)
	protected String xmsub;
	@XmlElementWrapper(name = "text")
	@XmlElement(name = "entry", required = true)
	protected List<String> xmtext;
	@XmlElement(required = true)
	protected String xmz;
	@XmlElement(required = false)
	protected String xmstrip;

	/**
	 * Default Empty Constructor
	 */
	public AbstractXMA2RRequest() {
		super();
	}

	/**
	 * 
	 * Parameterised Constructor
	 * 
	 * @param duz
	 * @param xmduz
	 * @param xmsub
	 * @param xmtext
	 * @param xmz
	 * @param xmstrip
	 */
	public AbstractXMA2RRequest(String duz, String xmduz, String xmsub,
			List<String> xmtext, String xmz, String xmstrip) {
		super();
		this.duz = duz;
		this.xmduz = xmduz;
		this.xmsub = xmsub;
		this.xmtext = xmtext;
		this.xmz = xmz;
		this.xmstrip = xmstrip;
	}

	/**
	 * Mandatory Parameters Constructor
	 * 
	 * @param xmduz
	 * @param xmsub
	 * @param xmtext
	 * @param xmz
	 */
	public AbstractXMA2RRequest(String xmduz, String xmsub,
			List<String> xmtext, String xmz) {
		super();
		this.xmduz = xmduz;
		this.xmsub = xmsub;
		this.xmtext = xmtext;
		this.xmz = xmz;
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
	protected void setDuz(String duz) {
		this.duz = duz;
	}

	/**
	 * @return the xmduz
	 */
	public String getXmduz() {
		return xmduz;
	}

	/**
	 * @param xmduz
	 *            the xmduz to set
	 */
	protected void setXmduz(String xmduz) {
		this.xmduz = xmduz;
	}

	/**
	 * @return the xmsub
	 */
	public String getXmsub() {
		return xmsub;
	}

	/**
	 * @param xmsub
	 *            the xmsub to set
	 */
	protected void setXmsub(String xmsub) {
		this.xmsub = xmsub;
	}

	/**
	 * @return the xmtext
	 */
	public List<String> getXmtext() {
		return xmtext;
	}

	/**
	 * @param xmtext
	 *            the xmtext to set
	 */
	protected void setXmtext(List<String> xmtext) {
		this.xmtext = xmtext;
	}

	/**
	 * @return the xmz
	 */
	public String getXmz() {
		return xmz;
	}

	/**
	 * @param xmz
	 *            the xmz to set
	 */
	protected void setXmz(String xmz) {
		this.xmz = xmz;
	}

	/**
	 * @return the xmstrip
	 */
	public String getXmstrip() {
		return xmstrip;
	}

	/**
	 * @param xmstrip
	 *            the xmstrip to set
	 */
	protected void setXmstrip(String xmstrip) {
		this.xmstrip = xmstrip;
	}

}

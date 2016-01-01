package gov.va.oit.vistaevolution.kernel.ws.xusrb.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

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
public class XUSRBValidAVRequest extends AbstractVistaRequest {

	/**
	 * AVCODE :
	 * 
	 * accessCode_";"_verifyCode in unencrypted form.
	 * 
	 */
	@XmlElement(required = true)
	private String avcode;

	/**
	 * No Arguments Constructor.
	 */
	public XUSRBValidAVRequest() {
		super();
	}

	/**
	 * 
	 * Parameterised Constructor
	 * 
	 * @param avcode
	 */
	public XUSRBValidAVRequest(String avcode) {
		super();
		this.avcode = avcode;
	}

	/**
	 * @return the avcode
	 */
	public String getAvcode() {
		return avcode;
	}

	/**
	 * @param avcode
	 *            the avcode to set
	 */
	public void setAvcode(String avcode) {
		this.avcode = avcode;
	}

}

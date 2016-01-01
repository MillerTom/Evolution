package gov.va.oit.vistaevolution.mailman.ws.xmcu1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMCU1RtranRequest extends AbstractXMCU1Request {

	/**
	 * inputString :
	 * 
	 * (required) Any character string converted by $$STRAN^XMCU1.
	 * 
	 */

	/**
	 * No Arguments Constructor
	 */
	public XMCU1RtranRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param inputString
	 */
	public XMCU1RtranRequest(String inputString) {
		super(inputString);
	}

}

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
public class XMCU1DecodeupRequest extends AbstractXMCU1Request {

	/**
	 * inputString :
	 * 
	 * Any character string.
	 * 
	 */

	/**
	 * No Arguments Constructor
	 */
	public XMCU1DecodeupRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param inputString
	 */
	public XMCU1DecodeupRequest(String inputString) {
		super(inputString);
	}

}

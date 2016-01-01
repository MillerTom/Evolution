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
public class XMCU1StranRequest extends AbstractXMCU1Request {

	/**
	 * inputString :
	 * 
	 * (Required) Any character string.
	 * 
	 */

	/**
	 * No Arguments Constructor
	 */
	public XMCU1StranRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param inputString
	 */
	public XMCU1StranRequest(String inputString) {
		super(inputString);
	}

}

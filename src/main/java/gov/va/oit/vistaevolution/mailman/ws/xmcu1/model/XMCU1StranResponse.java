package gov.va.oit.vistaevolution.mailman.ws.xmcu1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

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
public class XMCU1StranResponse extends AbstractVistaResponse {

	/**
	 * result :
	 * 
	 * Character “~” concatenated with the Converted control character(s).
	 */

	@XmlElement(required = false)
	private String result;

	/**
	 * No Arguments Constructor.
	 */
	public XMCU1StranResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param result
	 */
	public XMCU1StranResponse(String result) {
		super();
		this.result = result;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

}

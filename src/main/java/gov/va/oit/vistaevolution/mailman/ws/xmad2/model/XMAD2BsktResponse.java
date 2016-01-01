package gov.va.oit.vistaevolution.mailman.ws.xmad2.model;

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
public class XMAD2BsktResponse extends AbstractVistaResponse {

	/**
	 * result :
	 * 
	 * Successful—Basket IEN.
	 * 
	 * Unsuccessful—Error message.
	 * 
	 */

	@XmlElement(required = true)
	private String result;

	/**
	 * No Arguments Constructor.
	 */
	public XMAD2BsktResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param result
	 */
	public XMAD2BsktResponse(String result) {
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

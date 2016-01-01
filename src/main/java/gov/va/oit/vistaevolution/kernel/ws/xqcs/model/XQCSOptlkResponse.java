/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqcs.model;

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
public class XQCSOptlkResponse extends AbstractVistaResponse {

	/**
	 * result :
	 * 
	 * IEN If results are okay, this is the IEN of Option Name entered.
	 * 
	 * "" If there is no IEN for the Option Name entered.
	 * 
	 */
	@XmlElement(required = true)
	private String result;

	/**
	 * No Arguments Constructor.
	 */
	public XQCSOptlkResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param result
	 */
	public XQCSOptlkResponse(String result) {
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
	protected void setResult(String result) {
		this.result = result;
	}

}

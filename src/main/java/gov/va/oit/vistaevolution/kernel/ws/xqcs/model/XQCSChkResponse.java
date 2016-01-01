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
public class XQCSChkResponse extends AbstractVistaResponse {

	/**
	 * result :
	 * 
	 * • Successful—1
	 * 
	 * • Unsuccessful (error)—Message string
	 * 
	 */

	@XmlElement(required = true)
	private String result;

	/**
	 * No Arguments Constructor.
	 */
	public XQCSChkResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param result
	 */
	public XQCSChkResponse(String result) {
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

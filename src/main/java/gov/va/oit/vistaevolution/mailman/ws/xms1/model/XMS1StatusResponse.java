/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMS1StatusResponse extends AbstractVistaResponse {

	/**
	 * 
	 * result:
	 * 
	 * Successful—STATUS field (#5) value in the MESSAGE file (#3.9)
	 * 
	 * Unsuccessful—Null, recipient could not be found
	 */

	@XmlElement(required = false)
	private String result;

	/**
	 * No Arguments Constructor.
	 */
	public XMS1StatusResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param result
	 */
	public XMS1StatusResponse(String result) {
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

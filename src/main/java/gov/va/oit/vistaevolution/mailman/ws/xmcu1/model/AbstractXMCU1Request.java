/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmcu1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMCU1Request extends AbstractVistaRequest {

	/**
	 * inputString
	 * 
	 * Any character string.
	 */

	@XmlElement(required = true)
	protected String inputString;

	/**
	 * No Arguments Constructor
	 */
	public AbstractXMCU1Request() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param inputString
	 */
	public AbstractXMCU1Request(String inputString) {
		super();
		this.inputString = inputString;
	}

	/**
	 * @return the inputString
	 */
	public String getInputString() {
		return inputString;
	}

	/**
	 * @param inputString
	 *            the inputString to set
	 */
	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

}

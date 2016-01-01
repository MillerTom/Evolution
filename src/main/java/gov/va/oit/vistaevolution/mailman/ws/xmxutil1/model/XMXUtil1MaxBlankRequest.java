/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil1MaxBlankRequest extends AbstractVistaRequest {

	@XmlElement(required = true)
	private String input;

	/**
	 * Default no-arg constructors. 
	 */
	public XMXUtil1MaxBlankRequest() {
		this(null);
	}

	/**
	 * @param string
	 */
	public XMXUtil1MaxBlankRequest(String input) {
		setInput(input);
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
}

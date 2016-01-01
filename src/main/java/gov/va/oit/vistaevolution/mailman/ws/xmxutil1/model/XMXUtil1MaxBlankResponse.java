/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import java.util.List;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement(name = "XMXUtil1MaxBlankRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil1MaxBlankResponse extends AbstractVistaResponse {

	@XmlElement(required = false)
	private String correctedResult;

	/**
	 * Default no-arg constructors.
	 */
	public XMXUtil1MaxBlankResponse() {
		super();
	}

	/**
	 * @param status 
	 * 
	 */
	public XMXUtil1MaxBlankResponse( String status, List<String> errors) {
		super(status, errors);
		this.correctedResult = null;
	}
	
	/**
	 * @param string
	 */
	public XMXUtil1MaxBlankResponse(String input) {
		setCorrectedResult(input);
	}

	public String getCorrectedResult() {
		return correctedResult;
	}

	protected void setCorrectedResult(String input) {
		this.correctedResult = input;
	}

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmd.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

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
public class XMDResponse extends AbstractVistaResponse {

	@XmlElement(required = false)
	private String response;

	/**
	 * 
	 */
	public XMDResponse() {
		super();
	}

	public XMDResponse(List<String> errors) {
		super(errors);
		this.setResponse(null);
	}

	/**
	 * Call to superclass for setup.
	 * 
	 * @param status
	 * @param errors
	 */
	public XMDResponse(String status, String response) {
		setStatus(status);
		setResponse(response);
	}

	/**
	 * Call to superclass for setup.
	 * 
	 * @param status
	 * @param errors
	 */
	public XMDResponse(String status, List<String> errors) {
		super(status, errors);
	}

	/**
	 * @param value
	 */
	public XMDResponse(String response) {
		super();
		this.setResponse(response);
	}

	public String getResponse() {
		return response;
	}

	protected void setResponse(String response) {
		this.response = response;
	}

}

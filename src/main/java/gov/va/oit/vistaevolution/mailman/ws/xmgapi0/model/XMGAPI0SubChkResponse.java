/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model;

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
public class XMGAPI0SubChkResponse extends AbstractVistaResponse {
	
	@XmlElement(required = false)
	private XMGAPI0SubChkValue results;

	/**
	 * Error and status constructor.
	 * @param status
	 * @param errors
	 */
	public XMGAPI0SubChkResponse(String status, XMGAPI0SubChkValue results) {
		setStatus(status);
		this.results = results;
	}	
	
	/**
	 * Error and status constructor.
	 * @param status
	 * @param errors
	 */
	public XMGAPI0SubChkResponse(String status, List<String> errors) {
		super(status, errors);
	}
	
	/**
	 * Constructor from fields
	 * 
	 * @param results
	 */
	public XMGAPI0SubChkResponse(XMGAPI0SubChkValue results) {
		this.setResults(results);
	}

	/**
	 * Default no arg constructor
	 */
	public XMGAPI0SubChkResponse() {
		this.setResults(null);
	}

	public XMGAPI0SubChkValue getResults() {
		return this.results;
	}

	private void setResults(XMGAPI0SubChkValue results) {
		this.results = results;
	}

}

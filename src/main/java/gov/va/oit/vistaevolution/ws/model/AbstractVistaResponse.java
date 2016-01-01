package gov.va.oit.vistaevolution.ws.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * @author sorleski
 * @author Joshua Zangari
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractVistaResponse extends VistaXml {

	protected String rawResponse;

	@XmlElement(name = "status", required = false)
	protected String status;

	@XmlElement(name = "error", required = false)
	@XmlElementWrapper(name = "errors", required = false)
	protected List<String> errors;

	/**
	 * Most commonly used to create an error response. 
	 * @param status
	 * @param errors
	 */
	public AbstractVistaResponse(String status, List<String> errors) {
		super();
		this.status = status;
		this.errors = errors;
	}
	
	/**
	 * Sets up an error message without a status number. 
	 */
	public AbstractVistaResponse(List<String> errors) {
		setErrors(errors);
	}

	/**
	 * default no-arg constructor. 
	 */
	public AbstractVistaResponse() {
		super();
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getRawResponse() {
		return rawResponse;
	}

	public void setRawResponse(String rawResponse) {
		this.rawResponse = rawResponse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

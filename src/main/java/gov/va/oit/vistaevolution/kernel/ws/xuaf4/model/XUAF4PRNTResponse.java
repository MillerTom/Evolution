package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Bill Blackmon <bill.blackmon@medsphere.com>
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4PRNTResponse extends AbstractVistaResponse {

	@XmlElement(required = false)
	private String result;

	/**
	 * default constructor
	 */
	public XUAF4PRNTResponse() {
		super();
	}

	
	public XUAF4PRNTResponse(String result) {
		super();
		this.result = result;
	}
	
	public XUAF4PRNTResponse(String status, List<String> errors) {
		super(status, errors);
		this.result = null;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

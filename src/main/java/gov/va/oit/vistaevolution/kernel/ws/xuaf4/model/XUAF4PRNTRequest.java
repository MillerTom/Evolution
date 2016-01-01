package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author bill.blackmon <bill.blackmon@medshphere.comn>
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4PRNTRequest extends AbstractVistaRequest {

	@XmlElement(name = "sta", required = true)
	private String sta;

	/**
	 * Default No-Arg Constructor
	 */
	public XUAF4PRNTRequest() {
		super();
	}

	public XUAF4PRNTRequest(String sta) {
		this.sta = sta;
	}

	public String getSta() {
		return sta;
	}

	public void setSta(String sta) {
		this.sta = sta;
	}

}

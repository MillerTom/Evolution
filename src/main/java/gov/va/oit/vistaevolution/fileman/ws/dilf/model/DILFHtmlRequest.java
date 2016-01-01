package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

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
public class DILFHtmlRequest extends AbstractVistaRequest {

	@XmlElement(name = "string", required = true)
	private String string;

	@XmlElement(name = "action", required = false)
	private String action;

	
	public DILFHtmlRequest() {
		super();
	}


	public DILFHtmlRequest(String string, String action) {
		super();
		this.string = string;
		this.action= action;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getAction() {
		return action;
	}

	public void setAaction(String action) {
		this.action = action;
	}

	
} 
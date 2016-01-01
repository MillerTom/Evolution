package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Bill Blackmon <bill.blackmon@medsphere.com>
 * 
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFHtmlResponse extends AbstractVistaResponse {

	@XmlElement(required = true)
	private String data; // 1 to encode or -1 to decode


	public DILFHtmlResponse() {
		super();
	}

	public DILFHtmlResponse(String data) {
		super();
		this.data = data;

	} 

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

} // end class

package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

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
public class XMXUTIL1EncodeupResponse extends AbstractVistaResponse {

	@XmlElement(required = false)
	private String result;

	public XMXUTIL1EncodeupResponse() {
		super();
	}

	public XMXUTIL1EncodeupResponse(String result) {
		super();
		this.result = result;
	}

	public XMXUTIL1EncodeupResponse(List<String> errors) {
		setErrors(errors);
		setResult(null);
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

} // end class

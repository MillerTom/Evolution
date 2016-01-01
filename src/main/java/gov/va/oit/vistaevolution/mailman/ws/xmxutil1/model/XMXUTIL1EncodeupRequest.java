package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

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
public class XMXUTIL1EncodeupRequest extends AbstractVistaRequest {

	@XmlElement(name = "input", required = true)
	private String input="";


	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

} // end class

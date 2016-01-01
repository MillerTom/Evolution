package gov.va.oit.vistaevolution.ws.faults;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "VistaWebServiceFault")
@XmlAccessorType(XmlAccessType.NONE)
public class FaultBean {

	@XmlAttribute
	protected String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 */
	public FaultBean() {
		this(null);
	}

	/**
	 * @param message
	 */
	public FaultBean(String message) {
		super();
		this.message = message;
	}

}

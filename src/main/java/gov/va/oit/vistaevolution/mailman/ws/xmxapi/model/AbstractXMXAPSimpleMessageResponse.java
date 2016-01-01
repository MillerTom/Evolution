package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMXAPSimpleMessageResponse extends
	AbstractVistaResponse {

    @XmlElement(required = false)
    private String message;

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

}

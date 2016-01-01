package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType
public class XMXAPICre8XMZResponse extends AbstractVistaResponse {

    private String messageNumber;

    public XMXAPICre8XMZResponse() {
	super();
    }

    public XMXAPICre8XMZResponse(String messageNumber) {
	this.messageNumber = messageNumber;
    }

    public XMXAPICre8XMZResponse(String status, List<String> errors) {
	super(status, errors);
    }

    public String getMessageNumber() {
	return messageNumber;
    }

    public void setMessageNumber(String messageNumber) {
	this.messageNumber = messageNumber;
    }

}

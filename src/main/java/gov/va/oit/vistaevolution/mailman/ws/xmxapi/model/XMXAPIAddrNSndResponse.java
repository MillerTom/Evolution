package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIAddrNSndResponse extends AbstractVistaResponse {

    public XMXAPIAddrNSndResponse() {
	super();
    }

    public XMXAPIAddrNSndResponse(String msgIen) {
	super();
	setMsgIen(msgIen);
    }

    @XmlElement(name = "msgIen", required = false)
    private String msgIen;

    public String getMsgIen() {
	return this.msgIen;
    }

    public void setMsgIen(String msgIen) {
	this.msgIen = msgIen;
    }

    public XMXAPIAddrNSndResponse(String status, List<String> errors) {
	super(status, errors);
    }

}

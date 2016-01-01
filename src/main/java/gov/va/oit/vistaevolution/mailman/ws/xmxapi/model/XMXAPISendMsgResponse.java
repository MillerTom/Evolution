package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPISendMsgResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String xmz;

    public XMXAPISendMsgResponse() {
	super();
    }

    public XMXAPISendMsgResponse(String status, List<String> errors) {
	super(status, errors);
    }

    public XMXAPISendMsgResponse(String xmz) {
	super();
	this.xmz = xmz;
    }

    public String getXmz() {
	return xmz;
    }

    public void setXmz(String xmz) {
	this.xmz = xmz;
    }

}

package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBCre8BsktResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String ien;

    public XMXAPIBCre8BsktResponse(String status, List<String> errors) {
	super(status, errors);
    }

    public XMXAPIBCre8BsktResponse(String status, String ien) {
	super();
	this.setStatus(status);
	this.ien = ien;
    }

    public XMXAPIBCre8BsktResponse() {
	super();
    }

    public String getIen() {
	return ien;
    }

    public void setIen(String ien) {
	this.ien = ien;
    }

}

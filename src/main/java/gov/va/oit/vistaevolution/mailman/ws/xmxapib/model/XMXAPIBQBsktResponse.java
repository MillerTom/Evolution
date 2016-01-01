package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBQBsktResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String ien;

    @XmlElement(required = false)
    private String name;

    @XmlElement(required = false)
    private String numOfMsgs;

    @XmlElement(required = false)
    private String numOfNewMsgs;

    public String getIen() {
	return ien;
    }

    public void setIen(String ien) {
	this.ien = ien;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getNumOfMsgs() {
	return numOfMsgs;
    }

    public void setNumOfMsgs(String numOfMsgs) {
	this.numOfMsgs = numOfMsgs;
    }

    public String getNumOfNewMsgs() {
	return numOfNewMsgs;
    }

    public void setNumOfNewMsgs(String numOfNewMsgs) {
	this.numOfNewMsgs = numOfNewMsgs;
    }
}

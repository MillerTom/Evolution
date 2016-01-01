package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMXAPIBRequest extends AbstractVistaRequest {

    @XmlElement(required = false)
    protected String duz;
    @XmlElement(required = false)
    protected String xmDuz;

    public void setXmDuz(String xmDuz) {
	this.xmDuz = xmDuz;
    }

    public String getDuz() {
	return duz;
    }

    public void setDuz(String duz) {
	this.duz = duz;
    }

    public String getXmDuz() {
	return xmDuz;
    }

}

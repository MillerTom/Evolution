package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMXUtil3Request extends AbstractVistaRequest {
    @XmlElement(required = true)
    private String xmz;

    @XmlElement(required = false)
    private String xmAmt;

    @XmlElement(required = false)
    private String xmStart;

    @XmlElement(required = false)
    private String xmFind;

    public String getXmz() {
	return xmz;
    }

    public void setXmz(String xmz) {
	this.xmz = xmz;
    }

    public String getXmAmt() {
	return xmAmt;
    }

    public void setXmAmt(String xmAmt) {
	this.xmAmt = xmAmt;
    }

    public String getXmStart() {
	return xmStart;
    }

    public void setXmStart(String xmStart) {
	this.xmStart = xmStart;
    }

    public String getXmFind() {
	return xmFind;
    }

    public void setXmFind(String xmFind) {
	this.xmFind = xmFind;
    }
}

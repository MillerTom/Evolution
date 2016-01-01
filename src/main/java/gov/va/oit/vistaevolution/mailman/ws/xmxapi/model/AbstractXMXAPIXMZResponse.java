package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMXAPIXMZResponse extends AbstractVistaResponse {

    @XmlElement(name = "xmz", required = false)
    private String xmz;

    public String getXmz() {
        return xmz;
    }

    public void setXmz(String xmz) {
        this.xmz = xmz;
    }

}

package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2FromRequest extends AbstractVistaRequest {

    @XmlElement(required = true)
    private String xmz;

    public String getXmz() {
	return xmz;
    }

    public void setXmz(String xmz) {
	this.xmz = xmz;
    }

}

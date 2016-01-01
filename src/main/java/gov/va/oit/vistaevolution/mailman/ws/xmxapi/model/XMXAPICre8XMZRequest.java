package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPICre8XMZRequest extends AbstractVistaRequest {

    @XmlElement(required = true)
    private String xmSubj;

    public String getXmSubj() {
	return xmSubj;
    }

    public void setXmSubj(String xmSubj) {
	this.xmSubj = xmSubj;
    }

}

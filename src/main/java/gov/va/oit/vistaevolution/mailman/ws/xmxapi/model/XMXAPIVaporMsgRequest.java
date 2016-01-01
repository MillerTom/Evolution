package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIVaporMsgRequest extends AbstractXMXAPIXmKzaMsgRequest {

    @XmlElement(required = true)
    private String xmVpDate;

    public String getXmVpDate() {
	return xmVpDate;
    }

    public void setXmVpDate(String xmVpDate) {
	this.xmVpDate = xmVpDate;
    }

}

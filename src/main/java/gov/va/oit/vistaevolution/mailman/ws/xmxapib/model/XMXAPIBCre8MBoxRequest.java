package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBCre8MBoxRequest extends AbstractXMXAPIBRequest {

    @XmlElement(required = false)
    private String xmDate;

    public String getXmDate() {
	return xmDate;
    }

    public void setXmDate(String xmDate) {
	this.xmDate = xmDate;
    }
}

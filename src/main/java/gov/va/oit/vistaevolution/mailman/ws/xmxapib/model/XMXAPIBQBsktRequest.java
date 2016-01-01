package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBQBsktRequest extends AbstractXMXAPIBRequest {
    
    @XmlElement(required = true)
    private String xmk;

    public String getXmk() {
	return xmk;
    }

    public void setXmk(String xmk) {
	this.xmk = xmk;
    }
}

package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBCre8BsktRequest extends AbstractXMXAPIBRequest {

    @XmlElement(required = false)
    private String xmkn;

    public String getXmkn() {
	return xmkn;
    }

    public void setXmkn(String xmkn) {
	this.xmkn = xmkn;
    }
}

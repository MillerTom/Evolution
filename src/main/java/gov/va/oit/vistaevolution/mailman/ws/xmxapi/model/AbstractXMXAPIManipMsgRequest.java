package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMXAPIManipMsgRequest extends
	AbstractXMXAPIRequest {

    @XmlElement(name = "xmk", required = true)
    protected String xmk;

    public String getXmk() {
	return xmk;
    }

    public void setXmk(String xmk) {
	this.xmk = xmk;
    }

}

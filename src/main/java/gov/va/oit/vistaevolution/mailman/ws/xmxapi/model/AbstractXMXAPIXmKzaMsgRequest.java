package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMXAPIXmKzaMsgRequest extends
	AbstractXMXAPIManipMsgRequest {

    @XmlElementWrapper(name = "xmkzaList")
    @XmlElement(name = "xmkza", required = false)
    protected List<XMXAPIArrayEntry> xmkza;

    public List<XMXAPIArrayEntry> getXmkza() {
	return xmkza;
    }

    public void setXmkza(List<XMXAPIArrayEntry> xmkza) {
	this.xmkza = xmkza;
    }

}

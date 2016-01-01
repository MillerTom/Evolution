package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIReplyMsgRequest extends AbstractXMXAPIManipMsgRequest {

    @XmlElement(name = "xmkz", required = false)
    private String xmkz;

    @XmlElementWrapper(name = "xmBody", required = true)
    @XmlElement(name = "text", required = true)
    private List<String> xmBody;

    @XmlElementWrapper(name = "xmInstrs", required = false)
    @XmlElement(name = "xmInstr", required = false)
    private List<XMXAPIArrayEntry> xmInstr;

    public String getXmkz() {
	return xmkz;
    }

    public void setXmkz(String xmkz) {
	this.xmkz = xmkz;
    }

    public List<String> getXmBody() {
	return xmBody;
    }

    public void setXmBody(List<String> xmBody) {
	this.xmBody = xmBody;
    }

    public List<XMXAPIArrayEntry> getXmInstr() {
	return xmInstr;
    }

    public void setXmInstr(List<XMXAPIArrayEntry> xmInstr) {
	this.xmInstr = xmInstr;
    }

}

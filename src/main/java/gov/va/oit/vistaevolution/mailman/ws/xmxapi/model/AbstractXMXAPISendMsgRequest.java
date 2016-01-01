package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class AbstractXMXAPISendMsgRequest extends AbstractXMXAPIRequest {

    @XmlElement(name = "xmSubj", required = false)
    private String xmSubj;

    @XmlElementWrapper(name = "msg")
    @XmlElement(name = "text", required = true)
    private List<String> msg;

    @XmlElementWrapper(name = "xmTo")
    @XmlElement(name = "addressee", required = true)
    private List<XMXAPIArrayEntry> xmTo;

    @XmlElementWrapper(name = "xmInstrs")
    @XmlElement(name = "xmInstr", required = false)
    private List<XMXAPIArrayEntry> xmInstr;

    public String getXmSubj() {
	return xmSubj;
    }

    public void setXmSubj(String xmSubj) {
	this.xmSubj = xmSubj;
    }

    public List<String> getMsg() {
	return msg;
    }

    public void setMsg(List<String> msg) {
	this.msg = msg;
    }

    public List<XMXAPIArrayEntry> getXmTo() {
	return xmTo;
    }

    public void setXmTo(List<XMXAPIArrayEntry> xmTo) {
	this.xmTo = xmTo;
    }

    public List<XMXAPIArrayEntry> getXmInstr() {
	return xmInstr;
    }

    public void setXmInstr(List<XMXAPIArrayEntry> xmInstr) {
	this.xmInstr = xmInstr;
    }

}

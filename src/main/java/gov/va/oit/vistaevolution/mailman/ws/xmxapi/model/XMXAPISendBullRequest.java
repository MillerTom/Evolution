package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPISendBullRequest extends AbstractXMXAPIRequest {

    @XmlElement(required = true)
    private String xmbn;

    @XmlElementWrapper(name = "xmParms")
    @XmlElement(name = "xmParm", required = false)
    private List<XMXAPIArrayEntry> xmParm;

    @XmlElementWrapper(name = "msg")
    @XmlElement(name = "text", required = false)
    private List<String> msg;

    @XmlElementWrapper(name = "xmTo")
    @XmlElement(name = "addressee", required = false)
    private List<XMXAPIArrayEntry> xmTo;

    @XmlElementWrapper(name = "xmInstrs")
    @XmlElement(name = "xmInstr", required = false)
    private List<XMXAPIArrayEntry> xmInstr;

    public String getXmbn() {
	return xmbn;
    }

    public void setXmbn(String xmbn) {
	this.xmbn = xmbn;
    }

    public List<XMXAPIArrayEntry> getXmParm() {
	return xmParm;
    }

    public void setXmParm(List<XMXAPIArrayEntry> xmParm) {
	this.xmParm = xmParm;
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

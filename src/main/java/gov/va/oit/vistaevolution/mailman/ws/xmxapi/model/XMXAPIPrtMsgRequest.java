package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIPrtMsgRequest extends AbstractXMXAPIXmKzaMsgRequest {

    @XmlElement(name = "xmPrtTo", required = true)
    private String xmPrtTo;

    @XmlElement(name = "xmInstr", required = false)
    private String xmInstr;

    @XmlElement(name = "xmSubj", required = false)
    private String xmSubj;

    @XmlElementWrapper(name = "xmTo", required = false)
    @XmlElement(name = "addressee", required = false)
    private List<XMXAPIArrayEntry> xmTo;

    public String getXmPrtTo() {
	return xmPrtTo;
    }

    public void setXmPrtTo(String xmPrtTo) {
	this.xmPrtTo = xmPrtTo;
    }

    public String getXmInstr() {
	return xmInstr;
    }

    public void setXmInstr(String xmInstr) {
	this.xmInstr = xmInstr;
    }

    public String getXmSubj() {
	return xmSubj;
    }

    public void setXmSubj(String xmSubj) {
	this.xmSubj = xmSubj;
    }

    public List<XMXAPIArrayEntry> getXmTo() {
	return xmTo;
    }

    public void setXmTo(List<XMXAPIArrayEntry> xmTo) {
	this.xmTo = xmTo;
    }

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmd.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMDRequest extends AbstractVistaRequest {

    @XmlElement(required = true)
    private String duz;

    @XmlElement(required = false)
    private String xmDuz;

    @XmlElement(required = true)
    private String xmSub;

    @XmlElementWrapper(required = true, name = "message")
    @XmlElement(required = true, name = "text")
    private List<String> message;

    @XmlElementWrapper(required = false, name = "xmy")
    @XmlElement(required = false, name = "xmyEntry")
    private List<XMYEntry> xMY;

    @XmlElement(required = false)
    private String xmStrip;

    public String getDuz() {
	return duz;
    }

    public void setDuz(String duz) {
	this.duz = duz;
    }

    public String getXmDuz() {
	return xmDuz;
    }

    public void setXmDuz(String xmDuz) {
	this.xmDuz = xmDuz;
    }

    public String getXmSub() {
	return xmSub;
    }

    public void setXmSub(String xmSub) {
	this.xmSub = xmSub;
    }

    public List<String> getMessage() {
	return message;
    }

    public void setMessage(List<String> message) {
	this.message = message;
    }

    public List<XMYEntry> getxMY() {
	return xMY;
    }

    public void setxMY(List<XMYEntry> xMY) {
	this.xMY = xMY;
    }

    public String getXmStrip() {
	return xmStrip;
    }

    public void setXmStrip(String xmStrip) {
	this.xmStrip = xmStrip;
    }

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2KSeqNRequest extends AbstractVistaRequest {

    @XmlElement(required = true)
    private String duz;
    @XmlElement(required = true)
    private String xmk;
    @XmlElement(required = true)
    private String xmz;

    public String getDuz() {
	return duz;
    }

    public void setDuz(String duz) {
	this.duz = duz;
    }

    public String getXmk() {
	return xmk;
    }

    public void setXmk(String xmk) {
	this.xmk = xmk;
    }

    public String getXmz() {
	return xmz;
    }

    public void setXmz(String xmz) {
	this.xmz = xmz;
    }

}

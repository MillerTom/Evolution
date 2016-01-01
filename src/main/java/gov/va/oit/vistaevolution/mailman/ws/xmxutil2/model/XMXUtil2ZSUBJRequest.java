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
public class XMXUtil2ZSUBJRequest extends AbstractVistaRequest {

    @XmlElement(required = true)
    private String xmz;

    /**
     * Default no-arg constructor
     */
    public XMXUtil2ZSUBJRequest() {
	super();
    }

    /**
     * @param subject
     */
    public XMXUtil2ZSUBJRequest(String subject) {
	super();
	this.setXmz(subject);
    }

    public String getXmz() {
	return xmz;
    }

    protected void setXmz(String xmz) {
	this.xmz = xmz;
    }

}

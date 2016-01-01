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
public class XMXUtil2LineRequest extends AbstractVistaRequest {

    @XmlElement(required = false)
    private String ien;

    /**
     * @param ien
     */
    public XMXUtil2LineRequest(String ien) {
	super();
	this.ien = ien;
    }

    /**
	 * 
	 */
    public XMXUtil2LineRequest() {
	this(null);
    }

    public String getIen() {
	return ien;
    }

    protected void setIen(String ien) {
	this.ien = ien;
    }

}

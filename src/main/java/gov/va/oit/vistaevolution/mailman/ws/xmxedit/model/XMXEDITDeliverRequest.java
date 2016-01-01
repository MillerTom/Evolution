/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * 
 * Set/Delete Message Delivery Basket (All Users)
 * Input Parameter Class:
 * 
 * xmz:         (Required, Sequence = 1) Message Internal Entry
 *              Number (IEN) in the MESSAGE file (#3.9).
 * 
 * xmdbskt:     (Required, Sequence = 2) New Delivery basket name:
 *              "@" (at-sign), if you want to delete it.
 * 
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXEDITDeliverRequest extends AbstractVistaRequest {
    
    @XmlElement(required = true)
    private String xmz;
    
    @XmlElement(required = true)
    private String xmdbkst;
    
    /**
     * @return the xmz
     */
    public String getXmz() {
        return this.xmz;
    }
    
    /**
     * @param xmz the xmz to set
     */
    public void setXmz(final String xmz) {
        this.xmz = xmz;
    }
    
    /**
     * @return the xmdbkst
     */
    public String getXmdbkst() {
        return this.xmdbkst;
    }
    
    /**
     * @param xmdbkst the xmdbkst to set
     */
    public void setXmdbkst(final String xmdbkst) {
        this.xmdbkst = xmdbkst;
    }
    
    /**
     * Default Bean Constructor
     */
    public XMXEDITDeliverRequest() {
        super();
    }
    
}

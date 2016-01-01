
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * 
 * Get Message Information (Part 2)
 * Input Parameter Class:
 * 
 * xmduz:       (Required, Sequence = 1) User DUZ.
 * 
 * xmz:         (Required, Sequence = 2) Message Internal Entry
 *              Number (IEN) in the MESSAGE file (#3.9).
 * 
 * xmzrec:      (Optional, Sequence = 3) Zero node of the
 *              message: ^XMB(3.9,XMZ,0).
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL2Inmsg2Request extends AbstractVistaRequest {
    
    
    @XmlElement(required = true)
    private String xmduz;
    
    @XmlElement(required = true)
    private String xmz;
    
    @XmlElement(required = false)
    private String xmzrec;
    
    
    /**
     * @return the xmduz
     */
    public String getXmduz() {
        return this.xmduz;
    }
    
    
    /**
     * @param xmduz the xmduz to set
     */
    public void setXmduz(final String xmduz) {
        this.xmduz = xmduz;
    }
    
    
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
     * @return the xmzrec
     */
    public String getXmzrec() {
        return this.xmzrec;
    }
    
    
    /**
     * @param xmzrec the xmzrec to set
     */
    public void setXmzrec(final String xmzrec) {
        this.xmzrec = xmzrec;
    }
    
    
    /**
     * Default Bean Constructor
     */
    public XMXUTIL2Inmsg2Request() {
        super();
    }
    
}

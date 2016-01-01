/**
 *
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Set Server-related Fields in the Message File
 * Input Parameter Class:
 *
 * xmz:         (Required, Sequence = 1) Message
 *              Internal Entry Number (IEN) in the
 *              MESSAGE file (#3.9).
 *
 * xmser:       (Required, Sequence = 2) Server name.
 *              Must be the full name, starting with "S."
 *
 * status:      (Required, Sequence = 3) Status string
 *              to put in the STATUS field.
 * </pre>
 *
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMS1SrvTimeRequest extends AbstractVistaRequest {
    
    @XmlElement(required = true)
    private String xmz;
    
    @XmlElement(required = true)
    private String xmser;
    
    @XmlElement(required = true)
    private String status;
    
    
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
     * @return the xmser
     */
    public String getXmser() {
        return this.xmser;
    }
    
    
    /**
     * @param xmser the xmser to set
     */
    public void setXmser(final String xmser) {
        this.xmser = xmser;
    }
    
    
    /**
     * @return the status
     */
    public String getStatus() {
        return this.status;
    }
    
    
    /**
     * @param status the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }
    
    
    /**
     * Default Bean Constructor
     */
    public XMS1SrvTimeRequest() {
        super();
    }
}

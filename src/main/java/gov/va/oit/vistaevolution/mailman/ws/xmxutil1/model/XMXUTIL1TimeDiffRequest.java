/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * 
 * Reformat Decimal Time Difference to +-hhmm
 * Input Parameter Class:
 * 
 * xmdiff:      (Required) Decimal time difference.
 * 
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1TimeDiffRequest extends AbstractVistaRequest {
    
    @XmlElement(required = true)
    private String xmdiff;
    
    
    /**
     * @return the xmdiff
     */
    public String getXmdiff() {
        return this.xmdiff;
    }
    
    
    /**
     * @param xmdiff the xmdiff to set
     */
    public void setXmdiff(final String xmdiff) {
        this.xmdiff = xmdiff;
    }
    
    
    /**
     * Default Bean Constructor
     */
    public XMXUTIL1TimeDiffRequest() {
        super();
    }
    
}

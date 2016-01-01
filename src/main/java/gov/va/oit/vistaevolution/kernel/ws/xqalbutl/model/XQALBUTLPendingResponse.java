/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Pending Alerts for a User  
 * Output Parameters Class:
 * 
 * returns: Returns:
 * 
 *          1—YES, alert is pending.
 *
 *          0—NO, alert is not pending. * 
 * </pre>
 * 
 * @author rcollins
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XQALBUTLPendingResponse extends AbstractVistaResponse {
    
    @XmlElement(required = true)
    private String returns;  

    /**
     * @return the returns
     */
    public String getReturns() {
        return returns;
    }

    /**
     * @param returns the returns to set
     */
    public void setReturns(String returns) {
        this.returns = returns;
    }

    /**
     * Bean constructor initializes value
     * @param value
     */
    public XQALBUTLPendingResponse(final String value) {
        this.returns = value;
    }
    

    /**
     * Default Bean Constructor
     * @param value
     */
    public XQALBUTLPendingResponse() {
        this.returns = null;
    }
    
}

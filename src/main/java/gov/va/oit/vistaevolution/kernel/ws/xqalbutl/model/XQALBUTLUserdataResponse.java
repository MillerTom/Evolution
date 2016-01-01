
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * 
 * Get User Informationi for an Alert 
 * Output Parameters Class:
 * 
 * returns:   Returns:
 * 
 *            ALERT TRACKING File Entry—The information 
 *            associated with the desired entry in the 
 *            ALERT TRACKING file (#8992.1) descendent from 
 *            the specified root.
 *            
 *            NULL—If the specified alert is not present, 
 *            the array root is returned with a NULL value.
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@XmlRootElement(name = "XQALBUTLUserdataResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XQALBUTLUserdataResponse extends AbstractVistaResponse {
    
    @XmlElementWrapper(name = "response")
    @XmlElement(required = true)
    private List<String>returns;
    

    /**
     * @return the returns
     */
    public List<String> getReturns() {
        return this.returns;
    }

    /**
     * @param returns the returns to set
     */
    protected void setReturns(final List<String> returns) {
        this.returns = returns;
    }

    /**
     * Default Bean Constructor
     */
    public XQALBUTLUserdataResponse() {
        super();
        this.returns = null;
    }
    
    /**
     * Bean Constructor initializes the class
     * 
     * @param value
     * @param rawResponse
     */
    public XQALBUTLUserdataResponse(final List<String> value, 
            final String rawResponse) {
        
        this();
        this.returns = value;
        this.rawResponse = rawResponse;       
    }
}

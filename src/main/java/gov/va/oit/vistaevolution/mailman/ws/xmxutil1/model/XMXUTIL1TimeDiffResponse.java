
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * 
 * Reformat Decimal Time Difference to +-hhmm
 * Output Parameter Class:
 * 
 * response:    (Required) Returns reformatted decimal
 *              time difference to +-hhmm.
 * 
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement(name = "XMXUTIL1TimeDiffResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1TimeDiffResponse extends AbstractVistaResponse {
    
    @XmlElement(required = true)
    private String response;
    
    /**
     * @return the response
     */
    public String getResponse() {
        return this.response;
    }
    
    /**
     * @param response the response to set
     */
    protected void setResponse(final String response) {
        this.response = response;
    }
    
    /**
     * Default Bean Constructor
     */
    public XMXUTIL1TimeDiffResponse() {
        super();
    }
    
    /**
     * Constructor Initializes Object
     * @param value
     * @param rawResponse
     */
    public XMXUTIL1TimeDiffResponse(final String value) {
        
        this();
        this.response = value;
        this.rawResponse = value;
    }
    
}

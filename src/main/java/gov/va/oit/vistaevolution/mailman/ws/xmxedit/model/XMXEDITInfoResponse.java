
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * 
 * "Information Only" Flag Toggle
 * Output Parameters Class:
 * 
 * message:     (Required) Appropiate message, suitable for
 *              display to the user
 * 
 * flag:        (Optional) the flag that was sent into the service
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@XmlRootElement(name = "XMXEDITInfoResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXEDITInfoResponse extends AbstractVistaResponse {
    
    
    @XmlElement(name = "message", required = true)
    private String message;
    
    @XmlElement(name = "flag", required = false)
    private String flag;
    
    
    /**
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }
    
    
    /**
     * @param message the message to set
     */
    public void setMessage(final String message) {
        this.message = message;
    }
    
    
    /**
     * @return the flag
     */
    public String getFlag() {
        return this.flag;
    }
    
    
    /**
     * @param flag the flag to set
     */
    public void setFlag(final String flag) {
        this.flag = flag;
    }
    
    
    /**
     * Default Bean Constructor
     */
    public XMXEDITInfoResponse() {
        super();
    }
    
    
    /**
     * Constructor initializes the status, message and the
     * rawResponse fields in this class
     * 
     * @param status
     * @param msg
     * @param rawResponse
     */
    public XMXEDITInfoResponse(final String status, final String msg, 
            final String rawResponse) {
        
        this();
        this.status = status;
        this.message = msg;
        this.rawResponse = rawResponse;
        this.flag = null;
    }
    
    
    /**
     * Constructor initializes the status, message, flag and the
     * rawResponse fields in this class
     * 
     * @param status
     * @param msg
     * @param flag
     * @param rawResponse
     */
    public XMXEDITInfoResponse(final String status, final String msg, 
            final String flag, final String rawResponse) {
        
        this(status, msg, rawResponse);
        this.flag = flag;
    }
    
    
}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * 
 * Set/Delete Message Delivery Basket (All Users)
 * Output Parameter Class:
 * 
 * message:     (Required)  Appropriate message, suitable for 
 *              display to the user.
 * 
 * 
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement(name = "XMXEDITDeliverResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXEDITDeliverResponse extends AbstractVistaResponse {
    
    
    @XmlElement(name = "message", required = true)
    private String message;
    
    
    /**
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * @param message the message to set
     */
    protected void setMessage(String message) {
        this.message = message;
    }

    /**
     * Default Bean Constructor 
     */
    public XMXEDITDeliverResponse() {
        super();
    }
    
    /**
     * Constructor initializes the message and the 
     * rawResponse members
     * @param status
     * @param rawResponse
     */
    public XMXEDITDeliverResponse(String msg, String rawResponse) {
        
        this();
        this.message = msg;
        this.rawResponse = rawResponse;
    }

    /**
     * Constructor initializes the message, special,
     * and the rawResponse members
     * 
     * @param msg
     * @param special
     * @param rawResponse
     */
    public XMXEDITDeliverResponse(String msg, String status, String rawResponse) {
        
        this(msg, rawResponse);
        this.status = status;
    }    
}

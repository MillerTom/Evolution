package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Get the Number of Responses to a Message
 * Output Parameter Class:
 * 
 * responses:       (Required) Number of responses to a message.
 *                  If the number is a negative value, the message 
 *                  will explain the reasoning.
 *                  
 * message:         (Optional) Message explaining the result.
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement(name = "XMXUTIL2RespResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL2RespResponse extends AbstractVistaResponse {
    
    @XmlElement(name = "responses", required = true)
    private String responses;
    
    @XmlElement(name = "message", required = false)
    private String message;
    
    /**
     * @return the responses
     */
    public String getResponses() {
        return this.responses;
    }

    /**
     * @param responses the responses to set
     */
    protected void setResponses(String responses) {
        this.responses = responses;
    }

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
    public XMXUTIL2RespResponse() {
        super();
    }
    
    /**
     * This constructor sets the number of responses and
     * the rawResponse members
     * @param resp
     * @param rawResponse
     */
    public XMXUTIL2RespResponse(String resp, 
            String rawResponse) {
        
        this();
        this.message = null;
        this.responses = resp;
        this.rawResponse = rawResponse;
    }
    
    /**
     * This constructor sets the number of responses, 
     * the message, and the rawResponse members.
     * @param resp
     * @param msg
     * @param rawResponse
     */
    public XMXUTIL2RespResponse(String resp, 
            String msg, String rawResponse) {
        
        this(resp, rawResponse);
        this.message = msg;
    }
    
}

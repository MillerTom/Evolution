/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlElement;

/**
 * <pre>
 * 
 * Get Message Response Information
 * Ouput Parameter Class:
 * 
 * responses:       (Optional) Number of responses for a message.
 * 
 * lastResponse:    (Optional) Number of the last response that the
 *                  user has read.
 * 
 * message:         (Optional) message to user.
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
public class XMXUTIL2InrespsResponse extends AbstractVistaResponse {
    
    
    @XmlElement(name = "responses", required = false)
    private String responses;
    
    @XmlElement(name = "last_response", required = false)
    private String lastResponse;
    
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
    protected void setResponses(final String responses) {
        this.responses = responses;
    }
    
    
    /**
     * @return the lastResponse
     */
    public String getLastResponse() {
        return this.lastResponse;
    }
    
    
    /**
     * @param lastResponse the lastResponse to set
     */
    protected void setLastResponse(final String lastResponse) {
        this.lastResponse = lastResponse;
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
    protected void setMessage(final String message) {
        this.message = message;
    }
    
    
    /**
     * Default Bean Constructor
     */
    public XMXUTIL2InrespsResponse() {
        super();
    }
    
    
    /**
     * Constructor initializes the message,
     * and rawResponse;
     * 
     * @param message
     * @param rawResponse
     */
    public XMXUTIL2InrespsResponse(final String message, final String rawResponse) {
        
        this();
        this.status = "-1";
        this.message = message;
        this.rawResponse = rawResponse;
    }
    
    /**
     * Constructor initializes the responses, lastResponse,
     * and rawResponse members
     * 
     * @param responses
     * @param lastResponse
     * @param rawResponse
     */
    public XMXUTIL2InrespsResponse(final String responses, final String lastResponse, 
            final String rawResponse) {
        
        this();
        this.responses = responses;
        this.lastResponse = lastResponse;
        this.rawResponse = rawResponse;
    }
    
    
}

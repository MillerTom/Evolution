/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Set Server-related Fields in the Message File
 * Output Parameter class:
 * 
 * response:     (Required)
 * 
 * message:      (Optional)
 * 
 *               0—No error.
 *               "1 No Update"—If XMSER not found in the RECIPIENT multiple.
 *               "2 Status too long"—If STATUS is longer than 30 characters.
 *               "3 Bad Characters in Status"—If STATUS contains a caret ("^").
 * 
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement(name = "XMS1SrvTimeResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMS1SrvTimeResponse extends AbstractVistaResponse {
    
    @XmlElement(name = "response", required = true)
    private String response;
    
    @XmlElement(name = "message", required = false)
    private String message;
    
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
    public XMS1SrvTimeResponse() {
        super();
    }
    
    /**
     * Constructor initializes the response
     * and rawResponse objects
     * @param resp
     * @param rawResponse
     */
    public XMS1SrvTimeResponse(final String resp, final String rawResponse) {
        
        this();
        this.message = null;
        this.response = resp;
        this.rawResponse = rawResponse;
    }
    
    /**
     * Constructor initializes the response, message,
     * and rawResponse objects.
     * @param resp
     * @param message
     * @param rawResponse
     */
    public XMS1SrvTimeResponse(final String resp, final String message, 
            final String rawResponse) {
        
        this(resp, rawResponse);
        this.message = message;
    }
    
}

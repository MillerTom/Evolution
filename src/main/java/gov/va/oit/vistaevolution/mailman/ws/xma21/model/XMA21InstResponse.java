
package gov.va.oit.vistaevolution.mailman.ws.xma21.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Address Lookup (Non-Interactive)
 * Output Parameter Class:
 *
 * response:        Returns local array:
 *                      ADDRESS^<domain IEN>     (remote only)
 *                      REMOTE^via <domain name> (remote only)
 *                      REMOTE^<domain IEN>^<domain name>  (remote only)
 *
 *                      LOCAL^<DUZ>^<full name>  (local only)
 *                      ADDRESS^<DUZ>            (local only)
 *
 *                  Or one of the following errors:
 *
 *                      -1^Error in required input
 *                      -1^Addressee not found
 *                      -1^Domain not found
 *                      -1^Domain closed: <domain>
 *                      -1^Keys required for domain: <domain>
 *                      -1^May not forward priority mail to groups
 *                      -1^Message length restrictions to remote addresses
 * <pre>
 *
 * @author rcollins
 */
@XmlRootElement(name = "XMA21InstResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMA21InstResponse extends AbstractVistaResponse {
    
    @XmlElement(name = "duz", required = false)
    private String duz;
    
    @XmlElement(name = "username", required = false)
    private String username;
    
    @XmlElement(name = "address", required = false)
    private String address;
    
    @XmlElement(name = "location", required = false)
    private String location;
    
    @XmlElement(name = "domain_ien", required = false)
    private String ien;
    
    @XmlElement(name = "domain", required = false)
    private String domain;
    
    @XmlElement(name = "response", required = false)
    private String response;
    
    @XmlElement(name = "message", required = false)
    private String message;
    
    
    /**
     * @return the duz
     */
    public String getDuz() {
        return this.duz;
    }
    
    /**
     * @param duz the duz to set
     */
    protected void setDuz(final String duz) {
        this.duz = duz;
    }
    
    /**
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * @param username the username to set
     */
    protected void setUsername(final String username) {
        this.username = username;
    }
    
    /**
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }
    
    /**
     * @param address the address to set
     */
    protected void setAddress(final String address) {
        this.address = address;
    }
    
    /**
     * @return the location
     */
    public String getLocation() {
        return this.location;
    }
    
    /**
     * @param location the location to set
     */
    protected void setLocation(final String location) {
        this.location = location;
    }
    
    /**
     * @return the ien
     */
    public String getIen() {
        return this.ien;
    }

    /**
     * @param ien the ien to set
     */
    protected void setIen(String ien) {
        this.ien = ien;
    }

    /**
     * @return the domain
     */
    public String getDomain() {
        return this.domain;
    }
    
    /**
     * @param domain the domain to set
     */
    protected void setDomain(final String domain) {
        this.domain = domain;
    }
    
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
    public XMA21InstResponse() {
        super();
    }
    
    /**
     * This constructor initializes values for a valid
     * message response.
     * @param message
     * @param rawResponse
     */
    public XMA21InstResponse(final String message, final String rawResponse) {
        
        this();
        this.response = "-1";
        this.message = message;
        this.rawResponse = rawResponse;
    }
    
    
    /**
     * This constructor initializes values for a valid
     * LOCAL response.
     * @param username
     * @param duz
     * @param rawResponse
     */
    public XMA21InstResponse(final String username, final String duz, 
            final String rawResponse) {
        
        this();
        this.username = username;
        this.duz = duz;
        this.rawResponse = rawResponse;
        this.location = "LOCAL";
    }
    
    
    /**
     * This constructor initializes values for a valid
     * REMOTE response.
     * @param address
     * @param ien
     * @param domain
     * @param rawResponse
     */
    public XMA21InstResponse(final String address, final String ien, 
            final String domain, final String rawResponse) {
        
        this();
        this.address = address;
        this.ien = ien;
        this.domain = domain;
        this.rawResponse = rawResponse;
        this.location = "REMOTE";
    }
    
}

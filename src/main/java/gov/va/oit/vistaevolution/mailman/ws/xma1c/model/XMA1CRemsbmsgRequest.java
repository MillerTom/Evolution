
package gov.va.oit.vistaevolution.mailman.ws.xma1c.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Delete a Message from a Server Basket
 * Input Parameters Class: 
 * 
 * xmz:         (Required, Sequence = 1) Message Internal Entry 
 *              Number (IEN) in the MESSAGE file (#3.9).
 *              
 * xmser:       (Required, Sequence = 2) Server name. Must be the 
 *              full name, starting with "S."
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA1CRemsbmsgRequest {
	
    @XmlElement(required = true)
    private String xmser;
    @XmlElement(required = true)
	private String xmz;
	
    /**
     * @return the xmser
     */
    public String getXmser() {
        return xmser;
    }
    
    /**
     * @param xmser the xmser to set
     */
    public void setXmser(String xmser) {
        this.xmser = xmser;
    }
    
    /**
     * @return the xmz
     */
    public String getXmz() {
        return xmz;
    }
    
    /**
     * @param xmz the xmz to set
     */
    public void setXmz(String xmz) {
        this.xmz = xmz;
    }
	
    /**
     * Default Bean Constructor
     */
	public XMA1CRemsbmsgRequest() {
	    super();
	}
	
	/**
	 * Constructor initializes the object
	 * @param serverName
	 * @param message
	 */
	public XMA1CRemsbmsgRequest(final String serverName, 
	        final String message) {
	     
	    this();
	    this.xmser = serverName;
	    this.xmz = message;
	}
}

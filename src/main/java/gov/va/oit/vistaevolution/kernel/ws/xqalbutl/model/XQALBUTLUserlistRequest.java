
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Get Recipient Information for an Alert
 * Input Parameters Class:
 * 
 * xuaid:    (Required, Sequence = 1) This is the value XUAID 
 *           which is the alert identifier. It is passed to the 
 *           routine or option which is run when the alert is 
 *           selected.  It can also be obtained from a listing 
 *           of all of the XUAIDs for a specified user and/or 
 *           patient.
 * 
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XQALBUTLUserlistRequest {

	@XmlElement(required = true)
	private String xqaid;
	
	/**
     * @return the xqaid
     */
    public String getXqaid() {
        return this.xqaid;
    }

    /**
     * @param xqaid the xqaid to set
     */
    public void setXqaid(final String xqaid) {
        this.xqaid = xqaid;
    }
    
	/**
	 * Default Bean Constructor
	 */
	public XQALBUTLUserlistRequest() {
	    super();
	}

	public XQALBUTLUserlistRequest(String xqaid) {
	    super();
	    this.xqaid = xqaid;
	}

}

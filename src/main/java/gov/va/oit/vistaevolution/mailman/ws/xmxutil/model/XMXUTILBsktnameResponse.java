
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

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
 * bkstIEN:     (Reqired) Returns the IEN of a user's basket.
 * 
 * bkstName:    (Optional) Returns the name of a user's basket.
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement(name = "XMXUTILBsktnameResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILBsktnameResponse extends AbstractVistaResponse {
	
	@XmlElement(required = true)
	private String bsktIEN;
	
	@XmlElement(required = false)
	private String bsktName;
    
    /**
     * Default Bean Constructor
     */
    public XMXUTILBsktnameResponse() {
        super();
    }
    
    public XMXUTILBsktnameResponse(String bsktIEN) {
    	super();
    	this.bsktIEN = bsktIEN;
    }
    
    /**
     * Constructor initializes object
     * @param returns
     */
    public XMXUTILBsktnameResponse(String bsktIEN, String bsktName) {
    	super();
    	this.bsktIEN = bsktIEN;
    	this.bsktName = bsktName;
    }


	public String getBsktIEN() {
		return bsktIEN;
	}


	public void setBsktIEN(String bsktIEN) {
		this.bsktIEN = bsktIEN;
	}


	public String getBsktName() {
		return bsktName;
	}


	public void setBsktName(String bsktName) {
		this.bsktName = bsktName;
	}
    
}

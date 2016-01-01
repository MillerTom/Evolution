
package gov.va.oit.vistaevolution.kernel.ws.xusap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * VistaLink - This extrinsic function checks if user IEN passed in is linked to an active user
 * 
 * @param duz: (required) IEN of the user from the New Person file (#200).
 *          
 * @author Stephen Combs <Stephen.Combs@Synaptekcorp.com>
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSAPActiveRequest {
    
    @XmlElement(required = false)
    private String duz;
    
    /**
     * Default Bean Constructor
     */
    public XUSAPActiveRequest() {
        super();
    }
    
    /**
     * Bean Constructor w/ arguments
     * 
     * @param duz (required) IEN of the user from the New Person file (#200).
     */
    public XUSAPActiveRequest(String duz) {
        super();
        this.duz = duz;
    }

	/**
	 * @return the duz
	 */
	public String getDuz() {
		return duz;
	}

	/**
	 * @param duz the duz to set
	 */
	public void setDuz(String duz) {
		this.duz = duz;
	}
    


}

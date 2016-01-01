
package gov.va.oit.vistaevolution.kernel.ws.xusap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * VistaLink - This extrinsic function checks if user IEN passed in is linked to an active user
 * 
 * @ret Returns 1 if active user, 0 if not. 
 * 
 * @author Stephen Combs <Stephen.Combs@Synaptekcorp.com>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSAPActiveResponse {
    
    /**
	 * 
	 */
	public XUSAPActiveResponse() {
		super();
	}

	@XmlElement(required = true)
    private String ret;

    /**
     * @return the ret
     */
    public String getRet() {
        return ret;
    }

    /**
     * @param ret the ret to set
     */
    public void setRet(String ret) {
        this.ret = ret;
    }

    /**
     * Constructor initializes the class with 
     * the return value
     * @param ret
     */
    public XUSAPActiveResponse(String ret) {
        
        super();
        this.ret = ret;
    }
    
}

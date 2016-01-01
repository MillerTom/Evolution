/**
 *
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Get the Name of a User's Basket
 * Input Parameters Class:
 *
 * xmduz:       (required) User DUZ.
 *
 * xmk:         (required) Basket IEN.
 * </pre>
 *
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILBsktnameRequest extends AbstractVistaRequest{
	
	@XmlElement(required = true)
	private String xmduz;

	@XmlElement(required = true)
	private String xmz;

	@XmlElement(required = false)
	private String xmname = "0"; // set the default value
	
	/**
     * Default Bean Constructor
     */
    public XMXUTILBsktnameRequest() {
        super();
    }


    public XMXUTILBsktnameRequest(final String xmduz, 
            final String xmz) {
    	
    	super();
    	this.xmduz = xmduz;
    	this.xmz = xmz;
        
    }

    public XMXUTILBsktnameRequest(final String xmduz, 
            final String xmz, final String xmname) {
        
    	super();
    	this.xmduz = xmduz;
    	this.xmz = xmz;
        this.xmname = xmname;
    }

	public String getXmname() {
		return xmname;
	}

	public void setXmname(String xmname) {
		this.xmname = xmname;
	}

	public String getXmduz() {
		return xmduz;
	}

	public void setXmduz(String xmduz) {
		this.xmduz = xmduz;
	}

	public String getXmz() {
		return xmz;
	}

	public void setXmz(String xmz) {
		this.xmz = xmz;
	}

}

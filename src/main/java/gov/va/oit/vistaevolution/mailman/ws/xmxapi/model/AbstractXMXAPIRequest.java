package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMXAPIRequest extends AbstractVistaRequest {

    /**
     * DUZ :
     * 
     * User's DUZ.
     * 
     * XMDUZ :
     * 
     * The user (DUZ or name)
     */

    @XmlElement(name = "duz", required = true)
    private String duz;
    @XmlElement(name = "xmDuz", required = true)
    private String xmDuz;

    /**
     * No Arguments Constructor
     */
    public AbstractXMXAPIRequest() {
	super();
    }

    /**
     * Parameterised Constructor
     * 
     * @param duz
     * @param xmDuz
     */
    public AbstractXMXAPIRequest(String duz, String xmDuz) {
	super();
	this.duz = duz;
	this.xmDuz = xmDuz;
    }

    public String getDuz() {
	return duz;
    }

    public void setDuz(String duz) {
	this.duz = duz;
    }

    public String getXmDuz() {
	return xmDuz;
    }

    public void setXmDuz(String xmDuz) {
	this.xmDuz = xmDuz;
    }

}

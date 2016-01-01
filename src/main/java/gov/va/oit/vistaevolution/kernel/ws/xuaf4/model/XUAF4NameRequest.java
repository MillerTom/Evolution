package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * IEN (The internal entry number for the requested site.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4NameRequest extends AbstractVistaRequest {

    @XmlElement(name = "ien", required = true)
    private String IEN;

    /**
     * Default no arg constructor for JAXB
     */
    public XUAF4NameRequest() {
	this.setIEN(null);
    }

    /**
     * @param string
     */
    public XUAF4NameRequest(String value) {
	this.setIEN(value);
    }

    public String getIEN() {
	return IEN;
    }

    protected void setIEN(String IEN) {
	this.IEN = IEN;
    }

}

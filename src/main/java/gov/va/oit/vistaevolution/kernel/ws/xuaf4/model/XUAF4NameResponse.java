package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * IEN (The internal entry number for the requested site.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4NameResponse extends AbstractVistaResponse {

    @XmlElement(name = "institutionName", required = false)
    private String institutionName;

    public XUAF4NameResponse(List<String> errors) {
	super(errors);
    }

    /**
     * Default no arg constructor for JAXB
     */
    public XUAF4NameResponse() {
	this.setInstitutionName(null);
    }

    /**
     * @param string
     */
    public XUAF4NameResponse(String value) {
	this.setInstitutionName(value);
    }

    public String getInstitutionName() {
	return institutionName;
    }

    protected void setInstitutionName(String institutionName) {
	this.institutionName = institutionName;
    }

}

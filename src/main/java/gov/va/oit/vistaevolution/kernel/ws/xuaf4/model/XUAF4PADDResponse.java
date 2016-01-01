package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4PADDResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String streetAddress;

    @XmlElement(required = false)
    private String city;

    @XmlElement(required = false)
    private String state;

    @XmlElement(required = false)
    private String zipCode;

    /**
     * Default no Arg Constuctor
     */
    public XUAF4PADDResponse() {
	super();
    }

    public XUAF4PADDResponse(List<String> errors) {
	super(errors);
    }

    public String getStreetAddress() {
	return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
	this.streetAddress = streetAddress;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getZipCode() {
	return zipCode;
    }

    public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
    }

}
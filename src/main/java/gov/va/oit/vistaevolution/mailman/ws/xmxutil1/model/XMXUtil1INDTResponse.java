/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import java.util.List;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement(name = "XMXUtil1INDTResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil1INDTResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String date;

    /**
     * @param date
     */
    public XMXUtil1INDTResponse(String date) {
	super();
	this.date = date;
    }

    public XMXUtil1INDTResponse(List<String> errors) {
	super(errors);
    }

    public XMXUtil1INDTResponse(String status, List<String> errors) {
	super(status, errors);
    }

    public XMXUtil1INDTResponse() {
	super();
    }

    public String getDate() {
	return date;
    }

    protected void setDate(String date) {
	this.date = date;
    }

}

package gov.va.oit.vistaevolution.mailman.ws.xmxapig.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIGGotLocalResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String containsLocalMembers;

    public XMXAPIGGotLocalResponse() {
	super();
    }

    public XMXAPIGGotLocalResponse(String containsLocalMembers) {
	this.containsLocalMembers = containsLocalMembers;
    }

    public XMXAPIGGotLocalResponse(String status, List<String> errors) {
	super(status, errors);
    }

    public String getContainsLocalMembers() {
	return containsLocalMembers;
    }

    public void setContainsLocalMembers(String containsLocalMembers) {
	this.containsLocalMembers = containsLocalMembers;
    }

}

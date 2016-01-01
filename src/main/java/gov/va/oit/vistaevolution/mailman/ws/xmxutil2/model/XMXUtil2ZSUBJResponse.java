/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2ZSUBJResponse extends AbstractVistaResponse {

    @XmlElement(required = true)
    private String subject;

    /**
     * Default no-arg constructor
     */
    public XMXUtil2ZSUBJResponse() {
	super();
    }

    public XMXUtil2ZSUBJResponse(String status, List<String> errors) {
	super(status, errors);
    }

    /**
     * @param subject
     */
    public XMXUtil2ZSUBJResponse(String subject) {
	super();
	this.setSubject(subject);
    }

    public String getSubject() {
	return subject;
    }

    protected void setSubject(String subject) {
	this.subject = subject;
    }

}

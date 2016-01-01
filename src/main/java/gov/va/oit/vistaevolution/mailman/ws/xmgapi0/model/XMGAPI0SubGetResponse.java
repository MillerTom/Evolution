/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model;

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
public class XMGAPI0SubGetResponse extends AbstractVistaResponse {

	@XmlElement(required = false)
	private String subject;

	/**
	 * Constructor from fields
	 * 
	 * @param subject
	 */
	public XMGAPI0SubGetResponse(String subject) {
		super();
		this.setSubject(subject);
	}

	/**
	 * Default no arg constructor
	 * 
	 * @param subject
	 */
	public XMGAPI0SubGetResponse() {
		super();
		this.setSubject(subject);
	}

	public XMGAPI0SubGetResponse(List<String> errors) {
		super(errors);
	}

	public XMGAPI0SubGetResponse(String status, List<String> errors) {
		super(status, errors);
	}

	public XMGAPI0SubGetResponse(String status, String subject) {
		setStatus(status);
		setSubject(subject);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}

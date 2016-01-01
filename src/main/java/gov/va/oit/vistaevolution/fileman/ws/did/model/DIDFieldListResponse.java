/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIDFieldListResponse {

	@XmlElementWrapper(name = "fields")
	@XmlElement(name = "field", required = true)
	private List<String> fields;

	/**
	 * Default no arg constructor for jaxb
	 */
	public DIDFieldListResponse() {
	}

	/**
	 * @param attributes
	 */
	public DIDFieldListResponse(List<String> fields) {
		this.setFields(fields);
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

}

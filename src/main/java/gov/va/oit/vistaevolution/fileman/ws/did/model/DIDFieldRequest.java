/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.model;

import java.util.ArrayList;
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
public class DIDFieldRequest extends AbtractDIDRequest {

	@XmlElement(required = true)
	private String field;

	/**
	 * 
	 */
	public DIDFieldRequest() {
		super();
	}

	/**
	 * @param string
	 * @param string2
	 * @param object
	 * @param string3
	 */
	public DIDFieldRequest(String file, String field, List<String> flags,
			List<String> attributes) {
		super();
		this.setFile(file);
		this.setField(field);
		this.setFlags(flags);
		this.setAttributes(attributes);
	}

	/**
	 * @param string
	 * @param string2
	 * @param attributes2
	 */
	public DIDFieldRequest(String file, String field,
			ArrayList<String> attributes) {
		super();
		this.setFile(file);
		this.setField(field);
		this.setFlags(null);
		this.setAttributes(attributes);
	}

	public String getField() {
		return field;
	}

	protected void setField(String field) {
		this.field = field;
	}

}

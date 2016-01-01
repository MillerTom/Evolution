/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 *
 */
public abstract class AbtractDIDRequest {

	@XmlElement(required = true)
	protected String file;
	@XmlElementWrapper(name = "flags")
	@XmlElement(name = "flag", required = false)
	protected List<String> flags;
	@XmlElementWrapper(name = "attributes")
	@XmlElement(name = "attribute", required = true)
	protected List<String> attributes;


	public String getFile() {
		return file;
	}

	protected void setFile(String file) {
		this.file = file;
	}

	public List<String> getFlags() {
		return flags;
	}

	protected void setFlags(List<String> flags) {
		this.flags = flags;
	}

	public List<String> getAttributes() {
		return attributes;
	}

	protected void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

}
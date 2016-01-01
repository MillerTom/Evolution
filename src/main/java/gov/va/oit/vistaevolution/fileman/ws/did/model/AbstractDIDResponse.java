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
public class AbstractDIDResponse {

	@XmlElementWrapper(name = "attributes")
	@XmlElement(name = "attribute", required = true)
	protected List<DIDAttributeValue> didAttributes;

	/**
	 * 
	 */
	public AbstractDIDResponse() {
		super();
	}

	public List<DIDAttributeValue> getDidAttributes() {
		return didAttributes;
	}

	protected void setDidAttributes(List<DIDAttributeValue> didAttributes) {
		this.didAttributes = didAttributes;
	}

}
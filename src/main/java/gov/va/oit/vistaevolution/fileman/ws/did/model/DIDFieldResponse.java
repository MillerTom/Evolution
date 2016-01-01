/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIDFieldResponse extends AbstractDIDResponse {
	
	/**
	 * Default no arg constructor for jaxb
	 */
	public DIDFieldResponse(){
		super();
	}

	/**
	 * @param attributes
	 */
	public DIDFieldResponse(ArrayList<DIDAttributeValue> attributes) {
		this.setDidAttributes(attributes);
	}

	
}

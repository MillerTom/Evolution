/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIDFileRequest extends AbtractDIDRequest {
	
	public DIDFileRequest(String file, List<String> flags, List<String> attributes){
		super();
		this.setFile(file);
		this.setFlags(flags);
		this.setAttributes(attributes);
	}
	
	public DIDFileRequest(String file, List<String> attributes){
		this(file, null, attributes);
	}

	/**
	 * Default no arg constructor
	 */
	public DIDFileRequest() {
		super();
	}

}

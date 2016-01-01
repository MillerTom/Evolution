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
public class DIDFileListResponse {

	@XmlElementWrapper(name = "files")
	@XmlElement(name = "files", required = true)
	private List<String> files;
	
	/**
	 * @param files
	 */
	public DIDFileListResponse(List<String> files) {
		super();
		this.setFiles(files);
	}

	public DIDFileListResponse(){
		super();
	}

	public List<String> getFiles() {
		return files;
	}

	protected void setFiles(List<String> files) {
		this.files = files;
	}


}

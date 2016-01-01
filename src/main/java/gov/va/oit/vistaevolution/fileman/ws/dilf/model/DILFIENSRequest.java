/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

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
public class DILFIENSRequest {
	
	@XmlElementWrapper(name = "ddr")
	@XmlElement(name = "recordNumber", required = true)
	private List<String> ddr;
	

	/**
	 * 
	 */
	public DILFIENSRequest() {
		super();
	}

	/**
	 * @param ddr
	 */
	public DILFIENSRequest(List<String> ddr) {
		super();
		this.ddr = ddr;
	}

	public List<String> getDdr() {
		return ddr;
	}

	protected void setDdr(List<String> ddr) {
		this.ddr = ddr;
	}
	
	
}

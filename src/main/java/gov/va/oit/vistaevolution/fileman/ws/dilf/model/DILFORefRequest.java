/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFORefRequest {


	@XmlElement(required=true)
	private String ddr;

	/**
	 * 
	 */
	public DILFORefRequest() {
		this(null);
	}

	
	/**
	 * @param string
	 */
	public DILFORefRequest(String ddr) {
		this.setDdr(ddr);
	}

	public String getDdr() {
		return ddr;
	}

	protected void setDdr(String ddr) {
		this.ddr = ddr;
	}

}

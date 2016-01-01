/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

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
public class XUAF4ParentRequest {

	@XmlElement(name = "ien", required = true)
	private String IEN;
	
	@XmlElement(name = "asso", required = true)
	private String ASSO;

	/**
	 * Default No-Arg Constructor
	 */
	public XUAF4ParentRequest() {
		this.setIEN(null);
	}

	/**
	 * @param string
	 * @param string2
	 */
	public XUAF4ParentRequest(String IEN, String ASSO) {
		this.setIEN(IEN);
		this.setASSO(ASSO);
	}

	public String getIEN() {
		return IEN;
	}

	protected void setIEN(String iEN) {
		IEN = iEN;
	}

	public String getASSO() {
		return ASSO;
	}

	protected void setASSO(String aSSO) {
		ASSO = aSSO;
	}

}

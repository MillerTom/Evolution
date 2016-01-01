package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDaRequest extends AbstractVistaRequest {

	/**
	 * iens:
	 * 
	 * (Required) A string with record and sub-record numbers in IENS format.
	 * 
	 */

	@XmlElement(required = true)
	private String iens;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public DILFDaRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param iens
	 */
	public DILFDaRequest(String iens) {
		super();
		this.iens = iens;
	}

	/**
	 * @return the iens
	 */
	public String getIens() {
		return iens;
	}

	/**
	 * @param iens
	 *            the iens to set
	 */
	public void setIens(String iens) {
		this.iens = iens;
	}

}

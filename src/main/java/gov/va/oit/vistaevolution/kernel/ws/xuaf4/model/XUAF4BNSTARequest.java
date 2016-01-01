package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4BNSTARequest extends AbstractVistaRequest {

	/**
	 * 
	 * sta:
	 * 
	 * (Required) ) Institution Station Name lookup: • Station Name
	 * 
	 * 
	 */

	@XmlElement(required = true)
	private String sta;

	/**
	 * No Arguments Constructor.
	 */
	public XUAF4BNSTARequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param sta
	 */
	public XUAF4BNSTARequest(String sta) {
		super();
		this.sta = sta;
	}

	public String getSta() {
		return sta;
	}

	public void setSta(String sta) {
		this.sta = sta;
	}

}

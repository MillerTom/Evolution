package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMBGRPMgResponse extends AbstractVistaResponse {

	/**
	 * result :
	 * 
	 * • Successful—Mail Group Internal Entry Number (IEN)
	 * 
	 * • Unsuccessful (error)—0
	 * 
	 */
	@XmlElement(required = false)
	private String result;

	/**
	 * No Arguments Constructor.
	 */
	public XMBGRPMgResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param result
	 */
	public XMBGRPMgResponse(String result) {
		super();
		this.result = result;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

}

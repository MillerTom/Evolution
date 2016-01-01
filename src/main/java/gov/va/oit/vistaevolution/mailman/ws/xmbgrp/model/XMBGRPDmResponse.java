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
public class XMBGRPDmResponse extends AbstractVistaResponse {

	/**
	 * 
	 * result :
	 * 
	 * 
	 * • Successful—1
	 * 
	 * • Unsuccessful (error)—0
	 * 
	 */
	@XmlElement(required = false)
	private String result;

	/**
	 * No Arguments Constructor.
	 */
	public XMBGRPDmResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param result
	 */
	public XMBGRPDmResponse(String result) {
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

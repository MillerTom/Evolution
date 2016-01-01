/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4ParentResponse {

	/**
	 * 
	 */
	public XUAF4ParentResponse() {
		this(null, null);
	}

	@XmlAttribute
	private String responseType;
	@XmlValue
	private String value;

	/**
	 * @param string
	 * @param string2
	 */
	public XUAF4ParentResponse(String responseType, String value) {
		this.setResponseType(responseType);
		this.setValue(value);
	}

	public String getResponseType() {
		return responseType;
	}

	protected void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getValue() {
		return value;
	}

	protected void setValue(String value) {
		this.value = value;
	}

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author rob.carlson
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMGAPI2HdrResponse extends AbstractVistaResponse {

	@XmlElement(name = "data", required = false)
	private String data;

	public XMGAPI2HdrResponse() {
		super();
	}

	/**
	 * Error and status constructor.
	 * 
	 * @param status
	 * @param errors
	 */
	public XMGAPI2HdrResponse(String data) {
		this.data = data;

	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}

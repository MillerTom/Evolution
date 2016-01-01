/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1c.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA1CSetsbResponse {
	
	@XmlElement(name = "return-code", required = true)
	private String returnCode;
	
	@XmlElement(name = "return-msg", required = true)
	private String returnMsg;

	public XMA1CSetsbResponse() {
		super();
	}
	
	public XMA1CSetsbResponse(String returnCode, String returnMsg) {
		super();
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	
}

/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSNPIChkDgtResponse {

	
	/**
	 * XU SOA CHKDGT
	 * 
	 * This RPC call is used to validate the format of an NPI number, checking the length
	 * and if numeric. Also whether the check digit is valid.
	 * 
	 *  
	 * Input Variables	
	 * 	XUSNPI1:	(required) The National Provider Identifier.
	 * 
	 * Response
	 * 		If check digit is valid 1, else 0.
	 * 
	 */
	@XmlElement(required = true)
	private String data;

	public XUSNPIChkDgtResponse() {
		super();
	}

	public XUSNPIChkDgtResponse(String data) {
		super();
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param dataList the data to set
	 */
	public void setDataList(String data) {
		this.data = data;
	}


}

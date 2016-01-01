/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/*
 * XMWSOA FM2MM DT
 * 
 * This RPC takes a VA FileMan Date/Time input string and returns it as a
 * reformatted string:
 *     mm/dd/yy@hh:mm
 *     
 * If there's an error, it returns an error message.
 * 
 * Input Parameters:
 * 		XMDT		(Required) VA FileMan Date/Time input string.
 * 
 * Response:
 * 		Returns a reformatted VA FileMan Date/Time string:
 * 			mm/dd/yy@hh:mm
 * 		Example
 * 			XMDT=2940629.105744
 * 			Return:  06/29/94@10:57
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1MmdtRequest {

	@XmlElement(required = true)
	private String xmDt;

	public XMXUTIL1MmdtRequest() {
		super();
	}

	public XMXUTIL1MmdtRequest(String xmDt) {
		super();
		this.xmDt = xmDt;
	}

	/**
	 * @return the xmDt
	 */
	public String getXmDt() {
		return xmDt;
	}

	/**
	 * @param xmDt the xmDt to set
	 */
	public void setXmDt(String xmDt) {
		this.xmDt = xmDt;
	}

}

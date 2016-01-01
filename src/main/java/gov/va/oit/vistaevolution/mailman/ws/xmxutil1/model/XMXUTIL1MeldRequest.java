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
 * XMWSOA MELD STRING
 * This RPC combines a string and a number to form a new string of a given
 * length. The string will be right justified; the number left-justified,
 * with at least two spaces separating the string and number. The string will
 * be truncated, if necessary.  If there's an error, it returns an error
 * message.
 * 
 * Input Parameters:
 * 		XMSTRING	(Required) The input string.
 * 		XMNUMBER	(Optional) The number.
 * 		XMLEN		(Required) The length of the new string to be formed.
 * 
 * Response:
 * 		Returns the newly formed string.
 * 
 * 			Example 1
 * 				XMSTRING="Lotus blossom",XMNUM=123,XMLEN=10
 * 				Lotus 123
 * 			
 * 			Example 2
 * 				XMSTRING="Lotus blossom",XMNUM=123,XMLEN=15
 * 				Lotus blos 123
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1MeldRequest {

	@XmlElement(required = true)
	private String xmString;
	@XmlElement(required = false)
	private String xmNumber;
	@XmlElement(required = true)
	private String xmLen;

	public XMXUTIL1MeldRequest() {
		super();
	}

	public XMXUTIL1MeldRequest(String xmString, String xmNumber, String xmLen) {
		super();
		this.xmString = xmString;
		this.xmNumber = xmNumber;
		this.xmLen = xmLen;
	}

	/**
	 * @return the xmString
	 */
	public String getXmString() {
		return xmString;
	}

	/**
	 * @param xmString the xmString to set
	 */
	public void setXmString(String xmString) {
		this.xmString = xmString;
	}

	/**
	 * @return the xmNumber
	 */
	public String getXmNumber() {
		return xmNumber;
	}

	/**
	 * @param xmNumber the xmNumber to set
	 */
	public void setXmNumber(String xmNumber) {
		this.xmNumber = xmNumber;
	}

	/**
	 * @return the xmLen
	 */
	public String getXmLen() {
		return xmLen;
	}

	/**
	 * @param xmLen the xmLen to set
	 */
	public void setXmLen(String xmLen) {
		this.xmLen = xmLen;
	}

}

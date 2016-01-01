/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/**
 * XU SOA LEAP
 * 
 * This RPC function checks to see if the year passed in is a leap year or not. 
 * The function returns a one if the year is a leap year otherwise it returns a zero.
 * 
 * Input Variables	
 * 		Year:	(required) Year being tested to confirm if it is a leap year or not.
 * 
 * Response
 * 		Returns 1 for a leap year, otherwise 0.
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XLFDT3LeapRequest {

	@XmlElement(required = true)
	private String year;

	public XLFDT3LeapRequest() {
		super();
	}

	public XLFDT3LeapRequest(String year) {
		super();
		this.year = year;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

}

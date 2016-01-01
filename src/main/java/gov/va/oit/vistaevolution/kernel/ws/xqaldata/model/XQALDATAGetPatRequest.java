/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/**
 * TODO: Correct RPC name once broker is completed
 * XQALDATA GETPAT
 * 

 * Retrieve patient alerts within a given date range. 
 * 
 * Format	D GETPAT^XQALDATA(result array, patient IEN, start date, end date)
 *
 * Input Parameters
 * 	Patient IEN	(Required)  The IEN for the patient that is being checked for alerts
 * 	Start Date	(Required)  Beginning of the date (in FileMan format) range for gathering the patient alerts
 *  End Date	(Required)  End of the date (in FileMan format)  range for gathering the patient alerts
 *
 * Output
 * 	Data in result array
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XQALDATAGetPatRequest {

	@XmlElement(required = true)
	private String ien;
	@XmlElement(required = true)
	private String startDate;
	@XmlElement(required = true)
	private String endDate;

	public XQALDATAGetPatRequest() {
		super();
	}

	public XQALDATAGetPatRequest(String ien, String startDate, String endDate) {
		super();
		this.ien = ien;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @return the ien
	 */
	public String getIen() {
		return ien;
	}

	/**
	 * @param ien the ien to set
	 */
	public void setIen(String ien) {
		this.ien = ien;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}

/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XQALDATAGetPatResponse {

	
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
	@XmlElementWrapper(name = "data")
	@XmlElement(name = "dataElement", required = false)
	private List<String> data;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XQALDATAGetPatResponse(List<String> data) {
		this.setData(data);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XQALDATAGetPatResponse() {
		this.setData(null);
	}

	/**
	 * @return the data
	 */
	public List<String> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<String> data) {
		this.data = data;
	}

}

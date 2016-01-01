/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/*
 * XMWSOA USER NAME INFO
 * 
 * This RPC returns the name of the user by looking up XMDUZ in the NEW
 * PERSON file (#200). Optionally, it can also return the user's Title and/or
 * Institution. If XMDUZ is not numeric, it returns XMDUZ.  If there's an
 * error, it returns an error message.
 * 
 * Input Parameters:
 * 		XMDUZ		(Required) User DUZ.
 * 		XMINFO		(Optional) If the user's settings indicate that the user's
 * 					Institution and/or Title are desired, should that information be returned,
 * 					too?
 * 						0 (default)-No
 * 						1-Yes
 * 
 * Response:
 * 		Returns the user's Name, Title, and/or Institution.
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILNameResponse {
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMXUTILNameResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMXUTILNameResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}

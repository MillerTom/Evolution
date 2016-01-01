/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser2.model;

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
public class XUSER2GetUpnResponse {

	
	/**
	 * XUS PKI GET UPN
	 * 
	 * This RPC gets the SUBJECT ALTERNATIVE NAME field from the New Person (#200) 
	 * file field 501.2.  It is used to check that the correct PIV card has been 
	 * put into the reader. 
	 * 
	 * Input Parameters:
	 *   None
	 * 
	 * Returns:
	 *   String Subject Alternative Name field
	 *   
	 */
	@XmlElement(required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XUSER2GetUpnResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XUSER2GetUpnResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}

}

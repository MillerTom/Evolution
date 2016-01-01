/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xustzip.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/**
 * 
 * XU SOA LKCHECK
 *
 *  This agreement allows the VistaLink package to use routine XUSTZIP
 *  to perform checks on Kernel IP/device locking during the VistaLink
 *  reauthentication process, which includes support for the login
 *  capabilities of FatKAAT and KAAJEE.
 *   
 * Input Parameters
 * 		LKCHECK1		(Required) IP Address
 * 
 * Response
 * 		Result on failure returns the FileMan date/time
 * 		that the IP address should be locked until.
 * 		
 * 		Result on success returns 0.
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSTZIPLkCheckResponse {
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XUSTZIPLkCheckResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XUSTZIPLkCheckResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}

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
 * 
 * XMWSOA GET NET NAME
 * 
 * This RPC returns network name of user, including @site name.  If there's
 * an error, it returns an error message.
 * 
 * Input Parameters:
 * 
 * 		XMDUZ		(Required) User DUZ or any string.
 * 
 * Response:
 * 		Returns the user's Network Name and Domain name (i.e., @site name).
 * 
	 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILNetNameResponse {
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMXUTILNetNameResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMXUTILNetNameResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}

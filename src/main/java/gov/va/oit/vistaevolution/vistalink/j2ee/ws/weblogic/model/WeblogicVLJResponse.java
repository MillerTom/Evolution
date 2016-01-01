/**
 * 
 */
package gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WeblogicVLJResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class WeblogicVLJResponse {
	@XmlElement(name = "results", required = true)
	private String results;
	
	@XmlElement(name = "jndiName", required = false)
	private String jndiName;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public WeblogicVLJResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public WeblogicVLJResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}

	public String getJndiName() {
		return jndiName;
	}
	
	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}
	
	
}

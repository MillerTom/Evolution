
package gov.va.oit.vistaevolution.fileman.ws.dilfd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * File Verifier
 * Output Parameter Class:
 *
 * fileExists:    This Boolean function returns a
 *                1 if the file exists or a 0 if it
 *                does not.
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDVfileResponse {

    @XmlElement(required = true)
	private String fileExists;

	/**
     * @return the fileExists
     */
    public String getFileExists() {
        return this.fileExists;
    }

    /**
     * @param fileExists the fileExists to set
     */
    public void setFileExists(final String fileExists) {
        this.fileExists = fileExists;
    }

    /**
	 * Default Bean Constructor
	 */
	public DILFDVfileResponse() {
	    super();
	}

	/**
	 * Constructor initializes object
	 * @param value
	 */
	public DILFDVfileResponse(final String value) {
        this();
        this.fileExists = value;
    }

}

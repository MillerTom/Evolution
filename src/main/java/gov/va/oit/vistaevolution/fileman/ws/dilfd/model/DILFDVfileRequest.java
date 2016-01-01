package gov.va.oit.vistaevolution.fileman.ws.dilfd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * File Verifier
 * Input Parameter Class:
 *
 * file:    (Required) The number of the file or
 *          subfile that you want to check.
 *
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDVfileRequest {

    @XmlElement(required = true)
    private String file;

    /**
	 * Default Constructor
	 */
	public DILFDVfileRequest() {
	    super();
	}

	public DILFDVfileRequest(String file) {
	    super();
	    this.file = file;
	}
	
	/**
     * @return the file
     */
    public String getFile() {
        return this.file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(final String file) {
        this.file = file;
    }

}

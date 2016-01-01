
package gov.va.oit.vistaevolution.fileman.ws.dilfd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Field Verifier
 * Input Parameter Class:
 * 
 * file:        (Required) The number of the file or subfile 
 *              in which the field to be checked exists.
 * 
 * field:       (Required) The number of the field to be checked.
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDVfieldRequest {

    @XmlElement(required = true)
    private String file;
    @XmlElement(required = true)
	private String field;
	
    /**
	 * Default Bean Constructor
	 */
	public DILFDVfieldRequest() {
	    super();
	}
	
	public DILFDVfieldRequest(String file, String field) {
	    super();
	    this.file = file;
	    this.field = field;
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
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * @return the field
     */
    public String getField() {
        return this.field;
    }

    /**
     * @param field the field to set
     */
    public void setField(String field) {
        this.field = field;
    }

}

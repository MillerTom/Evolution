package gov.va.oit.vistaevolution.fileman.ws.dilfd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Field Number Retriever
 * Input Paramters Class:
 *
 * file:        (Required) The file number of the field's file or subfile.
 *
 * fieldname:   (Required) The full name of the field for which you want
 *              the number.
 * </pre>
 *
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDFldnumRequest {

    @XmlElement(required = true)
    private String file;
    @XmlElement(required = true)
	private String fieldName;


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


    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return this.fieldName;
    }


    /**
     * @param fieldName the fieldName to set
     */
    public void setFieldName(final String fieldName) {
        this.fieldName = fieldName;
    }


    /**
	 * Default Bean Constructor
	 */
	public DILFDFldnumRequest() {
	    super();
	}

	public DILFDFldnumRequest(String file, String fieldName) {
	    super();
	    this.file = file;
	    this.fieldName = fieldName;
	}
}

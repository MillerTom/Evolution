package gov.va.oit.vistaevolution.fileman.ws.dilfd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Field Verifier
 * Output Parameter Class:
 *
 * fieldExists:  (Required) returns a 1 if the field exists
 *               in the specified file and a 0 if it does not exist.
 * </pre>
 *
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDVfieldResponse {

    @XmlElement(required = true)
    private String fieldExists;

	/**
     * @return the fieldExists
     */
    public String getFieldExists() {
        return this.fieldExists;
    }

    /**
     * @param fieldExists the fieldExists to set
     */
    public void setFieldExists(final String fieldExists) {
        this.fieldExists = fieldExists;
    }

    /**
	 * Default bean constructor
	 */
    public DILFDVfieldResponse() {
        super();
    }

    /**
     * Constructor initializes the bean
     * @param value
     */
    public DILFDVfieldResponse(final String value) {
        this();
        this.fieldExists = value;
    }
}

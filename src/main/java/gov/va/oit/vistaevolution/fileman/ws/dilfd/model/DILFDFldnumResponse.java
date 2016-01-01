
package gov.va.oit.vistaevolution.fileman.ws.dilfd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * <pre>
 * Field Number Retriever
 * Output Parameters Class:
 *
 * returnVal:     The field number of the requested field
 *                  is returned by this extrinsic function. If
 *                  the field name does not exist or if there
 *                  is more than one field with that name, a 0
 *                  is returned.
 *
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDFldnumResponse {

    @XmlElement(required = true)
    private String returnVal;


	/**
     * @return the returnVal
     */
    public String getReturnVal() {
        return this.returnVal;
    }


    /**
     * @param returnVal the returnVal to set
     */
    public void setReturnVal(final String returnVal) {
        this.returnVal = returnVal;
    }


    /**
	 * Default bean constructor
	 */
	public DILFDFldnumResponse() {
	    super();
	}

	/**
	 * Constructor intializes the object
	 * @param value
	 */
	public DILFDFldnumResponse(final String value) {

	    super();
	    this.returnVal = value;
	}
}

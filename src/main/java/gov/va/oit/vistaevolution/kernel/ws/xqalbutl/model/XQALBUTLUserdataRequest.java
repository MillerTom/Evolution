
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * <pre>
 *
 * Get User Information for an Alert
 * Input Parameters Class:
 *
 * xqaid:   (Required, Sequence = 1) This is the value of the alert
 *          identifier. It is passed to the routine or option that
 *          is run when the alert is selected. It can also be obtained
 *          from a listing of all of the xqaid values for a specified
 *          user and/or patient.
 *
 * xuien:   (Required, Sequence = 2) This is the Internal Entry
 *          Number (IEN, DUZ value) in the NEW PERSON file (#200) for
 *          the desired user.
 *
 * </pre>
 *
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XQALBUTLUserdataRequest extends AbstractVistaRequest {

    @XmlElement(required = true)
    private String xqaid;
    @XmlElement(required = true)
    private String xuien;


    /**
     * @return the xqaid
     */
    public String getXqaid() {
        return this.xqaid;
    }


    /**
     * @param xqaid the xqaid to set
     */
    public void setXqaid(final String xqaid) {
        this.xqaid = xqaid;
    }


    /**
     * @return the xuien
     */
    public String getXuien() {
        return this.xuien;
    }


    /**
     * @param xuien the xuien to set
     */
    public void setXuien(final String xuien) {
        this.xuien = xuien;
    }


    /**
     * Default Bean Constructor
     */
    public XQALBUTLUserdataRequest() {
        super();
    }

}


package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Pending Alerts for a User in Specified Software
 * Input Parameters Class:
 *
 * xuien:   (Required, Sequence 1) This is the internal entry number
 *          in file 200 (DUZ value) for the desired user.
 *
 * xuaid:   (Required, Sequence 2) This is the value XUAID which is the
 *          alert identifier.  It is passed to the routine or option which
 *          is run when the alert is selected.  It can also be obtained from
 *          a listing of all of the XUAIDs for a specified user and/or patient.
 * </pre>
 *
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XQALBUTLPendingRequest extends AbstractVistaRequest{

    @XmlElement(required = true)
    private String xuien;
    @XmlElement(required = true)
    private String xuaid;


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
     * @return the xuaid
     */
    public String getXuaid() {
        return this.xuaid;
    }


    /**
     * @param xuaid the xuaid to set
     */
    public void setXuaid(final String xuaid) {
        this.xuaid = xuaid;
    }


    /**
     * Default Bean Constructor
     */
    public XQALBUTLPendingRequest() {
        super();
    }

}

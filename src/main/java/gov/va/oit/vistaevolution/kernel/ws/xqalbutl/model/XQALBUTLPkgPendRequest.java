
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
 * xuien:   (Required, Sequence = 1) This is the Internal Entry Number
 *          (IEN, DUZ value) in the NEW PERSON file (#200)
 *          for the desired user.
 *
 * xupkg:   (Required, Sequence = 2) This is the software/package identifier
 *          portion of the alert identifier (XQAID). It is a textual
 *          identifier for the software that created the alert and is
 *          the first ";"-piece of XQAID. It can be used in this
 *          context to determine whether the user specified by xqauser
 *          has any alerts pending containing the specified software
 *          identifier. The software identifier used can be a complete
 *          software identifier (e.g., XU-TSK) or more general (e.g., XU)
 *          to find users with any XU software alerts.
 *
 * </pre>
 *
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XQALBUTLPkgPendRequest extends AbstractVistaRequest {


    @XmlElement(required = true)
    private String xuien;
    @XmlElement(required = true)
    private String xupkg;

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
     * @return the xupkg
     */
    public String getXupkg() {
        return this.xupkg;
    }

    /**
     * @param xupkg the xupkg to set
     */
    public void setXupkg(final String xupkg) {
        this.xupkg = xupkg;
    }

    /**
     * Default Bean Constructor
     */
    public XQALBUTLPkgPendRequest() {
        super();
    }

}

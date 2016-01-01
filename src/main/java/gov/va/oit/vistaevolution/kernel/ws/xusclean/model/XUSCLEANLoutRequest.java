package gov.va.oit.vistaevolution.kernel.ws.xusclean.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Enter Logout Time in Sign-on Log
 * Input Parameters Class:
 *
 * da:     (Required) SIGN-ON LOG file #3.081 IEN
 * </pre>
 *
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSCLEANLoutRequest {

    @XmlElement(required = true)
    private String da;

    /**
     * @return the da
     */
    public String getDa() {
        return this.da;
    }

    /**
     * @param da the da to set
     */
    public void setDa(final String da) {
        this.da = da;
    }

    /**
     * Default Constructor
     */
    public XUSCLEANLoutRequest() {
        super();
    }
}

package gov.va.oit.vistaevolution.mailman.ws.xma21.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Address Lookup (Non-Interactive)
 * Input Parameters Class:
 *
 * xmadd:       (Required) A local or remote address. (-XMADD will
 *              remove any address.)
 *
 * xmdf:        (Optional) If XMDF is defined, all addressing restrictions are waived.
 *              Addressing restrictions are:
 *               > Restrict  "domain closed"
 *               > Restrict  "keys required for domain"
 *               > Restrict  "may not forward to domain"
 *               > Restrict  "may not forward priority mail to groups"
 *               > Restrict  "message length restrictions to remote addresses"
 *
 * xmduz:       (Required)  User's DUZ
 * </pre>
 *
 *
 * @author rcollins
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA21InstRequest extends AbstractVistaRequest {

    @XmlElement(required = true)
    private String xmadd;
    @XmlElement(required = false)
    private String xmdf;
    @XmlElement(required = true)
    private String xmduz;


    /**
     * @return the xmadd
     */
    public String getXmadd() {
        return this.xmadd;
    }

    /**
     * @param xmadd the xmadd to set
     */
    public void setXmadd(final String xmadd) {
        this.xmadd = xmadd;
    }

    /**
     * @return the xmdf
     */
    public String getXmdf() {
        return this.xmdf;
    }

    /**
     * @param xmdf the xmdf to set
     */
    public void setXmdf(final String xmdf) {
        this.xmdf = xmdf;
    }

    /**
     * @return the xmduz
     */
    public String getXmduz() {
        return this.xmduz;
    }

    /**
     * @param xmduz the xmduz to set
     */
    public void setXmduz(final String xmduz) {
        this.xmduz = xmduz;
    }

    /**
     * Default Bean constructor
     */
    public XMA21InstRequest() {

        super();
        this.xmadd = "";
        this.xmduz = "";
        this.xmdf = "";
    }

    /**
     * Constructor takes in and initializes values that are required
     * to execute.
     * @param address
     * @param user
     */
    public XMA21InstRequest(final String address, 
            final String user) {

        this();
        this.xmadd = address;
        this.xmduz = user;

    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Strip Control Characters & Leading/Trailing Spaces from a String
 * Output Parameters:
 *
 * returns:     (Required) Returns the input string stripped of
 *              any control characters and/or leading/trailing
 *              spaces.
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement(name = "XMXUTIL1ScrubResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1ScrubResponse extends AbstractVistaResponse {

    @XmlElement(name = "returns", required = true)
    private String returns;


    /**
     * @return the returns
     */
    public String getReturns() {
        return this.returns;
    }

    /**
     * @param returns the returns to set
     */
    protected void setReturns(final String returns) {
        this.returns = returns;
    }

    /**
     * Default Bean Constructor
     */
    public XMXUTIL1ScrubResponse() {
        super();
    }

    /**
     * Constructor Initializes response object
     * @param value
     */
    public XMXUTIL1ScrubResponse(final String value) {

        this();
        this.returns = value;
        this.setRawResponse(value);
    }

}

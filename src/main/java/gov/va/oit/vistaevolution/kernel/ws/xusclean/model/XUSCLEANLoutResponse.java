/**
 *
 */
package gov.va.oit.vistaevolution.kernel.ws.xusclean.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSCLEANLoutResponse {

    @XmlElement(required = true)
    private String response;

    /**
     * @return the response
     */
    public String getResponse() {
        return this.response;
    }


    /**
     * @param response the response to set
     */
    public void setResponse(final String response) {
        this.response = response;
    }


    /**
     * Default Constructor
     */
    public XUSCLEANLoutResponse() {
        super();
    }


    /**
     * Constructor initializes values
     * @param value
     */
    public XUSCLEANLoutResponse(final String value) {
        super();
        this.response = value;
    }



}

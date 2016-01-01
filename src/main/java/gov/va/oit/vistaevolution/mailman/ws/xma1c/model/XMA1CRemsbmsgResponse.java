
package gov.va.oit.vistaevolution.mailman.ws.xma1c.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Delete a Message from a Server Basket
 * Output Parameters Class:
 *
 * response:    (Required)  Return Parameters:
 *
 *               0^Successful
 *              -1^Error in required input
 *              -1^Server basket not found
 *              -1^Operation failed
 *              -1^Message not found in basket
 *
 *  </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA1CRemsbmsgResponse {

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
     * Default bean constructor
     */
    public XMA1CRemsbmsgResponse() {
        super();
    }

    /**
     * Constructor initializes the response
     * @param responseList
     */
    public XMA1CRemsbmsgResponse (final String value) {

        this();
        this.response = value;
    }
}

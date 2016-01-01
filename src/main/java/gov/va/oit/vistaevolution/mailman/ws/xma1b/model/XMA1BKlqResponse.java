
package gov.va.oit.vistaevolution.mailman.ws.xma1b.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Delete a Message from a Basket (into "WASTE" basket
 * Output Parameter Class:
 * 
 * response:     0^Successful
 *              -1^There is no message in that basket for this user
 *              -1^Error in required input
 * 
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA1BKlqResponse {
    
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
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * Constructor takes in are response collection
     * @param value
     */
    public XMA1BKlqResponse(final String value) {
        
        this();
        this.response = value;
    }

    /**
     * Constructor takes in are response collection
     * @param responseList
     */
    public XMA1BKlqResponse() {
        
        super();
        this.response = "";
    }
}

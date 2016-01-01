/**
 *
 */
package gov.va.oit.vistaevolution.fileman.ws.dialog.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * <pre>
 *
 * DIALOG Extractor (Single Line)
 * Output Parameters Class:
 *
 * response:    (Optional) the first line of text from a 
 *              DIALOG file (#.84) entry
 *
 * </pre>
 * 
 * @author Christopher Schuck
 *
 */
@XmlRootElement(name = "DIALOGEzBldResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class DIALOGEzBldResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String response;

    /**
     * @return the response
     */
    public String getResponse() {
        return this.response;
    }

    /**
     * @param aResponse the response to set
     */
    protected void setResponse(final String aResponse) {
        this.response = aResponse;
    }

    /**
     * Default Bean Constructor
     */
    public DIALOGEzBldResponse() {
        super();
    }

    /**
     * Bean Constructor initializes class
     * @param value
     * @param rawResponse
     */
    public DIALOGEzBldResponse(final String value) {
        
        super();
        this.response = value;
        this.rawResponse = value;
    }
}

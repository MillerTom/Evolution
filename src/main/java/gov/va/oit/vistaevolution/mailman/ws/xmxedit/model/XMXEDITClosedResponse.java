
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * “Closed” Flag Toggle
 * Output Parameter Class:
 *
 * message:     (Required) Returns the message
 * special:     (Optional) Return the special message
 *
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXEDITClosedResponse extends AbstractVistaResponse{

    @XmlElement(required = true)
    private String message;

    @XmlElement(required = false)
    private String special;


    /**
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * @param message the message to set
     */
    protected void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @return the special
     */
    public String getSpecial() {
        return this.special;
    }

    /**
     * @param special the special to set
     */
    protected void setSpecial(final String special) {
        this.special = special;
    }

    /**
     * Default Bean Constructor
     */
    public XMXEDITClosedResponse() {
        super();
    }

    /**
     * Constructor Initializes with the message
     * @param value
     * @param rawResponse
     */
    public XMXEDITClosedResponse(final String msg,
            final String rawResponse) {

        this();
        this.setRawResponse(rawResponse);
        this.message = msg;
        this.special = null;
    }

    /**
     * Construtor initalizes with the message
     * and special instruction
     * @param msg
     * @param spec
     * @param rawResponse
     */
    public XMXEDITClosedResponse(final String msg, 
            final String spec, final String rawResponse) {

        this(msg, rawResponse);
        this.special = spec;

    }

}

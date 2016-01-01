package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 *
 * Strip Control Characters & Leading/Trailing Spaces from a String
 * Input Parameter Class:
 *
 * xmxstring:    (Required, Sequence = 1) The input string.
 *
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1ScrubRequest extends AbstractVistaRequest{

    @XmlElement(required = true)
    private String xmxstring;


    /**
     * @return the xmxstring
     */
    public String getXmxstring() {
        return this.xmxstring;
    }


    /**
     * @param xmxstring the xmxstring to set
     */
    public void setXmxstring(final String xmxstring) {
        this.xmxstring = xmxstring;
    }


    /**
     * Default Bean Constructor
     */
    public XMXUTIL1ScrubRequest() {
        super();
    }

}

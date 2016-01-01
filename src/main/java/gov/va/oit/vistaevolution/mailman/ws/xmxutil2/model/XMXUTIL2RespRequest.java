package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Get the Number of Responses to a Message
 * Input Parameter Class:
 *
 * xmz:     (Required, Sequence = 1) Message Internal
 *          Entry Number (IEN) in the MESSAGE file (#3.9).
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL2RespRequest extends AbstractVistaRequest{

    @XmlElement(required = true)
    private String xmz;

    /**
     * Default Bean Constructor
     */
    public XMXUTIL2RespRequest() {
        super();
    }

    /**
     * @return the xmz
     */
    public String getXmz() {
        return this.xmz;
    }

    /**
     * @param xmz the xmz to set
     */
    public void setXmz(String xmz) {
        this.xmz = xmz;
    }

}

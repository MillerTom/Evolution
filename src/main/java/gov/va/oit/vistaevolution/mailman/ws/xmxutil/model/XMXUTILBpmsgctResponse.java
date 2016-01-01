package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.AbstractXMXUTILResponse
 *
 */
@XmlRootElement(name = "XMXUTILBpmsgctResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILBpmsgctResponse extends AbstractXMXUTILResponse {

    /**
     * Default Bean Constructor
     */
    public XMXUTILBpmsgctResponse() {
        super();
    }


    /**
     * Constructor initializes object
     * @param returns
     */
    public XMXUTILBpmsgctResponse(final String returns) {
        super(returns);
        this.rawResponse = returns;
    }

}

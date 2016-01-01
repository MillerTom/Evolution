
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgRequest;

@XmlRootElement(name = "XMXAPIMovemsg", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIMovemsg", namespace = "http://vistaevolution.va.gov")
public class Movemsg {

    @XmlElement(name = "XMXAPIMovemsgRequest", namespace = "")
    private XMXAPIMovemsgRequest xmxapiMovemsgRequest;

    /**
     * 
     * @return
     *     returns XMXAPIMovemsgRequest
     */
    public XMXAPIMovemsgRequest getXmxapiMovemsgRequest() {
        return this.xmxapiMovemsgRequest;
    }

    /**
     * 
     * @param xmxapiMovemsgRequest
     *     the value for the xmxapiMovemsgRequest property
     */
    public void setXmxapiMovemsgRequest(XMXAPIMovemsgRequest xmxapiMovemsgRequest) {
        this.xmxapiMovemsgRequest = xmxapiMovemsgRequest;
    }

}

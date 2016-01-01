
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgsRequest;

@XmlRootElement(name = "XMXAPIMovemsgs", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIMovemsgs", namespace = "http://vistaevolution.va.gov")
public class Movemsgs {

    @XmlElement(name = "XMXAPIMovemsgsRequest", namespace = "")
    private XMXAPIMovemsgsRequest xmxapiMovemsgsRequest;

    /**
     * 
     * @return
     *     returns XMXAPIMovemsgsRequest
     */
    public XMXAPIMovemsgsRequest getXmxapiMovemsgsRequest() {
        return this.xmxapiMovemsgsRequest;
    }

    /**
     * 
     * @param xmxapiMovemsgsRequest
     *     the value for the xmxapiMovemsgsRequest property
     */
    public void setXmxapiMovemsgsRequest(XMXAPIMovemsgsRequest xmxapiMovemsgsRequest) {
        this.xmxapiMovemsgsRequest = xmxapiMovemsgsRequest;
    }

}

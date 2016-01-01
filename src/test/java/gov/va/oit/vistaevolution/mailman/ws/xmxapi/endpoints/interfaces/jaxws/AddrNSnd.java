
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;

@XmlRootElement(name = "AddrNSndXMXAPI", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddrNSndXMXAPI", namespace = "http://vistaevolution.va.gov")
public class AddrNSnd {

    @XmlElement(name = "XMXAPIAddrNSndRequest", namespace = "")
    private XMXAPIAddrNSndRequest xmxapiAddrNSndRequest;

    /**
     * 
     * @return
     *     returns XMXAPIAddrNSndRequest
     */
    public XMXAPIAddrNSndRequest getXmxapiAddrNSndRequest() {
        return this.xmxapiAddrNSndRequest;
    }

    /**
     * 
     * @param xmxapiAddrNSndRequest
     *     the value for the xmxapiAddrNSndRequest property
     */
    public void setXmxapiAddrNSndRequest(XMXAPIAddrNSndRequest xmxapiAddrNSndRequest) {
        this.xmxapiAddrNSndRequest = xmxapiAddrNSndRequest;
    }

}

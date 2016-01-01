
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPutServRequest;

@XmlRootElement(name = "XMXAPIPutServ", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIPutServ", namespace = "http://vistaevolution.va.gov")
public class PutMsg {

    @XmlElement(name = "XMXAPIPutServRequest", namespace = "")
    private XMXAPIPutServRequest xmxapiPutServRequest;

    /**
     * 
     * @return
     *     returns XMXAPIPutServRequest
     */
    public XMXAPIPutServRequest getXmxapiPutServRequest() {
        return this.xmxapiPutServRequest;
    }

    /**
     * 
     * @param xmxapiPutServRequest
     *     the value for the xmxapiPutServRequest property
     */
    public void setXmxapiPutServRequest(XMXAPIPutServRequest xmxapiPutServRequest) {
        this.xmxapiPutServRequest = xmxapiPutServRequest;
    }

}

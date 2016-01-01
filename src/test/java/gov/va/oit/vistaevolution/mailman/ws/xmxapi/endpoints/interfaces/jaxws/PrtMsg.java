
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPrtMsgRequest;

@XmlRootElement(name = "XMXAPIPrtMsg", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIPrtMsg", namespace = "http://vistaevolution.va.gov")
public class PrtMsg {

    @XmlElement(name = "XMXAPIPrtMsgRequest", namespace = "")
    private XMXAPIPrtMsgRequest xmxapiPrtMsgRequest;

    /**
     * 
     * @return
     *     returns XMXAPIPrtMsgRequest
     */
    public XMXAPIPrtMsgRequest getXmxapiPrtMsgRequest() {
        return this.xmxapiPrtMsgRequest;
    }

    /**
     * 
     * @param xmxapiPrtMsgRequest
     *     the value for the xmxapiPrtMsgRequest property
     */
    public void setXmxapiPrtMsgRequest(XMXAPIPrtMsgRequest xmxapiPrtMsgRequest) {
        this.xmxapiPrtMsgRequest = xmxapiPrtMsgRequest;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendMsgRequest;

@XmlRootElement(name = "XMXAPISendMsg", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPISendMsg", namespace = "http://vistaevolution.va.gov")
public class SendMsg {

    @XmlElement(name = "XMXAPISendMsgRequest", namespace = "")
    private XMXAPISendMsgRequest xmxapiSendMsgRequest;

    /**
     * 
     * @return
     *     returns XMXAPISendMsgRequest
     */
    public XMXAPISendMsgRequest getXmxapiSendMsgRequest() {
        return this.xmxapiSendMsgRequest;
    }

    /**
     * 
     * @param xmxapiSendMsgRequest
     *     the value for the xmxapiSendMsgRequest property
     */
    public void setXmxapiSendMsgRequest(XMXAPISendMsgRequest xmxapiSendMsgRequest) {
        this.xmxapiSendMsgRequest = xmxapiSendMsgRequest;
    }

}

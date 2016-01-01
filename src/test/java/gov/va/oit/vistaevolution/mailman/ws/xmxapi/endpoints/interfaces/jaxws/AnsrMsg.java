
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAnsrMsgRequest;

@XmlRootElement(name = "XMXAPIAnsrMsg", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIAnsrMsg", namespace = "http://vistaevolution.va.gov")
public class AnsrMsg {

    @XmlElement(name = "XMXAPIAnsrMsgRequest", namespace = "")
    private XMXAPIAnsrMsgRequest xmxapiAnsrMsgRequest;

    /**
     * 
     * @return
     *     returns XMXAPIAnsrMsgRequest
     */
    public XMXAPIAnsrMsgRequest getXmxapiAnsrMsgRequest() {
        return this.xmxapiAnsrMsgRequest;
    }

    /**
     * 
     * @param xmxapiAnsrMsgRequest
     *     the value for the xmxapiAnsrMsgRequest property
     */
    public void setXmxapiAnsrMsgRequest(XMXAPIAnsrMsgRequest xmxapiAnsrMsgRequest) {
        this.xmxapiAnsrMsgRequest = xmxapiAnsrMsgRequest;
    }

}

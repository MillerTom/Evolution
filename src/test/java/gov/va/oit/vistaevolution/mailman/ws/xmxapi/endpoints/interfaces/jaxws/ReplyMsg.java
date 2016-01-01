
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgRequest;

@XmlRootElement(name = "XMXAPIReplyMsg", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIReplyMsg", namespace = "http://vistaevolution.va.gov")
public class ReplyMsg {

    @XmlElement(name = "XMXAPIReplyMsgRequest", namespace = "")
    private XMXAPIReplyMsgRequest xmxapiReplyMsgRequest;

    /**
     * 
     * @return
     *     returns XMXAPIReplyMsgRequest
     */
    public XMXAPIReplyMsgRequest getXmxapiReplyMsgRequest() {
        return this.xmxapiReplyMsgRequest;
    }

    /**
     * 
     * @param xmxapiReplyMsgRequest
     *     the value for the xmxapiReplyMsgRequest property
     */
    public void setXmxapiReplyMsgRequest(XMXAPIReplyMsgRequest xmxapiReplyMsgRequest) {
        this.xmxapiReplyMsgRequest = xmxapiReplyMsgRequest;
    }

}

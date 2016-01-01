
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgResponse;

@XmlRootElement(name = "XMXAPIReplyMsgResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIReplyMsgResponse", namespace = "http://vistaevolution.va.gov")
public class ReplyMsgResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIReplyMsgResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIReplyMsgResponse
     */
    public XMXAPIReplyMsgResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIReplyMsgResponse _return) {
        this._return = _return;
    }

}

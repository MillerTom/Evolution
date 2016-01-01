
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFwdMsgRequest;

@XmlRootElement(name = "XMXAPIFwdMsg", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIFwdMsg", namespace = "http://vistaevolution.va.gov")
public class FwdMsg {

    @XmlElement(name = "XMXAPIFwdMsgRequest", namespace = "")
    private XMXAPIFwdMsgRequest xmxapiFwdMsgRequest;

    /**
     * 
     * @return
     *     returns XMXAPIFwdMsgRequest
     */
    public XMXAPIFwdMsgRequest getXmxapiFwdMsgRequest() {
        return this.xmxapiFwdMsgRequest;
    }

    /**
     * 
     * @param xmxapiFwdMsgRequest
     *     the value for the xmxapiFwdMsgRequest property
     */
    public void setXmxapiFwdMsgRequest(XMXAPIFwdMsgRequest xmxapiFwdMsgRequest) {
        this.xmxapiFwdMsgRequest = xmxapiFwdMsgRequest;
    }

}

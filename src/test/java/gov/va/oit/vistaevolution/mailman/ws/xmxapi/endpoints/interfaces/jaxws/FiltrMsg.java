
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgRequest;

@XmlRootElement(name = "XMXAPIFiltrMsg", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIFiltrMsg", namespace = "http://vistaevolution.va.gov")
public class FiltrMsg {

    @XmlElement(name = "XMXAPIFiltrMsgRequest", namespace = "")
    private XMXAPIFiltrMsgRequest xmxapiFiltrMsgRequest;

    /**
     * 
     * @return
     *     returns XMXAPIFiltrMsgRequest
     */
    public XMXAPIFiltrMsgRequest getXmxapiFiltrMsgRequest() {
        return this.xmxapiFiltrMsgRequest;
    }

    /**
     * 
     * @param xmxapiFiltrMsgRequest
     *     the value for the xmxapiFiltrMsgRequest property
     */
    public void setXmxapiFiltrMsgRequest(XMXAPIFiltrMsgRequest xmxapiFiltrMsgRequest) {
        this.xmxapiFiltrMsgRequest = xmxapiFiltrMsgRequest;
    }

}

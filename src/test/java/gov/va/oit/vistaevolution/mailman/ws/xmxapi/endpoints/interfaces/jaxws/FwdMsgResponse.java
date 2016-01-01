
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFwdMsgResponse;

@XmlRootElement(name = "XMXAPIFwdMsgResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIFwdMsgResponse", namespace = "http://vistaevolution.va.gov")
public class FwdMsgResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIFwdMsgResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIFwdMsgResponse
     */
    public XMXAPIFwdMsgResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIFwdMsgResponse _return) {
        this._return = _return;
    }

}

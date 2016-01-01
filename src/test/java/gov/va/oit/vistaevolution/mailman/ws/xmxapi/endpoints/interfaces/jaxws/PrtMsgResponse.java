
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPrtMsgResponse;

@XmlRootElement(name = "XMXAPIPrtMsgResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIPrtMsgResponse", namespace = "http://vistaevolution.va.gov")
public class PrtMsgResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIPrtMsgResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIPrtMsgResponse
     */
    public XMXAPIPrtMsgResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIPrtMsgResponse _return) {
        this._return = _return;
    }

}

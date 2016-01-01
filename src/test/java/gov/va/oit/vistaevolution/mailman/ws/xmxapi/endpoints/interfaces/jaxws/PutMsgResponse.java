
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPutServResponse;

@XmlRootElement(name = "XMXAPIPutServResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIPutServResponse", namespace = "http://vistaevolution.va.gov")
public class PutMsgResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIPutServResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIPutServResponse
     */
    public XMXAPIPutServResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIPutServResponse _return) {
        this._return = _return;
    }

}

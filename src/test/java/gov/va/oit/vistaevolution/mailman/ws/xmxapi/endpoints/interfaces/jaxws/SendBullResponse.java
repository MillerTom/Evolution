
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendBullResponse;

@XmlRootElement(name = "XMXAPISendBullResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPISendBullResponse", namespace = "http://vistaevolution.va.gov")
public class SendBullResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPISendBullResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPISendBullResponse
     */
    public XMXAPISendBullResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPISendBullResponse _return) {
        this._return = _return;
    }

}

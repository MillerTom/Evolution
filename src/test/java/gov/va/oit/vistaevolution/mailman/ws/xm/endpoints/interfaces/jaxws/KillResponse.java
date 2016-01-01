
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillResponse;

@XmlRootElement(name = "KillXMResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KillXMResponse", namespace = "http://vistaevolution.va.gov")
public class KillResponse {

    @XmlElement(name = "return", namespace = "")
    private XMKillResponse _return;

    /**
     * 
     * @return
     *     returns XMKillResponse
     */
    public XMKillResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMKillResponse _return) {
        this._return = _return;
    }

}

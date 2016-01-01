
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITaskBullResponse;

@XmlRootElement(name = "XMXAPITaskBullResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPITaskBullResponse", namespace = "http://vistaevolution.va.gov")
public class SendBulletinResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPITaskBullResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPITaskBullResponse
     */
    public XMXAPITaskBullResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPITaskBullResponse _return) {
        this._return = _return;
    }

}

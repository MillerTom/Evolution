
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.jaxws;

import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGAddMbrsResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXAPIGAddMbrsResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddMbrsResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIGAddMbrsResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIGAddMbrsResponse
     */
    public XMXAPIGAddMbrsResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIGAddMbrsResponse _return) {
        this._return = _return;
    }

}

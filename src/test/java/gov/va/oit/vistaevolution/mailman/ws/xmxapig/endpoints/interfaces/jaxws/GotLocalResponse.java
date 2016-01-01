
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGGotLocalResponse;

@XmlRootElement(name = "XMXAPIGGotLocalResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIGGotLocalResponse", namespace = "http://vistaevolution.va.gov")
public class GotLocalResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIGGotLocalResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIGGotLocalResponse
     */
    public XMXAPIGGotLocalResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIGGotLocalResponse _return) {
        this._return = _return;
    }

}

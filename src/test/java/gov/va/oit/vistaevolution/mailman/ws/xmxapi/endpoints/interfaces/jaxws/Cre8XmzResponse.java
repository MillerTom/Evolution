
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPICre8XMZResponse;

@XmlRootElement(name = "XMXAPICre8XMZResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPICre8XMZResponse", namespace = "http://vistaevolution.va.gov")
public class Cre8XmzResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPICre8XMZResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPICre8XMZResponse
     */
    public XMXAPICre8XMZResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPICre8XMZResponse _return) {
        this._return = _return;
    }

}

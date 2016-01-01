
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityResponse;

@XmlRootElement(name = "XMXEDITPriorityResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXEDITPriorityResponse", namespace = "http://vistaevolution.va.gov")
public class PriorityResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXEDITPriorityResponse _return;

    /**
     * 
     * @return
     *     returns XMXEDITPriorityResponse
     */
    public XMXEDITPriorityResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXEDITPriorityResponse _return) {
        this._return = _return;
    }

}

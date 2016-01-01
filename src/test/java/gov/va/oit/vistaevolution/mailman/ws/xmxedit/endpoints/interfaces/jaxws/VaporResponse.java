
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporResponse;

@XmlRootElement(name = "XMXEDITVaporResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXEDITVaporResponse", namespace = "http://vistaevolution.va.gov")
public class VaporResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXEDITVaporResponse _return;

    /**
     * 
     * @return
     *     returns XMXEDITVaporResponse
     */
    public XMXEDITVaporResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXEDITVaporResponse _return) {
        this._return = _return;
    }

}

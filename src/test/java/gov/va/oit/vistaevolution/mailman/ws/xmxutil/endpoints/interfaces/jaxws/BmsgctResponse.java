
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctResponse;

@XmlRootElement(name = "XMXUTILBmsgctResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILBmsgctResponse", namespace = "http://vistaevolution.va.gov")
public class BmsgctResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTILBmsgctResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTILBmsgctResponse
     */
    public XMXUTILBmsgctResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTILBmsgctResponse _return) {
        this._return = _return;
    }

}

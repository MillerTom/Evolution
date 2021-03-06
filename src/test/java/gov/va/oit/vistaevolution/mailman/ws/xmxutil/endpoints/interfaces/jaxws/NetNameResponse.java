
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNetNameResponse;

@XmlRootElement(name = "XMXUTILNetNameResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILNetNameResponse", namespace = "http://vistaevolution.va.gov")
public class NetNameResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTILNetNameResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTILNetNameResponse
     */
    public XMXUTILNetNameResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTILNetNameResponse _return) {
        this._return = _return;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNameResponse;

@XmlRootElement(name = "XMXUTILNameResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILNameResponse", namespace = "http://vistaevolution.va.gov")
public class NameResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTILNameResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTILNameResponse
     */
    public XMXUTILNameResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTILNameResponse _return) {
        this._return = _return;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZSUBJResponse;

@XmlRootElement(name = "XMXUtil2ZSUBJResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUtil2ZSUBJResponse", namespace = "http://vistaevolution.va.gov")
public class ZsubjResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUtil2ZSUBJResponse _return;

    /**
     * 
     * @return
     *     returns XMXUtil2ZSUBJResponse
     */
    public XMXUtil2ZSUBJResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUtil2ZSUBJResponse _return) {
        this._return = _return;
    }

}

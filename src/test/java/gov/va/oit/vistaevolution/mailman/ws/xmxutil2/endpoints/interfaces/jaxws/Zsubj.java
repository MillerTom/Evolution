
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZSUBJRequest;

@XmlRootElement(name = "XMXUtil2ZSUBJ", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUtil2ZSUBJ", namespace = "http://vistaevolution.va.gov")
public class Zsubj {

    @XmlElement(name = "XMXUtil2ZSUBJRequest", namespace = "")
    private XMXUtil2ZSUBJRequest xmxUtil2ZSUBJRequest;

    /**
     * 
     * @return
     *     returns XMXUtil2ZSUBJRequest
     */
    public XMXUtil2ZSUBJRequest getXmxUtil2ZSUBJRequest() {
        return this.xmxUtil2ZSUBJRequest;
    }

    /**
     * 
     * @param xmxUtil2ZSUBJRequest
     *     the value for the xmxUtil2ZSUBJRequest property
     */
    public void setXmxUtil2ZSUBJRequest(XMXUtil2ZSUBJRequest xmxUtil2ZSUBJRequest) {
        this.xmxUtil2ZSUBJRequest = xmxUtil2ZSUBJRequest;
    }

}

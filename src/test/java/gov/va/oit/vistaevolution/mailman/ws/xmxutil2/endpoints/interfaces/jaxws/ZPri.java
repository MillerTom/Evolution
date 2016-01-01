
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZPriRequest;

@XmlRootElement(name = "ZPriXMXUtil2", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZPriXMXUtil2", namespace = "http://vistaevolution.va.gov")
public class ZPri {

    @XmlElement(name = "XMXUtil2ZPriRequest", namespace = "")
    private XMXUtil2ZPriRequest xmxUtil2ZPriRequest;

    /**
     * 
     * @return
     *     returns XMXUtil2ZPriRequest
     */
    public XMXUtil2ZPriRequest getXmxUtil2ZPriRequest() {
        return this.xmxUtil2ZPriRequest;
    }

    /**
     * 
     * @param xmxUtil2ZPriRequest
     *     the value for the xmxUtil2ZPriRequest property
     */
    public void setXmxUtil2ZPriRequest(XMXUtil2ZPriRequest xmxUtil2ZPriRequest) {
        this.xmxUtil2ZPriRequest = xmxUtil2ZPriRequest;
    }

}

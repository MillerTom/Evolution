
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2FromRequest;

@XmlRootElement(name = "XMXUTIL2From", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL2From", namespace = "http://vistaevolution.va.gov")
public class From {

    @XmlElement(name = "XMXUtil2FromRequest", namespace = "")
    private XMXUtil2FromRequest xmxUtil2FromRequest;

    /**
     * 
     * @return
     *     returns XMXUtil2FromRequest
     */
    public XMXUtil2FromRequest getXmxUtil2FromRequest() {
        return this.xmxUtil2FromRequest;
    }

    /**
     * 
     * @param xmxUtil2FromRequest
     *     the value for the xmxUtil2FromRequest property
     */
    public void setXmxUtil2FromRequest(XMXUtil2FromRequest xmxUtil2FromRequest) {
        this.xmxUtil2FromRequest = xmxUtil2FromRequest;
    }

}

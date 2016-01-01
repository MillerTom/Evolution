
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2LineRequest;

@XmlRootElement(name = "XMXUTIL2Line", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL2Line", namespace = "http://vistaevolution.va.gov")
public class Line {

    @XmlElement(name = "XMXUtil2LineRequest", namespace = "")
    private XMXUtil2LineRequest xmxUtil2LineRequest;

    /**
     * 
     * @return
     *     returns XMXUtil2LineRequest
     */
    public XMXUtil2LineRequest getXmxUtil2LineRequest() {
        return this.xmxUtil2LineRequest;
    }

    /**
     * 
     * @param xmxUtil2LineRequest
     *     the value for the xmxUtil2LineRequest property
     */
    public void setXmxUtil2LineRequest(XMXUtil2LineRequest xmxUtil2LineRequest) {
        this.xmxUtil2LineRequest = xmxUtil2LineRequest;
    }

}

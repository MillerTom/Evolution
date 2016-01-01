
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1MaxBlankRequest;

@XmlRootElement(name = "XMXUtil1MaxBlank", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUtil1MaxBlank", namespace = "http://vistaevolution.va.gov")
public class MaxBlank {

    @XmlElement(name = "XMXUtil1MaxBlankRequest", namespace = "")
    private XMXUtil1MaxBlankRequest xmxUtil1MaxBlankRequest;

    /**
     * 
     * @return
     *     returns XMXUtil1MaxBlankRequest
     */
    public XMXUtil1MaxBlankRequest getXmxUtil1MaxBlankRequest() {
        return this.xmxUtil1MaxBlankRequest;
    }

    /**
     * 
     * @param xmxUtil1MaxBlankRequest
     *     the value for the xmxUtil1MaxBlankRequest property
     */
    public void setXmxUtil1MaxBlankRequest(XMXUtil1MaxBlankRequest xmxUtil1MaxBlankRequest) {
        this.xmxUtil1MaxBlankRequest = xmxUtil1MaxBlankRequest;
    }

}

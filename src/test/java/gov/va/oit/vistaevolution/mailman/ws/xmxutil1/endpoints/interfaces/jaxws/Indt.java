
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1INDTRequest;

@XmlRootElement(name = "XMXUtil1INDT", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUtil1INDT", namespace = "http://vistaevolution.va.gov")
public class Indt {

    @XmlElement(name = "XMXUtil1INDTRequest", namespace = "")
    private XMXUtil1INDTRequest xmxUtil1INDTRequest;

    /**
     * 
     * @return
     *     returns XMXUtil1INDTRequest
     */
    public XMXUtil1INDTRequest getXmxUtil1INDTRequest() {
        return this.xmxUtil1INDTRequest;
    }

    /**
     * 
     * @param xmxUtil1INDTRequest
     *     the value for the xmxUtil1INDTRequest property
     */
    public void setXmxUtil1INDTRequest(XMXUtil1INDTRequest xmxUtil1INDTRequest) {
        this.xmxUtil1INDTRequest = xmxUtil1INDTRequest;
    }

}

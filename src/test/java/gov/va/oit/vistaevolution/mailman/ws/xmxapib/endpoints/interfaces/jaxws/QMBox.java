
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQMBoxRequest;

@XmlRootElement(name = "XMXAPIBQMBox", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIBQMBox", namespace = "http://vistaevolution.va.gov")
public class QMBox {

    @XmlElement(name = "XMXAPIBQMBoxRequest", namespace = "")
    private XMXAPIBQMBoxRequest xmxapibqmBoxRequest;

    /**
     * 
     * @return
     *     returns XMXAPIBQMBoxRequest
     */
    public XMXAPIBQMBoxRequest getXmxapibqmBoxRequest() {
        return this.xmxapibqmBoxRequest;
    }

    /**
     * 
     * @param xmxapibqmBoxRequest
     *     the value for the xmxapibqmBoxRequest property
     */
    public void setXmxapibqmBoxRequest(XMXAPIBQMBoxRequest xmxapibqmBoxRequest) {
        this.xmxapibqmBoxRequest = xmxapibqmBoxRequest;
    }

}

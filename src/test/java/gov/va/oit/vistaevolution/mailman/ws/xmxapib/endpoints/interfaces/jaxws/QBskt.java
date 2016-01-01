
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQBsktRequest;

@XmlRootElement(name = "XMXAPIBQBskt", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIBQBskt", namespace = "http://vistaevolution.va.gov")
public class QBskt {

    @XmlElement(name = "XMXAPIBQBsktRequest", namespace = "")
    private XMXAPIBQBsktRequest xmxapibqBsktRequest;

    /**
     * 
     * @return
     *     returns XMXAPIBQBsktRequest
     */
    public XMXAPIBQBsktRequest getXmxapibqBsktRequest() {
        return this.xmxapibqBsktRequest;
    }

    /**
     * 
     * @param xmxapibqBsktRequest
     *     the value for the xmxapibqBsktRequest property
     */
    public void setXmxapibqBsktRequest(XMXAPIBQBsktRequest xmxapibqBsktRequest) {
        this.xmxapibqBsktRequest = xmxapibqBsktRequest;
    }

}

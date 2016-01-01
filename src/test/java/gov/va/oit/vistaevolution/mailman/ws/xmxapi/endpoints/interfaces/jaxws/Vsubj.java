
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVSubjRequest;

@XmlRootElement(name = "XMXAPIVSubj", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIVSubj", namespace = "http://vistaevolution.va.gov")
public class Vsubj {

    @XmlElement(name = "XMXAPIVSubjRequest", namespace = "")
    private XMXAPIVSubjRequest xmxapivSubjRequest;

    /**
     * 
     * @return
     *     returns XMXAPIVSubjRequest
     */
    public XMXAPIVSubjRequest getXmxapivSubjRequest() {
        return this.xmxapivSubjRequest;
    }

    /**
     * 
     * @param xmxapivSubjRequest
     *     the value for the xmxapivSubjRequest property
     */
    public void setXmxapivSubjRequest(XMXAPIVSubjRequest xmxapivSubjRequest) {
        this.xmxapivSubjRequest = xmxapivSubjRequest;
    }

}

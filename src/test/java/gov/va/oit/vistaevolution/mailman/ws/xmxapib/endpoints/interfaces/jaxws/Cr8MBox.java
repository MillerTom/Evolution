
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8MBoxRequest;

@XmlRootElement(name = "XMXAPIBCre8MBox", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIBCre8MBox", namespace = "http://vistaevolution.va.gov")
public class Cr8MBox {

    @XmlElement(name = "XMXAPIBCre8MBoxRequest", namespace = "")
    private XMXAPIBCre8MBoxRequest xmxapibCre8MBoxRequest;

    /**
     * 
     * @return
     *     returns XMXAPIBCre8MBoxRequest
     */
    public XMXAPIBCre8MBoxRequest getXmxapibCre8MBoxRequest() {
        return this.xmxapibCre8MBoxRequest;
    }

    /**
     * 
     * @param xmxapibCre8MBoxRequest
     *     the value for the xmxapibCre8MBoxRequest property
     */
    public void setXmxapibCre8MBoxRequest(XMXAPIBCre8MBoxRequest xmxapibCre8MBoxRequest) {
        this.xmxapibCre8MBoxRequest = xmxapibCre8MBoxRequest;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendBullRequest;

@XmlRootElement(name = "XMXAPISendBull", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPISendBull", namespace = "http://vistaevolution.va.gov")
public class SendBull {

    @XmlElement(name = "XMXAPISendBullRequest", namespace = "")
    private XMXAPISendBullRequest xmxapiSendBullRequest;

    /**
     * 
     * @return
     *     returns XMXAPISendBullRequest
     */
    public XMXAPISendBullRequest getXmxapiSendBullRequest() {
        return this.xmxapiSendBullRequest;
    }

    /**
     * 
     * @param xmxapiSendBullRequest
     *     the value for the xmxapiSendBullRequest property
     */
    public void setXmxapiSendBullRequest(XMXAPISendBullRequest xmxapiSendBullRequest) {
        this.xmxapiSendBullRequest = xmxapiSendBullRequest;
    }

}

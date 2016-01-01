
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITaskBullRequest;

@XmlRootElement(name = "XMXAPITaskBull", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPITaskBull", namespace = "http://vistaevolution.va.gov")
public class SendBulletin {

    @XmlElement(name = "XMXAPITaskBullRequest", namespace = "")
    private XMXAPITaskBullRequest xmxapiTaskBullRequest;

    /**
     * 
     * @return
     *     returns XMXAPITaskBullRequest
     */
    public XMXAPITaskBullRequest getXmxapiTaskBullRequest() {
        return this.xmxapiTaskBullRequest;
    }

    /**
     * 
     * @param xmxapiTaskBullRequest
     *     the value for the xmxapiTaskBullRequest property
     */
    public void setXmxapiTaskBullRequest(XMXAPITaskBullRequest xmxapiTaskBullRequest) {
        this.xmxapiTaskBullRequest = xmxapiTaskBullRequest;
    }

}

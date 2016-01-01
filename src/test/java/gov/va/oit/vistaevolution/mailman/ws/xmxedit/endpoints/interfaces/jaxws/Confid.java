
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidRequest;

@XmlRootElement(name = "XMXEDITConfid", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXEDITConfid", namespace = "http://vistaevolution.va.gov")
public class Confid {

    @XmlElement(name = "XMXEDITConfidRequest", namespace = "")
    private XMXEDITConfidRequest xmxeditConfidRequest;

    /**
     * 
     * @return
     *     returns XMXEDITConfidRequest
     */
    public XMXEDITConfidRequest getXmxeditConfidRequest() {
        return this.xmxeditConfidRequest;
    }

    /**
     * 
     * @param xmxeditConfidRequest
     *     the value for the xmxeditConfidRequest property
     */
    public void setXmxeditConfidRequest(XMXEDITConfidRequest xmxeditConfidRequest) {
        this.xmxeditConfidRequest = xmxeditConfidRequest;
    }

}

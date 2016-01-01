
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporRequest;

@XmlRootElement(name = "XMXEDITVapor", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXEDITVapor", namespace = "http://vistaevolution.va.gov")
public class Vapor {

    @XmlElement(name = "XMXEDITVaporRequest", namespace = "")
    private XMXEDITVaporRequest xmxeditVaporRequest;

    /**
     * 
     * @return
     *     returns XMXEDITVaporRequest
     */
    public XMXEDITVaporRequest getXmxeditVaporRequest() {
        return this.xmxeditVaporRequest;
    }

    /**
     * 
     * @param xmxeditVaporRequest
     *     the value for the xmxeditVaporRequest property
     */
    public void setXmxeditVaporRequest(XMXEDITVaporRequest xmxeditVaporRequest) {
        this.xmxeditVaporRequest = xmxeditVaporRequest;
    }

}

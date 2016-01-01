
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityRequest;

@XmlRootElement(name = "XMXEDITPriority", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXEDITPriority", namespace = "http://vistaevolution.va.gov")
public class Priority {

    @XmlElement(name = "XMXEDITPriorityRequest", namespace = "")
    private XMXEDITPriorityRequest xmxeditPriorityRequest;

    /**
     * 
     * @return
     *     returns XMXEDITPriorityRequest
     */
    public XMXEDITPriorityRequest getXmxeditPriorityRequest() {
        return this.xmxeditPriorityRequest;
    }

    /**
     * 
     * @param xmxeditPriorityRequest
     *     the value for the xmxeditPriorityRequest property
     */
    public void setXmxeditPriorityRequest(XMXEDITPriorityRequest xmxeditPriorityRequest) {
        this.xmxeditPriorityRequest = xmxeditPriorityRequest;
    }

}

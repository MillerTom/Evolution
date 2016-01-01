
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextRequest;

@XmlRootElement(name = "XMXEDITText", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXEDITText", namespace = "http://vistaevolution.va.gov")
public class Text {

    @XmlElement(name = "XMXEDITTextRequest", namespace = "")
    private XMXEDITTextRequest xmxeditTextRequest;

    /**
     * 
     * @return
     *     returns XMXEDITTextRequest
     */
    public XMXEDITTextRequest getXmxeditTextRequest() {
        return this.xmxeditTextRequest;
    }

    /**
     * 
     * @param xmxeditTextRequest
     *     the value for the xmxeditTextRequest property
     */
    public void setXmxeditTextRequest(XMXEDITTextRequest xmxeditTextRequest) {
        this.xmxeditTextRequest = xmxeditTextRequest;
    }

}

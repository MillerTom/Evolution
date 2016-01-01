
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjRequest;

@XmlRootElement(name = "XMXEDITSubj", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXEDITSubj", namespace = "http://vistaevolution.va.gov")
public class Subj {

    @XmlElement(name = "XMXEDITSubjRequest", namespace = "")
    private XMXEDITSubjRequest xmxeditSubjRequest;

    /**
     * 
     * @return
     *     returns XMXEDITSubjRequest
     */
    public XMXEDITSubjRequest getXmxeditSubjRequest() {
        return this.xmxeditSubjRequest;
    }

    /**
     * 
     * @param xmxeditSubjRequest
     *     the value for the xmxeditSubjRequest property
     */
    public void setXmxeditSubjRequest(XMXEDITSubjRequest xmxeditSubjRequest) {
        this.xmxeditSubjRequest = xmxeditSubjRequest;
    }

}

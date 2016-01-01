
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillRequest;

@XmlRootElement(name = "KillXM", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KillXM", namespace = "http://vistaevolution.va.gov")
public class Kill {

    @XmlElement(name = "XMKillRequest", namespace = "")
    private XMKillRequest xmKillRequest;

    /**
     * 
     * @return
     *     returns XMKillRequest
     */
    public XMKillRequest getXmKillRequest() {
        return this.xmKillRequest;
    }

    /**
     * 
     * @param xmKillRequest
     *     the value for the xmKillRequest property
     */
    public void setXmKillRequest(XMKillRequest xmKillRequest) {
        this.xmKillRequest = xmKillRequest;
    }

}

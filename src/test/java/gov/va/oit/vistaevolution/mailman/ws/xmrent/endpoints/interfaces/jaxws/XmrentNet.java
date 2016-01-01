
package gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetRequest;

@XmlRootElement(name = "XMRENTNet", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMRENTNet", namespace = "http://vistaevolution.va.gov")
public class XmrentNet {

    @XmlElement(name = "XMRENTNet", namespace = "")
    private XMRENTNetRequest xmrentNet;

    /**
     * 
     * @return
     *     returns XMRENTNetRequest
     */
    public XMRENTNetRequest getXmrentNet() {
        return this.xmrentNet;
    }

    /**
     * 
     * @param xmrentNet
     *     the value for the xmrentNet property
     */
    public void setXmrentNet(XMRENTNetRequest xmrentNet) {
        this.xmrentNet = xmrentNet;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNetNameRequest;

@XmlRootElement(name = "XMXUTILNetName", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILNetName", namespace = "http://vistaevolution.va.gov")
public class NetName {

    @XmlElement(name = "XMXUTILNetNameRequest", namespace = "")
    private XMXUTILNetNameRequest xmxutilNetNameRequest;

    /**
     * 
     * @return
     *     returns XMXUTILNetNameRequest
     */
    public XMXUTILNetNameRequest getXmxutilNetNameRequest() {
        return this.xmxutilNetNameRequest;
    }

    /**
     * 
     * @param xmxutilNetNameRequest
     *     the value for the xmxutilNetNameRequest property
     */
    public void setXmxutilNetNameRequest(XMXUTILNetNameRequest xmxutilNetNameRequest) {
        this.xmxutilNetNameRequest = xmxutilNetNameRequest;
    }

}

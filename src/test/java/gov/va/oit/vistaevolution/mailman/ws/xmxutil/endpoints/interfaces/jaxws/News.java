
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNewsRequest;

@XmlRootElement(name = "XMXUTILNews", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILNews", namespace = "http://vistaevolution.va.gov")
public class News {

    @XmlElement(name = "XMXUTILNewsRequest", namespace = "")
    private XMXUTILNewsRequest xmxutilNewsRequest;

    /**
     * 
     * @return
     *     returns XMXUTILNewsRequest
     */
    public XMXUTILNewsRequest getXmxutilNewsRequest() {
        return this.xmxutilNewsRequest;
    }

    /**
     * 
     * @param xmxutilNewsRequest
     *     the value for the xmxutilNewsRequest property
     */
    public void setXmxutilNewsRequest(XMXUTILNewsRequest xmxutilNewsRequest) {
        this.xmxutilNewsRequest = xmxutilNewsRequest;
    }

}

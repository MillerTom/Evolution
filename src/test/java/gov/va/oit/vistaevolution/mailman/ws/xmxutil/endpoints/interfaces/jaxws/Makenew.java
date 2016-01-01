
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILMakenewRequest;

@XmlRootElement(name = "XMXUTILMakenew", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILMakenew", namespace = "http://vistaevolution.va.gov")
public class Makenew {

    @XmlElement(name = "XMXUTILMakenewRequest", namespace = "")
    private XMXUTILMakenewRequest xmxutilMakenewRequest;

    /**
     * 
     * @return
     *     returns XMXUTILMakenewRequest
     */
    public XMXUTILMakenewRequest getXmxutilMakenewRequest() {
        return this.xmxutilMakenewRequest;
    }

    /**
     * 
     * @param xmxutilMakenewRequest
     *     the value for the xmxutilMakenewRequest property
     */
    public void setXmxutilMakenewRequest(XMXUTILMakenewRequest xmxutilMakenewRequest) {
        this.xmxutilMakenewRequest = xmxutilMakenewRequest;
    }

}

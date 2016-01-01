
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctRequest;

@XmlRootElement(name = "XMXUTILBmsgct", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILBmsgct", namespace = "http://vistaevolution.va.gov")
public class Bmsgct {

    @XmlElement(name = "XMXUTILBmsgctRequest", namespace = "")
    private XMXUTILBmsgctRequest xmxutilBmsgctRequest;

    /**
     * 
     * @return
     *     returns XMXUTILBmsgctRequest
     */
    public XMXUTILBmsgctRequest getXmxutilBmsgctRequest() {
        return this.xmxutilBmsgctRequest;
    }

    /**
     * 
     * @param xmxutilBmsgctRequest
     *     the value for the xmxutilBmsgctRequest property
     */
    public void setXmxutilBmsgctRequest(XMXUTILBmsgctRequest xmxutilBmsgctRequest) {
        this.xmxutilBmsgctRequest = xmxutilBmsgctRequest;
    }

}

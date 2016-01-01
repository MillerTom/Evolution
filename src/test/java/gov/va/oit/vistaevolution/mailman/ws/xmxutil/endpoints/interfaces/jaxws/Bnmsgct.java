
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBnmsgctRequest;

@XmlRootElement(name = "XMXUTILBnmsgct", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILBnmsgct", namespace = "http://vistaevolution.va.gov")
public class Bnmsgct {

    @XmlElement(name = "XMXUTILBnmsgctRequest", namespace = "")
    private XMXUTILBnmsgctRequest xmxutilBnmsgctRequest;

    /**
     * 
     * @return
     *     returns XMXUTILBnmsgctRequest
     */
    public XMXUTILBnmsgctRequest getXmxutilBnmsgctRequest() {
        return this.xmxutilBnmsgctRequest;
    }

    /**
     * 
     * @param xmxutilBnmsgctRequest
     *     the value for the xmxutilBnmsgctRequest property
     */
    public void setXmxutilBnmsgctRequest(XMXUTILBnmsgctRequest xmxutilBnmsgctRequest) {
        this.xmxutilBnmsgctRequest = xmxutilBnmsgctRequest;
    }

}

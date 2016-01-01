
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNameRequest;

@XmlRootElement(name = "XMXUTILName", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILName", namespace = "http://vistaevolution.va.gov")
public class Name {

    @XmlElement(name = "XMXUTILNameRequest", namespace = "")
    private XMXUTILNameRequest xmxutilNameRequest;

    /**
     * 
     * @return
     *     returns XMXUTILNameRequest
     */
    public XMXUTILNameRequest getXmxutilNameRequest() {
        return this.xmxutilNameRequest;
    }

    /**
     * 
     * @param xmxutilNameRequest
     *     the value for the xmxutilNameRequest property
     */
    public void setXmxutilNameRequest(XMXUTILNameRequest xmxutilNameRequest) {
        this.xmxutilNameRequest = xmxutilNameRequest;
    }

}

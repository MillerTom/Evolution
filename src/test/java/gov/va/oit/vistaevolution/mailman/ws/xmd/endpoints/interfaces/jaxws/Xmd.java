
package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDRequest;

@XmlRootElement(name = "XMD", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMD", namespace = "http://vistaevolution.va.gov")
public class Xmd {

    @XmlElement(name = "XMDRequest", namespace = "")
    private XMDRequest xmdRequest;

    /**
     * 
     * @return
     *     returns XMDRequest
     */
    public XMDRequest getXmdRequest() {
        return this.xmdRequest;
    }

    /**
     * 
     * @param xmdRequest
     *     the value for the xmdRequest property
     */
    public void setXmdRequest(XMDRequest xmdRequest) {
        this.xmdRequest = xmdRequest;
    }

}

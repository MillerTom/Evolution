
package gov.va.oit.vistaevolution.kernel.ws.xuser2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.model.XUSER2GetUpnRequest;

@XmlRootElement(name = "XUSER2GetUpn", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSER2GetUpn", namespace = "http://vistaevolution.va.gov")
public class GetUpn {

    @XmlElement(name = "XUSER2GetUpnRequest", namespace = "")
    private XUSER2GetUpnRequest xuser2GetUpnRequest;

    /**
     * 
     * @return
     *     returns XUSER2GetUpnRequest
     */
    public XUSER2GetUpnRequest getXuser2GetUpnRequest() {
        return this.xuser2GetUpnRequest;
    }

    /**
     * 
     * @param xuser2GetUpnRequest
     *     the value for the xuser2GetUpnRequest property
     */
    public void setXuser2GetUpnRequest(XUSER2GetUpnRequest xuser2GetUpnRequest) {
        this.xuser2GetUpnRequest = xuser2GetUpnRequest;
    }

}

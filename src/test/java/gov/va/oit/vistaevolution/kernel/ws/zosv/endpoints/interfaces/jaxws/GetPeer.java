
package gov.va.oit.vistaevolution.kernel.ws.zosv.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.zosv.model.ZOSVGetPeerRequest;

@XmlRootElement(name = "GetPeerZSOV", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPeerZSOV", namespace = "http://vistaevolution.va.gov")
public class GetPeer {

    @XmlElement(name = "ZOSVGetPeerRequest", namespace = "")
    private ZOSVGetPeerRequest zosvGetPeerRequest;

    /**
     * 
     * @return
     *     returns ZOSVGetPeerRequest
     */
    public ZOSVGetPeerRequest getZosvGetPeerRequest() {
        return this.zosvGetPeerRequest;
    }

    /**
     * 
     * @param zosvGetPeerRequest
     *     the value for the zosvGetPeerRequest property
     */
    public void setZosvGetPeerRequest(ZOSVGetPeerRequest zosvGetPeerRequest) {
        this.zosvGetPeerRequest = zosvGetPeerRequest;
    }

}

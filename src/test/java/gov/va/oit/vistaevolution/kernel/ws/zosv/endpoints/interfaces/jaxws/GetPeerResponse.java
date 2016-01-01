
package gov.va.oit.vistaevolution.kernel.ws.zosv.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.zosv.model.ZOSVGetPeerResponse;

@XmlRootElement(name = "GetPeerZSOVResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPeerZSOVResponse", namespace = "http://vistaevolution.va.gov")
public class GetPeerResponse {

    @XmlElement(name = "return", namespace = "")
    private ZOSVGetPeerResponse _return;

    /**
     * 
     * @return
     *     returns ZOSVGetPeerResponse
     */
    public ZOSVGetPeerResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ZOSVGetPeerResponse _return) {
        this._return = _return;
    }

}

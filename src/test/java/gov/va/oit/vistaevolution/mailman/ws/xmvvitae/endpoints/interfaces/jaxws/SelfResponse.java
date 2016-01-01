
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAESelfResponse;

@XmlRootElement(name = "XMVVITAESelfResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMVVITAESelfResponse", namespace = "http://vistaevolution.va.gov")
public class SelfResponse {

    @XmlElement(name = "return", namespace = "")
    private XMVVITAESelfResponse _return;

    /**
     * 
     * @return
     *     returns XMVVITAESelfResponse
     */
    public XMVVITAESelfResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMVVITAESelfResponse _return) {
        this._return = _return;
    }

}

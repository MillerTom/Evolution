
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEOtherResponse;

@XmlRootElement(name = "XMVVITAEOtherResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMVVITAEOtherResponse", namespace = "http://vistaevolution.va.gov")
public class OtherResponse {

    @XmlElement(name = "return", namespace = "")
    private XMVVITAEOtherResponse _return;

    /**
     * 
     * @return
     *     returns XMVVITAEOtherResponse
     */
    public XMVVITAEOtherResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMVVITAEOtherResponse _return) {
        this._return = _return;
    }

}

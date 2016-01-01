
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitResponse;

@XmlRootElement(name = "XMVVITAEInitResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMVVITAEInitResponse", namespace = "http://vistaevolution.va.gov")
public class InitResponse {

    @XmlElement(name = "return", namespace = "")
    private XMVVITAEInitResponse _return;

    /**
     * 
     * @return
     *     returns XMVVITAEInitResponse
     */
    public XMVVITAEInitResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMVVITAEInitResponse _return) {
        this._return = _return;
    }

}

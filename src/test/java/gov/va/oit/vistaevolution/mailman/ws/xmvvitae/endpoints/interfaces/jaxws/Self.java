
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAESelfRequest;

@XmlRootElement(name = "XMVVITAESelf", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMVVITAESelf", namespace = "http://vistaevolution.va.gov")
public class Self {

    @XmlElement(name = "XMVVITAESelfRequest", namespace = "")
    private XMVVITAESelfRequest xmvvitaeSelfRequest;

    /**
     * 
     * @return
     *     returns XMVVITAESelfRequest
     */
    public XMVVITAESelfRequest getXmvvitaeSelfRequest() {
        return this.xmvvitaeSelfRequest;
    }

    /**
     * 
     * @param xmvvitaeSelfRequest
     *     the value for the xmvvitaeSelfRequest property
     */
    public void setXmvvitaeSelfRequest(XMVVITAESelfRequest xmvvitaeSelfRequest) {
        this.xmvvitaeSelfRequest = xmvvitaeSelfRequest;
    }

}

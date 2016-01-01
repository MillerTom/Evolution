
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitRequest;

@XmlRootElement(name = "XMVVITAEInit", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMVVITAEInit", namespace = "http://vistaevolution.va.gov")
public class Init {

    @XmlElement(name = "XMVVITAEInitRequest", namespace = "")
    private XMVVITAEInitRequest xmvvitaeInitRequest;

    /**
     * 
     * @return
     *     returns XMVVITAEInitRequest
     */
    public XMVVITAEInitRequest getXmvvitaeInitRequest() {
        return this.xmvvitaeInitRequest;
    }

    /**
     * 
     * @param xmvvitaeInitRequest
     *     the value for the xmvvitaeInitRequest property
     */
    public void setXmvvitaeInitRequest(XMVVITAEInitRequest xmvvitaeInitRequest) {
        this.xmvvitaeInitRequest = xmvvitaeInitRequest;
    }

}

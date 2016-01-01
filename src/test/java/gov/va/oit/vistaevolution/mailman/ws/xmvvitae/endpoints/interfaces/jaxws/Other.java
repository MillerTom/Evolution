
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEOtherRequest;

@XmlRootElement(name = "XMVVITAEOther", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMVVITAEOther", namespace = "http://vistaevolution.va.gov")
public class Other {

    @XmlElement(name = "XMVVITAEOtherRequest", namespace = "")
    private XMVVITAEOtherRequest xmvvitaeOtherRequest;

    /**
     * 
     * @return
     *     returns XMVVITAEOtherRequest
     */
    public XMVVITAEOtherRequest getXmvvitaeOtherRequest() {
        return this.xmvvitaeOtherRequest;
    }

    /**
     * 
     * @param xmvvitaeOtherRequest
     *     the value for the xmvvitaeOtherRequest property
     */
    public void setXmvvitaeOtherRequest(XMVVITAEOtherRequest xmvvitaeOtherRequest) {
        this.xmvvitaeOtherRequest = xmvvitaeOtherRequest;
    }

}

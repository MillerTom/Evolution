
package gov.va.oit.vistaevolution.mailman.ws.xmgapi2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.model.XMGAPI2HdrRequest;

@XmlRootElement(name = "XMGAPI2Hdr", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMGAPI2Hdr", namespace = "http://vistaevolution.va.gov")
public class Hdr {

    @XmlElement(name = "XMGAPI2HdrRequest", namespace = "")
    private XMGAPI2HdrRequest xmgapi2HdrRequest;

    /**
     * 
     * @return
     *     returns XMGAPI2HdrRequest
     */
    public XMGAPI2HdrRequest getXmgapi2HdrRequest() {
        return this.xmgapi2HdrRequest;
    }

    /**
     * 
     * @param xmgapi2HdrRequest
     *     the value for the xmgapi2HdrRequest property
     */
    public void setXmgapi2HdrRequest(XMGAPI2HdrRequest xmgapi2HdrRequest) {
        this.xmgapi2HdrRequest = xmgapi2HdrRequest;
    }

}

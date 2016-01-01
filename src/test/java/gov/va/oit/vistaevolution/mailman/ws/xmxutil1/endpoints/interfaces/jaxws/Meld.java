
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MeldRequest;

@XmlRootElement(name = "XMXUTIL1Meld", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL1Meld", namespace = "http://vistaevolution.va.gov")
public class Meld {

    @XmlElement(name = "XMXUTIL1MeldRequest", namespace = "")
    private XMXUTIL1MeldRequest xmxutil1MeldRequest;

    /**
     * 
     * @return
     *     returns XMXUTIL1MeldRequest
     */
    public XMXUTIL1MeldRequest getXmxutil1MeldRequest() {
        return this.xmxutil1MeldRequest;
    }

    /**
     * 
     * @param xmxutil1MeldRequest
     *     the value for the xmxutil1MeldRequest property
     */
    public void setXmxutil1MeldRequest(XMXUTIL1MeldRequest xmxutil1MeldRequest) {
        this.xmxutil1MeldRequest = xmxutil1MeldRequest;
    }

}

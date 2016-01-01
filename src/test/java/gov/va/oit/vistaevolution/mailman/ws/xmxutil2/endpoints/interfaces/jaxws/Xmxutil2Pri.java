
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2PriRequest;

@XmlRootElement(name = "XMXUTIL2Pri", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL2Pri", namespace = "http://vistaevolution.va.gov")
public class Xmxutil2Pri {

    @XmlElement(name = "XMXUTIL2PriRequest", namespace = "")
    private XMXUTIL2PriRequest xmxutil2PriRequest;

    /**
     * 
     * @return
     *     returns XMXUTIL2PriRequest
     */
    public XMXUTIL2PriRequest getXmxutil2PriRequest() {
        return this.xmxutil2PriRequest;
    }

    /**
     * 
     * @param xmxutil2PriRequest
     *     the value for the xmxutil2PriRequest property
     */
    public void setXmxutil2PriRequest(XMXUTIL2PriRequest xmxutil2PriRequest) {
        this.xmxutil2PriRequest = xmxutil2PriRequest;
    }

}

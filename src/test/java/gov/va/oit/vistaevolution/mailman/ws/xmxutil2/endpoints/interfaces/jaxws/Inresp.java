
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespRequest;

@XmlRootElement(name = "XMXUTIL2Inresp", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL2Inresp", namespace = "http://vistaevolution.va.gov")
public class Inresp {

    @XmlElement(name = "XMXUTIL2InrespRequest", namespace = "")
    private XMXUTIL2InrespRequest xmxutil2InrespRequest;

    /**
     * 
     * @return
     *     returns XMXUTIL2InrespRequest
     */
    public XMXUTIL2InrespRequest getXmxutil2InrespRequest() {
        return this.xmxutil2InrespRequest;
    }

    /**
     * 
     * @param xmxutil2InrespRequest
     *     the value for the xmxutil2InrespRequest property
     */
    public void setXmxutil2InrespRequest(XMXUTIL2InrespRequest xmxutil2InrespRequest) {
        this.xmxutil2InrespRequest = xmxutil2InrespRequest;
    }

}

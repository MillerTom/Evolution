
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgRequest;

@XmlRootElement(name = "XMXUTIL2Inmsg", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL2Inmsg", namespace = "http://vistaevolution.va.gov")
public class Inmsg {

    @XmlElement(name = "XMXUTIL2InmsgRequest", namespace = "")
    private XMXUTIL2InmsgRequest xmxutil2InmsgRequest;

    /**
     * 
     * @return
     *     returns XMXUTIL2InmsgRequest
     */
    public XMXUTIL2InmsgRequest getXmxutil2InmsgRequest() {
        return this.xmxutil2InmsgRequest;
    }

    /**
     * 
     * @param xmxutil2InmsgRequest
     *     the value for the xmxutil2InmsgRequest property
     */
    public void setXmxutil2InmsgRequest(XMXUTIL2InmsgRequest xmxutil2InmsgRequest) {
        this.xmxutil2InmsgRequest = xmxutil2InmsgRequest;
    }

}

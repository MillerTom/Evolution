
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MmdtRequest;

@XmlRootElement(name = "XMXUTIL1Mmdt", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL1Mmdt", namespace = "http://vistaevolution.va.gov")
public class Mmdt {

    @XmlElement(name = "XMXUTIL1MmdtRequest", namespace = "")
    private XMXUTIL1MmdtRequest xmxutil1MmdtRequest;

    /**
     * 
     * @return
     *     returns XMXUTIL1MmdtRequest
     */
    public XMXUTIL1MmdtRequest getXmxutil1MmdtRequest() {
        return this.xmxutil1MmdtRequest;
    }

    /**
     * 
     * @param xmxutil1MmdtRequest
     *     the value for the xmxutil1MmdtRequest property
     */
    public void setXmxutil1MmdtRequest(XMXUTIL1MmdtRequest xmxutil1MmdtRequest) {
        this.xmxutil1MmdtRequest = xmxutil1MmdtRequest;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripRequest;

@XmlRootElement(name = "XMXUTIL1Strip", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL1Strip", namespace = "http://vistaevolution.va.gov")
public class Strip {

    @XmlElement(name = "XMXUTIL1StripRequest", namespace = "")
    private XMXUTIL1StripRequest xmxutil1StripRequest;

    /**
     * 
     * @return
     *     returns XMXUTIL1StripRequest
     */
    public XMXUTIL1StripRequest getXmxutil1StripRequest() {
        return this.xmxutil1StripRequest;
    }

    /**
     * 
     * @param xmxutil1StripRequest
     *     the value for the xmxutil1StripRequest property
     */
    public void setXmxutil1StripRequest(XMXUTIL1StripRequest xmxutil1StripRequest) {
        this.xmxutil1StripRequest = xmxutil1StripRequest;
    }

}

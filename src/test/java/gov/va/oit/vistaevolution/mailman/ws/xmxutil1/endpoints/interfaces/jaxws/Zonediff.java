
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ZonediffRequest;

@XmlRootElement(name = "XMXUTIL1Zonediff", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL1Zonediff", namespace = "http://vistaevolution.va.gov")
public class Zonediff {

    @XmlElement(name = "XMXUTIL1ZonediffRequest", namespace = "")
    private XMXUTIL1ZonediffRequest xmxutil1ZonediffRequest;

    /**
     * 
     * @return
     *     returns XMXUTIL1ZonediffRequest
     */
    public XMXUTIL1ZonediffRequest getXmxutil1ZonediffRequest() {
        return this.xmxutil1ZonediffRequest;
    }

    /**
     * 
     * @param xmxutil1ZonediffRequest
     *     the value for the xmxutil1ZonediffRequest property
     */
    public void setXmxutil1ZonediffRequest(XMXUTIL1ZonediffRequest xmxutil1ZonediffRequest) {
        this.xmxutil1ZonediffRequest = xmxutil1ZonediffRequest;
    }

}

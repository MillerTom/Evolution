
package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1DecodeupRequest;

@XmlRootElement(name = "XMCU1Decodeup", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMCU1Decodeup", namespace = "http://vistaevolution.va.gov")
public class Decodeup {

    @XmlElement(name = "XMCU1DecodeupRequest", namespace = "")
    private XMCU1DecodeupRequest xmcu1DecodeupRequest;

    /**
     * 
     * @return
     *     returns XMCU1DecodeupRequest
     */
    public XMCU1DecodeupRequest getXmcu1DecodeupRequest() {
        return this.xmcu1DecodeupRequest;
    }

    /**
     * 
     * @param xmcu1DecodeupRequest
     *     the value for the xmcu1DecodeupRequest property
     */
    public void setXmcu1DecodeupRequest(XMCU1DecodeupRequest xmcu1DecodeupRequest) {
        this.xmcu1DecodeupRequest = xmcu1DecodeupRequest;
    }

}

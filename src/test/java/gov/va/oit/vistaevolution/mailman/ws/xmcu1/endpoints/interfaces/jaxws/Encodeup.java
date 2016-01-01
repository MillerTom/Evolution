
package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1EncodeupRequest;

@XmlRootElement(name = "XMCU1Encodeup", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMCU1Encodeup", namespace = "http://vistaevolution.va.gov")
public class Encodeup {

    @XmlElement(name = "XMCU1EncodeupRequest", namespace = "")
    private XMCU1EncodeupRequest xmcu1EncodeupRequest;

    /**
     * 
     * @return
     *     returns XMCU1EncodeupRequest
     */
    public XMCU1EncodeupRequest getXmcu1EncodeupRequest() {
        return this.xmcu1EncodeupRequest;
    }

    /**
     * 
     * @param xmcu1EncodeupRequest
     *     the value for the xmcu1EncodeupRequest property
     */
    public void setXmcu1EncodeupRequest(XMCU1EncodeupRequest xmcu1EncodeupRequest) {
        this.xmcu1EncodeupRequest = xmcu1EncodeupRequest;
    }

}

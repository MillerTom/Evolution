
package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1RtranRequest;

@XmlRootElement(name = "XMCU1Rtran", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMCU1Rtran", namespace = "http://vistaevolution.va.gov")
public class Rtran {

    @XmlElement(name = "XMCU1RtranRequest", namespace = "")
    private XMCU1RtranRequest xmcu1RtranRequest;

    /**
     * 
     * @return
     *     returns XMCU1RtranRequest
     */
    public XMCU1RtranRequest getXmcu1RtranRequest() {
        return this.xmcu1RtranRequest;
    }

    /**
     * 
     * @param xmcu1RtranRequest
     *     the value for the xmcu1RtranRequest property
     */
    public void setXmcu1RtranRequest(XMCU1RtranRequest xmcu1RtranRequest) {
        this.xmcu1RtranRequest = xmcu1RtranRequest;
    }

}

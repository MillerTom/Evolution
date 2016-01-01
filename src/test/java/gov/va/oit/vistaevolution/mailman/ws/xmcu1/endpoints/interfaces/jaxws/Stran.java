
package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1StranRequest;

@XmlRootElement(name = "XMCU1Stran", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMCU1Stran", namespace = "http://vistaevolution.va.gov")
public class Stran {

    @XmlElement(name = "XMCU1StranRequest", namespace = "")
    private XMCU1StranRequest xmcu1StranRequest;

    /**
     * 
     * @return
     *     returns XMCU1StranRequest
     */
    public XMCU1StranRequest getXmcu1StranRequest() {
        return this.xmcu1StranRequest;
    }

    /**
     * 
     * @param xmcu1StranRequest
     *     the value for the xmcu1StranRequest property
     */
    public void setXmcu1StranRequest(XMCU1StranRequest xmcu1StranRequest) {
        this.xmcu1StranRequest = xmcu1StranRequest;
    }

}

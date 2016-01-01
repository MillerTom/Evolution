
package gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaRequest;

@XmlRootElement(name = "XMA2REnta", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA2REnta", namespace = "http://vistaevolution.va.gov")
public class Enta {

    @XmlElement(name = "XMA2REntaRequest", namespace = "")
    private XMA2REntaRequest xma2REntaRequest;

    /**
     * 
     * @return
     *     returns XMA2REntaRequest
     */
    public XMA2REntaRequest getXma2REntaRequest() {
        return this.xma2REntaRequest;
    }

    /**
     * 
     * @param xma2REntaRequest
     *     the value for the xma2REntaRequest property
     */
    public void setXma2REntaRequest(XMA2REntaRequest xma2REntaRequest) {
        this.xma2REntaRequest = xma2REntaRequest;
    }

}

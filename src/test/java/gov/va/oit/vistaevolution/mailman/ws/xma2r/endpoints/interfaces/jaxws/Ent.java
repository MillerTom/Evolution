
package gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntRequest;

@XmlRootElement(name = "XMA2REnt", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA2REnt", namespace = "http://vistaevolution.va.gov")
public class Ent {

    @XmlElement(name = "XMA2REntRequest", namespace = "")
    private XMA2REntRequest xma2REntRequest;

    /**
     * 
     * @return
     *     returns XMA2REntRequest
     */
    public XMA2REntRequest getXma2REntRequest() {
        return this.xma2REntRequest;
    }

    /**
     * 
     * @param xma2REntRequest
     *     the value for the xma2REntRequest property
     */
    public void setXma2REntRequest(XMA2REntRequest xma2REntRequest) {
        this.xma2REntRequest = xma2REntRequest;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewRequest;

@XmlRootElement(name = "NewXM", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewXM", namespace = "http://vistaevolution.va.gov")
public class Xmnew {

    @XmlElement(name = "XMNewRequest", namespace = "")
    private XMNewRequest xmNewRequest;

    /**
     * 
     * @return
     *     returns XMNewRequest
     */
    public XMNewRequest getXmNewRequest() {
        return this.xmNewRequest;
    }

    /**
     * 
     * @param xmNewRequest
     *     the value for the xmNewRequest property
     */
    public void setXmNewRequest(XMNewRequest xmNewRequest) {
        this.xmNewRequest = xmNewRequest;
    }

}

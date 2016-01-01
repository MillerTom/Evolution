
package gov.va.oit.vistaevolution.mailman.ws.xmb.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbRequest;

@XmlRootElement(name = "Xmb", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Xmb", namespace = "http://vistaevolution.va.gov")
public class Xmb {

    @XmlElement(name = "XmbRequest", namespace = "")
    private XmbRequest xmbRequest;

    /**
     * 
     * @return
     *     returns XmbRequest
     */
    public XmbRequest getXmbRequest() {
        return this.xmbRequest;
    }

    /**
     * 
     * @param xmbRequest
     *     the value for the xmbRequest property
     */
    public void setXmbRequest(XmbRequest xmbRequest) {
        this.xmbRequest = xmbRequest;
    }

}

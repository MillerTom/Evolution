
package gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitRequest;

@XmlRootElement(name = "XUS1AProhibit", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUS1AProhibit", namespace = "http://vistaevolution.va.gov")
public class Prohibit {

    @XmlElement(name = "XUS1AProhibitRequest", namespace = "")
    private XUS1AProhibitRequest xus1AProhibitRequest;

    /**
     * 
     * @return
     *     returns XUS1AProhibitRequest
     */
    public XUS1AProhibitRequest getXus1AProhibitRequest() {
        return this.xus1AProhibitRequest;
    }

    /**
     * 
     * @param xus1AProhibitRequest
     *     the value for the xus1AProhibitRequest property
     */
    public void setXus1AProhibitRequest(XUS1AProhibitRequest xus1AProhibitRequest) {
        this.xus1AProhibitRequest = xus1AProhibitRequest;
    }

}

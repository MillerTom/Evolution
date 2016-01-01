
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiRequest;

@XmlRootElement(name = "XUSNPINpi", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSNPINpi", namespace = "http://vistaevolution.va.gov")
public class Npi {

    @XmlElement(name = "XUSNPINpiRequest", namespace = "")
    private XUSNPINpiRequest xusnpiNpiRequest;

    /**
     * 
     * @return
     *     returns XUSNPINpiRequest
     */
    public XUSNPINpiRequest getXusnpiNpiRequest() {
        return this.xusnpiNpiRequest;
    }

    /**
     * 
     * @param xusnpiNpiRequest
     *     the value for the xusnpiNpiRequest property
     */
    public void setXusnpiNpiRequest(XUSNPINpiRequest xusnpiNpiRequest) {
        this.xusnpiNpiRequest = xusnpiNpiRequest;
    }

}


package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PADDRequest;

@XmlRootElement(name = "XUAF4PADD", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4PADD", namespace = "http://vistaevolution.va.gov")
public class PADD {

    @XmlElement(name = "XUAF4PADDRequest", namespace = "")
    private XUAF4PADDRequest xuaf4PADDRequest;

    /**
     * 
     * @return
     *     returns XUAF4PADDRequest
     */
    public XUAF4PADDRequest getXuaf4PADDRequest() {
        return this.xuaf4PADDRequest;
    }

    /**
     * 
     * @param xuaf4PADDRequest
     *     the value for the xuaf4PADDRequest property
     */
    public void setXuaf4PADDRequest(XUAF4PADDRequest xuaf4PADDRequest) {
        this.xuaf4PADDRequest = xuaf4PADDRequest;
    }

}

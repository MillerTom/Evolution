
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4MADDRequest;

@XmlRootElement(name = "XUAF4MADD", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4MADD", namespace = "http://vistaevolution.va.gov")
public class MADD {

    @XmlElement(name = "XUAF4MADDRequest", namespace = "")
    private XUAF4MADDRequest xuaf4MADDRequest;

    /**
     * 
     * @return
     *     returns XUAF4MADDRequest
     */
    public XUAF4MADDRequest getXuaf4MADDRequest() {
        return this.xuaf4MADDRequest;
    }

    /**
     * 
     * @param xuaf4MADDRequest
     *     the value for the xuaf4MADDRequest property
     */
    public void setXuaf4MADDRequest(XUAF4MADDRequest xuaf4MADDRequest) {
        this.xuaf4MADDRequest = xuaf4MADDRequest;
    }

}

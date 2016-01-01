
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BNSTARequest;

@XmlRootElement(name = "BNSTAXUAF4", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BNSTAXUAF4", namespace = "http://vistaevolution.va.gov")
public class BNSTA {

    @XmlElement(name = "XUAF4BNSTARequest", namespace = "")
    private XUAF4BNSTARequest xuaf4BNSTARequest;

    /**
     * 
     * @return
     *     returns XUAF4BNSTARequest
     */
    public XUAF4BNSTARequest getXuaf4BNSTARequest() {
        return this.xuaf4BNSTARequest;
    }

    /**
     * 
     * @param xuaf4BNSTARequest
     *     the value for the xuaf4BNSTARequest property
     */
    public void setXuaf4BNSTARequest(XUAF4BNSTARequest xuaf4BNSTARequest) {
        this.xuaf4BNSTARequest = xuaf4BNSTARequest;
    }

}

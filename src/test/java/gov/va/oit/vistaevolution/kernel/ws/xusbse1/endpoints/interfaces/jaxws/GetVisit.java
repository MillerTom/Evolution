
package gov.va.oit.vistaevolution.kernel.ws.xusbse1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusbse1.model.XUSBSE1GetVisitRequest;

@XmlRootElement(name = "XUSBSE1GetVisit", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSBSE1GetVisit", namespace = "http://vistaevolution.va.gov")
public class GetVisit {

    @XmlElement(name = "XUSBSE1GetVisitRequest", namespace = "")
    private XUSBSE1GetVisitRequest xusbse1GetVisitRequest;

    /**
     * 
     * @return
     *     returns XUSBSE1GetVisitRequest
     */
    public XUSBSE1GetVisitRequest getXusbse1GetVisitRequest() {
        return this.xusbse1GetVisitRequest;
    }

    /**
     * 
     * @param xusbse1GetVisitRequest
     *     the value for the xusbse1GetVisitRequest property
     */
    public void setXusbse1GetVisitRequest(XUSBSE1GetVisitRequest xusbse1GetVisitRequest) {
        this.xusbse1GetVisitRequest = xusbse1GetVisitRequest;
    }

}

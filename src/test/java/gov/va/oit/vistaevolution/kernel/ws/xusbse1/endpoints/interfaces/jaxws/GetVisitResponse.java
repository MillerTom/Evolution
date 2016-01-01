
package gov.va.oit.vistaevolution.kernel.ws.xusbse1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusbse1.model.XUSBSE1GetVisitResponse;

@XmlRootElement(name = "XUSBSE1GetVisitResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSBSE1GetVisitResponse", namespace = "http://vistaevolution.va.gov")
public class GetVisitResponse {

    @XmlElement(name = "return", namespace = "")
    private XUSBSE1GetVisitResponse _return;

    /**
     * 
     * @return
     *     returns XUSBSE1GetVisitResponse
     */
    public XUSBSE1GetVisitResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XUSBSE1GetVisitResponse _return) {
        this._return = _return;
    }

}

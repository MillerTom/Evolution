
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAlertDatResponse;

@XmlRootElement(name = "XQALBUTLAlertDatResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XQALBUTLAlertDatResponse", namespace = "http://vistaevolution.va.gov")
public class AlertDatResponse {

    @XmlElement(name = "return", namespace = "")
    private XQALBUTLAlertDatResponse _return;

    /**
     * 
     * @return
     *     returns XQALBUTLAlertDatResponse
     */
    public XQALBUTLAlertDatResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XQALBUTLAlertDatResponse _return) {
        this._return = _return;
    }

}

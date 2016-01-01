
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAlertDatRequest;

@XmlRootElement(name = "XQALBUTLAlertDat", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XQALBUTLAlertDat", namespace = "http://vistaevolution.va.gov")
public class AlertDat {

    @XmlElement(name = "XQALBUTLAlertDatRequest", namespace = "")
    private XQALBUTLAlertDatRequest xqalbutlAlertDatRequest;

    /**
     * 
     * @return
     *     returns XQALBUTLAlertDatRequest
     */
    public XQALBUTLAlertDatRequest getXqalbutlAlertDatRequest() {
        return this.xqalbutlAlertDatRequest;
    }

    /**
     * 
     * @param xqalbutlAlertDatRequest
     *     the value for the xqalbutlAlertDatRequest property
     */
    public void setXqalbutlAlertDatRequest(XQALBUTLAlertDatRequest xqalbutlAlertDatRequest) {
        this.xqalbutlAlertDatRequest = xqalbutlAlertDatRequest;
    }

}

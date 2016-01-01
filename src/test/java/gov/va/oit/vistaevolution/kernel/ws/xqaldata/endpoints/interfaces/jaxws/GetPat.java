
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetPatRequest;

@XmlRootElement(name = "XQALDATAGetPat", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XQALDATAGetPat", namespace = "http://vistaevolution.va.gov")
public class GetPat {

    @XmlElement(name = "XQALDATAGetPatRequest", namespace = "")
    private XQALDATAGetPatRequest xqaldataGetPatRequest;

    /**
     * 
     * @return
     *     returns XQALDATAGetPatRequest
     */
    public XQALDATAGetPatRequest getXqaldataGetPatRequest() {
        return this.xqaldataGetPatRequest;
    }

    /**
     * 
     * @param xqaldataGetPatRequest
     *     the value for the xqaldataGetPatRequest property
     */
    public void setXqaldataGetPatRequest(XQALDATAGetPatRequest xqaldataGetPatRequest) {
        this.xqaldataGetPatRequest = xqaldataGetPatRequest;
    }

}

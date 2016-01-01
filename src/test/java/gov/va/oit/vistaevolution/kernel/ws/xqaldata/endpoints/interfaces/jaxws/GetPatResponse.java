
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetPatResponse;

@XmlRootElement(name = "XQALDATAGetPatResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XQALDATAGetPatResponse", namespace = "http://vistaevolution.va.gov")
public class GetPatResponse {

    @XmlElement(name = "return", namespace = "")
    private XQALDATAGetPatResponse _return;

    /**
     * 
     * @return
     *     returns XQALDATAGetPatResponse
     */
    public XQALDATAGetPatResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XQALDATAGetPatResponse _return) {
        this._return = _return;
    }

}

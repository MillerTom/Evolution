
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetUser1Response;

@XmlRootElement(name = "XQALDATAGetUser1Response", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XQALDATAGetUser1Response", namespace = "http://vistaevolution.va.gov")
public class GetUser1Response {

    @XmlElement(name = "return", namespace = "")
    private XQALDATAGetUser1Response _return;

    /**
     * 
     * @return
     *     returns XQALDATAGetUser1Response
     */
    public XQALDATAGetUser1Response getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XQALDATAGetUser1Response _return) {
        this._return = _return;
    }

}

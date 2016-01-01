
package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSOptlkResponse;

@XmlRootElement(name = "XQCSOptlkResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XQCSOptlkResponse", namespace = "http://vistaevolution.va.gov")
public class OptlkResponse {

    @XmlElement(name = "return", namespace = "")
    private XQCSOptlkResponse _return;

    /**
     * 
     * @return
     *     returns XQCSOptlkResponse
     */
    public XQCSOptlkResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XQCSOptlkResponse _return) {
        this._return = _return;
    }

}


package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSChkResponse;

@XmlRootElement(name = "XQCSChkResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XQCSChkResponse", namespace = "http://vistaevolution.va.gov")
public class ChkResponse {

    @XmlElement(name = "return", namespace = "")
    private XQCSChkResponse _return;

    /**
     * 
     * @return
     *     returns XQCSChkResponse
     */
    public XQCSChkResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XQCSChkResponse _return) {
        this._return = _return;
    }

}

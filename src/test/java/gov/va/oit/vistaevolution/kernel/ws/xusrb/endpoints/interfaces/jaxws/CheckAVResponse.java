
package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBCheckAVResponse;

@XmlRootElement(name = "CheckAVXUSRBResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckAVXUSRBResponse", namespace = "http://vistaevolution.va.gov")
public class CheckAVResponse {

    @XmlElement(name = "return", namespace = "")
    private XUSRBCheckAVResponse _return;

    /**
     * 
     * @return
     *     returns XUSRBCheckAVResponse
     */
    public XUSRBCheckAVResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XUSRBCheckAVResponse _return) {
        this._return = _return;
    }

}

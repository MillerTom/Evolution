
package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVResponse;

@XmlRootElement(name = "XUSRBValidAVResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSRBValidAVResponse", namespace = "http://vistaevolution.va.gov")
public class ValidAVResponse {

    @XmlElement(name = "return", namespace = "")
    private XUSRBValidAVResponse _return;

    /**
     * 
     * @return
     *     returns XUSRBValidAVResponse
     */
    public XUSRBValidAVResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XUSRBValidAVResponse _return) {
        this._return = _return;
    }

}


package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoResponse;

@XmlRootElement(name = "XUSRB2UserinfoResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSRB2UserinfoResponse", namespace = "http://vistaevolution.va.gov")
public class UserinfoResponse {

    @XmlElement(name = "return", namespace = "")
    private XUSRB2UserinfoResponse _return;

    /**
     * 
     * @return
     *     returns XUSRB2UserinfoResponse
     */
    public XUSRB2UserinfoResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XUSRB2UserinfoResponse _return) {
        this._return = _return;
    }

}

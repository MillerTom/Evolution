
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivResponse;

@XmlRootElement(name = "XMXSEC1SsPrivResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXSEC1SsPrivResponse", namespace = "http://vistaevolution.va.gov")
public class SsprivResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXSEC1SsPrivResponse _return;

    /**
     * 
     * @return
     *     returns XMXSEC1SsPrivResponse
     */
    public XMXSEC1SsPrivResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXSEC1SsPrivResponse _return) {
        this._return = _return;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1RtranResponse;

@XmlRootElement(name = "XMCU1RtranResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMCU1RtranResponse", namespace = "http://vistaevolution.va.gov")
public class RtranResponse {

    @XmlElement(name = "return", namespace = "")
    private XMCU1RtranResponse _return;

    /**
     * 
     * @return
     *     returns XMCU1RtranResponse
     */
    public XMCU1RtranResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMCU1RtranResponse _return) {
        this._return = _return;
    }

}

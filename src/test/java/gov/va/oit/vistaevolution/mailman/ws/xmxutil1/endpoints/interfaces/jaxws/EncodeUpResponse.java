
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupResponse;

@XmlRootElement(name = "XMXUTIL1EncodeupResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL1EncodeupResponse", namespace = "http://vistaevolution.va.gov")
public class EncodeUpResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTIL1EncodeupResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTIL1EncodeupResponse
     */
    public XMXUTIL1EncodeupResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTIL1EncodeupResponse _return) {
        this._return = _return;
    }

}

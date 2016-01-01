
package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1DecodeupResponse;

@XmlRootElement(name = "XMCU1DecodeupResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMCU1DecodeupResponse", namespace = "http://vistaevolution.va.gov")
public class DecodeupResponse {

    @XmlElement(name = "return", namespace = "")
    private XMCU1DecodeupResponse _return;

    /**
     * 
     * @return
     *     returns XMCU1DecodeupResponse
     */
    public XMCU1DecodeupResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMCU1DecodeupResponse _return) {
        this._return = _return;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewResponse;

@XmlRootElement(name = "XMXUTIL2NewResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL2NewResponse", namespace = "http://vistaevolution.va.gov")
public class Xmxutil2NewResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTIL2NewResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTIL2NewResponse
     */
    public XMXUTIL2NewResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTIL2NewResponse _return) {
        this._return = _return;
    }

}

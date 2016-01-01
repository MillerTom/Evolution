
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgResponse;

@XmlRootElement(name = "XMXUTIL2InmsgResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL2InmsgResponse", namespace = "http://vistaevolution.va.gov")
public class InmsgResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTIL2InmsgResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTIL2InmsgResponse
     */
    public XMXUTIL2InmsgResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTIL2InmsgResponse _return) {
        this._return = _return;
    }

}

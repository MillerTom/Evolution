
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgResponse;

@XmlRootElement(name = "XMXAPIMovemsgResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIMovemsgResponse", namespace = "http://vistaevolution.va.gov")
public class MovemsgResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIMovemsgResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIMovemsgResponse
     */
    public XMXAPIMovemsgResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIMovemsgResponse _return) {
        this._return = _return;
    }

}

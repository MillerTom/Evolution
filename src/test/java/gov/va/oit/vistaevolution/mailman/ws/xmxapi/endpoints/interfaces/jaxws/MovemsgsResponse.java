
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgsResponse;

@XmlRootElement(name = "XMXAPIMovemsgsResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIMovemsgsResponse", namespace = "http://vistaevolution.va.gov")
public class MovemsgsResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIMovemsgsResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIMovemsgsResponse
     */
    public XMXAPIMovemsgsResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIMovemsgsResponse _return) {
        this._return = _return;
    }

}

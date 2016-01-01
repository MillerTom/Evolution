
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1INDTResponse;

@XmlRootElement(name = "XMXUtil1INDTResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUtil1INDTResponse", namespace = "http://vistaevolution.va.gov")
public class IndtResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUtil1INDTResponse _return;

    /**
     * 
     * @return
     *     returns XMXUtil1INDTResponse
     */
    public XMXUtil1INDTResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUtil1INDTResponse _return) {
        this._return = _return;
    }

}

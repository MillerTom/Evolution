
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;

@XmlRootElement(name = "AddrNSndXMXAPIResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddrNSndXMXAPIResponse", namespace = "http://vistaevolution.va.gov")
public class AddrNSndResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIAddrNSndResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIAddrNSndResponse
     */
    public XMXAPIAddrNSndResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIAddrNSndResponse _return) {
        this._return = _return;
    }

}

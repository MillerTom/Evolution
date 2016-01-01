
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgResponse;

@XmlRootElement(name = "XMXAPIFiltrMsgResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIFiltrMsgResponse", namespace = "http://vistaevolution.va.gov")
public class FiltrMsgResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIFiltrMsgResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIFiltrMsgResponse
     */
    public XMXAPIFiltrMsgResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIFiltrMsgResponse _return) {
        this._return = _return;
    }

}

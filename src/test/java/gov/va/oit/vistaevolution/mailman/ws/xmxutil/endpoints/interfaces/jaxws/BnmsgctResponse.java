
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBnmsgctResponse;

@XmlRootElement(name = "XMXUTILBnmsgctResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILBnmsgctResponse", namespace = "http://vistaevolution.va.gov")
public class BnmsgctResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTILBnmsgctResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTILBnmsgctResponse
     */
    public XMXUTILBnmsgctResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTILBnmsgctResponse _return) {
        this._return = _return;
    }

}

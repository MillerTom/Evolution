
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporResponse;

@XmlRootElement(name = "XMXUTILKvaporResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILKvaporResponse", namespace = "http://vistaevolution.va.gov")
public class KvaporResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTILKvaporResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTILKvaporResponse
     */
    public XMXUTILKvaporResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTILKvaporResponse _return) {
        this._return = _return;
    }

}

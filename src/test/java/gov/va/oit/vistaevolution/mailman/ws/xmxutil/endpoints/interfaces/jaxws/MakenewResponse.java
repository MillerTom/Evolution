
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILMakenewResponse;

@XmlRootElement(name = "XMXUTILMakenewResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILMakenewResponse", namespace = "http://vistaevolution.va.gov")
public class MakenewResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTILMakenewResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTILMakenewResponse
     */
    public XMXUTILMakenewResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTILMakenewResponse _return) {
        this._return = _return;
    }

}

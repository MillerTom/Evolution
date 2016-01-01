
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewResponse;

@XmlRootElement(name = "NewXMResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewXMResponse", namespace = "http://vistaevolution.va.gov")
public class XmnewResponse {

    @XmlElement(name = "return", namespace = "")
    private XMNewResponse _return;

    /**
     * 
     * @return
     *     returns XMNewResponse
     */
    public XMNewResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMNewResponse _return) {
        this._return = _return;
    }

}

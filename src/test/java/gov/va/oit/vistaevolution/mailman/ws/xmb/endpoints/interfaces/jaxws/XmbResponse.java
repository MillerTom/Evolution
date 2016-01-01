
package gov.va.oit.vistaevolution.mailman.ws.xmb.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "XmbResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmbResponse", namespace = "http://vistaevolution.va.gov")
public class XmbResponse {

    @XmlElement(name = "return", namespace = "")
    private gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbResponse _return;

    /**
     * 
     * @return
     *     returns XmbResponse
     */
    public gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbResponse _return) {
        this._return = _return;
    }

}

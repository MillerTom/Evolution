
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Response;

@XmlRootElement(name = "N1XMResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "N1XMResponse", namespace = "http://vistaevolution.va.gov")
public class N1Response {

    @XmlElement(name = "return", namespace = "")
    private XMN1Response _return;

    /**
     * 
     * @return
     *     returns XMN1Response
     */
    public XMN1Response getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMN1Response _return) {
        this._return = _return;
    }

}

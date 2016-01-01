
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVSubjResponse;

@XmlRootElement(name = "XMXAPIVSubjResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIVSubjResponse", namespace = "http://vistaevolution.va.gov")
public class VsubjResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIVSubjResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIVSubjResponse
     */
    public XMXAPIVSubjResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIVSubjResponse _return) {
        this._return = _return;
    }

}

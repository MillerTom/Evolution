
package gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetResponse;

@XmlRootElement(name = "XMRENTNetResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMRENTNetResponse", namespace = "http://vistaevolution.va.gov")
public class XmrentNetResponse {

    @XmlElement(name = "return", namespace = "")
    private XMRENTNetResponse _return;

    /**
     * 
     * @return
     *     returns XMRENTNetResponse
     */
    public XMRENTNetResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMRENTNetResponse _return) {
        this._return = _return;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;

@XmlRootElement(name = "XMDResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMDResponse", namespace = "http://vistaevolution.va.gov")
public class XmdResponse {

    @XmlElement(name = "return", namespace = "")
    private XMDResponse _return;

    /**
     * 
     * @return
     *     returns XMDResponse
     */
    public XMDResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMDResponse _return) {
        this._return = _return;
    }

}

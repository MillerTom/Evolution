
package gov.va.oit.vistaevolution.kernel.ws.xuser.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Response;

@XmlRootElement(name = "XUSERDiv4Response", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUSERDiv4Response", namespace = "http://vistaevolution.va.gov")
public class Div4Response {

    @XmlElement(name = "return", namespace = "")
    private XUSERDiv4Response _return;

    /**
     * 
     * @return
     *     returns XUSERDiv4Response
     */
    public XUSERDiv4Response getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XUSERDiv4Response _return) {
        this._return = _return;
    }

}

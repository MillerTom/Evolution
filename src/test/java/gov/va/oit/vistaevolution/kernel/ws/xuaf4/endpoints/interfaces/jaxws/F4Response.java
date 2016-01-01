
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4F4Response;

@XmlRootElement(name = "F4XUAF4Response", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "F4XUAF4Response", namespace = "http://vistaevolution.va.gov")
public class F4Response {

    @XmlElement(name = "return", namespace = "")
    private XUAF4F4Response _return;

    /**
     * 
     * @return
     *     returns XUAF4F4Response
     */
    public XUAF4F4Response getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XUAF4F4Response _return) {
        this._return = _return;
    }

}

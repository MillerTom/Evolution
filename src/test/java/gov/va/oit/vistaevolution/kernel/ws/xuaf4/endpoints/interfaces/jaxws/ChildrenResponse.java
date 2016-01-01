
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ChildrenResponse;

@XmlRootElement(name = "XUAF4ChildrenResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4ChildrenResponse", namespace = "http://vistaevolution.va.gov")
public class ChildrenResponse {

    @XmlElement(name = "return", namespace = "")
    private XUAF4ChildrenResponse _return;

    /**
     * 
     * @return
     *     returns XUAF4ChildrenResponse
     */
    public XUAF4ChildrenResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XUAF4ChildrenResponse _return) {
        this._return = _return;
    }

}

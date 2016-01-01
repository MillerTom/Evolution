
package gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitResponse;

@XmlRootElement(name = "XUS1AProhibitResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUS1AProhibitResponse", namespace = "http://vistaevolution.va.gov")
public class ProhibitResponse {

    @XmlElement(name = "return", namespace = "")
    private XUS1AProhibitResponse _return;

    /**
     * 
     * @return
     *     returns XUS1AProhibitResponse
     */
    public XUS1AProhibitResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XUS1AProhibitResponse _return) {
        this._return = _return;
    }

}

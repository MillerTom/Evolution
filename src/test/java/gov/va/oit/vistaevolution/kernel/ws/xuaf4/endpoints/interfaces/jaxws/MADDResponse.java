
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4MADDResponse;

@XmlRootElement(name = "XUAF4MADDResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XUAF4MADDResponse", namespace = "http://vistaevolution.va.gov")
public class MADDResponse {

    @XmlElement(name = "return", namespace = "")
    private XUAF4MADDResponse _return;

    /**
     * 
     * @return
     *     returns XUAF4MADDResponse
     */
    public XUAF4MADDResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XUAF4MADDResponse _return) {
        this._return = _return;
    }

}

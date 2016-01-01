
package gov.va.oit.vistaevolution.kernel.ws.xlfdt3.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapResponse;

@XmlRootElement(name = "XLFDT3LeapResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XLFDT3LeapResponse", namespace = "http://vistaevolution.va.gov")
public class LeapResponse {

    @XmlElement(name = "return", namespace = "")
    private XLFDT3LeapResponse _return;

    /**
     * 
     * @return
     *     returns XLFDT3LeapResponse
     */
    public XLFDT3LeapResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XLFDT3LeapResponse _return) {
        this._return = _return;
    }

}

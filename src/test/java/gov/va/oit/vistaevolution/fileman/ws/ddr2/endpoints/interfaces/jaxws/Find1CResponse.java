
package gov.va.oit.vistaevolution.fileman.ws.ddr2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CResponse;

@XmlRootElement(name = "DDR2Find1CResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DDR2Find1CResponse", namespace = "http://vistaevolution.va.gov")
public class Find1CResponse {

    @XmlElement(name = "return", namespace = "")
    private DDR2Find1CResponse _return;

    /**
     * 
     * @return
     *     returns DDR2Find1CResponse
     */
    public DDR2Find1CResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DDR2Find1CResponse _return) {
        this._return = _return;
    }

}

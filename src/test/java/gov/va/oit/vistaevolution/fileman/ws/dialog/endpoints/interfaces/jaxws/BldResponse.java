
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldResponse;

@XmlRootElement(name = "DIALOGBldResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DIALOGBldResponse", namespace = "http://vistaevolution.va.gov")
public class BldResponse {

    @XmlElement(name = "return", namespace = "")
    private DIALOGBldResponse _return;

    /**
     * 
     * @return
     *     returns DIALOGBldResponse
     */
    public DIALOGBldResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DIALOGBldResponse _return) {
        this._return = _return;
    }

}

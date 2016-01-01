
package gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbResponse;

@XmlRootElement(name = "XMA1CSetsbResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA1CSetsbResponse", namespace = "http://vistaevolution.va.gov")
public class SetsbResponse {

    @XmlElement(name = "return", namespace = "")
    private XMA1CSetsbResponse _return;

    /**
     * 
     * @return
     *     returns XMA1CSetsbResponse
     */
    public XMA1CSetsbResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMA1CSetsbResponse _return) {
        this._return = _return;
    }

}

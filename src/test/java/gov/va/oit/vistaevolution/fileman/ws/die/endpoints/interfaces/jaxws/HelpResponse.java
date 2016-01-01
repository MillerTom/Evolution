
package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEHelpResponse;

@XmlRootElement(name = "helpResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "helpResponse", namespace = "http://vistaevolution.va.gov")
public class HelpResponse {

    @XmlElement(name = "return", namespace = "")
    private DIEHelpResponse _return;

    /**
     * 
     * @return
     *     returns DIEHelpResponse
     */
    public DIEHelpResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DIEHelpResponse _return) {
        this._return = _return;
    }

}

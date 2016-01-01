
package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEKeyValResponse;

@XmlRootElement(name = "DIEKeyValResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DIEKeyValResponse", namespace = "http://vistaevolution.va.gov")
public class KeyValResponse {

    @XmlElement(name = "return", namespace = "")
    private DIEKeyValResponse _return;

    /**
     * 
     * @return
     *     returns DIEKeyValResponse
     */
    public DIEKeyValResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DIEKeyValResponse _return) {
        this._return = _return;
    }

}

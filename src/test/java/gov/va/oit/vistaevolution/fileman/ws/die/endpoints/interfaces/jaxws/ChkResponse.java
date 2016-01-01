
package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEChkResponse;

@XmlRootElement(name = "chkResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chkResponse", namespace = "http://vistaevolution.va.gov")
public class ChkResponse {

    @XmlElement(name = "return", namespace = "")
    private DIEChkResponse _return;

    /**
     * 
     * @return
     *     returns DIEChkResponse
     */
    public DIEChkResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(DIEChkResponse _return) {
        this._return = _return;
    }

}

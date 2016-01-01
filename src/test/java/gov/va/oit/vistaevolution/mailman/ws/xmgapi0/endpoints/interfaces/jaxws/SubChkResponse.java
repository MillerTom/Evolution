
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkResponse;

@XmlRootElement(name = "XMGAPI0SubChkResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMGAPI0SubChkResponse", namespace = "http://vistaevolution.va.gov")
public class SubChkResponse {

    @XmlElement(name = "return", namespace = "")
    private XMGAPI0SubChkResponse _return;

    /**
     * 
     * @return
     *     returns XMGAPI0SubChkResponse
     */
    public XMGAPI0SubChkResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMGAPI0SubChkResponse _return) {
        this._return = _return;
    }

}

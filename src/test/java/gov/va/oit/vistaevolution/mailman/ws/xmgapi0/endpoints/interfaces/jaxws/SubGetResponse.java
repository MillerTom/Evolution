
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubGetResponse;

@XmlRootElement(name = "XMGAPI0SubGetResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMGAPI0SubGetResponse", namespace = "http://vistaevolution.va.gov")
public class SubGetResponse {

    @XmlElement(name = "return", namespace = "")
    private XMGAPI0SubGetResponse _return;

    /**
     * 
     * @return
     *     returns XMGAPI0SubGetResponse
     */
    public XMGAPI0SubGetResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMGAPI0SubGetResponse _return) {
        this._return = _return;
    }

}

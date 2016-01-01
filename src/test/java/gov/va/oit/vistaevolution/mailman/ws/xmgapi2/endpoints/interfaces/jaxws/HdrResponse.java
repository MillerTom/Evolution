
package gov.va.oit.vistaevolution.mailman.ws.xmgapi2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.model.XMGAPI2HdrResponse;

@XmlRootElement(name = "XMGAPI2HdrResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMGAPI2HdrResponse", namespace = "http://vistaevolution.va.gov")
public class HdrResponse {

    @XmlElement(name = "return", namespace = "")
    private XMGAPI2HdrResponse _return;

    /**
     * 
     * @return
     *     returns XMGAPI2HdrResponse
     */
    public XMGAPI2HdrResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMGAPI2HdrResponse _return) {
        this._return = _return;
    }

}

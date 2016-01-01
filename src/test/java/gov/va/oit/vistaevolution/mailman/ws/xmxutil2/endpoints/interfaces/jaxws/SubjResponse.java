
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjResponse;

@XmlRootElement(name = "XMXUTIL2SubjResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL2SubjResponse", namespace = "http://vistaevolution.va.gov")
public class SubjResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTIL2SubjResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTIL2SubjResponse
     */
    public XMXUTIL2SubjResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTIL2SubjResponse _return) {
        this._return = _return;
    }

}

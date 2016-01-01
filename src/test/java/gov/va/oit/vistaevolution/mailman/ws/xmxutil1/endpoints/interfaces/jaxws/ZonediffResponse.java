
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ZonediffResponse;

@XmlRootElement(name = "XMXUTIL1ZonediffResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTIL1ZonediffResponse", namespace = "http://vistaevolution.va.gov")
public class ZonediffResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTIL1ZonediffResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTIL1ZonediffResponse
     */
    public XMXUTIL1ZonediffResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTIL1ZonediffResponse _return) {
        this._return = _return;
    }

}

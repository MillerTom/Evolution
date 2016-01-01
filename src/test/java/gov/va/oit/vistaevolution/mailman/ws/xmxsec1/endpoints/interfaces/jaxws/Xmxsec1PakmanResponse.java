
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanResponse;

@XmlRootElement(name = "XMXSEC1PakmanResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXSEC1PakmanResponse", namespace = "http://vistaevolution.va.gov")
public class Xmxsec1PakmanResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXSEC1PakmanResponse _return;

    /**
     * 
     * @return
     *     returns XMXSEC1PakmanResponse
     */
    public XMXSEC1PakmanResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXSEC1PakmanResponse _return) {
        this._return = _return;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1StatusResponse;

@XmlRootElement(name = "XMS1StatusResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMS1StatusResponse", namespace = "http://vistaevolution.va.gov")
public class StatusResponse {

    @XmlElement(name = "return", namespace = "")
    private XMS1StatusResponse _return;

    /**
     * 
     * @return
     *     returns XMS1StatusResponse
     */
    public XMS1StatusResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMS1StatusResponse _return) {
        this._return = _return;
    }

}

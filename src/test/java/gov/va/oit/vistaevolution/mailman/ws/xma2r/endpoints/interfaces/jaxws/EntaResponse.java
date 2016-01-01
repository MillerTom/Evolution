
package gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaResponse;

@XmlRootElement(name = "XMA2REntaResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA2REntaResponse", namespace = "http://vistaevolution.va.gov")
public class EntaResponse {

    @XmlElement(name = "return", namespace = "")
    private XMA2REntaResponse _return;

    /**
     * 
     * @return
     *     returns XMA2REntaResponse
     */
    public XMA2REntaResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMA2REntaResponse _return) {
        this._return = _return;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoResponse;

@XmlRootElement(name = "XMA21WhoResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA21WhoResponse", namespace = "http://vistaevolution.va.gov")
public class WhoResponse {

    @XmlElement(name = "return", namespace = "")
    private XMA21WhoResponse _return;

    /**
     * 
     * @return
     *     returns XMA21WhoResponse
     */
    public XMA21WhoResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMA21WhoResponse _return) {
        this._return = _return;
    }

}

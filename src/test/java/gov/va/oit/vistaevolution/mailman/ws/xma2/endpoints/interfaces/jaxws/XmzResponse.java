
package gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzResponse;

@XmlRootElement(name = "XMA2XmzResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMA2XmzResponse", namespace = "http://vistaevolution.va.gov")
public class XmzResponse {

    @XmlElement(name = "return", namespace = "")
    private XMA2XmzResponse _return;

    /**
     * 
     * @return
     *     returns XMA2XmzResponse
     */
    public XMA2XmzResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMA2XmzResponse _return) {
        this._return = _return;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8MBoxResponse;

@XmlRootElement(name = "XMXAPIBCre8MBoxResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIBCre8MBoxResponse", namespace = "http://vistaevolution.va.gov")
public class Cr8MBoxResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIBCre8MBoxResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIBCre8MBoxResponse
     */
    public XMXAPIBCre8MBoxResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIBCre8MBoxResponse _return) {
        this._return = _return;
    }

}


package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQMBoxResponse;

@XmlRootElement(name = "XMXAPIBQMBoxResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPIBQMBoxResponse", namespace = "http://vistaevolution.va.gov")
public class QMBoxResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPIBQMBoxResponse _return;

    /**
     * 
     * @return
     *     returns XMXAPIBQMBoxResponse
     */
    public XMXAPIBQMBoxResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXAPIBQMBoxResponse _return) {
        this._return = _return;
    }

}

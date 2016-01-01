
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNewsResponse;

@XmlRootElement(name = "XMXUTILNewsResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUTILNewsResponse", namespace = "http://vistaevolution.va.gov")
public class NewsResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXUTILNewsResponse _return;

    /**
     * 
     * @return
     *     returns XMXUTILNewsResponse
     */
    public XMXUTILNewsResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXUTILNewsResponse _return) {
        this._return = _return;
    }

}

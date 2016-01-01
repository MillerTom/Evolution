
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextResponse;

@XmlRootElement(name = "XMXEDITTextResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXEDITTextResponse", namespace = "http://vistaevolution.va.gov")
public class TextResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXEDITTextResponse _return;

    /**
     * 
     * @return
     *     returns XMXEDITTextResponse
     */
    public XMXEDITTextResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(XMXEDITTextResponse _return) {
        this._return = _return;
    }

}

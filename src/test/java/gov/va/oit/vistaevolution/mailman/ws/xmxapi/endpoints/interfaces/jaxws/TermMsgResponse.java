package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITermMsgResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "XMXAPITermMsgResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPITermMsgResponse", namespace = "http://vistaevolution.va.gov")
public class TermMsgResponse {

    @XmlElement(name = "return", namespace = "")
    private XMXAPITermMsgResponse _return;

    /**
     * 
     * @return returns XMXAPITermMsgResponse
     */
    public XMXAPITermMsgResponse getReturn() {
	return this._return;
    }

    /**
     * 
     * @param _return
     *            the value for the _return property
     */
    public void setReturn(XMXAPITermMsgResponse _return) {
	this._return = _return;
    }

}

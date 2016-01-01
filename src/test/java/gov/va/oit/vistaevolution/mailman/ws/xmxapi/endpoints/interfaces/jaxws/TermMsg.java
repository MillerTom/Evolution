package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.jaxws;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITermMsgRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "XMXAPITermMsg", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXAPITermMsg", namespace = "http://vistaevolution.va.gov")
public class TermMsg {

    @XmlElement(name = "XMXAPITermMsgRequest", namespace = "")
    private XMXAPITermMsgRequest xmxapiTermMsgRequest;

    /**
     * 
     * @return returns XMXAPITermMsgRequest
     */
    public XMXAPITermMsgRequest getXmxapiTermMsgRequest() {
	return this.xmxapiTermMsgRequest;
    }

    /**
     * 
     * @param xmxapiTermMsgRequest
     *            the value for the xmxapiTermMsgRequest property
     */
    public void setXmxapiTermMsgRequest(
	    XMXAPITermMsgRequest xmxapiTermMsgRequest) {
	this.xmxapiTermMsgRequest = xmxapiTermMsgRequest;
    }

}

package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZNodeResponse;
import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ZNodeResponse extends AbstractVistaResponse {
	
	@XmlElement(name = "return", namespace = "")
    private XMXUtil2ZNodeResponse _return;

	public XMXUtil2ZNodeResponse getReturn() {
		return _return;
	}

	public void setReturn(XMXUtil2ZNodeResponse _return) {
		this._return = _return;
	}


}

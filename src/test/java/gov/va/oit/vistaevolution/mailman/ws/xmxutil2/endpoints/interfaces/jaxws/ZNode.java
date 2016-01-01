package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.jaxws;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZNodeRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "XMXUtil2ZNODE", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMXUtil2ZNODE", namespace = "http://vistaevolution.va.gov")
public class ZNode {

	@XmlElement(name = "XMXUtil2ZNodeRequest", namespace = "")
    private XMXUtil2ZNodeRequest xmxUtil2ZNodeRequest;

	public XMXUtil2ZNodeRequest getXmxUtil2ZNodeRequest() {
		return xmxUtil2ZNodeRequest;
	}

	public void setXmxUtil2ZNodeRequest(XMXUtil2ZNodeRequest xmxUtil2ZNodeRequest) {
		this.xmxUtil2ZNodeRequest = xmxUtil2ZNodeRequest;
	}

}

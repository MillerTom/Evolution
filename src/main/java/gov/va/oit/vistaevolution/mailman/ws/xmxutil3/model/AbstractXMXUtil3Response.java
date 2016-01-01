package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlElement;

public abstract class AbstractXMXUtil3Response extends AbstractVistaResponse {
    @XmlElement(required = false)
    private String toName;

    @XmlElement(required = false)
    private String type;

    public String getToName() {
	return toName;
    }

    public void setToName(String toName) {
	this.toName = toName;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }
}

package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBCre8MBoxResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String result;

    public XMXAPIBCre8MBoxResponse() {
	super();
    }

    public XMXAPIBCre8MBoxResponse(String status, List<String> errors) {
	super(status, errors);
    }

    public XMXAPIBCre8MBoxResponse(String status, String result) {
	super(status, null);
	this.result = result;
    }

    public String getResult() {
	return result;
    }

    public void setResult(String result) {
	this.result = result;
    }

}

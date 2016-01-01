package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIPrtMsgResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String taskNumber;

    public XMXAPIPrtMsgResponse() {
	super();
    }

    public XMXAPIPrtMsgResponse(String status, String taskNumber) {
	super(status, null);
	this.taskNumber = taskNumber;
    }

    public XMXAPIPrtMsgResponse(String taskNumber) {
	this.taskNumber = taskNumber;
    }

    public XMXAPIPrtMsgResponse(String status, List<String> errors) {
	super(status, errors);
    }

    public String getTaskNumber() {
	return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
	this.taskNumber = taskNumber;
    }

}

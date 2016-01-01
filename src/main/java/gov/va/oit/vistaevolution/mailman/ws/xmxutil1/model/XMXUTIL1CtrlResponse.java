package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1CtrlResponse {

	public XMXUTIL1CtrlResponse() {
		super();
	}

	@XmlElement(required = false)
	private String cleanedVal;

	@XmlElement(required = false)
	private List<String> errMsgs;

	public XMXUTIL1CtrlResponse(String cleanedVal, List<String> errMsgs) {
		super();
		this.cleanedVal = cleanedVal;
		this.errMsgs = errMsgs;
	}

	public String getCleanedVal() {
		return cleanedVal;
	}

	public void setCleanedVal(String cleanedVal) {
		this.cleanedVal = cleanedVal;
	}

	public List<String> getErrMsgs() {
		return errMsgs;
	}

	public void setErrMsgs(List<String> errMsgs) {
		this.errMsgs = errMsgs;
	}

}

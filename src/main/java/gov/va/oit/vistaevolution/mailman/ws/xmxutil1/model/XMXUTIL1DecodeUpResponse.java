package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1DecodeUpResponse {

	@XmlElement(required = false)
	private String decodedValue;
	
	@XmlElement(required = false)
	private List<String> errMsgs;
	
	
	public XMXUTIL1DecodeUpResponse() {
		super();
	}
	
	public XMXUTIL1DecodeUpResponse(String decodedValue) {
		super();
		this.decodedValue = decodedValue;
	}

	

	public XMXUTIL1DecodeUpResponse(String val, List<String> errMsgs) {
		super();
		this.decodedValue = val;
		this.errMsgs = errMsgs;
		
	}

	public String getDecodedValue() {
		return decodedValue;
	}

	public void setDecodedValue(String decodedValue) {
		this.decodedValue = decodedValue;
	}

	public List<String> getErrMsgs() {
		return errMsgs;
	}

	public void setErrMsgs(List<String> errMsgs) {
		this.errMsgs = errMsgs;
	}

}

package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1ConvertResponse {
	// is -1 if error on conversion
	@XmlElement(required = false)
	private String formattedDate;
	
	@XmlElement(required = false)
	private List<String> errMsgs;
	
	
	public XMXUTIL1ConvertResponse() {
		super();
	}


	public XMXUTIL1ConvertResponse(String formattedDate) {
		super();
		this.formattedDate = formattedDate;
	}


	public XMXUTIL1ConvertResponse(String formattedDate, List<String> errMsgs) {
		super();
		this.formattedDate = formattedDate;
		this.errMsgs = errMsgs;
	}


	public String getFormattedDate() {
		return formattedDate;
	}


	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}


	public List<String> getErrMsgs() {
		return errMsgs;
	}


	public void setErrMsgs(List<String> errMsgs) {
		this.errMsgs = errMsgs;
	}
	

}

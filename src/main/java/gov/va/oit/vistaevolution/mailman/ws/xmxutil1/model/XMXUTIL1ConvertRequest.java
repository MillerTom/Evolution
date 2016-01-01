package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1ConvertRequest {

	
	@XmlElement(name = "inetDate", required = true)
	private String inetDate;
	
	// 
	// XMTIME    =1 Convert time, too; =0 convert date only
	@XmlElement(name = "convertTime", required = true)
	private String xmTime;
	
	public XMXUTIL1ConvertRequest() {
		super();
	}
	

	public XMXUTIL1ConvertRequest(String inetDate, String xmtime) {
		super();
		this.inetDate = inetDate;
		this.xmTime = xmtime;
	}


	public String getInetDate() {
		return inetDate;
	}

	public void setInetDate(String inetDate) {
		this.inetDate = inetDate;
	}


	public String getXmTime() {
		return xmTime;
	}


	public void setXmTime(String xmTime) {
		this.xmTime = xmTime;
	}

	

}

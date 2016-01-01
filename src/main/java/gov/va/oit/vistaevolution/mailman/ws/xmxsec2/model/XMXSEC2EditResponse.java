package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.AbstractXMXSECResponse;
import gov.va.oit.vistaevolution.util.StrUtils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC2EditResponse extends AbstractXMXSECResponse {

	public XMXSEC2EditResponse() {
		super();
		this.msgRoot = new ArrayList<String>();
	}

	public XMXSEC2EditResponse(List<String> msgRoot) {
		super(msgRoot);
	
	}
	

	public XMXSEC2EditResponse(String mayEdit, List<String> errMsgs) {
		super(errMsgs);
		this.userMayEdit = mayEdit;
	}


	@XmlElement(name = "userMayEdit", required = true)
	private String userMayEdit;
	@XmlElementWrapper(name = "targetRoot")
	@XmlElement(name = "targetRootElement", required = true)
	private List<String> targetRoot;

	public String getUserMayEdit() { 
		return this.userMayEdit;
	}
	public void setUserMayEdit(String lvUserMayEdit) { 
		this.userMayEdit = lvUserMayEdit;
	}
	public List<String> getTargetRoot() { 
		return this.targetRoot;
	}
	public void setTargetRoot(List<String> lvTargetRoot) { 
		this.targetRoot = lvTargetRoot;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("userMayEdit ==> " + this.userMayEdit + "\n");
		sb.append("targetRoot ==> " + StrUtils.listToString(this.targetRoot) + "\n");
		return sb.toString();
	}

}

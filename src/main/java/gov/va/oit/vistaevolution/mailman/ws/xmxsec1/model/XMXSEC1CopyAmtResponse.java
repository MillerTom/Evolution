package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1CopyAmtResponse extends AbstractXMXSEC1Response {

	
	// returns 1 if ok or 0 if not ok 
	@XmlElement(name = "copyAmountOK", required = false)
	private String copyAmountOK;
	
	@XmlElementWrapper(name = "targetRoot")
	@XmlElement(name = "targetRootElement", required = false)
	private List<String> targetRoot;
	
	
	// constructors
	public XMXSEC1CopyAmtResponse() { 
		super();
	}
	public XMXSEC1CopyAmtResponse(List<String> msgRoot) { 
		super(msgRoot);
	}
	
	public XMXSEC1CopyAmtResponse(String copyAmountOK, List<String> targetRoot) {
		super();
		this.copyAmountOK = copyAmountOK;
		this.targetRoot = targetRoot;
	}

	// getters and setters
	public String getCopyAmountOK() { 
		return this.copyAmountOK;
	}
	public void setCopyAmountOK(String lvCopyAmountOK) { 
		this.copyAmountOK = lvCopyAmountOK;
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
		sb.append("copyAmountOK ==> " + this.copyAmountOK + "\n");
		sb.append("targetRoot ==> " + this.targetRoot + "\n");
		return sb.toString();
	}
}

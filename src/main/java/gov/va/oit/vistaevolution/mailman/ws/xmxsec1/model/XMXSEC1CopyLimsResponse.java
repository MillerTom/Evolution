package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1CopyLimsResponse extends AbstractXMXSEC1Response {

	
	@XmlElement(name = "numRecipeints", required = false)
	private String numRecipeints;
	@XmlElement(name = "numResponses", required = false)
	private String numResponses;
	@XmlElement(name = "numLines", required = false)
	private String numLines;
	
	@XmlElement(name = "errCode", required = false)
	private String errCode;
	
	@XmlElementWrapper(name = "targetRoot")
	@XmlElement(name = "targetRootElement", required = false)
	private List<String> targetRoot;

	// constructors
	public XMXSEC1CopyLimsResponse() {
		super();
	}

	public XMXSEC1CopyLimsResponse(List<String> msgRoot2) {
		super(msgRoot2);
	}

	public XMXSEC1CopyLimsResponse(String numRecipeints, String numResponses,
			String numLines) {
		super();
		this.numRecipeints = numRecipeints;
		this.numResponses = numResponses;
		this.numLines = numLines;
	}

	public XMXSEC1CopyLimsResponse(String errstring, List<String> errMsgs) {
		super(errMsgs);
		this.errCode = errstring;
	}

	public String getNumRecipeints() { 
		return this.numRecipeints;
	}
	public void setNumRecipeints(String lvNumRecipeints) { 
		this.numRecipeints = lvNumRecipeints;
	}
	public String getNumResponses() { 
		return this.numResponses;
	}
	public void setNumResponses(String lvNumResponses) { 
		this.numResponses = lvNumResponses;
	}
	public String getNumLines() { 
		return this.numLines;
	}
	public void setNumLines(String lvNumLines) { 
		this.numLines = lvNumLines;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("numRecipeints ==> " + this.numRecipeints + "\n");
		sb.append("numResponses ==> " + this.numResponses + "\n");
		sb.append("numLines ==> " + this.numLines + "\n");
		sb.append("errCode ==> " + this.errCode + "\n");
		sb.append("targetRoot ==> " + this.targetRoot + "\n");
		return sb.toString();
	}

	public List<String> getTargetRoot() {
		return targetRoot;
	}

	public void setTargetRoot(List<String> targetRoot) {
		this.targetRoot = targetRoot;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

}

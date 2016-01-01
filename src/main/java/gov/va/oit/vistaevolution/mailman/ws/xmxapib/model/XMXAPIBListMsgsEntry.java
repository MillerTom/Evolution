package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXAPIBListMsgsEntry")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBListMsgsEntry { 

	public XMXAPIBListMsgsEntry() { 
		super();
	}

	@XmlElement(name = "basketIen", required = false)
	private String basketIen;
	@XmlElement(name = "basketName", required = false)
	private String basketName;
	@XmlElement(name = "basketCrossRef", required = false)
	private String basketCrossRef;
	@XmlElement(name = "dateSent", required = false)
	private String dateSent;
	@XmlElement(name = "dateSentInternal", required = false)
	private String dateSentInternal;
	@XmlElement(name = "dateSentCrossRef", required = false)
	private String dateSentCrossRef;
	@XmlElement(name = "from", required = false)
	private String from;
	@XmlElement(name = "fromExtCrossRef", required = false)
	private String fromExtCrossRef;
	@XmlElement(name = "numLines", required = false)
	private String numLines;
	@XmlElement(name = "msgIsNew", required = false)
	private String msgIsNew;
	@XmlElement(name = "msgIsPriority", required = false)
	private String msgIsPriority;
	@XmlElement(name = "msgWasRead", required = false)
	private String msgWasRead;
	@XmlElement(name = "numResponses", required = false)
	private String numResponses;
	@XmlElement(name = "seqNum", required = false)
	private String seqNum;
	@XmlElement(name = "subj", required = false)
	private String subj;
	@XmlElement(name = "subjCrossRef", required = false)
	private String subjCrossRef;

	public String getBasketIen() { 
		return this.basketIen;
	}
	public void setBasketIen(String lvBasketIen) { 
		this.basketIen = lvBasketIen;
	}
	public String getBasketName() { 
		return this.basketName;
	}
	public void setBasketName(String lvBasketName) { 
		this.basketName = lvBasketName;
	}
	public String getBasketCrossRef() { 
		return this.basketCrossRef;
	}
	public void setBasketCrossRef(String lvBasketCrossRef) { 
		this.basketCrossRef = lvBasketCrossRef;
	}
	public String getDateSent() { 
		return this.dateSent;
	}
	public void setDateSent(String lvDateSent) { 
		this.dateSent = lvDateSent;
	}
	public String getDateSentInternal() { 
		return this.dateSentInternal;
	}
	public void setDateSentInternal(String lvDateSentInternal) { 
		this.dateSentInternal = lvDateSentInternal;
	}
	public String getDateSentCrossRef() { 
		return this.dateSentCrossRef;
	}
	public void setDateSentCrossRef(String lvDateSentCrossRef) { 
		this.dateSentCrossRef = lvDateSentCrossRef;
	}
	public String getFrom() { 
		return this.from;
	}
	public void setFrom(String lvFrom) { 
		this.from = lvFrom;
	}
	public String getFromExtCrossRef() { 
		return this.fromExtCrossRef;
	}
	public void setFromExtCrossRef(String lvFromExtCrossRef) { 
		this.fromExtCrossRef = lvFromExtCrossRef;
	}
	public String getNumLines() { 
		return this.numLines;
	}
	public void setNumLines(String lvNumLines) { 
		this.numLines = lvNumLines;
	}
	public String getMsgIsNew() { 
		return this.msgIsNew;
	}
	public void setMsgIsNew(String lvMsgIsNew) { 
		this.msgIsNew = lvMsgIsNew;
	}
	public String getMsgIsPriority() { 
		return this.msgIsPriority;
	}
	public void setMsgIsPriority(String lvMsgIsPriority) { 
		this.msgIsPriority = lvMsgIsPriority;
	}
	public String getMsgWasRead() { 
		return this.msgWasRead;
	}
	public void setMsgWasRead(String lvMsgWasRead) { 
		this.msgWasRead = lvMsgWasRead;
	}
	public String getNumResponses() { 
		return this.numResponses;
	}
	public void setNumResponses(String lvNumResponses) { 
		this.numResponses = lvNumResponses;
	}
	public String getSeqNum() { 
		return this.seqNum;
	}
	public void setSeqNum(String lvSeqNum) { 
		this.seqNum = lvSeqNum;
	}
	public String getSubj() { 
		return this.subj;
	}
	public void setSubj(String lvSubj) { 
		this.subj = lvSubj;
	}
	public String getSubjCrossRef() { 
		return this.subjCrossRef;
	}
	public void setSubjCrossRef(String lvSubjCrossRef) { 
		this.subjCrossRef = lvSubjCrossRef;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("basketIen ==> " + this.basketIen + "\n");
		sb.append("basketName ==> " + this.basketName + "\n");
		sb.append("basketCrossRef ==> " + this.basketCrossRef + "\n");
		sb.append("dateSent ==> " + this.dateSent + "\n");
		sb.append("dateSentInternal ==> " + this.dateSentInternal + "\n");
		sb.append("dateSentCrossRef ==> " + this.dateSentCrossRef + "\n");
		sb.append("from ==> " + this.from + "\n");
		sb.append("fromExtCrossRef ==> " + this.fromExtCrossRef + "\n");
		sb.append("numLines ==> " + this.numLines + "\n");
		sb.append("msgIsNew ==> " + this.msgIsNew + "\n");
		sb.append("msgIsPriority ==> " + this.msgIsPriority + "\n");
		sb.append("msgWasRead ==> " + this.msgWasRead + "\n");
		sb.append("numResponses ==> " + this.numResponses + "\n");
		sb.append("seqNum ==> " + this.seqNum + "\n");
		sb.append("subj ==> " + this.subj + "\n");
		sb.append("subjCrossRef ==> " + this.subjCrossRef + "\n");
		return sb.toString();
	}

}
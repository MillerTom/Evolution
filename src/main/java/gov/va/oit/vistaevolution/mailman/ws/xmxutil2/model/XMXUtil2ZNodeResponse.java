package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2ZNodeResponse extends AbstractVistaResponse {
	

		public XMXUtil2ZNodeResponse() { 
			super();
		}

		public XMXUtil2ZNodeResponse(String node) { 
			super();
			this.zeroNode = node;
		}

		public XMXUtil2ZNodeResponse(String node, String rawResponse) { 
			super();
			this.zeroNode = node;
			this.rawResponse = rawResponse;
		}

		public XMXUtil2ZNodeResponse(String node, List<String> errMsgs) {
			this.zeroNode = node;
			this.errMsgs = errMsgs;
		}

		@XmlElement(name = "zeroNode", required = false)
		private String zeroNode;

		@XmlElementWrapper(name = "errors")
		@XmlElement(name = "errorElement", required = false)
		private List<String> errMsgs;
		
		public String getZeroNode() { 
			return this.zeroNode;
		}
		public void setZeroNode(String lvZeroNode) { 
			this.zeroNode = lvZeroNode;
		}

		public String toString() { 
			StringBuffer sb = new StringBuffer();
			sb.append("Class = " + this.getClass() + "\n");
			sb.append("===========================================\n");
			sb.append("zeroNode ==> " + this.zeroNode + "\n");
			sb.append("errMsgs ==> " + StrUtils.listToString(this.errMsgs) + "\n");
			return sb.toString();
		}

		public List<String> getErrMsgs() {
			return errMsgs;
		}

		public void setErrMsgs(List<String> errMsgs) {
			this.errMsgs = errMsgs;
		}
}

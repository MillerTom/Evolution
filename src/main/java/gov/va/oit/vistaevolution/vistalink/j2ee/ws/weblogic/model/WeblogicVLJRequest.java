/**
 * 
 */
package gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "WeblogicVLJRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class WeblogicVLJRequest {
	
	@XmlElement(name = "userId",required = true)
	private String userId;
	@XmlElement(name = "division",required = true)
	private String division;
	@XmlElement(name = "connType",required = true)
	private String connType;
	@XmlElement(name = "rpcName",required = true)
	private String rpcName;
	@XmlElement(name = "rpcContext",required = true)
	private String rpcContext;
	

	public WeblogicVLJRequest() {
		super();
	}
	
	public WeblogicVLJRequest(String userId, String division, String connType,String rpcName, String rpcContext) {
		super();
		this.userId = userId;
		this.division = division;
		this.connType = connType;
		this.rpcName = rpcName;
		this.rpcContext = rpcContext;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getConnType() {
		return connType;
	}

	public void setConnType(String connType) {
		this.connType = connType;
	}

	public String getRpcName() {
		return rpcName;
	}

	public void setRpcName(String rpcName) {
		this.rpcName = rpcName;
	}

	public String getRpcContext() {
		return rpcContext;
	}

	public void setRpcContext(String rpcContext) {
		this.rpcContext = rpcContext;
	}
	
	

}

/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XQALBUTLAhistoryResponse {

	
	/**
	 * XU SOA AHIST
	 *
	 * This RPC returns information from the ALERT TRACKING file (#8992.1) for alerts with the 
	 * XUAID input parameter as its alert ID.  
	 *  
	 * 
	 * Input Variables	
	 * 		XUAID:	(required) This is the value XUAID which is the alert identifier.  
	 * 				It is passed to the routine or option which is run when the alert 
	 * 				is selected.  It can also be obtained from a listing of all of the 
	 * 				XUAIDs for a specified user and/or patient.
	 * 
	 * Response
	 * 		Returns data descendent from the closed root passed in XURET.
	 * 		The basic structure of the nodes is taken from the global for the
	 * 		entry and can be seen in a global map of the ALERT TRACKING (#8992.1)
	 * 		file.
	 * 
	 * 		array(0)="NO-ID;83194;3140107.141502^3140107.141502^NO-ID^^83194^1"
	 * 		array(1)="Your task #6749088 stopped because of an error^^XQA^XUTMUTL"
	 * 		array(2)=6749088
	 * 		array(20,0)="^8992.11PA^1^1"
	 * 		array(20,1,0)=83194
	 * 		array(20,1,1,0)="^8992.111PA^1^1"
	 * 		array(20,1,1,1,0)="1^^^3140107.141502"
	 * 		array(20,1,1,"B",1,1)=""
	 * 		array(20,"B",83194,1)=""
	 * 
	 */
	@XmlElementWrapper(name = "dataList")
	@XmlElement(name = "dataElement", required = false)
	private List<String> dataList;

	public XQALBUTLAhistoryResponse() {
		super();
	}

	public XQALBUTLAhistoryResponse(List<String> dataList) {
		super();
		this.dataList = dataList;
	}

	/**
	 * @return the dataList
	 */
	public List<String> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}


}

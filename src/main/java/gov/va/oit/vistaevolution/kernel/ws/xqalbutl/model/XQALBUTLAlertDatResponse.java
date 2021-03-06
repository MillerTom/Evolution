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
public class XQALBUTLAlertDatResponse {

	
	/**
	 * XU SOA ALERT
	 *
	 * This RPC returns information from the ALERT TRACKING (#8992.1) file
	 * for the alert XUAID in the array specified by XURET.  If the specified
	 * alert is not present, the array root is returned with a NULL value.
	 * 
	 * Input Variables	
	 * 		XUAID:	(required) This is the value XUAID which is the alert identifier.  
	 * 				It is passed to the routine or option which is run when the alert 
	 * 				is selected.  It can also be obtained from a listing of all of the 
	 * 				XUAIDs for a specified user and/or patient.
	 * 
	 * Response
	 * 		Returns data elements at the top level of the ALERT TRACKING (#8992.1)
	 * 		file subscripted by the field numbers.  This subscript is sufficient to
	 * 		obtain the data.  The values are shown as internal^external if the
	 * 		internal and external forms are different.  The next subscript after
	 * 		the field number will provide the field names if they are desired.  Use
	 * 		XQALERTD as the return root to simulate calling the API with a null
	 * 		root.
	 *		
	 *		array(.01)="NO-ID;83194;3140107.141502"
	 *		array(.01,"NAME")=""
	 *		array(.02)="3140107.141502^JAN 07, 2014@14:15:02"
	 *		array(.02,"DATE CREATED")=""
	 *		array(.03)="NO-ID"
	 *		array(.03,"PKG ID")=""
	 *		array(.04)=""
	 *		array(.04,"PATIENT")=""
	 * 
	 */
	@XmlElementWrapper(name = "dataList")
	@XmlElement(name = "dataElement", required = false)
	private List<String> dataList;

	public XQALBUTLAlertDatResponse() {
		super();
	}

	public XQALBUTLAlertDatResponse(List<String> dataList) {
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

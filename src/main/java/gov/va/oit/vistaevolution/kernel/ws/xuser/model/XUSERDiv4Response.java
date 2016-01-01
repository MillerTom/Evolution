/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser.model;

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
public class XUSERDiv4Response {

	
	/**
	 * XU SOA DIV4
	 * 
	 *    Returns the Divisions a user is assigned to. Returns '0' if no institution
	 *    for user. Returns '1' if user has institution entry. Institution entry is
	 *    in the NEW PERSON file (#200) field DIVISION (#16).
	 *    
	 * Input Parameters:
	 * 		XUROOT	(Required) Local variable the is passed by reference.
	 * 
	 * 		XUDUZ	Optional IEN to the NEW PERSON (#200) file. If not passed defaults to
	 * 				the current DUZ.
	 * 
	 * Response:
	 * 				Returns 1 to indicate that the array of pointers to the INSTITUTION (#4)
	 * 				has been defined and 0 to indicate that the array of pointer to the
	 * 				INSTITUTION (#4) file has not been defined. The format is
	 * 				ARRAY([^DIC(4 IEN]).
	 *   
	 */
	@XmlElementWrapper(name = "dataList")
	@XmlElement(name = "dataElement", required = false)
	private List<String> dataList;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XUSERDiv4Response(List<String> dataList) {
		this.setDataList(dataList);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XUSERDiv4Response() {
		this.setDataList(null);
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

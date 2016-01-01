/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
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
 * 		XUDUZ	(Optional) IEN to the NEW PERSON (#200) file. If not passed defaults to
 * 				the current DUZ.
 * 
 * Response:
 * 				Returns 1 to indicate that the array of pointers to the INSTITUTION (#4)
 * 				has been defined and 0 to indicate that the array of pointer to the
 * 				INSTITUTION (#4) file has not been defined. The format is
 * 				ARRAY([^DIC(4 IEN]).
 *   
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSERDiv4Request {

	@XmlElement(required = true)
	private String field;
	@XmlElement(required = false)
	private String iens;

	public XUSERDiv4Request() {
		super();
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getIens() {
		return iens;
	}

	public void setIens(String iens) {
		this.iens = iens;
	}
	
}

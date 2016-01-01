package gov.va.oit.vistaevolution.fileman.ws.die.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIEChkRequest {

	/**
	 * file :
	 * 
	 * (Required) The number of the file or subfile.
	 * 
	 * field :
	 * 
	 * (Required) Field number for which data is being validated.
	 * 
	 * flags :
	 * 
	 * (Optional) Flags to control processing
	 * 
	 * value :
	 * 
	 * (Required)  Value to be validated, as entered by a user. VALUE can take several 
	 * forms depending on the DATA TYPE field value involved, such as a partial, 
	 * unambiguous match for a pointer or any of the supported ways to input dates 
	 * (e.g., "TODAY" or "11/3/93").
	 * 
	 */
	@XmlElement(required = true)
	private String file;
	@XmlElement(required = true)
	private String field;
	@XmlElementWrapper(name = "flags")
	@XmlElement(name = "flag", required = false)
	private List<String> flags;
	@XmlElement(required = true)
	private String value;

	public DIEChkRequest() {
		super();
	}
	
	//Constructor for all inputs
	public DIEChkRequest(String file, String field, List<String> flags,
			String value) {
		super();
		this.file = file;
		this.field = field;
		this.flags = flags;
		this.value = value;
	}

	//Constructor for only required inputs
	public DIEChkRequest(String file, String field, List<String> flags) {
		super();
		this.file = file;
		this.field = field;
		this.flags = flags;
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @return the flags
	 */
	public List<String> getFlags() {
		return flags;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @param flags
	 *            the flags to set
	 */
	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}

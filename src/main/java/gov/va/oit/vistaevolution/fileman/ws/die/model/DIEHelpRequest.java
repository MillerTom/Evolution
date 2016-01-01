package gov.va.oit.vistaevolution.fileman.ws.die.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIEHelpRequest {

	/**
	 * file :
	 * 
	 * (Required) The number of the file or subfile to search.
	 * 
	 * field :
	 * 
	 * (Required) Field number for which help is requested
	 * 
	 * iens :
	 * 
	 * (Optional) The IENS that identifies the subfile, if FILE is a subfile
	 * number.
	 * 
	 * flags :
	 * 
	 * (Required) Flags used to determine what kind of help is returned by the call
	 * 
	 */
	@XmlElement(required = true)
	private String file;
	@XmlElement(required = true)
	private String field;
	@XmlElement(required = false)
	private String iens;
	@XmlElementWrapper(name = "flags")
	@XmlElement(name = "flag", required = true)
	private List<String> flags;

	public DIEHelpRequest() {
		super();
	}

	//Constructor for all fields
	public DIEHelpRequest(String file, String field, String iens, List<String> flags) {
		super();
		this.file = file;
		this.field = field;
		this.iens = iens;
		this.flags = flags;
	}

	//Constructor for required fields only
	public DIEHelpRequest(String file, String field, List<String> flags) {
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
	 * @return the iens
	 */
	public String getIens() {
		return iens;
	}

	/**
	 * @return the flags
	 */
	public List<String> getFlags() {
		return flags;
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
	 * @param iens
	 *            the iens to set
	 */
	public void setIens(String iens) {
		this.iens = iens;
	}

	/**
	 * @param flags
	 *            the flags to set
	 */
	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

}

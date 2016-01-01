/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class AbstractDILFFDARequest {

	@XmlElement(required = true)
	private String file;

	@XmlElement(required = true)
	private String field;

	@XmlElement(required = false)
	private String flags;

	@XmlElement(required = false)
	private List<String> value;

	/**
	 * 
	 */
	public AbstractDILFFDARequest() {
		this(null, null, null, null);
	}

	/**
	 * @param file
	 * @param field
	 * @param value
	 */
	protected AbstractDILFFDARequest(String file, String field) {
		this(file, field, null, null);
	}

	/**
	 * @param file
	 * @param field
	 * @param value
	 */
	protected AbstractDILFFDARequest(String file, String field,
			List<String> value) {
		this(file, field, null, value);
	}

	/**
	 * @param file
	 * @param field
	 * @param flags
	 */
	protected AbstractDILFFDARequest(String file, String field, String flags) {
		this(file, field, flags, null);
	}

	/**
	 * @param file
	 * @param field
	 * @param flags
	 * @param value
	 */
	protected AbstractDILFFDARequest(String file, String field, String flags,
			List<String> value) {
		super();
		this.file = file;
		this.field = field;
		this.flags = flags;
		this.value = value;
	}

	public String getFile() {
		return file;
	}

	protected void setFile(String file) {
		this.file = file;
	}

	public String getField() {
		return field;
	}

	protected void setField(String field) {
		this.field = field;
	}

	public String getFlags() {
		return flags;
	}

	protected void setFlags(String flags) {
		this.flags = flags;
	}

	public List<String> getValue() {
		return value;
	}

	protected void setValue(List<String> value) {
		this.value = value;
	}

}

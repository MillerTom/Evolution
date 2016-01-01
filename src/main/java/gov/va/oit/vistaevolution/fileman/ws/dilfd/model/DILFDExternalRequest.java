package gov.va.oit.vistaevolution.fileman.ws.dilfd.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDExternalRequest extends AbstractVistaRequest {

	/**
	 * file :
	 * 
	 * (Required) The number of the file or subfile that contains the field that
	 * describes the internal value passed in.
	 * 
	 * field :
	 * 
	 * (Required) The number of the field that describes the internal value
	 * passed in.
	 * 
	 * flags :
	 * 
	 * (Optional) To control processing(F, L, U).
	 * 
	 * internal :
	 * 
	 * (Required) The internal value that is to be converted to its external
	 * format.
	 */
	@XmlElement(required = true)
	private String file;
	@XmlElement(required = true)
	private String field;
	@XmlElementWrapper(name = "flags")
	@XmlElement(name = "flag", required = false)
	private List<String> flags;
	@XmlElement(required = true)
	private String internal;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public DILFDExternalRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param file
	 * @param field
	 * @param flags
	 * @param internal
	 */
	public DILFDExternalRequest(String file, String field, List<String> flags,
			String internal) {
		super();
		this.file = file;
		this.field = field;
		this.flags = flags;
		this.internal = internal;
	}

	/**
	 * Mandatory Parameters Constructor
	 * 
	 * @param file
	 * @param field
	 * @param internal
	 */
	public DILFDExternalRequest(String file, String field, String internal) {
		super();
		this.file = file;
		this.field = field;
		this.internal = internal;
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the flags
	 */
	public List<String> getFlags() {
		return flags;
	}

	/**
	 * @param flags
	 *            the flags to set
	 */
	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

	/**
	 * @return the internal
	 */
	public String getInternal() {
		return internal;
	}

	/**
	 * @param internal
	 *            the internal to set
	 */
	public void setInternal(String internal) {
		this.internal = internal;
	}

}

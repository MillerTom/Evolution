package gov.va.oit.vistaevolution.fileman.ws.dic.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DICFindRequest extends AbstractDICRequest {

	/**
	 * file :
	 * 
	 * (Required) The number of the file or subfile to search.
	 * 
	 * iens :
	 * 
	 * (Optional) The IENS that identifies the subfile, if FILE is a subfile
	 * number.
	 * 
	 * fields :
	 * 
	 * (Optional) The fields to return with each entry found.
	 * 
	 * flags :
	 * 
	 * (Optional) Flags to control processing.
	 * 
	 * [.]value :
	 * 
	 * (Required) The lookup values.
	 * 
	 * max :
	 * 
	 * (Optional) The maximum number of entries to find.
	 * 
	 * [.]xref :
	 * 
	 * (Optional) The indexes the Finder should search for matches.
	 * 
	 * [.]screen :
	 * 
	 * (Optional) Entry Screen. The screen to apply to each potential entry
	 * returned, to decide whether or not to include it.
	 * 
	 * id :
	 * 
	 * (Optional) The text to accompany each found entry to help identify it to
	 * the end user.
	 * 
	 * options :
	 * 
	 * (Optional) Optional Parameter
	 * 
	 */
	@XmlElementWrapper(name = "fields")
	@XmlElement(name = "field", required = false)
	private List<String> fields;
	@XmlElementWrapper(name = "values")
	@XmlElement(name = "value", required = true)
	private List<String> value;
	@XmlElement(required = false)
	private String max;
	@XmlElementWrapper(name = "xref")
	@XmlElement(name = "entry", required = false)
	private List<String> xref;
	@XmlElement(required = false)
	private String id;
	@XmlElement(required = false)
	private String options;

	/**
	 * No Arguments Constructor
	 */
	public DICFindRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param file
	 * @param iens
	 * @param fields
	 * @param flags
	 * @param value
	 * @param max
	 * @param xref
	 * @param screen
	 * @param id
	 * @param options
	 */
	public DICFindRequest(String file, String iens, List<String> fields,
			List<String> flags, List<String> value, String max,
			List<String> xref, String screen, String id, String options) {
		super(file, iens, flags, screen);
		this.fields = fields;
		this.value = value;
		this.max = max;
		this.xref = xref;
		this.id = id;
		this.options = options;
	}

	/**
	 * Mandatory Parameters Constructor
	 * 
	 * @param file
	 * @param value
	 */
	public DICFindRequest(String file, List<String> value) {
		super(file);
		this.value = value;
	}

	/**
	 * @return the fields
	 */
	public List<String> getFields() {
		return fields;
	}

	/**
	 * @return the value
	 */
	public List<String> getValue() {
		return value;
	}

	/**
	 * @param fields
	 *            the fields to set
	 */
	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(List<String> value) {
		this.value = value;
	}

	/**
	 * @return the options
	 */
	public String getOptions() {
		return options;
	}

	/**
	 * @param options
	 *            the options to set
	 */
	public void setOptions(String options) {
		this.options = options;
	}

	/**
	 * @return the max
	 */
	public String getMax() {
		return max;
	}

	/**
	 * @param max
	 *            the max to set
	 */
	public void setMax(String max) {
		this.max = max;
	}

	/**
	 * @return the xref
	 */
	public List<String> getXref() {
		return xref;
	}

	/**
	 * @param xref
	 *            the xref to set
	 */
	public void setXref(List<String> xref) {
		this.xref = xref;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

}

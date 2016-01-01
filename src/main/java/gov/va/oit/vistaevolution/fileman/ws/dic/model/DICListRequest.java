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
public class DICListRequest extends AbstractDICRequest {

	/**
	 * file :
	 * 
	 * (Required) The file whose entries are to be listed
	 * 
	 * iens :
	 * 
	 * (Optional) If the FILE parameter equals a file number, the Lister will
	 * ignore the IENS parameter. If the FILE parameter equals a subfile number,
	 * the Lister needs the IENS parameter to help identify which subfile to
	 * list.
	 * 
	 * fields :
	 * 
	 * (Optional) The fields to return with each entry found.
	 * 
	 * flags :
	 * 
	 * (Optional) Flags to control processing
	 * 
	 * max :
	 * 
	 * (Optional) The number of entries to return.
	 * 
	 * from :
	 * 
	 * (Optional) The index entry(s) from which to begin the list (e.g., a FROM
	 * value of "XQ" would list entries following XQ).
	 * 
	 * part :
	 * 
	 * (Optional) The index entry(s) from which to begin the list (e.g., a FROM
	 * value of "XQ" would list entries following XQ).
	 * 
	 * xref :
	 * 
	 * (Optional) The name of the index from which to build the list.
	 * 
	 * screen :
	 * 
	 * (Optional) Entry Screen. The screen to apply to each potential entry in
	 * the returned list to decide whether or not to include it.
	 * 
	 * id :
	 * 
	 * (Optional) The text to accompany each potential entry in the returned
	 * list to help identify it to the end user.
	 * 
	 * options :
	 * 
	 * (OPtional) Optional Parameter
	 * 
	 */

	@XmlElementWrapper(name = "fields")
	@XmlElement(name = "field", required = false)
	private List<String> fields;
	@XmlElement(required = false)
	private String max;
	@XmlElementWrapper(name = "from")
	@XmlElement(name = "entry", required = false)
	private List<String> from;
	@XmlElementWrapper(name = "parts")
	@XmlElement(name = "part", required = false)
	private List<String> part;
	@XmlElement(required = false)
	private String xref;
	@XmlElement(required = false)
	private String id;

	/**
	 * No Arguments Constructor
	 */
	public DICListRequest() {
		super();
	}

	/**
	 * parameterised constructor
	 * 
	 * @param file
	 * @param iens
	 * @param fields
	 * @param flags
	 * @param max
	 * @param from
	 * @param part
	 * @param xref
	 * @param screen
	 * @param id
	 * @param options
	 */
	public DICListRequest(String file, String iens, List<String> fields,
			List<String> flags, String max, List<String> from,
			List<String> part, String xref, String screen, String id) {
		super(file, iens, flags, screen);
		this.fields = fields;
		this.max = max;
		this.from = from;
		this.part = part;
		this.xref = xref;
		this.id = id;
	}

	/**
	 * Mandatory Parameters constructor
	 * 
	 * @param file
	 */
	public DICListRequest(String file) {
		super(file);
	}

	/**
	 * @return the fields
	 */
	public List<String> getFields() {
		return fields;
	}

	/**
	 * @param fields
	 *            the fields to set
	 */
	public void setFields(List<String> fields) {
		this.fields = fields;
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
	 * @return the from
	 */
	public List<String> getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(List<String> from) {
		this.from = from;
	}

	/**
	 * @return the part
	 */
	public List<String> getPart() {
		return part;
	}

	/**
	 * @param part
	 *            the part to set
	 */
	public void setPart(List<String> part) {
		this.part = part;
	}

	/**
	 * @return the xref
	 */
	public String getXref() {
		return xref;
	}

	/**
	 * @param xref
	 *            the xref to set
	 */
	public void setXref(String xref) {
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

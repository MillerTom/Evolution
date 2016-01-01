package gov.va.oit.vistaevolution.fileman.ws.dic.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractDICRequest extends AbstractVistaRequest {

	/**
	 * 
	 * file :
	 * 
	 * (Required) The number of the File or Subfile
	 * 
	 * iens :
	 * 
	 * (Optional) If the FILE parameter equals a file number, iens will be
	 * ignored. If the FILE parameter equals a subfile number, iens parameter
	 * needed to help identify which subfile .
	 * 
	 * flags :
	 * 
	 * (Optional) Flags to control processing
	 * 
	 * screen :
	 * 
	 * (Optional) Entry Screen. The screen to apply to each potential entry
	 * returned to decide whether or not to include it.
	 */

	@XmlElement(required = true)
	protected String file;
	@XmlElement(required = false)
	protected String iens;
	@XmlElementWrapper(name = "flags")
	@XmlElement(name = "flag", required = false)
	protected List<String> flags;
	@XmlElement(required = false)
	protected String screen;

	/**
	 * No Arguments Constructor
	 */
	public AbstractDICRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param file
	 * @param iens
	 * @param flags
	 * @param screen
	 */
	public AbstractDICRequest(String file, String iens, List<String> flags,
			String screen) {
		super();
		this.file = file;
		this.iens = iens;
		this.flags = flags;
		this.screen = screen;
	}

	/**
	 * Mandatory Parameters Constructor
	 * 
	 * @param file
	 */
	public AbstractDICRequest(String file) {
		this.file = file;
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
	 * @return the iens
	 */
	public String getIens() {
		return iens;
	}

	/**
	 * @param iens
	 *            the iens to set
	 */
	public void setIens(String iens) {
		this.iens = iens;
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
	 * @return the screen
	 */
	public String getScreen() {
		return screen;
	}

	/**
	 * @param screen
	 *            the screen to set
	 */
	public void setScreen(String screen) {
		this.screen = screen;
	}

}

/**
 *
 */
package gov.va.oit.vistaevolution.fileman.ws.dialog.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * <pre>
 *
 * BLD^DIALOG
 * Input Parameters Class:
 *
 * dialogNum:   (Required) Record number from the DIALOG
 *              file (#.84) for the text to be returned.
 *
 * textParam:   (Optional) Local array containing the dialogue
 *              parameters to substitute into the resulting text.
 *              Set the subscript of each node in this array to a
 *              dialogue parameter that is in a |window| in the
 *              referenced DIALOG file (#.84) entry's text. The
 *              value of each node should be in external, printable
 *              format and will be substituted in the DIALOG text
 *              for that DIALOG parameter.  If there is only one
 *              parameter in the list, you can pass its value in
 *              a local variable or as a literal, otherwise,
 *              pass by reference.
 *
 * flags:       (Optional) Flags to control processing. The possible values are:
 *
 *              S - Suppress the blank line that is normally inserted
 *              between discrete blocks of text that are built by separate
 *              calls to this routine.
 *
 *              F -Format the local array similar to the default output
 *              format of the ^TMP global, so that MSG^DIALOG can be
 *              called to either Write the array to the current device
 *              or to a simple local array.
 *
 * </pre>
 *
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIALOGBldRequest {

    @XmlElement(required = true)
	private String dialogNum;
    
    @XmlElementWrapper(name = "text-param")
    @XmlElement(required = false)
	private List<String> textParam;
    
    @XmlElement(name="flags", required = false)
	private String flags;

    @XmlElement(name="dir", required = false)
    private String dir;

	/**
	 * Default Bean Constructor
	 */
	public  DIALOGBldRequest() {
	    super();
	}

	public  DIALOGBldRequest(String dialogNum) {
	    super();
	    this.dialogNum = dialogNum;
	    this.textParam = new ArrayList<String>();
	    this.flags = "";
	    this.dir = "";
	}
	
	public  DIALOGBldRequest(String dialogNum, List<String> textParam, String flags, String dir) {
	    super();
	    this.dialogNum = dialogNum;
	    this.textParam = textParam;
	    this.flags = flags;
	    this.dir = dir;
	}

	/**
     * @return the dialogNum
     */
    public String getDialogNum() {
        return this.dialogNum;
    }

    /**
     * @param aDialogNum the dialogNum to set
     */
    public void setDialogNum(final String aDialogNum) {
        this.dialogNum = aDialogNum;
    }

    /**
     * @return the textParam
     */
    public List<String> getTextParam() {
        return this.textParam;
    }

    /**
     * @param aTextParam the textParam to set
     */
    public void setTextParam(final List<String> aTextParam) {
        this.textParam = aTextParam;
    }

    /**
     * @return the flags
     */
    public String getFlags() {
        return this.flags;
    }

    /**
     * @param aFlags the flags to set
     */
    public void setFlags(final String aFlags) {
        this.flags = aFlags;
    }

    public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

}

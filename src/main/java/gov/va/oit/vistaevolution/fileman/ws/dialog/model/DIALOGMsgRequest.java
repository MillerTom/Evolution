/**
 *
 */
package gov.va.oit.vistaevolution.fileman.ws.dialog.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 *
 * Output Generator
 * Input Parameters Class:
 *
 * flags:       (Optional) Flags to control processing. If none of the
 *              text-type flags (E, H or M) is entered, the routine behaves
 *              as if E were entered. If no flags are entered, it
 *              behaves as if FLAGS contained WE. The possible values are:
 *
 *              A - Local Array specified by the second parameter receives the text.
 *              W - Writes the text to the current device.
 *              S - Saves the ^TMP or other designated input array (does not KILL the array).
 *              E - Error array text is processed.
 *              H - Help array text is processed.
 *              M - Message array text (other text) is processed.
 *              B - Blank lines are suppressed between error messages.
 *              T - Return Total number of lines in the top level node of the local array specified by the second parameter.
 *
 * text_with:   (Optional) Maximum line length for formatting text. If specified,
 *              the text is broken into lines of this length when writing to the current
 *              device or when moving the text to the OUTPUT_ARRAY. Lines are not "joined"
 *              to fill out to this width.
 *
 *              If you do not specify TEXT_WIDTH:
 *              Text that is displayed on the current device is formatted to a line length
 *              of IOM-5 if IOM is defined, or to 75 characters otherwise.
 *              Text written to an OUTPUT_ARRAY is not reformatted.
 *
 * left_margin: (Optional) Left margin for writing text. If sent, the text is lined up in
 *              a column starting at this column number. Otherwise, the text is lined up
 *              with the left margin (column 0). This parameter has no effect on text sent
 *              to an array (A flag).
 *
 * input_root:  (Optional) Closed root of local input array in which text resides. If the
 *              text resides in a local array, this parameter must be sent. The last non-variable
 *              subscript of the local array must describe the type of text it contains, as
 *              the ^TMP global normally does ("DIERR" for errors, "DIHELP" for help text,
 *              or "DIMSG" for other text).
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIALOGMsgRequest {

    @XmlElement(required = false)
	private String flags;
    @XmlElement(required = false)
	private String textWidth;
    @XmlElement(required = false)
	private String leftMargin;
    @XmlElementWrapper(name = "inputroot")
    @XmlElement(required = false)
	private List<String> inputRoot;

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

    /**
     * @return the textWidth
     */
    public String getTextWidth() {
        return this.textWidth;
    }

    /**
     * @param aTextWidth the textWidth to set
     */
    public void setTextWidth(final String aTextWidth) {
        this.textWidth = aTextWidth;
    }

    /**
     * @return the leftMargin
     */
    public String getLeftMargin() {
        return this.leftMargin;
    }

    /**
     * @param aLeftMargin the leftMargin to set
     */
    public void setLeftMargin(final String aLeftMargin) {
        this.leftMargin = aLeftMargin;
    }

    /**
     * @return the inputRoot
     */
    public List<String> getInputRoot() {
        return this.inputRoot;
    }

    /**
     * @param aInputRoot the inputRoot to set
     */
    public void setInputRoot(final List<String> aInputRoot) {
        this.inputRoot = aInputRoot;
    }

    /**
	 * Default bean constructor
	 */
	public DIALOGMsgRequest() {
	    super();
	}

}

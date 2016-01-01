
package gov.va.oit.vistaevolution.fileman.ws.dilfd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 *
 * File Root Resolver
 * Input Parameters Class:
 *
 * file:        (Required) File number or subfile number.
 *
 * iens:        (Required when passing subfile numbers) Standard IENS
 *              indicating internal entry number.
 *
 * flags:       (Optional) If set to 1 (true), returns a closed root.
 *              The default is to return an open root.
 *
 * error_flag:  (Optional) If set to 1 (true), processes an error message
 *              if error is encountered.
 *
 * </pre>
 *
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDRootRequest {

    @XmlElement(required = true)
    private String file;
    @XmlElement(required = false)
	private String iens;
    @XmlElement(required = false)
	private String flags;
    @XmlElement(required = false)
	private String errorFlag;


    /**
	 * Default Bean Constructor
	 */
	public DILFDRootRequest() {
	    super();
	}

	public DILFDRootRequest(String file, String iens) {
	    super();
	    this.file = file;
	    this.iens = iens;
	    this.flags = "";
	    this.errorFlag = "";
	}

	public DILFDRootRequest(String file, String iens, String flags, String errorFlag) {
	    super();
	    this.file = file;
	    this.iens = iens;
	    this.flags = flags;
	    this.errorFlag = errorFlag;
	}

	/**
     * @return the file
     */
    public String getFile() {
        return this.file;
    }


    /**
     * @param file the file to set
     */
    public void setFile(final String file) {
        this.file = file;
    }


    /**
     * @return the iens
     */
    public String getIens() {
        return this.iens;
    }


    /**
     * @param iens the iens to set
     */
    public void setIens(final String iens) {
        this.iens = iens;
    }


    /**
     * @return the flags
     */
    public String getFlags() {
        return this.flags;
    }


    /**
     * @param flags the flags to set
     */
    public void setFlags(final String flags) {
        this.flags = flags;
    }


    /**
     * @return the errorFlag
     */
    public String getErrorFlag() {
        return this.errorFlag;
    }


    /**
     * @param errorFlag the errorFlag to set
     */
    public void setErrorFlag(final String errorFlag) {
        this.errorFlag = errorFlag;
    }

}

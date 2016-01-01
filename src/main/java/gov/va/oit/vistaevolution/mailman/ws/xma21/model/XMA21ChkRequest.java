/**
 *
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Verify User's Mail Group Memebership
 * Input Parameters Class:
 *
 * xmduz:       (Required, Sequence = 1) DUZ of the user in
 *              question.
 *
 * ien:         (Required, Sequence = 2) IEN of the mail group
 *              in the MAIL GROUP file (#3.8)
 *
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA21ChkRequest {

	@XmlElement(required = true)
	private String xmduz;
	@XmlElement(required = true)
	private String ien;

	/**
     * @return the xmduz
     */
    public String getXmduz() {
        return this.xmduz;
    }

    /**
     * @param xmduz the xmduz to set
     */
    public void setXmduz(final String xmduz) {
        this.xmduz = xmduz;
    }

    /**
     * @return the ien
     */
    public String getIen() {
        return this.ien;
    }

    /**
     * @param ien the ien to set
     */
    public void setIen(final String ien) {
        this.ien = ien;
    }

    /**
     * Default Bean Constructor
     */
    public XMA21ChkRequest() {

        super();
		this.xmduz = "";
        this.ien = "";
	}

    /**
     * Constructo initializes the class
     * @param xmduz
     * @param ien
     */
	public XMA21ChkRequest(final String xmduz, 
	        final String ien) {

	    this();
		this.xmduz = xmduz;
		this.ien = ien;
	}



}

package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Pending Alerts for a User in Specified Software
 * Output Parameters Class:
 *
 * returns: Returns:
 *
 *           1—YES, indicates one or more alerts pending
 *           for the specified user containing the
 *           software/package identifier string in the
 *           package part of XQAID.
 *
 *           0—NO, alerts not pending.
 *
 * </pre>
 *
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XQALBUTLPkgPendResponse extends AbstractVistaResponse {

	@XmlElement(required = true)
	private String returns;

	/**
     * @return the returns
     */
    public String getReturns() {
        return this.returns;
    }

    /**
     * @param returns the returns to set
     */
    public void setReturns(final String returns) {
        this.returns = returns;
    }

    /**
	 * Constructor initializes the class with the return value
	 *
	 * @param value
	 */
	public XQALBUTLPkgPendResponse(final String value) {
		super();
		this.returns = value;
	}

	/**
	 * Default Bean Constructor
	 */
	public XQALBUTLPkgPendResponse() {
		super();
		this.returns = null;
	}

}

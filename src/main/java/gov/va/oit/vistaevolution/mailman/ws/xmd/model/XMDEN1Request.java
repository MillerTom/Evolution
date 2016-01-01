package gov.va.oit.vistaevolution.mailman.ws.xmd.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMDEN1Request extends AbstractVistaRequest {

	@XmlElement(name = "duz", required = true)
	private String DUZ;

	@XmlElementWrapper(name = "message", required = true)
	@XmlElement(name = "text", required = true)
	private List<String> message;

	@XmlElementWrapper(name = "xmy", required = true)
	@XmlElement(name = "entry", required = true)
	private List<XMYEntry> XMY;

	@XmlElement(name = "xmSub", required = true)
	private String XMSub;

	@XmlElement(name = "xmdf", required = false)
	private String XMDF;

	@XmlElement(name = "xmStrip", required = false)
	private String XMStrip;

	/**
	 */
	public XMDEN1Request() {
		this(null, null, null, null, null, null);
	}

	/**
	 * @param dUZ
	 * @param message
	 * @param xMY
	 * @param xMSub
	 * @param XMDF
	 * @param xMStrip
	 */
	public XMDEN1Request(String dUZ, List<String> message, List<XMYEntry> xMY,
			String xMSub, String XMDF, String xMStrip) {
		super();
		this.DUZ = dUZ;
		this.message = message;
		this.XMY = xMY;
		this.XMSub = xMSub;
		this.XMDF = XMDF;
		this.XMStrip = xMStrip;
	}

	/**
	 * @param DUZ
	 * @param message
	 * @param XMY
	 * @param XMSub
	 */
	public XMDEN1Request(String DUZ, List<String> message, List<XMYEntry> XMY,
			String XMSub) {
		this(DUZ, message, XMY, XMSub, null, null);
	}

	public String getDUZ() {
		return DUZ;
	}

	protected void setDUZ(String dUZ) {
		DUZ = dUZ;
	}

	public List<String> getMessage() {
		return message;
	}

	protected void setMessage(List<String> message) {
		this.message = message;
	}

	public String getXMSub() {
		return XMSub;
	}

	protected void setXMSub(String xMZ) {
		XMSub = xMZ;
	}

	public List<XMYEntry> getXMY() {
		return XMY;
	}

	protected void setXMY(List<XMYEntry> XMY) {
		this.XMY = XMY;
	}

	public String getXMDF() {
		return XMDF;
	}

	protected void setXMDF(String xMDF) {
		XMDF = xMDF;
	}

	public String getXMStrip() {
		return XMStrip;
	}

	protected void setXMStrip(String xMStrip) {
		XMStrip = xMStrip;
	}

}

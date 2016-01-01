package gov.va.oit.vistaevolution.mailman.ws.xmd.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMDEnt1Request {

	@XmlElement(name = "duz", required = false)
	private String DUZ;

	@XmlElement(name = "xmduz", required = false)
	private String XMDUZ;

	@XmlElementWrapper(name = "xmy")
	@XmlElement(name = "entry", required = true)
	private List<XMYEntry> XMY;

	@XmlElement(name = "xmz", required = true)
	private String XMZ;

	/**
	 * Default no arg constructor.
	 */
	public XMDEnt1Request() {
		this.setDUZ(null);
		this.setXMDUZ(null);
		this.setXMY(null);
		this.setXMZ(null);

	}

	/**
	 * Constructor.
	 * 
	 * @param DUZ
	 * @param XMDUZ
	 * @param XMY
	 * @param XMZ
	 */
	public XMDEnt1Request(String DUZ, String XMDUZ, List<XMYEntry> XMY,
			String XMZ) {
		this.setDUZ(DUZ);
		this.setXMDUZ(XMDUZ);
		this.setXMY(XMY);
		this.setXMZ(XMZ);

	}

	/**
	 * @param string
	 * @param arrayList
	 * @param string2
	 */
	public XMDEnt1Request(String XMDUZ, ArrayList<XMYEntry> XMY,
			String XMZ) {
		this.setDUZ(null);
		this.setXMDUZ(XMDUZ);
		this.setXMY(XMY);
		this.setXMZ(XMZ);

	}

	public String getDUZ() {
		return DUZ;
	}

	protected void setDUZ(String dUZ) {
		DUZ = dUZ;
	}

	public String getXMDUZ() {
		return XMDUZ;
	}

	protected void setXMDUZ(String xMDUZ) {
		XMDUZ = xMDUZ;
	}

	public String getXMZ() {
		return XMZ;
	}

	protected void setXMZ(String xMZ) {
		XMZ = xMZ;
	}

	public List<XMYEntry> getXMY() {
		return XMY;
	}

	protected void setXMY(List<XMYEntry> XMY) {
		this.XMY = XMY;
	}

}

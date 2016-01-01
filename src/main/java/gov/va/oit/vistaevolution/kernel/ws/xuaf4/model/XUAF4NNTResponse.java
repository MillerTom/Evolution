package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import java.util.List;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4NNTResponse extends AbstractVistaResponse {

	@XmlElement(required = false)
	private String institutionName;

	@XmlElement(required = false)
	private String siteNumber;

	@XmlElement(required = false)
	private String institutionType;

	public XUAF4NNTResponse(List<String> errors) {
		super(errors);
	}

	/**
	*
	 */
	public XUAF4NNTResponse() {
		super();
		this.setInstitutionName(null);
		this.setSiteNumber(null);
		this.setInstitutionType(null);
	}

	/**
	 * @param institutionName
	 * @param siteNumber
	 * @param institutionType
	 */
	public XUAF4NNTResponse(String institutionName, String siteNumber,
			String institutionType) {
		super();
		this.setInstitutionName(institutionName);
		this.setSiteNumber(siteNumber);
		this.setInstitutionType(institutionType);
	}

	public String getInstitutionName() {
		return institutionName;
	}

	protected void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getSiteNumber() {
		return siteNumber;
	}

	protected void setSiteNumber(String siteNumber) {
		this.siteNumber = siteNumber;
	}

	public String getInstitutionType() {
		return institutionType;
	}

	protected void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}

}
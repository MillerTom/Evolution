package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DDR SOA FDA VALUES RETRIEVER      TAG: VALUESR
 * ROUTINE: DDR5                     RETURN VALUE TYPE: ARRAY
 * AVAILABILITY: SUBSCRIPTION
 * 
 * This RPC returns values from an FDA for a specified field using VALUES^DILF.
 * The IENS associated with a particular value is also returned. Use the DDR SOA
 * FDA VALUE RETRIEVER if you want the single value associated with a particula
 * file and field in a standard FDA.
 * 
 * Input Parameters
 * PARAMETERS             PARAMETER TYPE: LIST
 * MAXIMUM DATA LENGTH: 512  REQUIRED: YES
 * 
 * DESCRIPTION:
 * 		"FILE"  (Required) File or subfile number.
 * 		"FIELD" (Required) Field number for which data is being requested.
 * 		"FDA"   (Required) The FDA from which data is being requested.
 * 
 * Returns:
 * 
 * The output from the call is returned in the DDRDATA array. Its structure is:
 * 		DDRDATA Number of values found for the specified field. If no node exists in
 * 		        the FDA for the field, DDRDATA=0.
 * 		DDRDATA(seq#) Value for a particular instance of the field. Seq# is an
 *              integer starting with 1 that identifies the particular value.
 *      DDRDATA(seq#,"IENS") The IENS of the entry or subentry with the value in
 *              DDRDATA(seq#).
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFValuesRequest {
	@XmlElement(required = true)
	private String file;
	@XmlElement(required = true)
	private String field;

	private List<Fda> fdas;

	public DILFValuesRequest() {
		super();
	}

	//Constructor for all fields
	public DILFValuesRequest(String file, String field, List<Fda> fdas) {
		super();
		this.file = file;
		this.field = field;
		this.fdas = fdas;
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the fdas
	 */
	@XmlElementWrapper(name = "fdas", required = true)
	public List<Fda> getFdas() {
		return fdas;
	}

	/**
	 * @param fdas the fdas to set
	 */
	public void setFdas(List<Fda> fdas) {
		this.fdas = fdas;
	}
}

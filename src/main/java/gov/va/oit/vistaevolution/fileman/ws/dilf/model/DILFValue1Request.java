package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * DDR SOA FDA VALUE RETRIEVER
 * 
 * This RPC returns the value associated with a particular file and field in a
 * standard FDA. Only a single value is returned. If there is more than one node
 * in the FDA array for the same field, the first value encountered by this
 * function is returned. It uses $$VALUE1^DILF. Use the DDR SOA FDA VALUES
 * RETRIEVER RPC if you want more than one value returned.
 * 
 * Input Parameters:
 * 		PARAMETERS	(Required) A list of parameters
 * 	
 * 		Each Parameter contains a list of FDAs which have the following fields:
 *   	FILE		(Required) File or subfile number.
 *   	FIELD		(Required) Field number for which data is being requested.
 *   	FDA			(Required) The FDA (file#, iens, and field#) from which data is being requested.
 *   
 * Results:
 * 		This RPC returns the value for the specified file and field that is stored in
 * 		the FDA. If the field is a word-processing field, only the root at which
 * 		word-processing data is stored is returned. No IENS information is returned. If
 * 		more than one value is associated with a particular field (for example, in a
 * 		subfile), only a single value is returned. If there is no node in the FDA for a
 * 		particular field, a caret ("^") is returned. If the node has a null value, null
 * 		is returned.
 * 
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFValue1Request {
	@XmlElement(required = true)
	private String file;
	@XmlElement(required = true)
	private String field;
	@XmlElementWrapper(name = "fdaList")
	@XmlElement(name = "fda", required = true)
	private List<Fda> fdas;

	public DILFValue1Request() {
		super();
	}

	//Constructor for all fields
	public DILFValue1Request(String file, String field, List<Fda> fdas) {
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

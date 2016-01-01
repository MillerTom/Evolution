package gov.va.oit.vistaevolution.fileman.ws.die.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "DIEKeyVAlRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class DIEKeyValRequest {

	/**
	 *
	 *	DDR KEY VALIDATOR
	 *
	 *	Validates that values passed in do not violate key integrity.  Underlying
	 *	DBS call is KEYVAL^DIE.
	 *	
	 *	Input Parameters:
	 *		VALUES 	A list containing the values to validate
	 *
	 *		Array of data used to create FDA for KEYVAL^DIE call.  Alternating lines
	 *		contain file#^IENS^field# and value associated with preceding file, record,
	 *		and field.
	 *
	 *	Results:
	 *		If values pass validation, 1 is returned in first node of array.  If
	 *		validation fails, 0 is returned in first node followed by error
	 *		information.
	 * 
	 */
	@XmlElementWrapper(name = "values")
	@XmlElement(name = "value", required = true)
	private List<String> values;

	public DIEKeyValRequest() {
		super();
	}
	
	//Constructor for all inputs
	public DIEKeyValRequest(List<String> values) {
		super();
		this.values = values;
	}

	/**
	 * @return the values
	 */
	public List<String> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(List<String> values) {
		this.values = values;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DIEKeyValRequest [getValues()=" + getValues() + "]";
	}
	
	

}


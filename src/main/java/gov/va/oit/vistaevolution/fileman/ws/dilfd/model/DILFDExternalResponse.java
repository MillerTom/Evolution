package gov.va.oit.vistaevolution.fileman.ws.dilfd.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DILFDExternalResponse extends AbstractVistaResponse {

	/**
	 * outputData :
	 * 
	 * an external format value, as defined by a field in a file in the
	 * database. In the event of an error, this function outputs the empty
	 * string instead.
	 * 
	 */

	@XmlElementWrapper(name = "outputData")
	@XmlElement(name = "entry", required = true)
	private List<String> outputData;

	/**
	 * Non Argument Constructor
	 */
	public DILFDExternalResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param externalValue
	 */
	public DILFDExternalResponse(List<String> outputData) {
		super();
		this.outputData = outputData;
	}

	/**
	 * @return the outputData
	 */
	public List<String> getOutputData() {
		return outputData;
	}

	/**
	 * @param outputData
	 *            the outputData to set
	 */
	public void setOutputData(List<String> outputData) {
		this.outputData = outputData;
	}

}

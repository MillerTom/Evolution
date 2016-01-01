/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMVVITAEInitResponse extends AbstractVistaResponse {

	/**
	 * 
	 * outputDataList :
	 * 
	 * Array that should receive returned output data list
	 * 
	 * errors :
	 * 
	 * Array that should receive any error messages returned!
	 * 
	 */

	@XmlElementWrapper(name = "outputDataList")
	@XmlElement(name = "entry", required = false)
	private List<String> outputDataList;

	/**
	 * No Arguments Constructor.
	 */
	public XMVVITAEInitResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param outputDataList
	 * @param errors
	 */
	public XMVVITAEInitResponse(List<String> outputDataList, List<String> errors) {
		super(errors);
		this.outputDataList = outputDataList;
	}

	/**
	 * @return the outputDataList
	 */
	public List<String> getOutputDataList() {
		return outputDataList;
	}

	/**
	 * @param outputDataList
	 *            the outputDataList to set
	 */
	public void setOutputDataList(List<String> outputDataList) {
		this.outputDataList = outputDataList;
	}

}

package gov.va.oit.vistaevolution.fileman.ws.dic.model;

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
public class DICFindResponse extends AbstractVistaResponse {

	/**
	 * 
	 * outputDataList :
	 * 
	 * The array that should receive the output returned.
	 * 
	 */
	@XmlElementWrapper(name = "outputDataList")
	@XmlElement(name = "entry", required = false)
	private List<String> outputDataList;

	/**
	 * No Arguments Constructor.
	 */
	public DICFindResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param outputDataList
	 */
	public DICFindResponse(List<String> outputDataList) {
		super();
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

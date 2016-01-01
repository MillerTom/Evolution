package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4F4Response extends AbstractVistaResponse {

	/**
	 * outputDataList :
	 * 
	 * Array that should receive returned output data list
	 * 
	 */
	@XmlElementWrapper(name = "outputDataList")
	@XmlElement(name = "entry", required = false)
	private List<String> outputDataList;

	/**
	 * No Arguments Constructor
	 */
	public XUAF4F4Response() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param outputDataList
	 */
	public XUAF4F4Response(List<String> outputDataList) {
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

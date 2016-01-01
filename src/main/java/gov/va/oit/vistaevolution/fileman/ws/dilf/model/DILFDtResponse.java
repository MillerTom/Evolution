package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

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
public class DILFDtResponse extends AbstractVistaResponse {

	/**
	 * outputDataList:
	 * 
	 * VA FileMan's internal date format and (optionally) into the standard VA
	 * FileMan external, readable date format.
	 * 
	 */
	@XmlElementWrapper(name = "outputDataList")
	@XmlElement(name = "entry", required = false)
	private List<String> outputDataList;

	/**
	 * No Arguments Constructor.
	 */
	public DILFDtResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param outputDataList
	 */
	public DILFDtResponse(List<String> outputDataList) {
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

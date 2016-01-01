/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

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
public class XUAF4ChildrenResponse extends AbstractVistaResponse {

	/**
	 * outputDataList :
	 * 
	 * Returns the array populated with the list of Institutions that make up
	 * the parent VISN.
	 * 
	 * • Variable array ("c",ien)=station_name^station_number
	 * 
	 * • If no data found then return nothing.
	 * 
	 */

	@XmlElementWrapper(name = "outputDataList")
	@XmlElement(name = "entry", required = false)
	private List<String> outputDataList;

	/**
	 * No Arguments Constructor
	 */
	public XUAF4ChildrenResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param outputDataList
	 */
	public XUAF4ChildrenResponse(List<String> outputDataList) {
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

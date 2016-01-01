package gov.va.oit.vistaevolution.fileman.ws.ddr2.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DDR2Find1CResponse {

	/**
	 * dataList :
	 * 
	 * the Internal Entry Number (IEN) of a single record entry in a file based
	 * on input value(s).
	 * 
	 */
	@XmlElementWrapper(name = "dataList")
	@XmlElement(name = "data", required = false)
	private List<String> dataList;

	public DDR2Find1CResponse() {
	}

	public DDR2Find1CResponse(List<String> dataList) {
		this.dataList = dataList;
	}

	/**
	 * @return the dataList
	 */
	public List<String> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "DDR2Find1CResponse [dataList=" + dataList + "]";
	}
}

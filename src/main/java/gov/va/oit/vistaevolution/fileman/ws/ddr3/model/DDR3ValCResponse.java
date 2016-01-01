package gov.va.oit.vistaevolution.fileman.ws.ddr3.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DDR3ValCResponse {
	@XmlElementWrapper(name = "dataList")
	@XmlElement(name = "dataElement", required = false)
	private List<String> dataList;

	public DDR3ValCResponse() {
		super();
	}

	public DDR3ValCResponse(List<String> dataList) {
		super();
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
}

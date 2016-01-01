package gov.va.oit.vistaevolution.fileman.ws.die.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DIEKeyValResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class DIEKeyValResponse {

	/**
	 * data :
	 * 
	 * the Internal Entry Number (IEN) of a single record entry in a file based
	 * on input value(s).
	 * 
	 */
	@XmlElementWrapper(name = "dataList")
	@XmlElement(name = "dataElement", required = false)
	private List<String> dataList;

	public DIEKeyValResponse() {
		super();
	}

	public DIEKeyValResponse(List<String> dataList) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DIEKeyValResponse [getDataList()=" + getDataList() + "]";
	}

	

}

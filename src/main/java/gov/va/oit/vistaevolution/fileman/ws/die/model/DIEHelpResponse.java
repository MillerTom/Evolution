package gov.va.oit.vistaevolution.fileman.ws.die.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIEHelpResponse {

	/**
	 * data :
	 * 
	 * the Internal Entry Number (IEN) of a single record entry in a file based
	 * on input value(s).
	 * 
	 * msgRoot :
	 * 
	 * The array that should receive any error messages.
	 */
	@XmlElementWrapper(name = "dataList")
	@XmlElement(name = "dataElement", required = false)
	private List<String> dataList;

	public DIEHelpResponse() {
		super();
	}

	public DIEHelpResponse(List<String> dataList) {
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

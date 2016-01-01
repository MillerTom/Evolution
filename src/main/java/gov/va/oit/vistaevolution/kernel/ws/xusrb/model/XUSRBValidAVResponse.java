package gov.va.oit.vistaevolution.kernel.ws.xusrb.model;

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
public class XUSRBValidAVResponse extends AbstractVistaResponse {

	/**
	 * outputDataList :
	 * 
	 * an array of values
	 * 
	 * R(0)=DUZ if sign-on was OK, zero if not OK. R(1)=(0=OK, 1,2...=Can't
	 * sign-on for some reason). R(2)=verify needs changing. R(3)=Message.
	 * R(4)=0 R(5)=count of the number of lines of text, zero if none.
	 * R(5+n)=message text.
	 * 
	 * 
	 */

	@XmlElementWrapper(name = "outputDataList")
	@XmlElement(name = "entry", required = true)
	private List<String> outputDataList;

	/**
	 * No Arguments Constructor
	 */
	public XUSRBValidAVResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param outputDataList
	 */
	public XUSRBValidAVResponse(List<String> outputDataList) {
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

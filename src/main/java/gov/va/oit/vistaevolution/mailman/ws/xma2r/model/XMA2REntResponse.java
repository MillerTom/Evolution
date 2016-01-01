package gov.va.oit.vistaevolution.mailman.ws.xma2r.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMA2REntResponse extends AbstractXMA2RResponse {

	/**
	 * result :
	 * 
	 * IEN ---->If results are okay, this is the responses internal pointer
	 * located in file 3.9
	 * 
	 * 
	 * “E”n Text ---->If bad result, the letter "E" followed by a number,
	 * followed by a space, then a human readable explanation of the error.
	 * 
	 * msgRoot :
	 * 
	 * Array that will receive any Error Messages
	 */

	/**
	 * Default Empty Constructor
	 */
	public XMA2REntResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param result
	 * @param msgRoot
	 */
	public XMA2REntResponse(String result, List<String> msgRoot) {
		super(result, msgRoot);
	}
}

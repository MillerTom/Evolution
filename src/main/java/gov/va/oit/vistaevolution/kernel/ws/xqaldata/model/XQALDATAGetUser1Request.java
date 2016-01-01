/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/**
 * XU SOA GETUSER
 * 
 * This RPC returns a list of alerts a user needs to see.
 *  
 * Input Parameters
 * 		XUIEN		This is the internal entry number in file 200 (DUZ value) for the desired user.
 * 
 * Output
 * 	Returns a list of alerts that a user needs to see in the array specified by XURET.
 * 
 * array=6
 * array(1)="R  Your task #6752751 stopped because of an error^NO-ID;83194;3140108.154503"
 * array(2)="R  Your task #6752718 stopped because of an error^NO-ID;83194;3140108.151503"
 * array(3)="R  Your task #6752683 stopped because of an error^NO-ID;83194;3140108.144503"
 * array(4)="R  Your task #6752450 stopped because of an error^NO-ID;83194;3140108.141503"
 * array(5)="R  Your task #6752410 stopped because of an error^NO-ID;83194;3140108.134503"
 * array(6)="R  Your task #6752372 stopped because of an error^NO-ID;83194;3140108.131503"
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XQALDATAGetUser1Request {

	@XmlElement(required = true)
	private String ien;

	public XQALDATAGetUser1Request() {
		super();
	}

	public XQALDATAGetUser1Request(String ien) {
		super();
		this.ien = ien;
	}

	/**
	 * @return the ien
	 */
	public String getIen() {
		return ien;
	}

	/**
	 * @param ien the ien to set
	 */
	public void setIen(String ien) {
		this.ien = ien;
	}

}

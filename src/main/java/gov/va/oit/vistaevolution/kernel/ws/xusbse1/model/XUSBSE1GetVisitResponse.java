/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusbse1.model;

import java.util.ArrayList;

import gov.va.oit.vistaevolution.kernel.ws.xusbse1.UserToken;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 0G4976SEC
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSBSE1GetVisitResponse {
	
	@XmlElement(name = "return", required = false)
	private String ret;
	
	/*token object to be used for future use? 
	 * "ssn^name^station name^station number^DUZ^phone^vpid" is the expected return object
	 */
	private UserToken token;
	
	public XUSBSE1GetVisitResponse()
	{
		super();
	}
	
	public XUSBSE1GetVisitResponse(String ret)
	{
		super();
		this.ret = ret;
	}

	/**
	 * @return the ret
	 */
	public String getRet() {
		return ret;
	}

	/**
	 * @param ret the ret to set
	 */
	public void setRet(String ret) {
		this.ret = ret;
	}
	
	public UserToken parseResponse(String rawResponse){
		token = new UserToken();
		ArrayList<String> list = new ArrayList<String>();
        int pos = 0, end, rawArraySize = rawResponse.length();
        
        // using index as a faster means of parsing
        while ((end = rawResponse.indexOf('^', pos)) >= 0) {
                list.add(rawResponse.substring(pos, end));
                pos = end + 1;
        }
        //validate last position of array, as there isn't a trailing caret at the end of the string, and this 
        //field may be blank.
        if(pos < rawArraySize){
        	end = rawArraySize;
        	list.add(rawResponse.substring(pos, end));
        }else if(pos == rawArraySize){
        	list.add("");
        }
        
        //add values to the token object only is the array is the correct size, else return a null object
        if(list.size() == 7){
        	token.setSsn(list.get(0));
        	token.setName(list.get(1));
        	token.setStationName(list.get(2));
        	token.setStationNum(list.get(3));
        	token.setDuz(list.get(4));
        	token.setTeleNum(list.get(5));
        	token.setVpid(list.get(6));
        }else{
        	token = null;
        }

        return token;
	}
	
}

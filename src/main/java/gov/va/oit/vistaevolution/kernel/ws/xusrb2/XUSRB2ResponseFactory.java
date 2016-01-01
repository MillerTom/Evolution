/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2;

import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivGetXUSRB2Response;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivSetXUSRB2Response;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.StrUtilsException;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Christopher Schuck
 *
 */
@Component
public class XUSRB2ResponseFactory extends AbstractResponseFactory {

	private static final Logger LOG = Logger
			.getLogger(XUSRB2ResponseFactory.class);
	
	public XUSRB2UserinfoResponse createUserinfoFromString(String rawResponse) {
		List<String> retAry = new ArrayList<String>();
		try {
			retAry = StrUtils.stringtoList(rawResponse,"\n");
		} catch (StrUtilsException e) {
			LOG.debug("Unable to parse response.",e);
		}
		return new XUSRB2UserinfoResponse(retAry);
	}

	public DivGetXUSRB2Response createDivGetXUSRB2ResponseFromString(String rawResponse) {
		ArrayList<String> retAry = new ArrayList<String>();
		try {
			retAry = StrUtils.stringtoList(rawResponse,"\n");
		} catch (StrUtilsException e) {
			LOG.debug("Unable to parse response.",e);
		}
		return new DivGetXUSRB2Response(retAry);
	}
	
	public DivSetXUSRB2Response createDivSetXUSRB2ResponseFromString(String rawResponse) {
		
		return new DivSetXUSRB2Response(rawResponse);
	}

}

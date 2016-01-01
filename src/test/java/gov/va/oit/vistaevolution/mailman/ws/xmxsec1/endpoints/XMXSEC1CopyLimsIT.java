package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1CopyLimsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyLimsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyLimsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.utils.XMXSEC1Constants;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XMXSEC1CopyLimsIT extends VistaLinkContextITParent {
	
	public XMXSEC1CopyLimsIT() {
		super();
	}
	
	private static Logger LOGGER = Logger.getLogger(XMXSEC1CopyLimsIT.class);
	
	@Autowired
	private XMXSEC1CopyLimsEndpoint service;
	private XMXSEC1CopyLimsRequest request;
	private XMXSEC1CopyLimsResponse response;

	
	/**
	 * <em>Test Case #1  </em>
	 * Check the site’s message copy limits.
	 	Input Data:
		None.
		
		Procedure Call:
		>D COPYLIMS^XMWSOA06(.RETURN)
		
		Expected Output:
		>ZW RETURN
		RETURN="99999^9999^9999999"


	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC1CopyLims001() { 

		request = new XMXSEC1CopyLimsRequest();
		response = service.CopyLims(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMXSEC1Constants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult CopyLims Num Lines --> " + response.getNumLines() + "\n");
		LOGGER.info("\nResult CopyLims Num Recipients --> " + response.getNumRecipeints() + "\n");
		LOGGER.info("\nResult CopyLims Num Responses --> " + response.getNumResponses() + "\n");
		assertEquals("9999999", response.getNumLines());
		assertEquals("9999", response.getNumResponses());
		assertEquals("99999", response.getNumRecipeints());


	}

}

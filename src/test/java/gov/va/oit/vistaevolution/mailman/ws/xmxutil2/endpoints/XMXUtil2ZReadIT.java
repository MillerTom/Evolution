package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZReadEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZReadRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZReadResponse;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXUtil2ZReadIT extends EvolutionIT<XMXUtil2ZReadEndpoint> {
	private static final Logger LOGGER = Logger.getLogger(XMXUtil2ZReadIT.class);
	private XMXUtil2ZReadRequest request;
	private String newMailMessageIEN = "";
	@Override
	protected Class<XMXUtil2ZReadEndpoint> getType() {
		return XMXUtil2ZReadEndpoint.class;
	}
	
	@Before
	public void setUp() {
		XMDEndpoint service = null;
		try {
			service = getEndpointImpl(XMDEndpoint.class);
		} catch (Exception e) {
			LOGGER.error(this.getClass().toString() + ".setUp(): failed to create XMDEndpoint");
			LOGGER.error(this.getClass().toString() + ".setUp(): exception: " + e.getMessage() );
		}
		if(service != null) { 
			this.newMailMessageIEN = MailUtils.createMailMessage(service, null, null, null);
			LOGGER.info("XMXUtil2ZReadIT new ien = " + this.newMailMessageIEN);
		}else { 
			LOGGER.error("Service was null");
		}
		
	}
	/**
	 * <em>This RPC returns the number of responses to a message 
	 * 		that a specified user has read.  If there's an error, 
	 * 		it returns an error message.</em>
	 * 
	 * 		RETURN PARAMETER DESCRIPTION:   
   			Null-User has not read the message at all
   			0-User has read the original message only
   			Number-User has read through this response


	 * 
	 * <b>User has not read the message at all.  Return null</b>
	 * 
	 * <pre>
				Input Data:
				>S XMDUZ=1       ***DBITPRO use:    >S XMDUZ=.5
				>S XMZ=100       ***DBITPRO use:    >S XMZ=58880
				
				Procedure Call:
				>D ZREAD^XMWSOA07(.RETURN,XMDUZ,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN=""
	</pre>
	 */
	@Test
	public void testMsgWasNotReadByUser() {
		String testResponse = null; 	
		
		request = new XMXUtil2ZReadRequest(".5", "58880");
		XMXUtil2ZReadResponse response = service.ZRead(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getNumResponsesRead());	 
	}	// end test 

	
	/**
	 * <em>This RPC returns the number of responses to a message 
	 * 		that a specified user has read.  If there's an error, 
	 * 		it returns an error message.</em>
	 * 
	 * 		RETURN PARAMETER DESCRIPTION:   
   			Null-User has not read the message at all
   			0-User has read the original message only
   			Number-User has read through this response


	 * 
	 * <b>Error.  User DUZ is null  Return error.</b>
	 * 
	 * <pre>
				Input Data:
				>S XMDUZ=""
				>S XMZ=100
				
				Procedure Call:
				>D ZREAD^XMWSOA07(.RETURN,XMDUZ,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN="-1^Error in required input"

	</pre>
	 */
	
	@Test
	public void testWhenMsgDuzIsNull() {
		String testResponse = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, XMXUtil2ZReadEndpointImpl.MY_SERVICE);
		testResponse = testResponse.replace(VistaConstants.PARAM, "DUZ");
		
		request = new XMXUtil2ZReadRequest("", "58880");
		
		XMXUtil2ZReadResponse response = service.ZRead(request);		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getErrors().get(0));	 
	}	// end test 
	
	/**
	 * <em>This RPC returns the number of responses to a message 
	 * 		that a specified user has read.  If there's an error, 
	 * 		it returns an error message.</em>
	 * 
	 * 		RETURN PARAMETER DESCRIPTION:   
   			Null-User has not read the message at all
   			0-User has read the original message only
   			Number-User has read through this response


	 * 
	 * <b>Error.  MSG IEN is null  Return error.</b>
	 * 
	 * <pre>
				Input Data:
				>S XMDUZ=""
				>S XMZ=100
				
				Procedure Call:
				>D ZREAD^XMWSOA07(.RETURN,XMDUZ,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN="-1^Error in required input"

	</pre>
	 */
	
	@Test
	public void testWhenMsgIENIsNull() {
		String testResponse = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, XMXUtil2ZReadEndpointImpl.MY_SERVICE);
		testResponse = testResponse.replace(VistaConstants.PARAM, "XMZ");
		
		request = new XMXUtil2ZReadRequest(".5", "");
		
		XMXUtil2ZReadResponse response = service.ZRead(request);		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getErrors().get(0));	 
	}	// end test 
	
	
	/**
	 * <em>This RPC returns the number of responses to a message 
	 * 		that a specified user has read.  If there's an error, 
	 * 		it returns an error message.</em>
	 * 
	 * 		RETURN PARAMETER DESCRIPTION:   
   			Null-User has not read the message at all
   			0-User has read the original message only
   			Number-User has read through this response


	 * 
	 * <b>User read the original message only.</b>
	 * 
	 * <pre>
				Input Data:
				>S XMDUZ=.5
				>S XMZ=28       ***DBITPRO use:    >S XMZ=59056
				
				Procedure Call:
				>D ZREAD^XMWSOA07(.RETURN,XMDUZ,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN=0


	</pre>
	 */
	
	@Test
	public void testWhenUserHasReadOriginalMsgOnly() {
		String testResponse = "0";
		request = new XMXUtil2ZReadRequest(".5", "59056");
		
		XMXUtil2ZReadResponse response = service.ZRead(request);		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getNumResponsesRead());	 
	}	// end test 
	
	/**
	 * <em>This RPC returns the number of responses to a message 
	 * 		that a specified user has read.  If there's an error, 
	 * 		it returns an error message.</em>
	 * 
	 * 		RETURN PARAMETER DESCRIPTION:   
   			Null-User has not read the message at all
   			0-User has read the original message only
   			Number-User has read through this response


	 * 
	 * <b>User has read through this response.</b>
	 * 
	 * <pre>
				Input Data:
				>S XMDUZ=83159    ***DBITPRO use:    >S XMDUZ=.5
				>S XMZ="42858"    ***DBITPRO use:    >S XMZ=60449
				
				Procedure Call:
				>D ZREAD^XMWSOA07(.RETURN,XMDUZ,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN=1

	</pre>
	 */
	
	@Test
	public void testWhenUserHasReadOriginalMsgAndResponse() {
		String testResponse = "1";
		
		request = new XMXUtil2ZReadRequest(".5", "60449");
		
		XMXUtil2ZReadResponse response = service.ZRead(request);		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getNumResponsesRead());	 
	}	// end test 
}

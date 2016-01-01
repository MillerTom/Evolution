package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZFromEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZFromRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZFromResponse;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XMXUtil2ZFromIT extends VistaLinkContextITParent {

	private static final String ERR_MSG_NOT_POP = "Failed to populate a new mail message in VistA";
	private static Logger LOGGER = Logger.getLogger(XMXUtil2ZFromIT.class);
	
	final String TEST2_REGEX_FORMAT = "\\d{2}/\\d{2}/\\d{2}\\@\\d{2}:\\d{2}";
	
	@Autowired
	private XMXUtil2ZFromEndpoint service;
	
	private XMXUtil2ZFromRequest request;
	private XMXUtil2ZFromResponse response;
	
//	@Autowired
//	private XMXAPIAddrNSndEndpoint msgService;
//	
//	private TestMessageCreator msgCreator;
//	private XMXAPIAddrNSndResponse msgResponse = new XMXAPIAddrNSndResponse("123", "");
	
//	private boolean msgResponsePopulated = false;
//	
//	private boolean initMailMessage() { 
//		msgCreator = new TestMessageCreator();
//		
//		if(msgCreator.createMailMessage(msgService,"Test Subject for XMXUtil2FromIT", "", null)) { 
//			this.msgResponsePopulated = msgCreator.isMsgResponsePopulated();
//			this.msgResponse = msgCreator.getMsgResponse();
//		}
//		return this.msgResponsePopulated;
//	}
	
	

	/**
	 * <em>This RPC returns the message From information. 
	 * It is returned in external format.  If there's an 
	 * error, it returns an error message.
	 * 
	 * Error.  Pass in null message IEN.
	 * 
	 * 
	 * <pre>
				Input Data:
				>S XMZ=""
				
				Procedure Call:
				>D ZFROM^XMWSOA07(.RETURN,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN="-1^Error in required input"




	
	</pre>
	 */
	
	@Test
	public void jtestXMXUtil2ZFrom001() throws VistaWebServiceFault {
		
		String tstResp = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, XMXUtil2ZFromEndpointImpl.MY_SERVICE);
		tstResp = tstResp.replace(VistaConstants.PARAM, "XMZ");
		
		request = new XMXUtil2ZFromRequest("");

		response = service.ZFrom(request);		


		assertNotNull(response);
		assertEquals(tstResp, response.getZfromInfo());	// assertEquals(null == input)

	}	// end test 1
	

	/**
	 * <em>This RPC returns the message From information. 
	 * It is returned in external format.  If there's an 
	 * error, it returns an error message.
	 * 
	 * Error.  Pass in invalid  message IEN.
	 * 
	 * 
	 * <pre>
				Input Data:
				>S XMZ="9999999"
				
				Procedure Call:
				>D ZFROM^XMWSOA07(.RETURN,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN="-1^Error in required input"




	
	</pre>
	 */
	
	@Test
	public void jtestXMXUtil2ZFrom002() throws VistaWebServiceFault {
		
		
		String tstResp = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, XMXUtil2ZFromEndpointImpl.MY_SERVICE);
		tstResp = tstResp.replace(VistaConstants.PARAM, "XMZ");
		
		request = new XMXUtil2ZFromRequest("9999999");

		response = service.ZFrom(request);		


		assertNotNull(response);
		assertEquals(tstResp, response.getZfromInfo());	// assertEquals(null == input)

	}	// end test 1
	
	/**
	 * <em>This RPC returns the message From information. 
	 * It is returned in external format.  If there's an 
	 * error, it returns an error message.
	 * 
	 * Error.  Pass in invalid message IEN.
	 * 
	 * 
	 * <pre>
				Input Data:
				>S XMZ="0"
				
				Procedure Call:
				>D ZFROM^XMWSOA07(.RETURN,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN="-1^Error in required input"




	
	</pre>
	 */
	
	@Test
	public void jtestXMXUtil2ZFrom003() throws VistaWebServiceFault {
		
		
		String tstResp = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, XMXUtil2ZFromEndpointImpl.MY_SERVICE);
		tstResp = tstResp.replace(VistaConstants.PARAM, "XMZ");
		
		request = new XMXUtil2ZFromRequest("0");

		response = service.ZFrom(request);		


		assertNotNull(response);
		assertEquals(tstResp, response.getZfromInfo());	// assertEquals(null == input)

	}	// end test 1
	
	/**
	 * <em>This RPC returns the message From information. 
	 * It is returned in external format.  If there's an 
	 * error, it returns an error message.
	 * 
	 * Error.  Pass in null message IEN.
	 * 
	 * 
	 * <pre>
				Input Data:
				>S XMZ=msgResponse.getMsgIen()
				
				Procedure Call:
				>D ZFROM^XMWSOA07(.RETURN,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN="-1^Error in required input"




	
	</pre>
	 */
	
	@Test
	public void jtestXMXUtil2ZFrom004() throws VistaWebServiceFault {
		
//		if(initMailMessage()) { 
//			LOGGER.info("Successfully created new mail message for XMXUtil2^ZFrom, IEN = " 
//					+ this.msgResponse.getMsgIen());
//		}else { 
//			LOGGER.error("Failed to create new mail message for XMXUtil2^ZFromIT");
//		}
//
//		if(!this.msgResponsePopulated) { 
//			// try to populate, if we can't fail
//			if(!initMailMessage()) { 
//				fail(ERR_MSG_NOT_POP);
//			}
//		}
//		String tstResp = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, XMXUtil2ZFromEndpointImpl.MY_SERVICE);
//		tstResp = tstResp.replace(VistaConstants.PARAM, "XMZ");
//		
//		request = new XMXUtil2ZFromRequest(msgResponse.getMsgIen());
//
//		response = service.ZFrom(request);		
//
//
//		assertNotNull(response);
//		assertEquals(tstResp, response.getZfromInfo());	// assertEquals(null == input)

	}	// end test 1
}

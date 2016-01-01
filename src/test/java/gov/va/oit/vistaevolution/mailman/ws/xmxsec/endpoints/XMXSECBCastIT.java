package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECBcastRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECBcastResponse;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XMXSECBCastIT extends VistaLinkContextITParent {
	
	private static Logger LOGGER = Logger.getLogger(XMXSECBCastIT.class);
	
	@Autowired
	private XMXSECBcastEndpointImpl service;
	private XMXSECBcastRequest request;
	private XMXSECBcastResponse response;
	
	
//	@Autowired
//	private XMXAPIAddrNSndEndpoint msgService;
//	
//	private TestMessageCreator msgCreator;
//	private XMXAPIAddrNSndResponse msgResponse = new XMXAPIAddrNSndResponse("123", "");
	
//	private boolean msgResponsePopulated = false;
	
//	private boolean initMailMessage(XMXAPIAddrNSndRequest msgRequest) { 
//		msgCreator = new TestMessageCreator();
//		if(msgRequest != null) { 
//			msgCreator.setMsgRequest(msgRequest);
//		}
//		
//		if(msgCreator.createMailMessage(msgService,"Test Subject for XMXSECBCastIT", "", null)) { 
//			this.msgResponsePopulated = msgCreator.isMsgResponsePopulated();
//			this.msgResponse = msgCreator.getMsgResponse();
//		}
//		return this.msgResponsePopulated;
//	}
	
	/**
	 * <em>Check if Message was Broadcast - 
	 * This RPC returns a value indicating   
	 * whether a message was broadcast or not (0 = No; 1 = Yes). 
	 * 
	 * Error.  Pass in null message IEN.
	 * 
	 * 
	 * <pre>
			Input Data:
			>S XMZ=""
			
			Procedure Call:
			>D BCAST^XMWSOA06(.RETURN,XMZ)
			
			Expected Output:
			>ZW RETURN
			RETURN="-1^Error in required input"

	</pre>
	 */
	
	@Test
	public void jtestXMXSECBCast001() throws VistaWebServiceFault {
		
		request = new XMXSECBcastRequest("");
		response = service.Bcast(request);		

		assertNotNull(response);
		assertEquals(VistaConstants.ERR_MSG_IN_REQD_INPUT2, response.getMsgRoot().get(0));	

	}	// end test 1
	
	/**
	 * <em>
	 * 
	 * Error.  Pass in IEN that has no message
	 * 
	 * 
	 * <pre>
			Input Data:
			>S XMZ="999999"
			
			Procedure Call:
			>D BCAST^XMWSOA06(.RETURN,XMZ)
			
			Expected Output:
			>ZW RETURN
			RETURN="-1^Message not found"

	</pre>
	 */
	
	@Test
	public void jtestXMXSECBCast002() throws VistaWebServiceFault {
		
		request = new XMXSECBcastRequest("999999");
		response = service.Bcast(request);		

		assertNotNull(response);
		assertEquals(VistaConstants.ERR_MSG_NOT_FOUND, response.getMsgRoot().get(0));	

	}	// end test 

	/**
	 * <em>
	 * 
	 * Error.  Pass in IEN that has no message
	 * 
	 * 
	 * <pre>
			Input Data:
			>S XMZ="100"
			
			Procedure Call:
			>D BCAST^XMWSOA06(.RETURN,XMZ)
			
			Expected Output:
			>ZW RETURN
			RETURN="-1^Message not found"

	</pre>
	 */
	
	@Test
	public void jtestXMXSECBCast003() throws VistaWebServiceFault {
//		XMXAPIAddrNSndRequest msgRequest  = new XMXAPIAddrNSndRequest();
//		ArrayList<String> msg = new ArrayList<String>();
//
//		msg.add("ZZ BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios.");
//		msg.add("ZZ BASE Test case for API $$ENT^XMA2R");
//		
//
//		ArrayList<String> xmto = new ArrayList<String>();
//		xmto.add("*");
//		
//
//
//
//		String duz = ".5";
//		String xmDuz = ".5";
//		String xmSubj = "ZZ VISTA Web Srvc Subject "; //  + Math.random()*1000;
//		String xmStrip = "";
//		HashMap<String,String> hm = new HashMap<String,String>();
//		hm.put("ADDR FLAGS", "R");
//		hm.put("FLAGS", "I");
//		
//		
//		msgRequest.setDuz(duz);
//		msgRequest.setXmDuz(xmDuz);
//		msgRequest.setXmSubj(xmSubj);
//		msgRequest.setXmz(  msg);
//		msgRequest.setXmStrip(xmStrip);
//		msgRequest.setXmto(xmto);
//		msgRequest.setXmInstrMap(hm);
//		
		
//		if(initMailMessage(msgRequest)) { 
//			LOGGER.info("Successfully created new mail message for XMXSEC^BCastIT, IEN = " 
//					+ this.msgResponse.getMsgIen());
//		}else { 
//			LOGGER.error("Failed to create new mail message for XMXSEC^BCastIT");
//		}
//
//		if(!this.msgResponsePopulated) { 
//			// try to populate, if we can't fail
//			if(!initMailMessage(msgRequest)) { 
//				fail(VistaConstants.ERR_MSG_NOT_POP);
//			}
//		}
		
//		request = new XMXSECBcastRequest(msgResponse.getMsgIen());
//		response = service.Bcast(request);		
//
//		assertNotNull(response);
//		assertEquals("1", response.getMsgWasBroadCast());	

	}	// end test 

}

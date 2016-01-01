package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.XMXSEC1CopyAmtIT;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2EditRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2EditResponse;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XMXSEC2EditIT extends VistaLinkContextITParent {

	
	private static Logger LOGGER = Logger.getLogger(XMXSEC1CopyAmtIT.class);
	private final String ERR_MSG_NOT_POP = "Failed to populate a new mail message in VistA";
	
	@Autowired
	private XMXSEC2EditEndpointImpl service;
	private XMXSEC2EditRequest request;
	private XMXSEC2EditResponse response;
	
//	@Autowired
//	private XMXAPIAddrNSndEndpoint msgService;
//	
//	private TestMessageCreator msgCreator;
//	private XMXAPIAddrNSndResponse msgResponse = new XMXAPIAddrNSndResponse("123", "");
	
	private boolean msgResponsePopulated = false;

	
//	private boolean initMailMessage() { 
//		msgCreator = new TestMessageCreator();
//		
//		if(msgCreator.createMailMessage(msgService,"Test Subject for XMXSEC2EditIT", "", null)) { 
//			this.msgResponsePopulated = msgCreator.isMsgResponsePopulated();
//			this.msgResponse = msgCreator.getMsgResponse();
//		}
//		return this.msgResponsePopulated;
//	}
	
	public XMXSEC2EditIT() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * <em>Test Case #1  </em>
	 * Check a user who can edit a message.
		 Input Data:
		XMDUZ=.6
		XMZ=msgResponse.getMsgIen()
		
		Procedure Call:
		>service.Edit(XMDUZ,XMZ,"")
		
		Expected Output:
		UserMayEdit=1


	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC2Edit001() { 
//		if(initMailMessage()) { 
//			LOGGER.info("Successfully created new mail message for XMXSEC2EditIT, IEN = " 
//					+ this.msgResponse.getMsgIen());
//		}else { 
//			LOGGER.error("Failed to create new mail message for XMXSEC2EditIT");
//		}
//
//		if(!this.msgResponsePopulated) { 
//			// try to populate, if we can't fail
//			if(!initMailMessage()) { 
//				fail(ERR_MSG_NOT_POP);
//			}
//		}
//		request = new XMXSEC2EditRequest(".6", msgResponse.getMsgIen(), "");
//		response = service.Edit(request);
//		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
//			LOGGER.warn(VistaConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
//		}
//
//		assertNotNull(response);
//		LOGGER.info("\nResult userMayEdit --> " + response.getUserMayEdit() + "\n");
//		assertEquals("1", response.getUserMayEdit());
		
	}

	
	/**
	 * <em>Test Case #2  </em>
	 * Check a user who cannot edit a message.
		 Input Data:
		XMDUZ=83320
		XMZ=74398 // this was created by a run in test case one, where duz was .6
		
		Procedure Call:
		>service.Edit(XMDUZ,XMZ,"")
		
		Expected Output:
		UserMayEdit=0

		this may always return 1 because the rpc will check the user logged in to see if they have access, 
		so regardless of what we pass in, we will get 1 back if the mail msg was created 
		by the programmer1 account
	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC2Edit002() { 

		request = new XMXSEC2EditRequest("83320", "74398", "");
		response = service.Edit(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(VistaConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult userMayEdit --> " + response.getUserMayEdit() + "\n");
		assertEquals("0", response.getUserMayEdit());
		
	}
	
	/**
	 * <em>Test Case #3  </em>
	 * Check a non-existent user
		 Input Data:
		XMDUZ=99999
		XMZ=74398 // this was created by a run in test case one, where duz was .6
		
		Procedure Call:
		>service.Edit(XMDUZ,XMZ,"")
		
		Expected Output:
		UserMayEdit=0

		this may always return 1 because the rpc will check the user logged in to see if they have access, 
		so regardless of what we pass in, we will get 1 back if the mail msg was created 
		by the programmer1 account
	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC2Edit003() { 

		request = new XMXSEC2EditRequest("99999", "74398", "");
		response = service.Edit(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(VistaConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult userMayEdit --> " + response.getUserMayEdit() + "\n");
		assertEquals("0", response.getUserMayEdit());
		
	}
	
	/**
	 * <em>Test Case #4 </em>
	 * Try to call the API with no user DUZ
		 Input Data:
		XMDUZ=""
		XMZ=74398 // this was created by a run in test case one, where duz was .6
		
		Procedure Call:
		>service.Edit(XMDUZ,XMZ,"")
		
		Expected Output:
		"invalid input, XMDUZ - required.  call to XMXSEC2^Edit Service will fail for lack of necessary input."
	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC2Edit004() { 

		request = new XMXSEC2EditRequest("", "74398", "");
		response = service.Edit(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(VistaConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult userMayEdit --> " + response.getUserMayEdit() + "\n");
		assertEquals("invalid input, XMDUZ - required.  call to XMXSEC2^Edit Service will fail for lack of necessary input.", response.getMsgRoot().get(0));
		
	}
	
	/**
	 * <em>Test Case #5 </em>
	 * Try to call the API with an invalid XMDUZ parameter
		 Input Data:
		XMDUZ="A"
		XMZ=74398 // this was created by a run in test case one, where duz was .6
		
		Procedure Call:
		>service.Edit(XMDUZ,XMZ,"")
		
		Expected Output:
		"-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC2Edit005() { 

		request = new XMXSEC2EditRequest("A", "74398", "");
		response = service.Edit(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(VistaConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult userMayEdit --> " + response.getUserMayEdit() + "\n");
		assertEquals(VistaConstants.ERR_MSG_IN_REQD_INPUT2, response.getMsgRoot().get(0));
		
	}
	
	/**
	 * <em>Test Case #5 </em>
	 * Try to call the API with an invalid XMZ number
		 Input Data:
		XMDUZ=".6"
		XMZ=999999 // this was created by a run in test case one, where duz was .6
		
		Procedure Call:
		>service.Edit(XMDUZ,XMZ,"")
		
		Expected Output:
		"-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC2Edit006() { 

		request = new XMXSEC2EditRequest(".6", "9999999", "");
		response = service.Edit(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(VistaConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult userMayEdit --> " + response.getUserMayEdit() + "\n");
		assertEquals(VistaConstants.ERR_MSG_NOT_FOUND, response.getMsgRoot().get(0));
		
	}
	
	/**
	 * <em>Test Case #7 </em>
	 * Check another user who cannot edit a message
		 Input Data:
		XMDUZ="83320"
		XMZ=58880 
		
		Procedure Call:
		>service.Edit(XMDUZ,XMZ,"")
		
		Expected Output:
		"0^Only the originator may Edit a message."
	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC2Edit007() { 

		request = new XMXSEC2EditRequest(".6", "74399", "");
		response = service.Edit(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(VistaConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult userMayEdit --> " + response.getUserMayEdit() + "\n");
		assertEquals(VistaConstants.ERR_MSG_CNNT_EDIT_SNT_MSG, response.getUserMayEdit());
		
	}

	/**
	 * <em>Test Case #8 </em>
	 * Check another user who cannot edit a message
		 Input Data:
		XMDUZ="83320"
		XMZ=58880 
		
		Procedure Call:
		>service.Edit(XMDUZ,XMZ,"")
		
		Expected Output:
		"0^Only the originator may Edit a message."
	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC2Edit008() { 

		request = new XMXSEC2EditRequest("83320", "58880", "");
		response = service.Edit(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(VistaConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult userMayEdit --> " + response.getUserMayEdit() + "\n");
		assertEquals(VistaConstants.ERR_MSG_ONLY_ORGIN_EDIT, response.getUserMayEdit());
		
	}
}

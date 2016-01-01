package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1CopyAmtEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyAmtRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyAmtResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.utils.XMXSEC1Constants;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XMXSEC1CopyAmtIT extends VistaLinkContextITParent {

	private static Logger LOGGER = Logger.getLogger(XMXSEC1CopyAmtIT.class);
	private static final String ERR_MSG_NOT_POP = "Failed to populate a new mail message in VistA";

	@Autowired
	private XMXSEC1CopyAmtEndpoint service;
	private XMXSEC1CopyAmtRequest request;
	private XMXSEC1CopyAmtResponse response;
	
	public XMXSEC1CopyAmtIT() {
		super();
	}
	
//	@Autowired
//	private XMXAPIAddrNSndEndpoint msgService;
//	
//	private TestMessageCreator msgCreator;
//	private XMXAPIAddrNSndResponse msgResponse = new XMXAPIAddrNSndResponse("123", "");
	
//	private boolean msgResponsePopulated = false;
//
//	
//	private boolean initMailMessage() { 
//		msgCreator = new TestMessageCreator();
//		
//		if(msgCreator.createMailMessage(msgService,"Test Subject for XMA2R^ENTA", "", null)) { 
//			this.msgResponsePopulated = msgCreator.isMsgResponsePopulated();
//			this.msgResponse = msgCreator.getMsgResponse();
//		}
//		return this.msgResponsePopulated;
//	}
	
	/**
	 * <em>Test Case #1  </em>
	 * Check a message without specifying particular responses
	 Input Data:
		>S XMZ=msgIen
		
		Procedure Call:
		>D COPYAMT^XMWSOA06(XMZ,"")
		
		Expected Output:
		>ZW RETURN
		RETURN=1

	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC1CopyAmt001() { 
//		if(initMailMessage()) { 
//			LOGGER.info("Successfully created new mail message for XMA2R^ENTA, IEN = " 
//					+ this.msgResponse.getMsgIen());
//		}else { 
//			LOGGER.error("Failed to create new mail message for XMA2R^ENTA");
//		}
//
//		if(!this.msgResponsePopulated) { 
//			// try to populate, if we can't fail
//			if(!initMailMessage()) { 
//				fail(ERR_MSG_NOT_POP);
//			}
//		}
//		request = new XMXSEC1CopyAmtRequest(msgResponse.getMsgIen(), "");
//		response = service.CopyAmt(request);
//		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
//			LOGGER.warn(XMXSEC1Constants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
//		}
//
//		assertNotNull(response);
//		LOGGER.info("\nResult CopyAmountOK --> " + response.getCopyAmountOK() + "\n");
//		assertEquals("1", response.getCopyAmountOK());
		
	}
	
	/**
	 * <em>Test Case #2  </em>
	 * Check a message’s first response
	 	Input Data:
		>S XMZ=msgIen
		>S XMZ=1
		Procedure Call:
		>D COPYAMT^XMWSOA06(XMZ,"1")
		
		Expected Output:
		>ZW RETURN
		RETURN=1

	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC1CopyAmt002() { 
		
//		if(!this.msgResponsePopulated) { 
//			// try to populate, if we can't fail
//			if(!initMailMessage()) { 
//				fail(ERR_MSG_NOT_POP);
//			}
//		} 
//		request = new XMXSEC1CopyAmtRequest(msgResponse.getMsgIen(), "1");
//		response = service.CopyAmt(request);
//		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
//			LOGGER.warn(XMXSEC1Constants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
//		}
//
//		assertNotNull(response);
//		LOGGER.info("\nResult CopyAmountOK --> " + response.getCopyAmountOK() + "\n");
//		assertEquals("1", response.getCopyAmountOK());
		
	}
	
	/**
	 * <em>Test Case #3  </em>
	 * Check a message and its second response
	 	Input Data:
		>S XMZ=msgIen
		
		Procedure Call:
		>D COPYAMT^XMWSOA06(XMZ,"0,2")
		
		Expected Output:
		>ZW RETURN
		RETURN=1

	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC1CopyAmt003() { 
		
//		if(!this.msgResponsePopulated) { 
//			// try to populate, if we can't fail
//			if(!initMailMessage()) { 
//				fail(ERR_MSG_NOT_POP);
//			}
//		} 
//		request = new XMXSEC1CopyAmtRequest(msgResponse.getMsgIen(), "0,2");
//		response = service.CopyAmt(request);
//		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
//			LOGGER.warn(XMXSEC1Constants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
//		}
//
//		assertNotNull(response);
//		LOGGER.info("\nResult CopyAmountOK --> " + response.getCopyAmountOK() + "\n");
//		assertEquals("1", response.getCopyAmountOK());
		
	}
	
	/**
	 * <em>Test Case #4  </em>
	 * Check a non-existent message
	 	Input Data:
		>S XMZ="9999999"
		
		Procedure Call:
		>D COPYAMT^XMWSOA06(XMZ,"0")
		
		Expected Output:
		>ZW RETURN
		RETURN=-1^Message not found

	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC1CopyAmt004() { 



		request = new XMXSEC1CopyAmtRequest("9999999", "0");
		response = service.CopyAmt(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMXSEC1Constants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult CopyAmountOK --> " + response.getCopyAmountOK() + "\n");
		assertEquals("-1^Message not found", response.getMsgRoot().get(0));

	}
	
	/**
	 * <em>Test Case #5  </em>
	 * Check a non-existent response parameter.  The RPC returns a success regardless
	 	Input Data:
		>S XMZ=msgIen
		>S XMZ=3
		Procedure Call:
		>D COPYAMT^XMWSOA06(XMZ,"3")
		
		Expected Output:
		>ZW RETURN
		RETURN=1

	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC1CopyAmt005() { 
		
//		if(!this.msgResponsePopulated) { 
//			// try to populate, if we can't fail
//			if(!initMailMessage()) { 
//				fail(ERR_MSG_NOT_POP);
//			}
//		}
//		request = new XMXSEC1CopyAmtRequest(msgResponse.getMsgIen(), "3");
//		response = service.CopyAmt(request);
//		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
//			LOGGER.warn(XMXSEC1Constants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
//		}
//
//		assertNotNull(response);
//		LOGGER.info("\nResult CopyAmountOK --> " + response.getCopyAmountOK() + "\n");
//		assertEquals("1", response.getCopyAmountOK());
		
	}
	
	/**
	 * <em>Test Case #6  </em>
	 * Try to call the API with no message IEN
	 	Input Data:
		>S XMZ=""
		>S XMZ=0
		Procedure Call:
		>D COPYAMT^XMWSOA06("","0")
		
		Expected Output:
		>ZW RETURN
		RETURN=-1^Error in required input

	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC1CopyAmt006() { 

		request = new XMXSEC1CopyAmtRequest("", "0");
		response = service.CopyAmt(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMXSEC1Constants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult CopyAmountOK --> " + response.getCopyAmountOK() + "\n");
		assertEquals("-1^Error in required input", response.getMsgRoot().get(0));
	}
}

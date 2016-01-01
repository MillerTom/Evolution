package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1CopyRecpEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyRecpRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyRecpResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.utils.XMXSEC1Constants;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XMXSEC1CopyRecpIT extends VistaLinkContextITParent {

	private static Logger LOGGER = Logger.getLogger(XMXSEC1CopyRecpIT.class);
	private static final String ERR_MSG_NOT_POP = "Failed to populate a new mail message in VistA";

	@Autowired
	XMXSEC1CopyRecpEndpoint service;
	XMXSEC1CopyRecpRequest request;
	XMXSEC1CopyRecpResponse response;
	
	
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
//		if(msgCreator.createMailMessage(msgService,"Test Subject for XMXSEC1CopyRecpIT", "", null)) { 
//			this.msgResponsePopulated = msgCreator.isMsgResponsePopulated();
//			this.msgResponse = msgCreator.getMsgResponse();
//		}
//		return this.msgResponsePopulated;
//	}
	public XMXSEC1CopyRecpIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * Check the number of recipients for a message.
	 Input Data:
		>S XMZ=msgIen
		
		Procedure Call:
		>D COPYRECP^XMWSOA06(XMZ)
		
		Expected Output:
		>ZW RETURN
		RETURN=1


	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC1CopyRecp001() { 
//		if(initMailMessage()) { 
//			LOGGER.info("Successfully created new mail message for XMA2R^ENTA, IEN = " 
//					+ this.msgResponse.getMsgIen());
//		}else { 
//			LOGGER.error("Failed to create new mail message for XMA2R^ENTA");
//		}

//		if(!this.msgResponsePopulated) { 
//			// try to populate, if we can't fail
//			if(!initMailMessage()) { 
//				fail(ERR_MSG_NOT_POP);
//			}else { 
//				request = new XMXSEC1CopyRecpRequest(msgResponse.getMsgIen());
//				response = service.CopyRecp(request);
//				if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
//					LOGGER.warn(XMXSEC1Constants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
//				}
//				
//				assertNotNull(response);
//				LOGGER.info("\nResult getMsgOK --> " + response.getMsgOK() + "\n");
//				assertEquals("1", response.getMsgOK());
//			}
//		}
		
	}
	
	/**
	 * <em>Test Case #2  </em>
	 * Check a non-existent message
	 	Input Data:
		>S XMZ=9999999
		
		Procedure Call:
		>D COPYRECP^XMWSOA06(XMZ)
		
		Expected Output:
		>ZW RETURN
		RETURN=-1^Message not found


	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC1CopyRecp002() { 

		request = new XMXSEC1CopyRecpRequest("999999");
		response = service.CopyRecp(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMXSEC1Constants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult getMsgOK --> " + response.getMsgOK() + "\n");
		assertEquals("-1^Message not found", response.getMsgRoot().get(0));

	}
	
	/**
	 * <em>Test Case #3  </em>
	 * Try to call the API with no message IEN
	 	Input Data:
		>S XMZ=""
		
		Procedure Call:
		>D COPYRECP^XMWSOA06(XMZ)
		
		Expected Output:
		>ZW RETURN
		RETURN=-1^Error in required input


	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC1CopyRecp003() { 
		request = new XMXSEC1CopyRecpRequest("");
		response = service.CopyRecp(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMXSEC1Constants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult getMsgOK --> " + response.getMsgOK() + "\n");
		assertEquals("-1^Error in required input", response.getMsgRoot().get(0));

	}
	
	
	/**
	 * <em>Test Case #4  </em>
	 * Try to call the API with an invalid XMZ parameter
	 	Input Data:
		>S XMZ="A"
		
		Procedure Call:
		>D COPYRECP^XMWSOA06(XMZ)
		
		Expected Output:
		>ZW RETURN
		RETURN=-1^Error in required input


	 * 
	 * </pre>
	 */
	@Test
	public void jtestXMXSEC1CopyRecp004() { 

		request = new XMXSEC1CopyRecpRequest("A");
		response = service.CopyRecp(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMXSEC1Constants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nResult getMsgOK --> " + response.getMsgOK() + "\n");
		assertEquals("-1^Error in required input", response.getMsgRoot().get(0));

	}
	
}

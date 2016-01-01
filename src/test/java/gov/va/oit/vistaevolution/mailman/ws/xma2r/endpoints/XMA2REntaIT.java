package gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.XMA2REntaEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaResponse;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.util.XMA2RConstants;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for ENTA method of XMA2R Webservice
 */
public class XMA2REntaIT extends EvolutionIT<XMA2REntaEndpoint> {
	private static final String ERR_MSG_NOT_POP = "Failed to populate a new mail message in VistA";
	
	private String newMailMessageIEN = "";
	private XMA2REntaRequest request;
	private XMA2REntaResponse response;
	private static Logger LOGGER = Logger.getLogger(XMA2REntaIT.class);
	private boolean msgPopulated = false;
	
	@Before
	public void setUp() {
		request = new XMA2REntaRequest();
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
			msgPopulated=true;
		}else { 
			LOGGER.error("Service was null");
		}
		
	}
	

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Send a response to a message. Use the IEN of the test message and the
	 * name of the user (yourself) that created the test message.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K XMTEXT
	 * >S XMZ=278219
	 * >S XMSUB="ZZ VISTA API EXPOSURE ENTA-XMWSOA02"
	 * >S XMTEXT(1)="The VISTA EVOLUTION Test Case Scenario"
	 * >S XMTEXT(2)="Test case for API $$ENTA^XMA2R"
	 * >S XMSTRIP=""
	 * >S XMDUZ="CUNNINGHAM,ALLEN"
	 * 
	 * Procedure Call:
	 * >D ENTA^XMWSOA02(.RETURN,XMZ,XMSUB,.XMTEXT,XMSTRIP,XMDUZ)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=278233
	 * 
	 * </pre>
	 */
	@Test
	public void sendResponseToAMessage() throws VistaWebServiceFault {

		
		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}
		List<String> xmtext = new ArrayList<String>();
		xmtext.add("The VISTA EVOLUTION Test Case Scenario");
		xmtext.add("Test case for API $$ENTA^XMA2R");

		request = new XMA2REntaRequest(
				this.newMailMessageIEN,
				"ZZ VISTA API EXPOSURE ENTA-XMWSOA02",
				xmtext, 
				"",
				"1"
				);

		response = service.enta(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMA2RConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nReply MSG IEN --> " + response.getResult() + "\n");
		assertTrue("MSG IEN is Greater than 0", Integer.parseInt(response.getResult()) > 0);

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error in required input. Use the IEN of the original test message and no
	 * message text.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMTEXT
	 * >S XMZ=278219
	 * >S XMSUB="ZZ VISTA API EXPOSURE ENTA-XMWSOA02"
	 * >S XMTEXT=""
	 * >S XMSTRIP=""
	 * >S XMDUZ="CUNNINGHAM,ALLEN"
	 *  
	 * Procedure Call:
	 * >D ENTA^XMWSOA02(.RETURN,XMZ,XMSUB,.XMTEXT,XMSTRIP,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testNullMsgText() throws VistaWebServiceFault {

		
		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}
		List<String> xmtext = new ArrayList<String>();
		xmtext.add("The VISTA EVOLUTION Test Case Scenario");
		xmtext.add("Test case for API $$ENTA^XMA2R");

		request = new XMA2REntaRequest(
				this.newMailMessageIEN,
				"ZZ VISTA API EXPOSURE ENTA-XMWSOA02",
				null, // msg text is null
				"",
				"1"
				);

		response = service.enta(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMA2RConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nReply MSG IEN --> " + response.getResult() + "\n");
		assertEquals("invalid input XMTEXT - required.  Missing the array containing the text of the message,  call to ENTA^XMA2R Service will fail for lack of neccessary input.", 
				response.getMsgRoot().get(0));
		

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error: Subject must be at least 3 chars long.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K XMTEXT
	 * >S XMZ=278219
	 * >S XMSUB="Vi"
	 * >S XMTEXT(1)="The VISTA EVOLUTION Test Case Scenario"
	 * >S XMTEXT(2)="Test case for API $$ENTA^XMA2R"
	 * >S XMSTRIP=""
	 * >S XMDUZ="CUNNINGHAM,ALLEN"
	 * 
	 * Procedure Call:
	 * >D ENTA^XMWSOA02(.RETURN,XMZ,XMSUB,.XMTEXT,XMSTRIP,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^SUBJECT must be at least 3 characters long."
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testSubjectIsTooShort() throws VistaWebServiceFault {

	if(!this.msgPopulated) { 

		fail(ERR_MSG_NOT_POP);

	}
		List<String> xmtext = new ArrayList<String>();
		xmtext.add("The VISTA EVOLUTION Test Case Scenario");
		xmtext.add("Test case for API $$ENTA^XMA2R");

		request = new XMA2REntaRequest(
				this.newMailMessageIEN,
				"VI", // subect too short
				xmtext, 
				"",
				"1"
				);

		response = service.enta(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMA2RConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nReply MSG IEN --> " + response.getResult() + "\n");
		assertEquals("SUBJECT must be at least 3 characters long.", 
				response.getMsgRoot().get(1));

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Error: Subject text is too long.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K XMTEXT
	 * >S XMZ=278219
	 * >S XMSUB="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
	 * >S XMTEXT(1)="The VISTA EVOLUTION Test Case Scenario"
	 * >S XMTEXT(2)="Test case for API $$ENTA^XMA2R"
	 * >S XMSTRIP=""
	 * >S XMDUZ="CUNNINGHAM,ALLEN"
	 * 
	 * Procedure Call:
	 * >D ENTA^XMWSOA02(.RETURN,XMZ,XMSUB,.XMTEXT,XMSTRIP,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Entered SUBJECT too long, 8 characters longer than 65."
	 * 
	 * </pre>
	 */
	@Test
	public void testSubjectIsTooLong() throws VistaWebServiceFault {

		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}
		List<String> xmtext = new ArrayList<String>();
		xmtext.add("The VISTA EVOLUTION Test Case Scenario");
		xmtext.add("Test case for API $$ENTA^XMA2R");

		request = new XMA2REntaRequest(
				this.newMailMessageIEN,
				"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", // subect too long
				xmtext, 
				"",
				"1"
				);

		response = service.enta(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMA2RConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nReply MSG IEN --> " + response.getResult() + "\n");
		assertEquals("Entered SUBJECT too long, 8 characters longer than 65.", 
				response.getMsgRoot().get(1));
	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * Error: Message not found.
	 * 
	 * <pre>
	 * >K XMTEXT
	 * >S XMZ="999999123"
	 * >S XMSUB="ZZ VISTA API EXPOSURE ENTA-XMWSOA02"
	 * >S XMTEXT(1)="The VISTA EVOLUTION Test Case Scenario"
	 * >S XMTEXT(2)="Test case for API $$ENTA^XMA2R"
	 * >S XMSTRIP=""
	 * >S XMDUZ="CUNNINGHAM,ALLEN"
	 *  
	 * Procedure Call:
	 * >D ENTA^XMWSOA02(.RETURN,XMZ,XMSUB,.XMTEXT,XMSTRIP,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Message not found"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testBogusIen() throws VistaWebServiceFault {

		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}		
		List<String> xmtext = new ArrayList<String>();
		xmtext.add("The VISTA EVOLUTION Test Case Scenario");
		xmtext.add("Test case for API $$ENTA^XMA2R");

		request = new XMA2REntaRequest(
				"999999999", //this.newMailMessageIEN,
				"ZZ VISTA API EXPOSURE ENTA-XMWSOA02", 
				xmtext, 
				"",
				"1"
				);

		response = service.enta(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMA2RConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nReply MSG IEN --> " + response.getResult() + "\n");
		assertEquals("Message not found", 
				response.getMsgRoot().get(1));

	}

	/**
	 * <em>Test Case #6  </em>
	 * 
	 * Error: Subject cannot contain control characters.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K XMTEXT
	 * >S XMZ=278219
	 * >S XMSUB="ZZ VISTA API EXPOSURE ENTA-XMWSOA02" +CntrlC 
	 * >S XMTEXT(1)="The VISTA EVOLUTION Test Case Scenario"
	 * >S XMTEXT(2)="Test case for API $$ENTA^XMA2R"
	 * >S XMSTRIP=""
	 * >S XMDUZ="CUNNINGHAM,ALLEN"
	 *  
	 * Procedure Call:
	 * >D ENTA^XMWSOA02(.RETURN,XMZ,XMSUB,.XMTEXT,XMSTRIP,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Subject cannot contain control characters.^ZZ VISTA API EXPOSURE ENTA"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testSubjectWithControlChars() throws VistaWebServiceFault {
		
		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}
		List<String> xmtext = new ArrayList<String>();
		char ctrlC = 0x3;
		xmtext.add("The VISTA EVOLUTION Test Case Scenario");
		xmtext.add("Test case for API $$ENTA^XMA2R" );

		request = new XMA2REntaRequest(
				this.newMailMessageIEN,
				"ZZ VISTA API EXPOSURE ENTA-XMWSOA02 " + ctrlC, 
				xmtext, 
				"",
				"1"
				);

		response = service.enta(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMA2RConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nReply MSG IEN --> " + response.getResult() + "\n");
		assertEquals("Subject cannot contain control characters.", 
				response.getMsgRoot().get(1));
		//assertTrue("MSG IEN is Greater than 0", Integer.parseInt(response.getResult()) > 0);

	}

	/**
	 * <em>Test Case #7  </em>
	 * 
	 * Error: Addressee not found.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMTEXT
	 * >S XMZ=278219
	 * >S XMSUB="ZZ VISTA API EXPOSURE ENTA-XMWSOA02"
	 * >S XMTEXT(1)="The VISTA EVOLUTION Test Case Scenario"
	 * >S XMTEXT(2)="Test case for API $$ENTA^XMA2R"
	 * >S XMSTRIP=""
	 * >S XMDUZ="2122"
	 *  
	 * Procedure Call:
	 * >D ENTA^XMWSOA02(.RETURN,XMZ,XMSUB,.XMTEXT,XMSTRIP,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^E11 Addressee not found"
	 * 
	 * </pre>
	 */
	@Test
	public void testInvalidAddressee() throws VistaWebServiceFault {

		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}
		List<String> xmtext = new ArrayList<String>();
		xmtext.add("The VISTA EVOLUTION Test Case Scenario");
		xmtext.add("Test case for API $$ENTA^XMA2R" );

		request = new XMA2REntaRequest(
				this.newMailMessageIEN,
				"ZZ VISTA API EXPOSURE ENTA-XMWSOA02", 
				xmtext, 
				"",
				"999999"
				);

		response = service.enta(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMA2RConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nReply MSG IEN --> " + response.getResult() + "\n");
		assertEquals("E11 Addressee not found.", 
				response.getMsgRoot().get(1));
	}

	/**
	 * <em>Test Case #8  </em>
	 * 
	 * Send an answer to the test message using the user’s DUZ.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMTEXT
	 * >S XMZ=278219
	 * >S XMSUB="ZZ VISTA API EXPOSURE ENTA-XMWSOA02"
	 * >S XMTEXT(1)="Test message using DUZ."
	 * >S XMSTRIP=""
	 * >S XMDUZ="83323"     This is my DUZ. Yours will be different.
	 *  
	 * Procedure Call:
	 * >D ENTA^XMWSOA02(.RETURN,XMZ,XMSUB,.XMTEXT,XMSTRIP,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=278270
	 * 
	 * </pre>
	 */
	@Test
	public void sendAnswerToOriginalMessage() throws VistaWebServiceFault {

		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}
		List<String> xmtext = new ArrayList<String>();
		xmtext.add("The VISTA EVOLUTION Test Case Scenario");
		xmtext.add("Test case for API $$ENTA^XMA2R" );

		request = new XMA2REntaRequest(
				this.newMailMessageIEN,
				"ZZ VISTA API EXPOSURE ENTA-XMWSOA02", 
				xmtext, 
				"",
				"1"
				);

		response = service.enta(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMA2RConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nReply MSG IEN --> " + response.getResult() + "\n");
		assertTrue("MSG IEN is Greater than 0", Integer.parseInt(response.getResult()) > 0);

	}

	/**
	 * <em>Test Case #9  </em>
	 * 
	 * Remove the “^” character from the message text.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMTEXT
	 * >S XMZ=278219
	 * >S XMSUB="ZZ VISTA API EXPOSURE ENTA-XMWSOA02”
	 * >S XMTEXT(1)="Test to Remove shift 6. (Test Case ^^ Scenario)"
	 * >S XMTEXT(2)="Test case for Remote Procedure ENTA-^XMWSOA02"
	 * >S XMSTRIP=""
	 * >S XMDUZ="1"
	 * 
	 * Procedure Call:
	 * >D ENTA^XMWSOA02(.RETURN,XMZ,XMSUB,.XMTEXT,XMSTRIP,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=278238           Your IEN value will be different
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void removeSpecifiedCharFromMessageText() throws VistaWebServiceFault {

		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}
		List<String> xmtext = new ArrayList<String>();
		xmtext.add("Test to Remove shift 6. (Test Case ^^ Scenario)");
		xmtext.add("Test case for Remote Procedure ENTA-^XMWSOA02");

		request = new XMA2REntaRequest(
				this.newMailMessageIEN,
				"ZZ VISTA API EXPOSURE ENTA-XMWSOA02", 
				xmtext, 
				"",
				"1"
				);

		response = service.enta(request);
		if(response.getMsgRoot() != null && response.getMsgRoot().size() > 0) { 
			LOGGER.warn(XMA2RConstants.ERR_MSG_GEN + ", msgRoot var:" + StrUtils.listToString(response.getMsgRoot()));
		}

		assertNotNull(response);
		LOGGER.info("\nReply MSG IEN --> " + response.getResult() + "\n");
		assertTrue("MSG IEN is Greater than 0", Integer.parseInt(response.getResult()) > 0);

		
	}

	@Override
	protected Class<XMA2REntaEndpoint> getType() {
		return XMA2REntaEndpoint.class;
	}
}

package gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.XMA2REntEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
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
 * @author Steve Orleski<sorleski@caci.com>
 * 
 *         Integration Test for ENT method of XMA2R Webservice
 */
public class XMA2REntIT extends EvolutionIT<XMA2REntEndpoint> {
	private static Logger LOGGER = Logger.getLogger(XMA2REntIT.class);
	private String newMailMessageIEN = "";
	private boolean msgPopulated = false;
	private static final String ERR_MSG_NOT_POP = "Failed to populate a new mail message in VistA";
	
	private XMA2REntRequest request;
	private XMA2REntResponse response;

	@Before
	public void setUp() {
		request = new XMA2REntRequest();
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

	/* 
	 * <em>
	 * This RPC creates and sends a reply to a message and returns the message number 
	 * of the reply. If the reply is not successful, the RPC returns a string with the 
	 * text of the error. Unlike an answer, a reply is sent to all (local) recipients 
	 * of the message to which you are replying. The sender of the reply must be a 
	 * recipient of the original message
	 * </em>
	 */
	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error message â€œ-1^Error in required inputâ€�. Parameter XMZ is set to null.
	 * 
	 * <pre>
	 Input Data:
		>K XMTEXT
		>S DUZ=1
		>S XMZ=this.newMailMessageIEN // from the 
		>S XMSUBJ="VISTA API EXPOSURE ENT-XMA2R"
		>S XMTEXT(1)=" Test Case for API ENT^--XMA2R."
		>S XMSTRIP="-"
		>S XMDUZ="1"
		>S XMNET=0

		Procedure Call:
		>D ENT^XMWSOA01(.RETURN,XMZ,XMSUBJ,.XMTEXT,XMSTRIP,XMDUZ,XMNET) 

		Expected Output:
		>ZW RETURN
		RETURN="-1^Error in required input"


	 * 
	 * </pre>
	 */
	@Test
	public void testNullMsgIen() throws VistaWebServiceFault {
		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}
		List<String> xmtext = new ArrayList<String>();
		xmtext.add("Test Case for API ENT^--XMA2R.");

		request = new XMA2REntRequest(
				null,
				"ZZ VISTA TEST API ENT-XMA2R",
				xmtext,
				"-",
				"1", 
				"0");

		response = service.ent(request);
		assertNotNull(response);
		assertEquals("invalid input XMZ - required.  Missing Message IEN,  call to ENT^XMA2R Service will fail for lack of neccessary input.", response.getMsgRoot().get(0));


	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error message â€œ-1^Error in required inputâ€�. Parameter XMSUBJ is set to
	 * null.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K XMTEXT
	 * >S XMZ="278615"
	 * >S XMSUBJ=""
	 * >S XMTEXT(1)="Test Case for API ENT^--XMA2R."
	 * >S XMSTRIP="-"
	 * >S XMDUZ=DUZ
	 * >S XMNET=0
	 * 
	 * Procedure Call:
	 * >D ENT^XMWSOA01(.RETURN,XMZ,XMSUBJ,.XMTEXT,XMSTRIP,XMDUZ,XMNET) 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testNullMsgSubject() throws VistaWebServiceFault {
		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}
		List<String> xmtext = new ArrayList<String>();
		xmtext.add("Test Case for API ENT^--XMA2R.");

		request = new XMA2REntRequest(
				this.newMailMessageIEN, 
				"", // set subject to null
				xmtext,
				"-",
				"1", 
				"0");

		response = service.ent(request);
		assertNotNull(response);
		assertEquals("invalid input XMSUBJ - required.  Missing Subject of the message,  call to ENT^XMA2R Service will fail for lack of neccessary input.", response.getMsgRoot().get(0));

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error message â€œ-1^Error in required inputâ€�. Parameter XMTEXT is set to
	 * null.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K XMTEXT
	 * >S XMZ="278615"
	 * >S XMSUBJ="ZZ VISTA TEST API ENT-XMA2R"
	 * >S XMTEXT(1)=""
	 * >S XMSTRIP="-"
	 * >S XMDUZ=DUZ
	 * >S XMNET=0
	 * 
	 * Procedure Call:
	 * >D ENT^XMWSOA01(.RETURN,XMZ,XMSUBJ,.XMTEXT,XMSTRIP,XMDUZ,XMNET)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testNullMsgBody() throws VistaWebServiceFault {
		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}

		List<String> xmtext = new ArrayList<String>();
		xmtext.add("Test Case for API ENT^--XMA2R.");

		request = new XMA2REntRequest(
				this.newMailMessageIEN, 
				"ZZ VISTA TEST API ENT-XMA2R", 
				null, // set xmtext to null
				"-",
				"1", 
				"0");

		response = service.ent(request);
		assertNotNull(response);
		assertEquals("invalid input XMTEXT - required.  Missing the array containing the text of the message,  call to ENT^XMA2R Service will fail for lack of neccessary input.", response.getMsgRoot().get(0));

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Error message â€œ-1^Error in required inputâ€�. Parameter XMDUZ is set to
	 * null.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMTEXT
	 * >S XMZ="278615"
	 * >S XMSUBJ="ZZ VISTA TEST API ENT-XMA2R"
	 * >S XMTEXT(1)="Test Case for API ENT^--XMA2R."
	 * >S XMSTRIP="-"
	 * >S XMDUZ=""
	 * >S XMNET=0
	 * 
	 * Procedure Call:
	 * >D ENT^XMWSOA01(.RETURN,XMZ,XMSUBJ,.XMTEXT,XMSTRIP,XMDUZ,XMNET)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testNullMsgDuz() throws VistaWebServiceFault {
		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}

		List<String> xmtext = new ArrayList<String>();
		xmtext.add("Test Case for API ENT^--XMA2R.");

		request = new XMA2REntRequest(
				this.newMailMessageIEN, 
				"ZZ VISTA TEST API ENT-XMA2R", 
				xmtext, 
				"-",
				"", // set duz to null 
				"0");

		response = service.ent(request);
		assertNotNull(response);
		assertEquals("invalid input XMDUZ - required.  Missing User's DUZ or Name of Sender(LastName,FirstName),  call to ENT^XMA2R Service will fail for lack of neccessary input.", response.getMsgRoot().get(0));

	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * Error message â€œ-1^Message not foundâ€�. Parameter XMZ is a bogus IEN.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K XMTEXT
	 * >S XMZ="999999999"
	 * >S XMSUBJ="ZZ VISTA TEST API ENT-XMA2R"
	 * >S XMTEXT(1)="Test Case for API ENT^--XMA2R."
	 * >S XMSTRIP="-"
	 * >S XMDUZ=111
	 * >S XMNET=0
	 * 
	 * Procedure Call:
	 * >D ENT^XMWSOA01(.RETURN,XMZ,XMSUBJ,.XMTEXT,XMSTRIP,XMDUZ,XMNET)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Message not found"
	 * 
	 * </pre>
	 */
	@Test
	public void testBogusMsgIen() throws VistaWebServiceFault {
		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}

		List<String> xmtext = new ArrayList<String>();
		xmtext.add("Test Case for API ENT^--XMA2R.");

		request = new XMA2REntRequest(
				"999999999", // bogus msg IEN  
				"ZZ VISTA TEST API ENT-XMA2R", 
				xmtext, 
				"-",
				"1", 
				"0");

		response = service.ent(request);
		assertNotNull(response);
		assertEquals("Message not found", response.getMsgRoot().get(1));

	}

	/**
	 * <em>Test Case #6  </em>
	 * 
	 * Error message â€œ-1^Sender is not a recipient of the messageâ€�. Parameter
	 * XMDUZ is a bogus DUZ.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMTEXT
	 * >S XMZ="278615"
	 * >S XMSUBJ="ZZ VISTA TEST API ENT-XMA2R"
	 * >S XMTEXT(1)="Test Case for API ENT^--XMA2R."
	 * >S XMSTRIP="-"
	 * >S XMDUZ="999999999"
	 * >S XMNET=0
	 * 
	 * Procedure Call:
	 * >D ENT^XMWSOA01(.RETURN,XMZ,XMSUBJ,.XMTEXT,XMSTRIP,XMDUZ,XMNET)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Sender is not a recipient of the message"
	 * 
	 * </pre>
	 */
	@Test
	public void testSenderNotARecipient() throws VistaWebServiceFault {
		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}

		List<String> xmtext = new ArrayList<String>();
		xmtext.add("Test Case for API ENT^--XMA2R.");

		request = new XMA2REntRequest(
				this.newMailMessageIEN, // bogus msg IEN  
				"ZZ VISTA TEST API ENT-XMA2R", 
				xmtext, 
				"-",
				"999999999",  // bogus duz
				"0");

		response = service.ent(request);
		assertNotNull(response);
		assertEquals("Sender is not a recipient of the message", response.getMsgRoot().get(1));

	}

	/**
	 * <em>Test Case #7  </em>
	 * 
	 * Reply to the test MailMan message and remove any - characters from the
	 * text message.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMTEXT
	 * >S XMZ="278615"
	 * >S XMSUBJ="ZZ VISTA TEST API ENT-XMA2R"
	 * >S XMTEXT(1)="Test Case for API ENT^--XMA2R."
	 * >S XMSTRIP="-"
	 * >S XMDUZ=DUZ
	 * >S XMNET=0
	 * 
	 * Procedure Call:
	 * >D ENT^XMWSOA01(.RETURN,XMZ,XMSUBJ,.XMTEXT,XMSTRIP,XMDUZ,XMNET)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=278623
	 * 
	 * </pre>
	 */
	@Test
	public void testRemoveOfSpecifiedCharacterFromMsgBodyText() throws VistaWebServiceFault {
		if(!this.msgPopulated) { 

			fail(ERR_MSG_NOT_POP);

		}
		List<String> xmtext = new ArrayList<String>();
		xmtext.add("Test Case for API ENT^--XMA2R.");

		request = new XMA2REntRequest(
				this.newMailMessageIEN, 
				"ZZ VISTA TEST API ENT-XMA2R", 
				xmtext, 
				"-",
				"1",  // bogus duz
				"0");

		response = service.ent(request);
		System.out.println("\nMSG IEN --> " + response.getResult() + "\n");
		assertNotNull(response);
		//assertTrue("IEN is Greater than 0", Integer.parseInt(response.getResult()) > 0);
	}

	@Override
	protected Class<XMA2REntEndpoint> getType() {
		return XMA2REntEndpoint.class;
	}



}

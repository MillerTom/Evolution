/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.interfaces.XMA2XmzEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/*
 * NAME: XMWSOA EN1                        TAG: EN1
 * 
 * This RPC calls the XMZ^XMA2 API to create a message stub.  If this
 * fails, the RPC returns an error message.  If the call was successful,
 * the RPC then calls the API, EN1^XMD to add text and recipients and send
 * the message.
 * 
 * Returns:
 *   0^Successful
 *   -1^Error in required input
 *   -1^Failed to create message stub
 *   -1^DUZ not found
 *   -1^Subject names of this format (1"R"1.N) are RESERVED
 *   -1^SUBJECT must be at least 3 characters long.
 *   -1^Entered SUBJECT too long, <number> characters longer than 65.
 *   -1^Subject cannot contain control characters.
 *   
 *   Input Parameters:
 *   
 *   DUZ	(Required String) Sender's DUZ.
 *   MSG	(Required List) An array containing the text to be added to the message.
 *   XMY    (Required List) Addressee array, XMY(x)="", where x can be:
 *     			User's DUZ or enough of the user's name for a positive ID. For example:
 *     	         XMY(1301)="" OR XMY("lastname,first")=""
 *     		     G.group name (enough for positive ID). For example:
 *         		 XMY("G.group name")=""
 *         		 S.server name (enough for positive ID).
 *         		 D.device name (enough for positive ID).
 *              Prefix the above (except devices and servers) by:
 *              	I: for "Information Only" recipient (cannot reply). For example:
 *                        XMY("I:1301")="" or XMY("I:lastname,first")=""
 *                  C: for "Copy" recipient (not expected to reply). For example:
 *                        XMY("C:1301")="" or XMY("C:lastname,first")=""
 *                  L@datetime: for when (in future) to send to this recipient (datetime
 *                  	can be anything accepted by VA FileMan). For example:
 *                  	    XMY("L@25 DEC@0500:1301")="" or XMY("L@1 JAN:lastname,first")="" or
 *                            XMY("L@2981225.05:1301")=""
 *                            (Can combine IL@datetime: or CL@datetime:)
 *             To delete any recipient (including users, groups, devices, and
 *              	servers, prefix with a hyphen/dash ("-"). For example:
 *                        XMY(-1301)="" or XMY("-lastname,first")=""
 *             To address any recipient (including users, groups, devices, and
 *             		servers) at a remote site, just add the @site name. For example:
 *             			  XMY(recipient@site name)=""
 *  XMSUB	(Required String)Subject of the message.  It should be from 3 to 65 characters 
 *  		in length. If it is less than 3 characters,then three dots ("...") will be appended
 *  		to it.  If it is more than 65 characters, then it will be truncated.
 *  		Subject 'Rnnn' is reserved.
 *  XMSTRIP (Optional String) String containing characters that should be removed from 
 *  		the message text. The default is none.
 *  XMDF    (Optional String)If XMDF is defined, addressing restrictions are waived.
 *  		Addressing restrictions are:
 *  			> Restrict  "domain closed"
 *  			> Restrict  "keys required for domain"
 *  			> Restrict  "may not forward to domain"
 *  			> Restrict  "may not forward priority mail to groups"
 *  			> Restrict  "message length restrictions to remote addresses"
 * 
 */
public class XMA2XmzIT extends EvolutionIT<XMA2XmzEndpoint> {
	private final String EXPECTED_SUCCESS_MESSAGE = "0^Successful";
	private final String EXPECTED_FAILURE_REQUIRED_INPUT_MESSAGE ="-1^Error in required input";
	private final String EXPECTED_FAILURE_CREATE_MSG_STUB_MESSAGE ="-1^Failed to create message stub";
	private final String EXPECTED_FAILURE_DUZ_NOT_FOUND_MESSAGE ="-1^DUZ not found";
	private final String EXPECTED_FAILURE_RESERVED_MESSAGE ="-1^Subject names of this format (1\"R\"1.N) are RESERVED";
	private final String EXPECTED_FAILURE_SUBJECT_TOO_SHORT_MESSAGE ="-1^SUBJECT must be at least 3 characters long.";
	private final String EXPECTED_FAILURE_SUBJECT_TOO_LONG_MESSAGE ="-1^Entered SUBJECT too long";
	private final String EXPECTED_FAILURE_CONTROL_CHARS_MESSAGE ="-1^Subject cannot contain control characters.";

	@Override
	protected Class<XMA2XmzEndpoint> getType() {
		return XMA2XmzEndpoint.class;
	}

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMA2XmzIT.class);

	private XMA2XmzRequest request;
	private XMA2XmzResponse response;

	@Before
	public void setUp() {
		request = new XMA2XmzRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * Test Case #1  Error in required input
	 * 
	 * >S MSG(1)="A TEST MESSAGE"
	 * >S XMSUB="A RPC CALL TEST MESSAGE"
	 * >S XMSTRIP="*^"
	 * >S MSG(1)="A TEST MESSAGE*********  2",MSG(2)="REPEAT T^^^HIS IS ONLY "
	 * >D EN1^XMWSOA02(.RETURN,DUZ,.MSG,,XMSUB,,XMSTRIP)
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmz001() throws VistaWebServiceFault {

		HashMap <String, String> xmys = new HashMap<String, String>();
		ArrayList <String>msgs = new ArrayList<String>();
		
		request.setDuz("");
	
		msgs.add("A TEST MESSAGE");
		msgs.add("A TEST MESSAGE*********  2");
		msgs.add("REPEAT T^^^HIS IS ONLY ");
		request.setMsgs(msgs);
	
		xmys.put("83320","");
		request.setXmys(xmys);
		
		request.setXmSub("A RPC CALL TEST MESSAGE");
		request.setXmStrip("*^");
		request.setXmDf("");
		
		// Execute request against mocked object backend.
		response = service.xmz(request);
	
		assertNotNull(response);
		assertEquals(EXPECTED_FAILURE_REQUIRED_INPUT_MESSAGE, response.getResults());
	}

	/**
	 * Test Case #2  Successful
	 * 
	 * >S DUZ=.5
	 * >S MSG(1)="A TEST MESSAGE"
	 * >S MSG(1)="A TEST MESSAGE",MSG(2)="REPEAT THIS IS ONLY A TEST"
	 * >S XMY(83320)="",
	 * >S XMY(.6)=""
	 * >S XMSUB="A RPC CALL TEST MESSAGE"
	 * >D EN1^XMWSOA02(.RETURN,DUZ,.MSG,.XMY,XMSUB)
	 * 
	 * >ZW RETURN
	 * RETURN="0^Successful"
	 * 
	 * IN Basket, 6 messages (1-6), 5 new
	 * *=New/!=Priority.......Subject........................From.....................
	 * *1. DATA UPDATE FOR NDF                              NDF MANAGER
	 * *2. UPDATED INTERACTIONS                             NDF MANAGER
	 * !3. DRUGS UNMATCHED FROM NATIONAL DRUG FILE          NDF MANAGER
	 * *4. INTERACTIONS and ALLERGIES UPDATED               NDF MANAGER
	 * *5. Products with changed classes                    NDF MANAGER
	 *   6. A RPC CALL TEST MESSAGE                          CARPENTER,KEVIN
	 *   IN Basket Message: 1// 6
	 *   
	 *   Subj: A RPC CALL TEST MESSAGE  [#277737] 01/31/14@10:29:05  2 lines
	 *   From: CARPENTER,KEVIN  In 'IN' basket.   Page 1
	 *   -------------------------------------------------------------------------------
	 *   A TEST MESSAGE
	 *   REPEAT THIS IS ONLY A TEST
	 *   
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmz002() throws VistaWebServiceFault {

		HashMap <String, String> xmys = new HashMap<String, String>();
		ArrayList <String>msgs = new ArrayList<String>();
		
		request.setDuz(".5");
	
		msgs.add("A TEST MESSAGE");
		msgs.add("REPEAT THIS IS ONLY A TEST");
		request.setMsgs(msgs);
	
		xmys.put("83320","");
		xmys.put(".6","");
		request.setXmys(xmys);
		
		request.setXmSub("A RPC CALL TEST MESSAGE");
		request.setXmStrip("");
		request.setXmDf("");
		
		// Execute request against mocked object backend.
		response = service.xmz(request);
	
		assertNotNull(response);
		assertEquals(EXPECTED_SUCCESS_MESSAGE, response.getResults());
	}

	/**
	 * Test Case #3  Successful
	 * >S DUZ=.5
	 * >S XMSUB="A RPC CALL TEST MESSAGE"
	 * >S XMSTRIP="*^"
	 * >S MSG(1)="A TEST MESSAGE 2",MSG(2)="REPEAT T^^^HIS IS ONLY"
	 * >S XMY(97843598347593874)=""
	 * >D EN1^XMWSOA02(.RETURN,DUZ,.MSG,.XMY,XMSUB,,XMSTRIP)
	 * 
	 * >ZW RETURN
	 * RETURN="0^Successful"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmz003() throws VistaWebServiceFault {

		HashMap <String, String> xmys = new HashMap<String, String>();
		ArrayList <String>msgs = new ArrayList<String>();
		
		request.setDuz(".5");
	
		msgs.add("A TEST MESSAGE 2");
		msgs.add("REPEAT T^^^HIS IS ONLY");
		request.setMsgs(msgs);
	
		xmys.put("97843598347593874","");
		request.setXmys(xmys);
		
		request.setXmSub("A RPC CALL TEST MESSAGE");
		request.setXmStrip("*^");
		request.setXmDf("");
		
		// Execute request against mocked object backend.
		response = service.xmz(request);
	
		assertNotNull(response);
		assertEquals(EXPECTED_SUCCESS_MESSAGE, response.getResults());
	}

	/**
	 * Test Case #4  Error in required input
	 * 
	 * >S DUZ=.5
	 * >S MSG(1)="A TEST MESSAGE"
	 * >S XMSUB="A RPC CALL TEST MESSAGE"
	 * >S XMSTRIP="*^"
	 * >S MSG(1)="A TEST MESSAGE 2",MSG(2)="REPEAT T^^^HIS IS ONLY"
	 * >D EN1^XMWSOA02(.RETURN,DUZ,.MSG,,XMSUB,,XMSTRIP)
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmz004() throws VistaWebServiceFault {

		HashMap <String, String> xmys = new HashMap<String, String>();
		ArrayList <String>msgs = new ArrayList<String>();
		
		request.setDuz(".5");
	
		msgs.add("A TEST MESSAGE");
		msgs.add("A TEST MESSAGE 2");
		msgs.add("REPEAT T^^^HIS IS ONLY");
		request.setMsgs(msgs);
	
//		xmys.put("","");
		request.setXmys(xmys);
		
		request.setXmSub("A RPC CALL TEST MESSAGE");
		request.setXmStrip("*^");
		request.setXmDf("");
		
		// Execute request against mocked object backend.
		response = service.xmz(request);
	
		assertNotNull(response);
		assertEquals(EXPECTED_FAILURE_REQUIRED_INPUT_MESSAGE, response.getResults());
	}

	/**
	 * Test Case #5  Successful
	 * 
	 * >S DUZ=.5
	 * >S XMSUB="A RPC CALL TEST MESSAGE"
	 * >S XMSTRIP="*^"
	 * >S MSG(1)="A TEST MESSAGE 2",MSG(2)="REPEAT T^^^HIS IS ONLY"
	 * >S XMY("SHARED,MAIL")=""
	 * >D EN1^XMWSOA02(.RETURN,DUZ,.MSG,,XMSUB,,XMSTRIP)
	 * 
	 *  >ZW RETURN
	 *  RETURN="0^Successful"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmz005() throws VistaWebServiceFault {

		HashMap <String, String> xmys = new HashMap<String, String>();
		ArrayList <String>msgs = new ArrayList<String>();
		
		request.setDuz(".5");
	
		msgs.add("A TEST MESSAGE 2");
		msgs.add("REPEAT T^^^HIS IS ONLY");
		request.setMsgs(msgs);
	
		xmys.put("SHARED,MAIL","");
		request.setXmys(xmys);
		
		request.setXmSub("A RPC CALL TEST MESSAGE");
		request.setXmStrip("*^");
		request.setXmDf("");
		
		// Execute request against mocked object backend.
		response = service.xmz(request);
	
		assertNotNull(response);
		assertEquals(EXPECTED_SUCCESS_MESSAGE, response.getResults());
	}

	/**
	 * Test Case #6  
	 * 
	 * Test for message subject too short
	 * 
	 * >S DUZ=.5
	 * >S XMSUB="A1"
	 * >S XMSTRIP="*^"
	 * >S MSG(1)="A TEST MESSAGE 2",MSG(2)="REPEAT T^^^HIS IS ONLY"
	 * >S XMY(97843598347593874)=""
	 * >D EN1^XMWSOA02(.RETURN,DUZ,.MSG,.XMY,XMSUB,,XMSTRIP)
	 * 
	 * >ZW RETURN
	 * RETURN="-1^SUBJECT must be at least 3 characters long.^A1"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmz006() throws VistaWebServiceFault {

		HashMap <String, String> xmys = new HashMap<String, String>();
		ArrayList <String>msgs = new ArrayList<String>();
		
		request.setDuz(".5");
	
		msgs.add("A TEST MESSAGE 2");
		msgs.add("REPEAT T^^^HIS IS ONLY");
		request.setMsgs(msgs);
	
		xmys.put("97843598347593874","");
		request.setXmys(xmys);
		
		request.setXmSub("A1");
		request.setXmStrip("*^");
		request.setXmDf("");
		
		// Execute request against mocked object backend.
		response = service.xmz(request);
	
		assertNotNull(response);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_FAILURE_SUBJECT_TOO_SHORT_MESSAGE, response.getResults());
		assertTrue(failMsg, response.getResults().contains(EXPECTED_FAILURE_SUBJECT_TOO_SHORT_MESSAGE));
	}

	/**
	 * Test Case #7
	 * 
	 * Test for non-existent DUZ
	 * 
	 * >S DUZ=.566
	 * >S XMSUB="A RPC CALL TEST MESSAGE"
	 * >S XMSTRIP="*^"
	 * >S MSG(1)="A TEST MESSAGE 2",MSG(2)="REPEAT T^^^HIS IS ONLY"
	 * >S XMY(.6)=""
	 * >D EN1^XMWSOA02(.RETURN,DUZ,.MSG,.XMY,XMSUB,,XMSTRIP)
	 * 
	 *  >ZW RETURN
	 *  RETURN="-1^DUZ not found"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmz007() throws VistaWebServiceFault {

		HashMap <String, String> xmys = new HashMap<String, String>();
		ArrayList <String>msgs = new ArrayList<String>();
		
		request.setDuz(".566");
	
		msgs.add("A TEST MESSAGE 2");
		msgs.add("REPEAT T^^^HIS IS ONLY");
		request.setMsgs(msgs);
	
		xmys.put(".6","");
		request.setXmys(xmys);
		
		request.setXmSub("A RPC CALL TEST MESSAGE");
		request.setXmStrip("*^");
		request.setXmDf("");
		
		// Execute request against mocked object backend.
		response = service.xmz(request);
	
		assertNotNull(response);
		assertEquals(EXPECTED_FAILURE_DUZ_NOT_FOUND_MESSAGE, response.getResults());
	}

	/**
	 * Test Case #8  
	 * 
	 * Test for subject too long
	 * 
	 * S DUZ=.5
	 * S XMSUB="A RPC CALL TEST MESSAGE 1234567890 1234567890 1234567890 1234567890"
	 * S XMSTRIP="*^"
	 * S MSG(1)="A TEST MESSAGE 2",MSG(2)="REPEAT T^^^HIS IS ONLY"
	 * S XMY(.6)=""
	 * D EN1^XMWSOA02(.RETURN,DUZ,.MSG,.XMY,XMSUB,,XMSTRIP)
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Entered SUBJECT too long, 2 characters longer than 65.^A RPC CALL TES
	 * T MESSAGE 1234567890 1234567890 1234567890 12345678"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmz008() throws VistaWebServiceFault {

		HashMap <String, String> xmys = new HashMap<String, String>();
		ArrayList <String>msgs = new ArrayList<String>();
		
		request.setDuz(".5");
	
		msgs.add("A TEST MESSAGE 2");
		msgs.add("REPEAT T^^^HIS IS ONLY");
		request.setMsgs(msgs);
	
		xmys.put(".6","");
		request.setXmys(xmys);
		
		request.setXmSub("A RPC CALL TEST MESSAGE 1234567890 1234567890 1234567890 1234567890");
		request.setXmStrip("*^");
		request.setXmDf("");
		
		// Execute request against mocked object backend.
		response = service.xmz(request);
	
		assertNotNull(response);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_FAILURE_SUBJECT_TOO_LONG_MESSAGE, response.getResults());
		assertTrue(failMsg, response.getResults().contains(EXPECTED_FAILURE_SUBJECT_TOO_LONG_MESSAGE));
	}

	/**
	 * Test Case #9  
	 * 
	 * Test subject containing control character
	 * 
	 * S DUZ=.5
	 * S XMSUB="A11"_$C(22)
	 * S XMSTRIP="*^"
	 * S MSG(1)="A TEST MESSAGE 2",MSG(2)="REPEAT T^^^HIS IS ONLY"
	 * S XMY(.6)=""
	 * D EN1^XMWSOA02(.RETURN,DUZ,.MSG,.XMY,XMSUB,,XMSTRIP)
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Subject cannot contain control characters.^A11"_$c(22)
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmz009() throws VistaWebServiceFault {

		HashMap <String, String> xmys = new HashMap<String, String>();
		ArrayList <String>msgs = new ArrayList<String>();
		
		request.setDuz(".5");
	
		msgs.add("A TEST MESSAGE 2");
		msgs.add("REPEAT T^^^HIS IS ONLY");
		request.setMsgs(msgs);
	
		xmys.put(".6","");
		request.setXmys(xmys);
		
		request.setXmSub("A RPC CALL TEST MESSAGE");
		request.setXmStrip("*^");
		request.setXmDf("");
		
		// Execute request against mocked object backend.
		response = service.xmz(request);
	
		assertNotNull(response);
//	TODO: Need to see if I can pass a control character		
//		assertEquals(EXPECTED_FAILURE_CONTROL_CHARS_MESSAGE, response.getResults());
		assertEquals(EXPECTED_SUCCESS_MESSAGE, response.getResults());
	}

	/**
	 * Test Case #10  Successful
	 * 
	 * Test for reserved subject of R#####
	 * 
	 * S DUZ=.5
	 * S XMSUB="R4535435"
	 * S XMSTRIP="*^"
	 * S MSG(1)="A TEST MESSAGE 2",MSG(2)="REPEAT T^^^HIS IS ONLY"
	 * S XMY(.6)=""
	 * D EN1^XMWSOA02(.RETURN,DUZ,.MSG,.XMY,XMSUB,,XMSTRIP)
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Subject names of this format (1""R""1.N) are RESERVED^R4535435"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmz010() throws VistaWebServiceFault {

		HashMap <String, String> xmys = new HashMap<String, String>();
		ArrayList <String>msgs = new ArrayList<String>();
		
		request.setDuz(".5");
	
		msgs.add("A TEST MESSAGE 2");
		msgs.add("REPEAT T^^^HIS IS ONLY");
		request.setMsgs(msgs);
	
		xmys.put(".6","");
		request.setXmys(xmys);
		
		request.setXmSub("R4535435");
		request.setXmStrip("*^");
		request.setXmDf("");
		
		// Execute request against mocked object backend.
		response = service.xmz(request);
	
		assertNotNull(response);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_FAILURE_RESERVED_MESSAGE, response.getResults());
		assertTrue(failMsg, response.getResults().contains(EXPECTED_FAILURE_RESERVED_MESSAGE));
	}
}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmb.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMNewEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmb.endpoints.interfaces.XMBEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Leisa Martella
 *
 */
/**
 * XMWSOA XMB
 * 
 * This RPC creates and sends a bulletin in the background. The message
 * number (XMZ) is not returned. The bulletin is sent to the mail
 * groups defined for the bulletin in the BULLETIN file (#3.6), as well as to
 * any additional recipients defined in XMY.
 * 
 * Input Parameters:
 * XMDUZ    (Required String)
 * 			User's DUZ or FREE TEXT.  This is the sender of the message.  If it is
 * 			not defined, it defaults to DUZ.  If it is FREE TEXT, it must not be more
 * 			than 70 characters.
 *
 * MSG		(Optional List)
 * 			This is text, in addition to the text defined in the bulletin, to
 * 			append to the bulletin.
 *
 * XMY      (Required List)
 * 			Recipients, in addition to those defined in the bulletin.
 * 
 * XMBULL   (Required String)
 * 			Full, exact name, of the bulletin. Case is important.
 * 
 * XMB		(Optional list)
 * 			Bulletin parameter(s). For example:
 * 			XMB(1)=<parm 1>, XMB(2)=<parm 2>, etc.
 * 
 * XMDF		(Optional String)
 * 			If XMDF is defined, addressing restrictions are waived.
 * 			Addressing restrictions are:
 * 			  > Restrict  "domain closed"
 * 			  > Restrict  "keys required for domain"
 * 			  > Restrict  "may not forward to domain"
 * 			  > Restrict  "may not forward priority mail to groups"
 * 			  > Restrict  "message length restrictions to remote addresses"
 * 
 * 	XMDT	(Optional String)
 * 			Date/time (in any format understood by VA FileMan) to send the bulletin.
 * 			The default is now.
 * 
 * Returns:
 *    0^[Name of Bulletin] if successful
 *    -1^Error in required input
 *    -1^Bulletin does not exit
 *    -1^Operation failed
 *    
 */
public class XmbIT extends EvolutionIT<XMBEndpoint> {

	private final String EXPECTED_SUCCESS_MESSAGE = "0^"; 
	private final String EXPECTED_ERROR_IN_INPUT_MESSAGE ="-1^Error in required input";
	private final String EXPECTED_BULLETIN_DOES_NOT_EXIST_MESSAGE ="-1^Bulletin does not exist";
	@SuppressWarnings("unused")
	private final String EXPECTED_OPERATION_FAILED_MESSAGE ="-1^Operation Failed";

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XmbIT.class);

	private XmbRequest xmbRequest;
	private XmbResponse xmbResponse;
	private HashMap<String,String> xmyMap;
	private ArrayList<String> xmbList;

	@Before
	public void setUp() {
		xmbRequest = new XmbRequest();
		xmyMap = new HashMap<String,String>();
		xmbList = new ArrayList<String>();
	}

	@After
	public void tearDown() {
		xmbRequest = null;
		xmyMap = null;
		xmbList = null;
	}

	//Internal Test helper class to return the endpoint.
	protected Class<XMBEndpoint> getType()
	{
		return XMBEndpoint.class;
	}
	
	/**
	 * Test Case #1 Success  
	 *
	 * xmbs (Required List):
	 * 	XMB(1)="JOHN SMITH"
	 * 	XMB(2)="AMY CARTER"
	 * 	XMB(3)="FARMERS INSURANCE"
	 * 
	 * xmys (Required List):
	 * 	XMY(53468)=""
	 * 
	 * 	xmDuz = 53468
	 * 	xmsgs = null
	 * 	xmys = .XMY
	 * 	xmBull = "XUSSPKI SAN"
	 * 	xmbs = .XMB
	 * 	xmDf = null
	 * 	xmDt = null
	 *  
	 * The expected result from RPC Broker is:
	 * 
	 *	RESULT="0^XUSSPKI SAN"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmb001() throws VistaWebServiceFault {
		ArrayList<String> msgList = new ArrayList<String>();
	
		//Set xmys list
		xmyMap.put("53468","");

		//Set xmbs list
		 xmbList.add("JOHN SMITH");
		 xmbList.add("AMY CARTER");
		 xmbList.add("FARMERS INSURANCE");
		
		//Set Request parameters
		xmbRequest.setXmDuz("53468");
		xmbRequest.setXmys(xmyMap);
		xmbRequest.setXmBull("XUSSPKI SAN");
		xmbRequest.setXmbs(xmbList);

		
		xmbResponse = service.xmb(xmbRequest);

		assertNotNull(xmbResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_SUCCESS_MESSAGE + xmbRequest.getXmBull(), xmbResponse.getResults());
		assertTrue(failMsg, xmbResponse.getResults().contains(EXPECTED_SUCCESS_MESSAGE));

	}

	/**
	 * Test Case #2 Bulletin does not exist  
	 *
	 * xmbs (Required List):
	 * 	XMB(1)="JOHN SMITH"
	 * 	XMB(2)="AMY CARTER"
	 * 	XMB(3)="FARMERS INSURANCE"
	 * 
	 * xmys (Required List):
	 * 	XMY(53468)=""
	 * 
	 * 	xmDuz = 53468
	 * 	xmsgs = null
	 * 	xmys = .XMY
	 * 	xmBull = "ZZZXUSSPKI SAN"
	 * 	xmbs = .XMB
	 * 	xmDf = null
	 * 	xmDt = null
	 *  
	 * The expected result from RPC Broker is:
	 * 
	 *	RESULT="-1^Bulletin does not exist"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmb002() throws VistaWebServiceFault {
		
		//Set xmys list
		xmyMap.put("53468","");
		
		//Set xmbs list
		 xmbList.add("JOHN SMITH");
		 xmbList.add("AMY CARTER");
		 xmbList.add("FARMERS INSURANCE");
		
		//Set Request parameters
		xmbRequest.setXmDuz("53468");
		xmbRequest.setXmys(xmyMap);
		xmbRequest.setXmBull("ZZZXUSSPKI SAN");
		xmbRequest.setXmbs(xmbList);
		
		xmbResponse = service.xmb(xmbRequest);
		
		assertNotNull(xmbResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_BULLETIN_DOES_NOT_EXIST_MESSAGE, xmbResponse.getResults());
		assertTrue(failMsg, xmbResponse.getResults().contains(EXPECTED_BULLETIN_DOES_NOT_EXIST_MESSAGE));

	}

	/**
	 * Test Case #3 Success  
	 *
	 * xmbs (Required List):
	 * 	XMB(1)="JOHN SMITH"
	 * 	XMB(2)="AMY CARTER"
	 * 	XMB(3)="FARMERS INSURANCE"
	 * 
	 * xmys (Required List):
	 * 	XMY(53468)=""
	 * 
	 * 	xmDuz = 53468
	 * 	xmsgs = null
	 * 	xmys = .XMY
	 * 	xmBull = "XUSSPKI SAN"
	 * 	xmbs = .XMB
	 * 	xmDf = null
	 * 	xmDt = "1/10/2014@1245"
	 *  
	 * The expected result from RPC Broker is:
	 * 
	 *	RESULT="0^XUSSPKI SAN"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmb003() throws VistaWebServiceFault {

		//Set xmys list
		xmyMap.put("53468","");
		
		//Set xmbs list
		 xmbList.add("JOHN SMITH");
		 xmbList.add("AMY CARTER");
		 xmbList.add("FARMERS INSURANCE");
		
		//Set Request parameters
		xmbRequest.setXmDuz("53468");
		xmbRequest.setXmys(xmyMap);
		xmbRequest.setXmBull("XUSSPKI SAN");
		xmbRequest.setXmbs(xmbList);
		xmbRequest.setXmDt("1/10/2014@1245");
		
		xmbResponse = service.xmb(xmbRequest);
		
		assertNotNull(xmbResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_SUCCESS_MESSAGE + xmbRequest.getXmBull(), xmbResponse.getResults());
		assertTrue(failMsg, xmbResponse.getResults().contains(EXPECTED_SUCCESS_MESSAGE));

	}

	/**
	 * Test Case #4 Success  
	 *
	 * xmbs (Required List):
	 * 	XMB(1)="JOHN SMITH"
	 * 	XMB(2)="AMY CARTER"
	 * 	XMB(3)="FARMERS INSURANCE"
	 * 
	 * xmys (Required List):
	 * 	XMY(53468)=""
	 * 
	 *  xmsgs (Optional List):
	 * 	XMSG(1)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(2)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(3)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(4)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(5)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(6)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(7)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(8)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(9)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(10)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 
	 * 	xmDuz = 53468
	 * 	xmsgs = .XMSG
	 * 	xmys = .XMY
	 * 	xmBull = "XUSSPKI SAN"
	 * 	xmbs = .XMB
	 * 	xmDf = null
	 * 	xmDt = null
	 *  
	 * The expected result from RPC Broker is:
	 * 
	 *	RESULT="0^XUSSPKI SAN"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmb004() throws VistaWebServiceFault {
		ArrayList<String> xmsgList = new ArrayList<String>();
		
		//Set xmys list
		xmyMap.put("53468","");
		
		//Set xmbs list
		 xmbList.add("JOHN SMITH");
		 xmbList.add("AMY CARTER");
		 xmbList.add("FARMERS INSURANCE");
		
		//Set Request parameters
		xmbRequest.setXmDuz("53468");
		xmbRequest.setXmys(xmyMap);
		xmbRequest.setXmBull("XUSSPKI SAN");
		xmbRequest.setXmbs(xmbList);
		
		//Set xmsg list
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		
		xmbResponse = service.xmb(xmbRequest);
		
		assertNotNull(xmbResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_SUCCESS_MESSAGE + xmbRequest.getXmBull(), xmbResponse.getResults());
		assertTrue(failMsg, xmbResponse.getResults().contains(EXPECTED_SUCCESS_MESSAGE));

	}

	/**
	 * Test Case #6 Success
	 *   
	 * xmbs (Required List):
	 * 	XMB(1)="JOHN SMITH"
	 * 	XMB(2)="AMY CARTER"
	 * 	XMB(3)="FARMERS INSURANCE"
	 * 
	 * xmys (Required List):
	 * 	XMY(53468)=""
	 * 
	 * 	xmDuz = 53468
	 * 	xmsgs = null
	 * 	xmys = .XMY
	 * 	xmBull = "XUSSPKI SAN"
	 * 	xmbs = .XMB
	 * 	xmDf = "1"
	 * 	xmDt = null
	 *  
	 * The expected result from RPC Broker is:
	 * 
	 *	RESULT="0^XUSSPKI SAN"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmb006() throws VistaWebServiceFault {
		
		//Set xmys list
		xmyMap.put("53468","");
		
		//Set xmbs list
		 xmbList.add("JOHN SMITH");
		 xmbList.add("AMY CARTER");
		 xmbList.add("FARMERS INSURANCE");
		
		//Set Request parameters
		xmbRequest.setXmDuz("53468");
		xmbRequest.setXmys(xmyMap);
		xmbRequest.setXmBull("XUSSPKI SAN");
		xmbRequest.setXmbs(xmbList);
		xmbRequest.setXmDf("1");
		
		xmbResponse = service.xmb(xmbRequest);
		
		assertNotNull(xmbResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_SUCCESS_MESSAGE + xmbRequest.getXmBull(), xmbResponse.getResults());
		assertTrue(failMsg, xmbResponse.getResults().contains(EXPECTED_SUCCESS_MESSAGE));

	}

	/**
	 * Test Case #8 XMBULL missing (Required Field)  
	 *
	 * xmbs (Required List):
	 * 	XMB(1)="JOHN SMITH"
	 * 	XMB(2)="AMY CARTER"
	 * 	XMB(3)="FARMERS INSURANCE"
	 * 
	 * xmys (Required List):
	 * 	XMY(53468)=""
	 * 
	 * 	xmDuz = 53468
	 * 	xmsgs = null
	 * 	xmys = .XMY
	 * 	xmBull = ""
	 * 	xmbs = .XMB
	 * 	xmDf = null
	 * 	xmDt = null
	 *  
	 * The expected result from RPC Broker is:
	 * 
	 *	RESULT="-1^Bulletin does not exist"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmb008() throws VistaWebServiceFault {
		
		//Set xmys list
		xmyMap.put("53468","");
		
		//Set xmbs list
		 xmbList.add("JOHN SMITH");
		 xmbList.add("AMY CARTER");
		 xmbList.add("FARMERS INSURANCE");
		
		//Set Request parameters
		xmbRequest.setXmDuz("53468");
		xmbRequest.setXmys(xmyMap);
		xmbRequest.setXmBull("");
		xmbRequest.setXmbs(xmbList);
		
		xmbResponse = service.xmb(xmbRequest);
		
		assertNotNull(xmbResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_ERROR_IN_INPUT_MESSAGE, xmbResponse.getResults());
		assertTrue(failMsg, xmbResponse.getResults().contains(EXPECTED_ERROR_IN_INPUT_MESSAGE));

	}

	/**
	 * Test Case #9 Success
	 *   
	 * xmbs (Required List):
	 * 	XMB(1)="JOHN SMITH"
	 * 	XMB(2)="AMY CARTER"
	 * 	XMB(3)="FARMERS INSURANCE"
	 * 
	 * xmys (Required List):
	 * 	XMY(53468)=""
	 * 
	 *  xmsgs (Optional List):
	 * 	XMSG(1)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(2)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(3)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(4)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(5)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(6)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(7)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(8)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(9)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 	XMSG(10)="BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY"
	 * 
	 * 
	 * 	xmDuz = 53468
	 * 	xmsgs = .XMSG
	 * 	xmys = .XMY
	 * 	xmBull = "XUSSPKI SAN"
	 * 	xmbs = .XMB
	 * 	xmDf = null
	 * 	xmDt = "1/10/2014@1435"
	 *  
	 * The expected result from RPC Broker is:
	 * 
	 *	RESULT="0^XUSSPKI SAN"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmb009() throws VistaWebServiceFault {

		ArrayList<String> xmsgList = new ArrayList<String>();
		
		//Set xmys list
		xmyMap.put("53468","");
		
		//Set xmbs list
		 xmbList.add("JOHN SMITH");
		 xmbList.add("AMY CARTER");
		 xmbList.add("FARMERS INSURANCE");
		
		//Set xmsg list
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
		xmsgList.add("BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY");
			
		//Set Request parameters
		xmbRequest.setXmDuz("53468");
		xmbRequest.setXmys(xmyMap);
		xmbRequest.setXmBull("XUSSPKI SAN");
		xmbRequest.setXmbs(xmbList);
		xmbRequest.setXmDf("1");
		
		xmbResponse = service.xmb(xmbRequest);
		
		assertNotNull(xmbResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_SUCCESS_MESSAGE + xmbRequest.getXmBull(), xmbResponse.getResults());
		assertTrue(failMsg, xmbResponse.getResults().contains(EXPECTED_SUCCESS_MESSAGE));

	}

	/**
	 * Test Case #10 Success
	 *   
	 * xmbs (Required List):
	 * 	XMB(3)="FARMERS INSURANCE"
	 * 
	 * xmys (Required List):
	 * 	XMY(53468)=""
	 * 
	 * 	xmDuz = 53468
	 * 	xmsgs = null
	 * 	xmys = .XMY
	 * 	xmBull = "XUSSPKI SAN"
	 * 	xmbs = .XMB
	 * 	xmDf = null
	 * 	xmDt = null
	 *  
	 * The expected result from RPC Broker is:
	 * 
	 *	RESULT="0^XUSSPKI SAN"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmb010() throws VistaWebServiceFault {
		
		//Set xmys list
		xmyMap.put("53468","");
		
		//Set xmbs list
		 xmbList.add("");
		 xmbList.add("");
		 xmbList.add("FARMERS INSURANCE");
		
		//Set Request parameters
		xmbRequest.setXmDuz("53468");
		xmbRequest.setXmys(xmyMap);
		xmbRequest.setXmBull("XUSSPKI SAN");
		xmbRequest.setXmbs(xmbList);
		
		xmbResponse = service.xmb(xmbRequest);
		
		assertNotNull(xmbResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_SUCCESS_MESSAGE + xmbRequest.getXmBull(), xmbResponse.getResults());
		assertTrue(failMsg, xmbResponse.getResults().contains(EXPECTED_SUCCESS_MESSAGE));

	}

	/**
	 * Test Case #11 missing Required Fields  
	 *
	 * xmbs (Required List) = empty
	 * xmys (Required List) = empty
	 * 	xmDuz = 53468
	 * 	xmsgs = null
	 * 	xmys = .XMY
	 * 	xmBull = ""
	 * 	xmbs = .XMB
	 * 	xmDf = null
	 * 	xmDt = null
	 *  
	 * The expected result from RPC Broker is:
	 * 
	 *	RESULT="-1^Bulletin does not exist"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testXmb011() throws VistaWebServiceFault {
		
		//Set Request parameters
		xmbRequest.setXmDuz("53468");
		xmbRequest.setXmys(xmyMap);
		xmbRequest.setXmBull("");
		xmbRequest.setXmbs(xmbList);
		
		xmbResponse = service.xmb(xmbRequest);
		
		assertNotNull(xmbResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_ERROR_IN_INPUT_MESSAGE, xmbResponse.getResults());
		assertTrue(failMsg, xmbResponse.getResults().contains(EXPECTED_ERROR_IN_INPUT_MESSAGE));

	}


}

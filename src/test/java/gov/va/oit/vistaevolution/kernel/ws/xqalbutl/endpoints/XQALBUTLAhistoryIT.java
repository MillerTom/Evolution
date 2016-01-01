/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLAhistoryEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAhistoryRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAhistoryResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/**
 * XU SOA AHIST
 *
 * This RPC returns information from the ALERT TRACKING file (#8992.1) for alerts with the 
 * XUAID input parameter as its alert ID.  
 *  
 * 
 * Input Variables	
 * 		XUAID:	(required) This is the value XUAID which is the alert identifier.  
 * 				It is passed to the routine or option which is run when the alert 
 * 				is selected.  It can also be obtained from a listing of all of the 
 * 				XUAIDs for a specified user and/or patient.
 * 
 * Response
 * 		Returns data descendent from the closed root passed in XURET.
 * 		The basic structure of the nodes is taken from the global for the
 * 		entry and can be seen in a global map of the ALERT TRACKING (#8992.1)
 * 		file.
 * 
 * 		array(0)="NO-ID;83194;3140107.141502^3140107.141502^NO-ID^^83194^1"
 * 		array(1)="Your task #6749088 stopped because of an error^^XQA^XUTMUTL"
 * 		array(2)=6749088
 * 		array(20,0)="^8992.11PA^1^1"
 * 		array(20,1,0)=83194
 * 		array(20,1,1,0)="^8992.111PA^1^1"
 * 		array(20,1,1,1,0)="1^^^3140107.141502"
 * 		array(20,1,1,"B",1,1)=""
 * 		array(20,"B",83194,1)=""
 * 
 */

public class XQALBUTLAhistoryIT extends EvolutionIT<XQALBUTLAhistoryEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XQALBUTLAhistoryIT.class);

	@Override
	protected Class<XQALBUTLAhistoryEndpoint> getType() {
		return XQALBUTLAhistoryEndpoint.class;
	}


	private XQALBUTLAhistoryRequest request;
	private XQALBUTLAhistoryResponse response;

	@Before
	public void setUp() {
		request = new XQALBUTLAhistoryRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * Test Case #1  
	 * 
	 * In this test case you will look for a specific alert by its alert identifier.
	 * 
	 *   >S XUAID="LA7-MESSAGE-416570;.5;3030226.111106",XURET=””
	 *   >D AHISTR^XUSOAR(XURET,XUAID)
	 *   
	 *   >ZW XURET
	 *   XURET(0)="LA7-MESSAGE-416570;.5;3030226.111106^3030226.111106^LA7-MESSAGE-416570^^.5^1"
	 *   XURET(1)="Lab Messaging error #37 on message #416570^^DIS^LA7UXQA"
	 *   XURET(2)=416570
	 *   XURET(20,"0")="^8992.11^7143^2"
	 *   XURET(20,"1",0)=5030
	 *   XURET(20,"2",0)="7143^3030303.083623^3030303.083657"
	 *   XURET(20,"B","5030",1)=""
	 *   XURET(20,"B","7143",2)=""
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testAhistory001() throws VistaWebServiceFault {
	//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
	ArrayList <String> results = new ArrayList <String>();
	results.add("LA7-MESSAGE-416570;.5;3030226.111106^3030226.111106^LA7-MESSAGE-416570^^.5^1");
	results.add("Lab Messaging error #37 on message #416570^^DIS^LA7UXQA");
	results.add("7143^3030303.083623^3030303.083657");


		request.setXuaID("LA7-MESSAGE-416570;.5;3030226.111106");

		// Execute request against mocked object backend.
		response = service.ahistory(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
		assertEquals(results.get(1), response.getDataList().get(1));
	}
	/**
	 * Test Case #2  
	 * 
	 *  In this test case you will look for an alert that does not exist.  No data is returned.
	 *  
	 *  > S XQAID="INVALID ALERT ID ",XURET=””
	 *  
	 *  >D AHISTR^XUSOAR(XURET,XUAID)
	 *  >ZW XURET
	 *  XURET=””
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testAhistory002() throws VistaWebServiceFault {
	//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
	ArrayList <String> results = new ArrayList <String>();
		results.add("");
	
	
		request.setXuaID("INVALID ALERT ID ");
	
		// Execute request against mocked object backend.
		response = service.ahistory(request);
	
		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	
}

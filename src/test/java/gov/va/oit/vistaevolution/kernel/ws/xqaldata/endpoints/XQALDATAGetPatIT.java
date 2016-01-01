/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.XQALDATAGetPatEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetPatRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetPatResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

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
 * XU SOA GETPAT
 * 
 * This RPC returns all alerts for a patient (XUDFN).  Optionally a FIRST
 * date of creation (XUFDAT) and LAST date of creation (XULDAT) can be
 * passed to limit what is returned.
 * 
 * 
 * Format	D GETPAT^XQALDATA(result array, patient IEN, start date, end date)
 *
 * Input Parameters
 
 * 	XUDFN		(Required)  This is the patient's DFN from the PATIENT file (#2).
 * 	XUFDAT		(Optional)  This is the alert's beginning date of creation (in FileMan format) range for gathering the patient alerts
 *  XULDAT		(Optional)  End of the date (in FileMan format)  range for gathering the patient alerts
 *
 * Output
 * Returns a list of alerts for a PATIENT in the array specified by XURET.
 * 
 * array=1
 * array(1)="   ZZYER,EMA (R6770): Admitted on 09/18 09:56 to 131-2AO
 *              221-1^OR,186833,18;83170;3130918.095848"
 *   
 */

public class XQALDATAGetPatIT extends EvolutionIT<XQALDATAGetPatEndpoint> {

	@Override
	protected Class<XQALDATAGetPatEndpoint> getType() {
		return XQALDATAGetPatEndpoint.class;
	}
	
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XQALDATAGetPatIT.class);

	private XQALDATAGetPatRequest xqaldataGetPatRequest;
	private XQALDATAGetPatResponse xqaldataGetPatResponse;

	@Before
	public void setUp() {
		xqaldataGetPatRequest = new XQALDATAGetPatRequest();
		xqaldataGetPatResponse = new XQALDATAGetPatResponse();
	}

	@After
	public void tearDown() {
		xqaldataGetPatRequest = null;
		xqaldataGetPatRequest = null;
	}

	/**
	 * Test Case #1  
	 * 
	 * >D GETPATR^XUSOAR("RES",214,3081001)
	 * D GETPAT^XQALDATA(XURET,XUDFN,XUFDAT,XULDAT)
	 * ^
	 * <UNDEFINED>GETPATR+1^XUSOAR *XULDAT
	 * >Q
	 * 
	 * Input Parameters
	 * 	Patient IEN	=
	 * 	Start Date	=
	 *  End Date	=
	 *
	 * Output
	 *
	 * @throws VistaWebServiceFault
	 */
@Test
@Ignore
	public void testGetPat001() throws VistaWebServiceFault {
		//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
		String result = "PASS";
	
		//Set Expected Results
		ArrayList<String> data = new ArrayList<String>();
		data.add("123");
		xqaldataGetPatResponse.setData(data );
		
		xqaldataGetPatRequest.setIen("RES");
		xqaldataGetPatRequest.setStartDate("214");
		xqaldataGetPatRequest.setEndDate("3081001");
		
	
		xqaldataGetPatResponse = service.getPat(xqaldataGetPatRequest);
		assertNotNull(xqaldataGetPatResponse);
		assertEquals(result, "PASS");
//		assertEquals(data.get(0), xqaldataGetPatResponse.getData());

		// Fail
		fail("Failed due to internal error in running the XLFDT3 Leap Service.");
	}

	/**
	 * Test Case #2  
	 * 
	 * Input Parameters
	 * 	Patient IEN	=
	 * 	Start Date	=
	 *  End Date	=
	 *
	 * Output
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testGetPat002() throws VistaWebServiceFault {
		//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
		String result = "PASS";
	
		//Set Expected Results
		List<String> data = new ArrayList<String>();
		xqaldataGetPatResponse.setData(data );
		
		xqaldataGetPatRequest.setIen("");
		xqaldataGetPatRequest.setStartDate("");
		xqaldataGetPatRequest.setEndDate("");
		
	
		xqaldataGetPatResponse = service.getPat(xqaldataGetPatRequest);
		assertNotNull(xqaldataGetPatResponse);
		assertEquals(result, "PASS");
	
		// Fail
		fail("Failed due to internal error in running the XLFDT3 Leap Service.");
	}
	
	/**
	 * Test Case #3  
	 * 
	 * Input Parameters
	 * 	Patient IEN	=
	 * 	Start Date	=
	 *  End Date	=
	 *
	 * Output
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testGetPat003() throws VistaWebServiceFault {
		//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
		String result = "PASS";
	
		//Set Expected Results
		List<String> data = new ArrayList<String>();
		xqaldataGetPatResponse.setData(data );
		
		xqaldataGetPatRequest.setIen("");
		xqaldataGetPatRequest.setStartDate("");
		xqaldataGetPatRequest.setEndDate("");
		
	
		xqaldataGetPatResponse = service.getPat(xqaldataGetPatRequest);
		assertNotNull(xqaldataGetPatResponse);
		assertEquals(result, "PASS");
	
		// Fail
		fail("Failed due to internal error in running the XLFDT3 Leap Service.");
	}
	
	/**
	 * Test Case #4  
	 * 
	 * Input Parameters
	 * 	Patient IEN	=
	 * 	Start Date	=
	 *  End Date	=
	 *
	 * Output
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testGetPat004() throws VistaWebServiceFault {
		//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
		String result = "PASS";
	
		//Set Expected Results
		List<String> data = new ArrayList<String>();
		xqaldataGetPatResponse.setData(data );
		
		xqaldataGetPatRequest.setIen("");
		xqaldataGetPatRequest.setStartDate("");
		xqaldataGetPatRequest.setEndDate("");
		
	
		xqaldataGetPatResponse = service.getPat(xqaldataGetPatRequest);
		assertNotNull(xqaldataGetPatResponse);
		assertEquals(result, "PASS");
	
		// Fail
		fail("Failed due to internal error in running the XLFDT3 Leap Service.");
	}
	
	/**
	 * Test Case #5  
	 * 
	 * Input Parameters
	 * 	Patient IEN	=
	 * 	Start Date	=
	 *  End Date	=
	 *
	 * Output
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testGetPat005() throws VistaWebServiceFault {
		//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
		String result = "PASS";
	
		//Set Expected Results
		List<String> data = new ArrayList<String>();
		xqaldataGetPatResponse.setData(data );
		
		xqaldataGetPatRequest.setIen("");
		xqaldataGetPatRequest.setStartDate("");
		xqaldataGetPatRequest.setEndDate("");
		
	
		xqaldataGetPatResponse = service.getPat(xqaldataGetPatRequest);
		assertNotNull(xqaldataGetPatResponse);
		assertEquals(result, "PASS");
	
		// Fail
		fail("Failed due to internal error in running the XLFDT3 Leap Service.");
	}
	
	/**
	 * Test Case #6  
	 * 
	 * Input Parameters
	 * 	Patient IEN	=
	 * 	Start Date	=
	 *  End Date	=
	 *
	 * Output
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testGetPat006() throws VistaWebServiceFault {
		//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
		String result = "PASS";
	
		//Set Expected Results
		List<String> data = new ArrayList<String>();
		xqaldataGetPatResponse.setData(data );
		
		xqaldataGetPatRequest.setIen("");
		xqaldataGetPatRequest.setStartDate("");
		xqaldataGetPatRequest.setEndDate("");
		
	
		xqaldataGetPatResponse = service.getPat(xqaldataGetPatRequest);
		assertNotNull(xqaldataGetPatResponse);
		assertEquals(result, "PASS");
	
		// Fail
		fail("Failed due to internal error in running the XLFDT3 Leap Service.");
	}
	
	/**
	 * Test Case #7  
	 * 
	 * Input Parameters
	 * 	Patient IEN	=
	 * 	Start Date	=
	 *  End Date	=
	 *
	 * Output
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testGetPat007() throws VistaWebServiceFault {
		//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
		String result = "PASS";
	
		//Set Expected Results
		List<String> data = new ArrayList<String>();
		xqaldataGetPatResponse.setData(data );
		
		xqaldataGetPatRequest.setIen("");
		xqaldataGetPatRequest.setStartDate("");
		xqaldataGetPatRequest.setEndDate("");
		
	
		xqaldataGetPatResponse = service.getPat(xqaldataGetPatRequest);
		assertNotNull(xqaldataGetPatResponse);
		assertEquals(result, "PASS");
	
		// Fail
		fail("Failed due to internal error in running the XLFDT3 Leap Service.");
	}
	
	/**
	 * Test Case #8  
	 * 
	 * Input Parameters
	 * 	Patient IEN	=
	 * 	Start Date	=
	 *  End Date	=
	 *
	 * Output
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testGetPat008() throws VistaWebServiceFault {
		//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
		String result = "PASS";
	
		//Set Expected Results
		List<String> data = new ArrayList<String>();
		xqaldataGetPatResponse.setData(data );
		
		xqaldataGetPatRequest.setIen("");
		xqaldataGetPatRequest.setStartDate("");
		xqaldataGetPatRequest.setEndDate("");
		
	
		xqaldataGetPatResponse = service.getPat(xqaldataGetPatRequest);
		assertNotNull(xqaldataGetPatResponse);
		assertEquals(result, "PASS");
	
		// Fail
		fail("Failed due to internal error in running the XLFDT3 Leap Service.");
	}
	
	/**
	 * Test Case #9  
	 * 
	 * Input Parameters
	 * 	Patient IEN	=
	 * 	Start Date	=
	 *  End Date	=
	 *
	 * Output
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testGetPat009() throws VistaWebServiceFault {
		//TODO: Setup Test Case when RPC is complete (Leisa)
		String result = "PASS";
	
		//Set Expected Results
		List<String> data = new ArrayList<String>();
		xqaldataGetPatResponse.setData(data );
		
		xqaldataGetPatRequest.setIen("");
		xqaldataGetPatRequest.setStartDate("");
		xqaldataGetPatRequest.setEndDate("");
		
	
		xqaldataGetPatResponse = service.getPat(xqaldataGetPatRequest);
		assertNotNull(xqaldataGetPatResponse);
		assertEquals(result, "PASS");
	
		// Fail
		fail("Failed due to internal error in running the XLFDT3 Leap Service.");
	}

}

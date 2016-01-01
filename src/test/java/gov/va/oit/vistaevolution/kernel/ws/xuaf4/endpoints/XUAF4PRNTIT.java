package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import javax.xml.ws.soap.SOAPFaultException;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4PRNTEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PRNTRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PRNTResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
// import org.junit.Ignore;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Bill Blackmon <bill.blackmon@medsphere.com>
 * 
 * 
 *         Integration test for XUAF4PRNTTest - VERY rough draft - based on
 *         XMDEnt1Test.java and XMDEntIT.java 1/31
 */

public class XUAF4PRNTIT extends EvolutionIT<XUAF4PRNTEndpoint> {
	XUAF4PRNTRequest request;

	@Override
	protected Class<XUAF4PRNTEndpoint> getType() {
		return XUAF4PRNTEndpoint.class;
	}

	@Before
	public void setUp() {
		request = new XUAF4PRNTRequest();

	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em>retrieve the parent station for a given station</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET XUSTA="NORTHPORT NHCU"
	 * 
	 * Procedure Call:
	 * 
	 * >D PRNTR^XUSOAR(.RESULT,STA)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RESULT
	 * RESULT="632^632^NORTHPORT"
	 * </pre>
	 * 
	 */
	@Test
	@Ignore
	public void testRetrieveParentStation() throws VistaWebServiceFault {
		String expectedResponse = "632^632^NORTHPORT";

		request.setSta("NORTHPORT");

		XUAF4PRNTResponse response = service.prnt(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}

	/**
	 * <em>retrieve a parent station number using a parent facility</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET XUSTA="NEW JERSEY MEMORIAL HOME"
	 * 
	 * Procedure Call:
	 * 
	 * >D PRNTR^XUSOAR(.RESULT,STA)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RESULT
	 * RESULT="0^no parent associated with input station number"
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveParentStationFromParentFacility() throws VistaWebServiceFault {
		String expectedResponse = "no parent associated with input station number";
		String expectedStatus="0";

		request.setSta("NORTHPORT NHCU");

		XUAF4PRNTResponse response = service.prnt(request);

		assertNotNull(response);
		assertNull(response.getResult());
		assertNotNull(response.getErrors());
		assertNotNull(response.getStatus());
		assertEquals(expectedStatus, response.getStatus());
		assertEquals(expectedResponse, response.getErrors().get(0));

	}

	/**
	 * <em>retrieve a parent station without specifying a station name (the variable STA is undefined)</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET 
	 * 
	 * Procedure Call:
	 * 
	 * >D PRNTR^XUSOAR(.RESULT,STA)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RESULT
	 * RESULT="0^no parent associated with input station number"
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveParentStationWithoutSTA() throws VistaWebServiceFault {
		
		try {
			service.prnt(request);
			fail();
		} catch (VistaWebServiceFault f) {
			// expected when not run against deployment
		} catch (SOAPFaultException f) {
			// expected when run against deployment
			
		}catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 * <em>a parent using a station name of NULL</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET XUSTA=""
	 * 
	 * Procedure Call:
	 * 
	 * >D PRNTR^XUSOAR(.RESULT,STA)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RESULT
	 * RESULT="0^no station number passed"
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveParentStationWithNullSTA() throws VistaWebServiceFault {
		String expectedResponse = "no station number passed";
		String expectedStatus ="0";
		
		request.setSta("");
		XUAF4PRNTResponse response = service.prnt(request);

		assertNotNull(response);
		assertNull(response.getResult());
		assertNotNull(response.getErrors());
		assertNotNull(response.getStatus());
		assertEquals(expectedStatus, response.getStatus());
		assertEquals(expectedResponse, response.getErrors().get(0));

	}

	/**
	 * <em>retrieve a parent station using a station name that does not exist.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET XUSTA="XXXXXX"
	 * 
	 * Procedure Call:
	 * 
	 * >D PRNTR^XUSOAR(.RESULT,STA)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RESULT
	 * RESULT="0^no parent associated with input station number"
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveParentStationWithInvalidSTA() throws VistaWebServiceFault {
		String expectedResponse = "no parent associated with input station number";
		String expectedStatus = "0";

		request.setSta("XXXXXX");
		XUAF4PRNTResponse response = service.prnt(request);

		assertNotNull(response);
		assertNull(response.getResult());
		assertNotNull(response.getErrors());
		assertNotNull(response.getStatus());
		assertEquals(expectedStatus, response.getStatus());
		assertEquals(expectedResponse, response.getErrors().get(0));

	}

} // end class

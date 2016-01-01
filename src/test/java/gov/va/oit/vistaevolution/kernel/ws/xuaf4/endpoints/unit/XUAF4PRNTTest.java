package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4PRNTEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4PRNTEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PRNTRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PRNTResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 * @author bill.blackmon <bill.blackmon@medsphere.com>
 *  RPC = "XU SOA Encodeup"
 *
 */

public class XUAF4PRNTTest extends VistaLinkContextTestParent {
	XUAF4PRNTRequest request;
	XUAF4PRNTEndpoint service;

	@Before
	public void setUp() {
		request = new XUAF4PRNTRequest();
		service = new XUAF4PRNTEndpointImpl(new XUAF4ResponseFactory(), getVistaLinkContext());

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
	public void testRetrieveParentStation() throws VistaWebServiceFault {
		String testResponse = "1";

		request.setSta("NORTHPORT NHCU");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		XUAF4PRNTResponse response = service.prnt(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getResult());

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
		String testResponse = "0^no parent associated with input station number";

		request.setSta("NORTHPORT NHCU");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		XUAF4PRNTResponse response = service.prnt(request);

		assertNotNull(response);
		assertNull(response.getResult());
		assertNotNull(response.getErrors());
		assertNotNull(response.getStatus());
		assertEquals(testResponse.split("\\^")[0], response.getStatus());
		assertEquals(testResponse.split("\\^")[1], response.getErrors().get(0));

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
		String testResponse = "0^no parent associated with input station number";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		XUAF4PRNTResponse response = service.prnt(request);

		assertNotNull(response);
		assertNull(response.getResult());
		assertNotNull(response.getErrors());
		assertNotNull(response.getStatus());
		assertEquals(testResponse.split("\\^")[0], response.getStatus());
		assertEquals(testResponse.split("\\^")[1], response.getErrors().get(0));

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
		String testResponse = "0^no station number passed";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);
		request.setSta("");
		XUAF4PRNTResponse response = service.prnt(request);

		assertNotNull(response);
		assertNull(response.getResult());
		assertNotNull(response.getErrors());
		assertNotNull(response.getStatus());
		assertEquals(testResponse.split("\\^")[0], response.getStatus());
		assertEquals(testResponse.split("\\^")[1], response.getErrors().get(0));

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
		String testResponse = "0^no parent associated with input station number";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		request.setSta("XXXXXX");
		XUAF4PRNTResponse response = service.prnt(request);

		assertNotNull(response);
		assertNull(response.getResult());
		assertNotNull(response.getErrors());
		assertNotNull(response.getStatus());
		assertEquals(testResponse.split("\\^")[0], response.getStatus());
		assertEquals(testResponse.split("\\^")[1], response.getErrors().get(0));

	}	


}	// end of class

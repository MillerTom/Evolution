package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4TFEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4TFEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4TFRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4TFResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XUAF4TFTest extends VistaLinkContextTestParent {
	XUAF4TFRequest request;
	XUAF4TFEndpoint service;

	@Before
	public void setUp() {
		request = new XUAF4TFRequest();
		service = new XUAF4TFEndpointImpl(new XUAF4ResponseFactory(), getVistaLinkContext());

	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em>retrieve whether or not this is a treating facility</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET IEN=632
	 * SET U="^"
	 * 
	 * Procedure Call:
	 * 
	 * D TFR^XUSOAR(.XURET,.XUIEN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XURET
	 * XURET=1
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveIsIEN() throws VistaWebServiceFault {
		String testResponse = "1";

		request.setIEN("632");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		XUAF4TFResponse response = service.tf(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getValue());

	}

	/**
	 * <em>retrieve whether or not this is a non-treating facility</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET XUIEN=17007
	 * SET U="^"
	 * 
	 * Procedure Call:
	 * 
	 * >D TFR^XUSOAR(.XURET,.XUIEN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XURET
	 * XURET=0
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveIsNotIEN() throws VistaWebServiceFault {
		String testResponse = "0";

		request.setIEN("17007");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		XUAF4TFResponse response = service.tf(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getValue());

	}

	/**
	 * <em>– attempt to retrieve the treating facility flag without defining the IEN array</em>
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >SET U="^"
	 * 
	 * Procedure Call:
	 * 
	 * >D TFR^XUSOAR(.XURET,.XUIEN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XURET
	 * XURET=0
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveWithoutIEN() throws VistaWebServiceFault {
		String testResponse = "0";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		XUAF4TFResponse response = service.tf(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getValue());

	}
	
	/**
	 * <em>attempt to retrieve the treating facility flag without specifying the station</em>
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >SET U="^"
	 * >SET XUIEN=""
	 * 
	 * Procedure Call:
	 * 
	 * >D TFR^XUSOAR(.XURET,.XUIEN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XURET
	 * XURET=0
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveNoIEN() throws VistaWebServiceFault {
		String testResponse = "0";

		request.setIEN("");
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		XUAF4TFResponse response = service.tf(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getValue());

	}
	
	/**
	 * <em>attempt to retrieve the treating facility flag using an non-existing facility internal entry number.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >SET U="^"
	 * >SET XUIEN=90
	 * 
	 * Procedure Call:
	 * 
	 * >D TFR^XUSOAR(.XURET,.XUIEN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XURET
	 * XURET=0
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveInvalidIEN() throws VistaWebServiceFault {
		String testResponse = "0";

		request.setIEN("90");
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		XUAF4TFResponse response = service.tf(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getValue());

	}
	
	/**
	 * <em>attempt to retrieve the treating facility flag using the facility name instead of the internal entry number.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >SET U="^"
	 * >SET XUIEN="NORTHPORT NHCU"
	 * 
	 * Procedure Call:
	 * 
	 * >D TFR^XUSOAR(.XURET,.XUIEN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW XURET
	 * XURET=0
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveNameIEN() throws VistaWebServiceFault {
		String testResponse = "0";

		request.setIEN("NORTHPORT NHCU");
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		XUAF4TFResponse response = service.tf(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getValue());

	}



}

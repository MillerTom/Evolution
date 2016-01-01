package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4STAEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4STAEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4STARequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4STAResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XUAF4STATest extends VistaLinkContextTestParent {
	XUAF4STARequest request;
	private XUAF4STAEndpoint service;

	@Before
	public void setUp() {
		request = new XUAF4STARequest();
		service = new XUAF4STAEndpointImpl(new XUAF4ResponseFactory(), getVistaLinkContext());

	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * – retrieve the station number
	 * 
	 * <pre>
	 * >SET XURET=""
	 * >SET XUIEN=8291
	 * >SET U="^"
	 *  
	 * >D STAR^XUSOAR(.XURET,.XUIEN)
	 *  
	 * >ZW XURET
	 * XURET="589GY"
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveStationNumber() throws VistaWebServiceFault {
		String testResponse = "589GY";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		request.setIen("8291");

		XUAF4STAResponse response = service.sta(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getStationNumber());

	}
	
	/**
	 * retrieve a blank station number from a defined station in the dictionary
	 * 
	 * <pre>
	 * >SET XURET=""
	 * >SET XUIEN=651
	 * >SET U="^"
	 *  
	 * >D STAR^XUSOAR(.XURET,.XUIEN)
	 *  
	 * >ZW XURET
	 * XURET=""
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveBlankStationNumber() throws VistaWebServiceFault {
		String testResponse = "";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		request.setIen("651");

		XUAF4STAResponse response = service.sta(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getStationNumber());

	}

	/**
	 * retrieve a station number using an undefined IEN
	 * 
	 * <pre>
	 * >SET XURET=""
	 * >SET U="^"
	 *  
	 * >D STAR^XUSOAR(.XURET,.XUIEN)
	 *  
	 * >ZW XURET
	 * XURET=""
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveUndefinedIEN() throws VistaWebServiceFault {
		String testResponse = "";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		XUAF4STAResponse response = service.sta(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getStationNumber());

	}
	
	/**
	 * retrieve a station number using an IEN of NULL
	 * 
	 * <pre>
	 * >SET XURET=""
	 * >SET XUIEN=""
	 * >SET U="^"
	 *  
	 * >D STAR^XUSOAR(.XURET,.XUIEN)
	 *  
	 * >ZW XURET
	 * XURET=""
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveNullIEN() throws VistaWebServiceFault {
		String testResponse = "";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		request.setIen("");
		XUAF4STAResponse response = service.sta(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getStationNumber());

	}
	
	/**
	 * retrieve a station number using an IEN that does not exist in the dictionary
	 * 
	 * <pre>
	 * >SET XURET=""
	 * >SET XUIEN=10000
	 * >SET U="^"
	 *  
	 * >D STAR^XUSOAR(.XURET,.XUIEN)
	 *  
	 * >ZW XURET
	 * XURET=""
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveNonexistantIEN() throws VistaWebServiceFault {
		String testResponse = "";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		request.setIen("10000");
		XUAF4STAResponse response = service.sta(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getStationNumber());

	}

}

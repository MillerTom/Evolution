package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4TFEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4TFRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4TFResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.xml.ws.soap.SOAPFaultException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class XUAF4TFIT extends EvolutionIT<XUAF4TFEndpoint> {

	XUAF4TFRequest request;

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
	 */
	@Override
	protected Class<XUAF4TFEndpoint> getType() {
		return XUAF4TFEndpoint.class;
	}

	@Before
	public void setUp() {
		request = new XUAF4TFRequest();

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
		
		try {
			service.tf(request);
			fail();
		} catch (SOAPFaultException e) {
			// This is expected
		} catch( Exception e ) {
			fail();
		}
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

		XUAF4TFResponse response = service.tf(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getValue());

	}

}

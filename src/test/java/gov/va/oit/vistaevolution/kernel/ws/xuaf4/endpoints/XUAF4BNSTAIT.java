package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4BNSTAEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BNSTARequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BNSTAResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XUAF4BNSTAIT extends EvolutionIT<XUAF4BNSTAEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XUAF4BNSTAIT.class);

	private XUAF4BNSTARequest request;
	private XUAF4BNSTAResponse response;

	@Override
	protected Class<XUAF4BNSTAEndpoint> getType() {
		return XUAF4BNSTAEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XUAF4BNSTARequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XUAF4BNSTAIT() {
		super();
	}

	/**
	 * <em>Test Case #1    Look Up billing facility name using Station  Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 				>S STA="101"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$BNSTA^XUAF4(STA)
	 * 
	 * 			Expected Output:
	 * 				>ZW RETURN
	 * 				RETURN="ZZTEST VEO BNSTA-XUAF4"
	 * 
	 * </pre>
	 * 
	 */
	@Test
	public void testBNSTA001() throws VistaWebServiceFault {

		String testResponse = "ZZTEST VEO BNSTA-XUAF4";

		request.setSta("101");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.BNSTA(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(testResponse, response.getFacilityName());

	}

	/**
	 * <em>Test Case #2    Look Up bogus billing facility 
	 * name using Station Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 				>S STA="999999999"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$BNSTA^XUAF4(STA)
	 * 
	 * 			Expected Output:
	 * 				>ZW RETURN
	 * 				RETURN=""
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testBNSTA002() throws VistaWebServiceFault {

		String testResponse = "";

		request.setSta("999999999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.BNSTA(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(testResponse, response.getFacilityName());

	}

}

/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4BnienEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BnienRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BnienResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for BNIEN method of XUAF4 Webservice
 */
public class XUAF4BnienIT extends EvolutionIT<XUAF4BnienEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XUAF4BnienIT.class);

	private XUAF4BnienRequest request;
	private XUAF4BnienResponse response;

	@Override
	protected Class<XUAF4BnienEndpoint> getType() {
		return XUAF4BnienEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XUAF4BnienRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XUAF4BnienIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Use the IEN of an institution to return the BILLING FACILITY.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=11555
	 * 
	 * Procedure Call:
	 * >D BNIENR^XUSOAR(.XURET,XUIEN)
	 * 
	 * Expected Output:
	 * >ZW XURET
	 * XURET="TEST BILLING FACILITY"
	 * 
	 * </pre>
	 */
	@Test
	public void testBnien001() throws VistaWebServiceFault {

		String result = "TEST BILLING FACILITY";

		request.setXuien("11555");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bnien(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getBfName());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Use the IEN of a non-existent institution.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=99999
	 * 
	 * Procedure Call:
	 * >D BNIENR^XUSOAR(.XURET,XUIEN)
	 * 
	 * Expected Output:
	 * >ZW XURET
	 * XURET=""
	 * 
	 * </pre>
	 */
	@Test
	public void testBnien002() throws VistaWebServiceFault {

		String result = "";

		request.setXuien("99999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bnien(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getBfName());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Use the IEN of an existing institution that has no data in the BILLING
	 * FACILITY field.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=665
	 * 
	 * Procedure Call:
	 * >D BNIENR^XUSOAR(.XURET,XUIEN)
	 * 
	 * Expected Output:
	 * >ZW XURET
	 * XURET=""
	 * 
	 * </pre>
	 */
	@Test
	public void testBnien003() throws VistaWebServiceFault {

		String result = "";

		request.setXuien("665");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bnien(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getBfName());
	}
}

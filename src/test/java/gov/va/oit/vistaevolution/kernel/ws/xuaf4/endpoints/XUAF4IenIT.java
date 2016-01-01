/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4IenEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4IenRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4IenResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for IEN method of XUAF4 Webservice
 */
public class XUAF4IenIT extends EvolutionIT<XUAF4IenEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XUAF4IenIT.class);

	private XUAF4IenRequest request;
	private XUAF4IenResponse response;

	@Override
	protected Class<XUAF4IenEndpoint> getType() {
		return XUAF4IenEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XUAF4IenRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XUAF4IenIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Lookup a Station Number and return its IEN value.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUSTA="101"
	 * 
	 * Procedure Call:
	 * >D IENR^XUSOAR(.RETURN,XUSTA)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=101
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testIen001() throws VistaWebServiceFault {

		String result = "101";

		request.setSta("101");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}
		response = service.ien(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getIen());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error. Lookup a null Station Number and return a null value.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUSTA=""
	 * 
	 * Procedure Call:
	 * >D IENR^XUSOAR(.RETURN,XUSTA)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=""
	 * 
	 * </pre>
	 */
	@Test
	public void testIen002() throws VistaWebServiceFault {

		String result = "";

		request.setSta("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}
		response = service.ien(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getIen());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error. Lookup a bogus Station Number and return null value.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUSTA="999999999"
	 * 
	 * Procedure Call:
	 * >D IENR^XUSOAR(.RETURN,XUSTA)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=""
	 * 
	 * </pre>
	 */
	@Test
	public void testIen003() throws VistaWebServiceFault {

		String result = "";

		request.setSta("999999999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}
		response = service.ien(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getIen());
	}

}

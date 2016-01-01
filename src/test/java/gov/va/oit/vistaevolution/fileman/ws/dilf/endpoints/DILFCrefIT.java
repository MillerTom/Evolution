package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFCrefEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFCrefRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFCrefResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for CREF method of DILF Webservice
 */
public class DILFCrefIT extends EvolutionIT<DILFCrefEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(DILFCrefIT.class);

	private DILFCrefRequest request;
	private DILFCrefResponse response;

	@Override
	protected Class<DILFCrefEndpoint> getType() {
		return DILFCrefEndpoint.class;
	}

	@Before
	public void setup() {
		request = new DILFCrefRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public DILFCrefIT() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * global with ending comma
	 * 
	 * <pre>
	 * 	 >S GLB="^DIZ(99999,"
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA="^DIZ(99999)"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref001() throws VistaWebServiceFault {

		String result = "^DIZ(99999)";

		request.setOpenRoot("^DIZ(99999,");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.cref(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertEquals(result, response.getClosedRoot());
	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * global with ending open parenthesis
	 * 
	 * <pre>
	 * 	>S GLB="^DIZ("
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA="^DIZ"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref002() throws VistaWebServiceFault {

		String result = "^DIZ";

		request.setOpenRoot("^DIZ(");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.cref(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertEquals(result, response.getClosedRoot());

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * global with subscript and no comma
	 * 
	 * <pre>
	 * 	 >S GLB="^DIZ(99999"
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA="^DIZ(99999)"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref003() throws VistaWebServiceFault {

		String result = "^DIZ(99999)";

		request.setOpenRoot("^DIZ(99999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.cref(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertEquals(result, response.getClosedRoot());

	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * null global value
	 * 
	 * <pre>
	 * 	 >S GLB=""
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref004() throws VistaWebServiceFault {

		String result = "";

		request.setOpenRoot("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.cref(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertEquals(result, response.getClosedRoot());

	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * global value of “^”
	 * 
	 * <pre>
	 * 	 >S GLB="^"
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA="^"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref005() throws VistaWebServiceFault {

		String result = "^";

		request.setOpenRoot("^");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.cref(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertEquals(result, response.getClosedRoot());

	}

	/**
	 * <em>Test Case #6</em>
	 * 
	 * non-global value
	 * 
	 * <pre>
	 * 	>S GLB="A"
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA="A"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref006() throws VistaWebServiceFault {

		String result = "A";

		request.setOpenRoot("A");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.cref(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertEquals(result, response.getClosedRoot());

	}

	/**
	 * <em>Test Case #7</em>
	 * 
	 * global value consisting of only numbers
	 * 
	 * <pre>
	 * 	 >S GLB="9999"
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA="9999"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref007() throws VistaWebServiceFault {

		String result = "9999";

		request.setOpenRoot("9999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.cref(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertEquals(result, response.getClosedRoot());

	}

	/**
	 * <em>Test Case #8</em>
	 * 
	 * global value of an open parenthesis
	 * 
	 * <pre>
	 * 	>S GLB="("
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref008() throws VistaWebServiceFault {

		String result = "";

		request.setOpenRoot("(");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.cref(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertEquals(result, response.getClosedRoot());

	}

	/**
	 * <em>Test Case #9</em>
	 * 
	 * global value of an end parenthesis
	 * 
	 * <pre>
	 * 	 >S GLB=")"
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA=")"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref009() throws VistaWebServiceFault {

		String result = ")";

		request.setOpenRoot(")");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.cref(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertEquals(result, response.getClosedRoot());

	}

	/**
	 * <em>Test Case #10</em>
	 * 
	 * global value of acomma
	 * 
	 * <pre>
	 * 	 >S GLB=","
	 * >D CREFR^DDR5(.DDRDATA,GLB)
	 * >ZW DDRDATA
	 * DDRDATA=","
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCref010() throws VistaWebServiceFault {

		String result = ",";

		request.setOpenRoot(",");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.cref(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}
		assertNotNull(response);
		assertEquals(result, response.getClosedRoot());

	}

}

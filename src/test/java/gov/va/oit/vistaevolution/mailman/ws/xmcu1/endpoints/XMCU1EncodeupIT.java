package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.XMCU1EncodeupEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1EncodeupRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1EncodeupResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for Encodeup method of XMCU1 Webservice
 */
public class XMCU1EncodeupIT extends EvolutionIT<XMCU1EncodeupEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(XMCU1EncodeupIT.class);

	private XMCU1EncodeupResponse response;
	private XMCU1EncodeupRequest request;

	@Override
	protected Class<XMCU1EncodeupEndpoint> getType() {
		return XMCU1EncodeupEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMCU1EncodeupRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMCU1EncodeupIT() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Pass in a string with embedded �^�. Return the string with any �^�
	 * characters converted to �~U~�.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING="A^B^C^D^"
	 * 
	 * Procedure Call:
	 * >D ENCODEUP^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="A~U~B~U~C~U~D~U~"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeup001() throws VistaWebServiceFault {

		String result = "A~U~B~U~C~U~D~U~";

		request.setInputString("A^B^C^D^");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.encodeup(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Pass in a string with no embedded �^� characters. Return the passed in
	 * string.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING="ABCD"
	 * 
	 * Procedure Call:
	 * >D ENCODEUP^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="ABCD"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeup002() throws VistaWebServiceFault {

		String result = "ABCD";

		request.setInputString("ABCD");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.encodeup(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * Pass in a string that contains all �^� characters. Return the converted
	 * string with all �~U~� characters.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING="^^^^"
	 * 
	 * Procedure Call:
	 * >D ENCODEUP^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~U~~U~~U~~U~"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeup003() throws VistaWebServiceFault {

		String result = "~U~~U~~U~~U~";

		request.setInputString("^^^^");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.encodeup(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * Pass in a string that contains all �~U~� characters. Return the converted
	 * string with all �~U~� characters.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING="~U~~U~~U~~U~"
	 * 
	 * Procedure Call:
	 * >D ENCODEUP^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~U~~U~~U~~U~"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeup004() throws VistaWebServiceFault {

		String result = "~U~~U~";

		request.setInputString("~U~~U~");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.encodeup(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * Pass in a null string. Return an error message.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=""
	 * 
	 * Procedure Call:
	 * >D ENCODEUP^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeup005() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		request.setInputString("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.encodeup(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

}

package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.XMCU1DecodeupEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1DecodeupRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1DecodeupResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for Decodeup method of XMCU1 Webservice
 */
public class XMCU1DecodeupIT extends EvolutionIT<XMCU1DecodeupEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(XMCU1DecodeupIT.class);

	private XMCU1DecodeupResponse response;
	private XMCU1DecodeupRequest request;

	@Override
	protected Class<XMCU1DecodeupEndpoint> getType() {
		return XMCU1DecodeupEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMCU1DecodeupRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMCU1DecodeupIT() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Pass in a string with embedded “~U~”. Return the string with all “~U~”
	 * characters converted to “^”.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING="A~U~B~U~C~U~D~U~"
	 * 
	 * Procedure Call:
	 * >D DECODEUP^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="A^B^C^D^"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDecodeup001() throws VistaWebServiceFault {

		String result = "A^B^C^D^";

		request.setInputString("A~U~B~U~C~U~D~U~");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.decodeup(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Pass in a string with no embedded “~U~” characters. Return the passed in
	 * string.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING="ABCD"
	 * 
	 * Procedure Call:
	 * >D DECODEUP^XMWSOA01(.RETURN,STRING)
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
	public void testDecodeup002() throws VistaWebServiceFault {

		String result = "ABCD";

		request.setInputString("ABCD");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.decodeup(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * Pass in a string that contains all “~U~” characters. Return the converted
	 * string with all “^” characters.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING="~U~~U~~U~~U~"
	 * 
	 * Procedure Call:
	 * >D DECODEUP^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="^^^^"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDecodeup003() throws VistaWebServiceFault {

		String result = "^^^^";

		request.setInputString("~U~~U~~U~~U~");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.decodeup(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * Pass in a string that contains all “^” characters. Return the converted
	 * string with all “^” characters.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING="^^^^"
	 * 
	 * Procedure Call:
	 * >D DECODEUP^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="^^^^"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDecodeup004() throws VistaWebServiceFault {

		String result = "^^^^";

		request.setInputString("^^^^");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.decodeup(request);

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
	 * >D DECODEUP^XMWSOA01(.RETURN,STRING)
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
	public void testDecodeup005() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		request.setInputString("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.decodeup(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}
}
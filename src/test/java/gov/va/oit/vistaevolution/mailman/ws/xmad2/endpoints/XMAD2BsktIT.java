package gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints.interfaces.XMAD2BsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for BSKT method of XMAD2 Webservice
 */
public class XMAD2BsktIT extends EvolutionIT<XMAD2BsktEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XMAD2BsktIT.class);

	private XMAD2BsktRequest request;
	private XMAD2BsktResponse response;

	@Override
	protected Class<XMAD2BsktEndpoint> getType() {
		return XMAD2BsktEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMAD2BsktRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMAD2BsktIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Pass in DUZ and an existing basket name and return the basket IEN.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XMDUZ=.6
	 * >S XMKN="WASTE"
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=.5
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testBskt001() throws VistaWebServiceFault {

		String result = ".5";

		request.setXmduz(".6");
		request.setXmkn("WASTE");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bskt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Pass in DUZ and a non-existent basket name and return the new basket IEN.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XMDUZ=.6
	 * >S XMKN="NEW BASKET"
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=2
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testBskt002() throws VistaWebServiceFault {

		String result = "2";

		request.setXmduz(".6");
		request.setXmkn("NEW BASKET");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bskt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Pass in a non-existentDUZ and return an error message.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XMDUZ=9999999
	 * >S XMKN="TEST ERROR"
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^User '9999999' not found."
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testBskt003() throws VistaWebServiceFault {

		String result = "-1^User '9999999' not found.";

		request.setXmduz("9999999");
		request.setXmkn("TEST ERROR");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bskt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Pass in a basket name of less than two characters and return an error
	 * message.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=DUZ
	 * >S XMKN="A"
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Must be |1|-|2| characters, no ^."
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testBskt004() throws VistaWebServiceFault {

		String result = "-1^Must be |1|-|2| characters, no ^.";

		request.setXmduz(".6");
		request.setXmkn("A");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bskt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * Pass in a basket name of more than 30 characters and return an error
	 * message.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XMDUZ=DUZ
	 * >S XMKN="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567"
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Must be |1|-|2| characters, no ^."
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testBskt005() throws VistaWebServiceFault {

		String result = "-1^Must be |1|-|2| characters, no ^.";

		request.setXmduz(".6");
		request.setXmkn("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bskt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #6  </em>
	 * 
	 * Pass in a basket name containing a “^” character and return an error
	 * message.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XMDUZ=DUZ
	 * >S XMKN="A^BASKET"
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Must be |1|-|2| characters, no ^."
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testBskt006() throws VistaWebServiceFault {

		String result = "-1^Must be |1|-|2| characters, no ^.";

		request.setXmduz(".6");
		request.setXmkn("A^BASKET");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bskt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #7  </em>
	 * 
	 * Pass in a DUZ for which you are not authorized to be a surrogate and
	 * return an error message.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XMDUZ=83197
	 * >S XMKN="TEST SURROGATE CHECK"
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^You are not authorized to be a surrogate of DUZ 83197."
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testBskt007() throws VistaWebServiceFault {

		String result = "-1^You are not authorized to be a surrogate of DUZ 83197.";

		request.setXmduz("83197");
		request.setXmkn("TEST SURROGATE CHECK");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bskt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #8  </em>
	 * 
	 * Pass in null DUZ and return an error message.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XMDUZ=""
	 * >S XMKN="TEST ERROR”
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN)
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
	public void testBskt008() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		request.setXmduz("");
		request.setXmkn("TEST ERROR");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bskt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #9  </em>
	 * 
	 * Pass in null basket name and return an error message.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XMDUZ=DUZ
	 * >S XMKN=""
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN)
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
	public void testBskt009() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		request.setXmduz(".6");
		request.setXmkn("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.bskt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces.XMS1StatusEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1StatusRequest;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1StatusResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Leisa Martella
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for Status Method of XMS1 Status Web service
 */
public class XMS1StatusIT extends EvolutionIT<XMS1StatusEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XMS1StatusIT.class);

	private XMS1StatusRequest request;
	private XMS1StatusResponse response;

	@Override
	protected Class<XMS1StatusEndpoint> getType() {
		return XMS1StatusEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMS1StatusRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMS1StatusIT() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Error. Do not pass in the Message IEN or the Server Name.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K RETURN
	 * >S XMZ=""
	 * >S XMSER=""
	 * 
	 * Procedure Call:
	 * >D STATUS^XMWSOA01(.RETURN,XMZ,XMSER)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStatus001() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		request.setXmz("");
		request.setXmser("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.status(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Error. Pass in the non-existing Server Name.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMZ=""
	 * >S XMSER="55117"
	 * 
	 * Procedure Call:
	 * >D STATUS^XMWSOA01(.RETURN,XMZ,XMSER)
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
	public void testStatus002() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		request.setXmz("");
		request.setXmser("55117");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.status(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * Error. Pass in no Message IEN and a valid Server Name.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K RETURN
	 * >S XMZ=""
	 * >S XMSER="S.XTPM PATCH SERVER"
	 * 
	 * Procedure Call:
	 * >D STATUS^XMWSOA01(.RETURN,XMZ,XMSER)
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
	public void testStatus003() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		request.setXmz("");
		request.setXmser("S.XTPM PATCH SERVER");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.status(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * Error. Pass in an invalid Message IEN and a valid Server Name.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K RETURN
	 * >S XMZ="55117"
	 * >S XMSER="S.XTPM PATCH SERVER"
	 * 
	 * Procedure Call:
	 * >D STATUS^XMWSOA01(.RETURN,XMZ,XMSER)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RESULT="-1^Invalid recipient or message"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStatus004() throws VistaWebServiceFault {

		String result = "-1^Invalid recipient or message";

		request.setXmz("55117");
		request.setXmser("S.XTPM PATCH SERVER");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.status(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * Pass in avalid Message IEN and a valid Server Name.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K RETURN
	 * >S XMZ="29"
	 * >S XMSER="XXX@Q-ASI.MED.VA.GOV"
	 * 
	 * Procedure Call:
	 * >D STATUS^XMWSOA01(.RETURN,XMZ,XMSER)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^Awaiting transmission."
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStatus005() throws VistaWebServiceFault {

		String result = "0^Awaiting transmission.";

		request.setXmz("29");
		request.setXmser("XXX@Q-ASI.MED.VA.GOV");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.status(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #6</em>
	 * 
	 * Pass in a valid Message IEN and a valid Server Name.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMZ="202159"
	 * >S XMSER="S.YSCLSERVER"
	 * 
	 * Procedure Call:
	 * >D STATUS^XMWSOA01(.RETURN,XMZ,XMSER)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^Served (hand off done)"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStatus006() throws VistaWebServiceFault {

		String result = "0^Served (hand off done)";

		request.setXmz("202159");
		request.setXmser("S.YSCLSERVER");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.status(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

}

package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.XQCSOptlkEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSOptlkRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSOptlkResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for OPTLK method of XQCS Webservice
 */
public class XQCSOptlkIT extends EvolutionIT<XQCSOptlkEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XQCSOptlkIT.class);

	private XQCSOptlkRequest request;
	private XQCSOptlkResponse response;

	@Override
	protected Class<XQCSOptlkEndpoint> getType() {
		return XQCSOptlkEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XQCSOptlkRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XQCSOptlkIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Lookup the Option named “XUCOMMAND” and return its IEN.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S OPTION="XUCOMMAND"
	 * 
	 * Procedure Call:
	 * >S RETURN=$$OPTLK^XQCS(OPTION)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=10
	 * 
	 * </pre>
	 */
	@Test
	public void testOptlk001() throws VistaWebServiceFault {

		String result = "10";

		request.setXuopt("XUCOMMAND");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.optlk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #2  </em> Lookup the Option named “ZTESTOPTLKXQCS002” and
	 * return a null value.
	 * 
	 * <pre>
	 * Input Data:
	 * >S OPTION="ZTESTOPTLKXQCS002"
	 * 
	 * Procedure Call:
	 * >S RETURN=$$OPTLK^XQCS(OPTION)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=""
	 * 
	 * </pre>
	 */
	@Test
	public void testOptlk002() throws VistaWebServiceFault {

		String result = "";

		request.setXuopt("ZTESTOPTLKXQCS002");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.optlk(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

}

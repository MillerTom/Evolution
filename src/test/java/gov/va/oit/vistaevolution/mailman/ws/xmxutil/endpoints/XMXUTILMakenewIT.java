/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILMakenewEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILMakenewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILMakenewResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for MAKENEW method of XMXUTIL Webservice
 */
public class XMXUTILMakenewIT extends EvolutionIT<XMXUTILMakenewEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(XMXUTILMakenewIT.class);

	private XMXUTILMakenewRequest request;
	private XMXUTILMakenewResponse response;

	@Override
	protected Class<XMXUTILMakenewEndpoint> getType() {
		return XMXUTILMakenewEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMXUTILMakenewRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMXUTILMakenewIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Make a message new.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMDUZ=.5,XMK=1,XMZ=285424,XMLOCKIT=0
	 * 
	 * Procedure Call:
	 * >D MAKENEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^Successful"
	 * 
	 * </pre>
	 */
	@Test
	public void testMakenew001() throws VistaWebServiceFault {
		// unexpected data returned
		String results = "0^Successful";

		request.setXmduz(".5");
		request.setXmk("1");
		request.setXmz("285424");
		request.setXmlockit("0");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.makenew(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getAddMsgResult());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Make a message new. Have MailMan lock and unlock the mailbox global.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMDUZ=.5,XMK=1,XMZ=285425,XMLOCKIT=1
	 * 
	 * Procedure Call:
	 * >D MAKENEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^Successful"
	 * 
	 * </pre>
	 */
	@Test
	public void testMakenew002() throws VistaWebServiceFault {

		// unexpected data returned
		String results = "0^Successful";

		request.setXmduz(".5");
		request.setXmk("1");
		request.setXmz("285425");
		request.setXmlockit("1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.makenew(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getAddMsgResult());

	}

}

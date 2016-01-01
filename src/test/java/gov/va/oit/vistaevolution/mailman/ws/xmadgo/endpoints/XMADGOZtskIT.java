/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmadgo.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.endpoints.interfaces.XMADGOZtskEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.model.XMADGOZtskRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.model.XMADGOZtskResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
/**
 * 
 * XMWSOA ZTSK
 * 
 * This RPC starts tasks to deliver messages in local delivery queues. It
 * has no effect if the background filer has been stopped or if the local
 * delivery queues are already active.
 * 
 * Returns:
 *    0^Tasks started to deliver messages in local delivery queues
 *    -1^Background filer set to stop"
 *   
 */

public class XMADGOZtskIT extends EvolutionIT<XMADGOZtskEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMADGOZtskIT.class);

	@Override
	protected Class<XMADGOZtskEndpoint> getType() {
		return XMADGOZtskEndpoint.class;
	}
	

	private XMADGOZtskRequest request;
	private XMADGOZtskResponse response;

	@Before
	public void setUp() {
		request = new XMADGOZtskRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * Test Case #1  
	 *
	 * Test normally
	 * 
	 * >D ZTSK^XMWSOA08(.RESULT)
	 * 
	 * >ZW RESULT
	 * RESULT="0^Tasks started to deliver messages in local delivery queues"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testLkCheck001() throws VistaWebServiceFault {

		// Execute request against mocked object backend.
		response = service.ztsk(request);

		assertNotNull(response);
		assertEquals("0^Tasks started to deliver messages in local delivery queues", response.getResults());
	}

}

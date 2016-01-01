/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITVaporEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXEDITVaporIT extends EvolutionIT<XMXEDITVaporEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(XMXEDITVaporIT.class);

	/**
	 * Test Case #1 - valid input
	 */
	@Ignore
	@Test
	public void testVapor001() throws VistaWebServiceFault, Exception {
		
		// this next line needs to be amended to use CRE8XMZ when it becomes available
		
		XMXEDITVaporRequest request = new XMXEDITVaporRequest("74457", "3140318");
		
		XMXEDITVaporResponse response = service.vapor(request);
		
		assertNotNull(response);
		
		LOGGER.debug(response.getXmmsg());
		
		assertTrue(response.getXmmsg().equals("0^Successful"));

	}

	/**
	 * Test Case #2 - Error in required input
	 */
	@Test
	public void testVapor002() throws VistaWebServiceFault {
		XMXEDITVaporRequest request = new XMXEDITVaporRequest("0", "3140318");
		
		XMXEDITVaporResponse response = service.vapor(request);
		
		assertNotNull(response);
		
		LOGGER.debug(response.getXmmsg());
		
		assertTrue(response.getXmmsg().equals("-1^Error in required input"));

	}

	/**
	 * Test Case #3 - Message not found
	 */
	@Test
	public void testVapor003() throws VistaWebServiceFault {
		XMXEDITVaporRequest request = new XMXEDITVaporRequest("-9999", "3140318");
		
		XMXEDITVaporResponse response = service.vapor(request);
		
		assertNotNull(response);
		
		LOGGER.debug(response.getXmmsg());
		
		assertTrue(response.getXmmsg().equals("-1^Message not found"));

	}

	@Override
	protected Class<XMXEDITVaporEndpoint> getType() {
		return XMXEDITVaporEndpoint.class;
	}

}

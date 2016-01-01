/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TstampResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for TSTAMP method of XMXUTIL1 Webservice
 */
public class XMXUTIL1TstampIT extends VistaLinkContextITParent {

	@Autowired
	private XMXUTIL1TstampEndpointImpl service;

	private XMXUTIL1TstampResponse response;

	/**
	 * Default Empty Constructor
	 */
	public XMXUTIL1TstampIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Generate a current timestamp.
	 * 
	 * <pre>
	 * Input Data:
	 * None.
	 * 
	 * Procedure Call:
	 * >D TSTAMP^XMWSOA07(.RETURN)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=5464917241
	 * 
	 * </pre>
	 */
	@Test
	public void testTstamp001() throws VistaWebServiceFault {

		response = service.tstamp();

		assertNotNull(response);
		if (response.getCurrentTimeStamp() != null) {
			assertEquals("5464917241", response.getCurrentTimeStamp());
		} else {
			fail("currentTimeStamp is NULL !!");
		}
	}
}

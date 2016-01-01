/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces.XUSKAAJUserinfoEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJUserinfoRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJUserinfoResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XUSKAAJUserinfoIT extends VistaLinkContextITParent {

	private static final Logger LOGGER = Logger.getLogger(XUSKAAJUserinfoIT.class);
	
	@Autowired
	private XUSKAAJUserinfoEndpoint service;
	
	private static XUSKAAJUserinfoRequest request;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		request = new XUSKAAJUserinfoRequest();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		request = null;
	}

	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Get User info for current user of specified workstation in return array RET
	 * </pre>
	 */
	@Test
	public void testUserinfo001() throws VistaWebServiceFault {
		
		request.setClientip("72.152.237.118");
		request.setServernm("SDVMRPMSDEV01");
		
		XUSKAAJUserinfoResponse response = service.userinfo(request);
		
		assertNotNull(response);
		
		if (response.getRet() != null && !response.getRet().isEmpty()) {
			// LOGGER.info(response.getRet().get(0));
			for (int i = 0; i < response.getRet().size(); i++) {
				LOGGER.info("ret[" + i + "]: " + response.getRet().get(i));
			}
			assertTrue(response.getRet().get(0).equals("1"));
		} else {
			fail("no response received");
		}

		
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Get User info for current user of specified workstation in return array RET
	 * </pre>
	 */
	@Test
	public void testUserinfo002() throws VistaWebServiceFault {
		
		request.setClientip("192.168.1.1");
		request.setServernm("FLINTSTONE");
		
		XUSKAAJUserinfoResponse response = service.userinfo(request);
		
		assertNotNull(response);
		
		if (response.getRet() != null && !response.getRet().isEmpty()) {
			// LOGGER.info(response.getRet().get(0));
			for (int i = 0; i < response.getRet().size(); i++) {
				LOGGER.info("ret[" + i + "]: " + response.getRet().get(i));
			}
			assertTrue(response.getRet().get(0).equals("1"));
		} else {
			fail("no response received");
		}

		
	}
}

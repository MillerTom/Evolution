/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BS2Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Request;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Response;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XMA1BS2IT extends VistaLinkContextITParent {

	private static final Logger LOGGER = Logger.getLogger(XMA1BS2IT.class);
	
	@Autowired
	private XMA1BS2Endpoint service;
	
	private static XMA1BS2Request request;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		// service = new XMA1BS2EndpointImpl();
		request = new XMA1BS2Request();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		request = null;
	}

	@Before
	public void setupTest() {
	    request.setXmduz(".5");
	    request.setXmkm("");
	    request.setXmz("");
	}

	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Put a message in the current user's IN basket.
	 * </pre>
	 */
	@Test
	public void testS2001() throws VistaWebServiceFault {
	    request.setXmduz(".6");
        request.setXmkm("1");
        request.setXmz("73865");
        
        XMA1BS2Response response = this.service.s2(request);
        assertNotNull(response);
        LOGGER.info("response: " + response.getResponse());
        assertTrue(response.getResponse().equalsIgnoreCase("-1^XMDUZ is not a recipient of the message"));
	}

}

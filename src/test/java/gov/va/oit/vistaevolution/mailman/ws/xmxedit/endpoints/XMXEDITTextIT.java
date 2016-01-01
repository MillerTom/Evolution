/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITTextEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXEDITTextIT extends EvolutionIT<XMXEDITTextEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(XMXEDITTextIT.class);

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITTextEndpointImpl#text(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextRequest)}.
	 */
	@Test
	public void testText001() {
		List<String> xmbody = new ArrayList<String>();
		xmbody.add("LINE 1");
		xmbody.add("LINE 2");
		
		XMXEDITTextRequest request = new XMXEDITTextRequest("76492", xmbody);
		
		XMXEDITTextResponse response = service.text(request);
		
		assertNotNull(response);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertTrue(response.getResponse().equals("0^Successful"));
	}

	@Test
	public void testText002() {
		List<String> xmbody = new ArrayList<String>();
		xmbody.add("LINE 1");
		xmbody.add("LINE 2");
		
		XMXEDITTextRequest request = new XMXEDITTextRequest("0", xmbody);
		
		XMXEDITTextResponse response = service.text(request);
		
		assertNotNull(response);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertTrue(response.getResponse().equals("-1^Error in required input"));
	}

	@Test
	public void testText003() {
		List<String> xmbody = new ArrayList<String>();
		xmbody.add("LINE 1");
		xmbody.add("LINE 2");
		
		XMXEDITTextRequest request = new XMXEDITTextRequest("-9999", xmbody);
		
		XMXEDITTextResponse response = service.text(request);
		
		assertNotNull(response);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertTrue(response.getResponse().equals("-1^Message not found"));
	}

	@Override
	protected Class<XMXEDITTextEndpoint> getType() {
		return XMXEDITTextEndpoint.class;
	}

}

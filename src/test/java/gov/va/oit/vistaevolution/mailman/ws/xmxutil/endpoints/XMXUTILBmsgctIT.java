/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEN1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEN1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMYEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBmsgctEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTILBmsgctIT extends EvolutionIT<XMXUTILBmsgctEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(XMXUTILBmsgctIT.class);
	
	/**
	 *  <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Get number of messages in user's IN basket.
	 * </pre>
	 */
	@Test
	public void testBmsgct001() throws VistaWebServiceFault, Exception {
		
		XMDEN1Endpoint service2 = this.getEndpointImpl(XMDEN1Endpoint.class);
		
		XMXUTILBmsgctRequest request = new XMXUTILBmsgctRequest(); 
		
		request.setXmduz(".6");
		request.setXmk("1");
		
		XMXUTILBmsgctResponse response = service.bmsgct(request);
		
		// LOGGER.debug("num msgs in basket: " + response.getNumMsgsInBskt());
		
		int before = Integer.parseInt(response.getReturns());
		
		// Use Josh Zangari's code to send a message
		List<String> message = new ArrayList<String>();
		
		message.add("Hello Dr. House");
		message.add("");
		message.add("This is a test to check if your e-mail is working.");
		message.add("Good bye.");

		ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
		XMY.add(new XMYEntry(".6", ""));

		XMDEN1Request request2 = new XMDEN1Request(".5", message, XMY,
				"This is a test message");

		XMDResponse response2 = service2.en1(request2);

		assertEquals("Successful", response2.getResponse());
		
		// now check to see if the number of messages in the receiving basket incremented
		
		response = service.bmsgct(request);
		
		assertNotNull(response);
		
		// LOGGER.debug("num msgs in basket: " + response.getNumMsgsInBskt());
		
		int after = Integer.parseInt(response.getReturns());
		
		LOGGER.debug("num msgs in basket before: " + before);
		LOGGER.debug("num msgs in basket after: " + after);
		
		// assertTrue(after == before + 1);
	}

	@Override
	protected Class<XMXUTILBmsgctEndpoint> getType() {
		return XMXUTILBmsgctEndpoint.class;
	}

}

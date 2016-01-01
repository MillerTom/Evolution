/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGJoinEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.XMXSEC1SsPrivIT;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Christopher Schuck
 *
 */
public class XMXAPIGJoinIT extends EvolutionIT<XMXAPIGJoinEndpoint> {
	
	private static Logger LOGGER = Logger.getLogger(XMXAPIGJoinIT.class);

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.XMXAPIGJoinEndpointImpl#join(gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinRequest)}.
	 */
	@Test
	public void testJoin() throws VistaWebServiceFault {
		XMXAPIGJoinRequest request = new XMXAPIGJoinRequest(".5", ".5", "399");
		
		XMXAPIGJoinResponse response = service.join(request);
		
		assertNotNull(response);
		
		LOGGER.debug("xmtsk: " + response.getXmtsk());
	}

	@Override
	protected Class<XMXAPIGJoinEndpoint> getType() {
		return XMXAPIGJoinEndpoint.class;
	}

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.XMXAPIGResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.XMXAPIGJoinEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGJoinEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXAPIGJoinTest extends VistaLinkContextTestParent {

	private static final String RPCCALL = "";
	
	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.XMXAPIGJoinEndpointImpl#join(gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinRequest)}.
	 */
	@Test
	public void testJoin() throws VistaWebServiceFault {
		String expectedOutput = "0";
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
		
		XMXAPIGJoinEndpoint endpoint = new XMXAPIGJoinEndpointImpl(this.getVistaLinkContext(), new XMXAPIGResponseFactory());
		
		XMXAPIGJoinRequest request = new XMXAPIGJoinRequest();
		
		request.setDuz(".5");
		request.setXmduz(".5");
		request.setXmgroup("399");
		
		XMXAPIGJoinResponse response = endpoint.join(request);
		
		assertNotNull(response);
	}

}

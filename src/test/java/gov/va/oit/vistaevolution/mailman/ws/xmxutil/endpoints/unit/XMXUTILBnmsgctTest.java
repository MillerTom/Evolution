/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILBnmsgctEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBnmsgctEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBnmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBnmsgctResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTILBnmsgctTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILBnmsgctEndpointImpl#bnmsgct(gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBnmsgctRequest)}.
	 */
	@Test
	public void testBnmsgct() throws VistaWebServiceFault {
		String expectedOutput = "1";
		
		XMXUTILBnmsgctRequest request = new XMXUTILBnmsgctRequest();
		
		request.setXmduz(".6");
		request.setXmk("1");
		
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XMXUTILBnmsgctEndpoint endpoint = new XMXUTILBnmsgctEndpointImpl(new XMXUTILResponseFactory(), this.getVistaLinkContext());
        
        XMXUTILBnmsgctResponse response = endpoint.bnmsgct(request);
        
        assertNotNull(response);      
        assertTrue(response.getReturns().equals("1"));
	}

}

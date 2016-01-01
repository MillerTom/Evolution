package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILBmsgctEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBmsgctEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XMXUTILBmsgctTest extends VistaLinkContextTestParent {

	private static final String RPCCALL = "";
	
	@Test
	public void testBmsgct() throws VistaWebServiceFault {
		String expectedOutput = "1";
		
		XMXUTILBmsgctRequest request = new XMXUTILBmsgctRequest();
		
		request.setXmduz(".6");
		request.setXmk("1");
		
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XMXUTILBmsgctEndpoint endpoint = new XMXUTILBmsgctEndpointImpl(new XMXUTILResponseFactory(), this.getVistaLinkContext());
        
        XMXUTILBmsgctResponse response = endpoint.bmsgct(request);
        
        assertNotNull(response);      
        assertTrue(response.getReturns().equals("1"));
        
	}

}

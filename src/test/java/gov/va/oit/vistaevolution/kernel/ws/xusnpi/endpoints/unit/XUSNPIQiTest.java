package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.XUSNPIResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.XUSNPIQiEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPIQiEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIQiRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIQiResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XUSNPIQiTest extends VistaLinkContextTestParent {

	private static final String RPCCALL = "";
	
	@Test
	public void testQi() throws VistaWebServiceFault {
		String expectedOutput = "0";
		
		XUSNPIQiRequest request = new XUSNPIQiRequest("53476");
		
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XUSNPIQiEndpoint endpoint = new XUSNPIQiEndpointImpl(getVistaLinkContext(), new XUSNPIResponseFactory());
        
        XUSNPIQiResponse response = endpoint.qi(request);
        
        assertNotNull(response);        
        assertEquals(expectedOutput, response.getResponse());
	}

}

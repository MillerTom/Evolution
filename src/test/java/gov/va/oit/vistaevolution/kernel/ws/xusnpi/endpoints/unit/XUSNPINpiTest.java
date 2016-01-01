/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.XUSNPIResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.XUSNPINpiEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPINpiEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XUSNPINpiTest extends VistaLinkContextTestParent {

	private static final String RPCCALL = "";
	
	/**
	 * Test method for {@link gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.XUSNPINpiEndpointImpl#npi(gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiRequest)}.
	 */
	@Test
	public void testNpi() throws VistaWebServiceFault {
        String expectedOutput = "0";
        
        XUSNPINpiRequest request = new XUSNPINpiRequest("Individual_ID", ".6");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XUSNPINpiEndpoint endpoint = new XUSNPINpiEndpointImpl(getVistaLinkContext(), new XUSNPIResponseFactory());
        
        XUSNPINpiResponse response = endpoint.npi(request);
        
        assertNotNull(response);        
        assertEquals(expectedOutput, response.getResponse());
	}

}

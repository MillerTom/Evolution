/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.XUS1AResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints.XUS1AProhibitEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints.interfaces.XUS1AProhibitEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitRequest;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XUS1AProhibitTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints.XUS1AProhibitEndpointImpl#prohibit(gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitRequest)}.
	 */
	@Test
	public void testProhibit() {
		String expectedOutput = "1^";
		
		XUS1AProhibitRequest request = new XUS1AProhibitRequest("1500", "0800-2300");
		
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XUS1AProhibitEndpoint endpoint = new XUS1AProhibitEndpointImpl(getVistaLinkContext(), new XUS1AResponseFactory());
        
        XUS1AProhibitResponse response = endpoint.prohibit(request);
        
        assertNotNull(response);        
        assertEquals(expectedOutput, response.getResponse());
	}

}

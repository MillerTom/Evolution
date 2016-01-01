/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.XMA1CResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.XMA1CSetsbEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.XMA1CSetsbEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMA1CSetsbTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.XMA1CSetsbEndpointImpl#setsb(gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbRequest)}.
	 */
	@Test
	public void testSetsb() throws VistaWebServiceFault {
        String expectedOutput = "0^Successful";
        
        XMA1CSetsbRequest request = new XMA1CSetsbRequest(); 
        
        request.setXmxx("S.XU");
        request.setXmz("999");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMA1CSetsbEndpoint endpoint = new XMA1CSetsbEndpointImpl(new XMA1CResponseFactory(), 
                this.getVistaLinkContext() );
        
        //  Execute the Endpoint
        XMA1CSetsbResponse response = endpoint.setsb(request);
        
        assertNotNull(response);
        assertEquals("0", response.getReturnCode());
	}

}

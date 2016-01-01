
package gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.XMA1CResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.XMA1CRemsbmsgEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.XMA1CRemsbmsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CRemsbmsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CRemsbmsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMA1CRemsbmsgTest extends VistaLinkContextTestParent {

    private static final String RPCCALL = "XMWSOA REMSBMSG";   
    
    @Test
    public void testDeleteMessage001() throws VistaWebServiceFault {
     
        String expectedOutput = "0^Successful";
        
        XMA1CRemsbmsgRequest request = new XMA1CRemsbmsgRequest(); 
        
        request.setXmser("S.XU USER ADD");
        request.setXmz("999");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMA1CRemsbmsgEndpoint endpoint = new XMA1CRemsbmsgEndpointImpl(this.getVistaLinkContext(), 
                new XMA1CResponseFactory() );
        
        //  Execute the Endpoint
        XMA1CRemsbmsgResponse response = endpoint.remsbmsg(request);
        
        assertNotNull(response);      
        assertTrue(response.getResponse().equalsIgnoreCase("0^Successful"));
    }   
    
}

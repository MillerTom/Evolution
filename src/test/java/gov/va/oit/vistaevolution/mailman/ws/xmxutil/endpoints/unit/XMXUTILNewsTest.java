/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILNewsEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNewsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNewsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNewsResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
public class XMXUTILNewsTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "";
    

    @Test
    public void testNews() throws VistaWebServiceFault {
        
        String expectedOutput = "NEWS";
        
        XMXUTILNewsRequest request = new XMXUTILNewsRequest();
        
        request.setXmDuz(".5");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTILNewsEndpoint endpoint = new XMXUTILNewsEndpointImpl(this.getVistaLinkContext(),
                new XMXUTILResponseFactory());
        
        //  Execute request
        XMXUTILNewsResponse response = endpoint.news(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResults());
        
    }
}

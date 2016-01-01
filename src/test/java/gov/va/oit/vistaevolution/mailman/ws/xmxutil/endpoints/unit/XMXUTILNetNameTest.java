/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILNetNameEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNetNameEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNetNameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNetNameResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
public class XMXUTILNetNameTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "";
    

    @Test
    public void testNetName() throws VistaWebServiceFault {
        
        String expectedOutput = "NETNAME";
        
        XMXUTILNetNameRequest request = new XMXUTILNetNameRequest();
        
        request.setXmDuz(".5");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTILNetNameEndpoint endpoint = new XMXUTILNetNameEndpointImpl(this.getVistaLinkContext(),
                new XMXUTILResponseFactory());
        
        //  Execute request
        XMXUTILNetNameResponse response = endpoint.netName(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResults());
        
    }
}

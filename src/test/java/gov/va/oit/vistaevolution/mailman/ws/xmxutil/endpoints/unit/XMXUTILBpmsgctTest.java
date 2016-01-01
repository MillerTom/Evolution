/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILBpmsgctEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBpmsgctEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBpmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBpmsgctResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXUTILBpmsgctTest extends VistaLinkContextTestParent {

    private static final String RPCCALL = "XMWSOA NUMB PRIORITY IN BSK";
    

    @Test
    public void testPriority() throws VistaWebServiceFault {
        
        String expectedOutput = "6";
        
        XMXUTILBpmsgctRequest request = new XMXUTILBpmsgctRequest();
        
        request.setXmduz(".5");
        request.setXmk("1");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTILBpmsgctEndpoint endpoint = new XMXUTILBpmsgctEndpointImpl(this.getVistaLinkContext(),
                new XMXUTILResponseFactory());
        
        //  Execute request
        XMXUTILBpmsgctResponse response = endpoint.bpmsgct(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getReturns());
        
    }
    
    @Test(expected = VistaWebServiceFault.class)
    public void testPriorityFail() {
        
        String expectedOutput = "6";
        
        XMXUTILBpmsgctRequest request = new XMXUTILBpmsgctRequest();
        
        request.setXmduz(".5");
        request.setXmk("1");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenThrow(new VistaWebServiceFault("MOCKITO ERROR"));
        
        //  Set up Endpoint
        XMXUTILBpmsgctEndpoint endpoint = new XMXUTILBpmsgctEndpointImpl(this.getVistaLinkContext(),
                new XMXUTILResponseFactory());
        
        //  Execute request
        XMXUTILBpmsgctResponse response = endpoint.bpmsgct(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getReturns());        
    }

    
}

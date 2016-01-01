/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITDeliverEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITDeliverEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITDeliverRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITDeliverResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXEDITDeliverTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XMWSOA DELIVER BASKET ALL";
    
    
    @Test
    public void deliverTest() {        
        
        String expectedOutput = "-1^You may not Edit a message you have already sent to someone else.";
        
        XMXEDITDeliverRequest request = new XMXEDITDeliverRequest();
        
        request.setXmz(".6");       
        request.setXmdbkst("COLTRANE");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXEDITDeliverEndpoint endpoint = new XMXEDITDeliverEndpointImpl(this.getVistaLinkContext(),
                new XMXEDITResponseFactory());
        
        //  Execute request
        XMXEDITDeliverResponse response = endpoint.deliver(request);        
        assertNotNull(response);
        assertEquals("-1", response.getStatus());
        assertEquals("You may not Edit a message you have already sent to someone else.", response.getMessage());
        assertEquals(expectedOutput, response.getRawResponse());
        
    }
    
    
    @Test(expected = VistaWebServiceFault.class)
    public void deliverErrorTest() {        
        
        String expectedOutput = "-1^You may not Edit a message you have already sent to someone else.";
        
        XMXEDITDeliverRequest request = new XMXEDITDeliverRequest();
        
        request.setXmz(".6");       
        request.setXmdbkst("COLTRANE");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenThrow(new VistaWebServiceFault("MOCKITO ERROR"));
        
        //  Set up Endpoint
        XMXEDITDeliverEndpoint endpoint = new XMXEDITDeliverEndpointImpl(this.getVistaLinkContext(),
                new XMXEDITResponseFactory());
        
        //  Execute request
        XMXEDITDeliverResponse response = endpoint.deliver(request);        
        assertNotNull(response);
        assertEquals("-1", response.getStatus());
        assertEquals("You may not Edit a message you have already sent to someone else.", response.getMessage());
        assertEquals(expectedOutput, response.getRawResponse());
        
    }
}

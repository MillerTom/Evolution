/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITClosedEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITClosedEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITClosedRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITClosedResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXEDITClosedTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XMWSOA CLOSED TOGGLE";
    

    @Test
    public void testClosedToggle() throws VistaWebServiceFault {
        
        String expectedOutput = "0^'Closed'flag removed.^PICSRF";
        
        XMXEDITClosedRequest request = new XMXEDITClosedRequest();
        
        request.setXmz("7000");       
        request.setXminstr("P");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXEDITClosedEndpoint endpoint = new XMXEDITClosedEndpointImpl(this.getVistaLinkContext(),
                new XMXEDITResponseFactory());
        
        //  Execute request
        XMXEDITClosedResponse response = endpoint.closed(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getRawResponse());
        assertEquals("Closed", response.getMessage());
        assertEquals("flag removed.^PICSRF", response.getSpecial());
        
    }
    
    
    @Test(expected=VistaWebServiceFault.class)
    public void testClosedToggleError() throws VistaWebServiceFault {
        
        String expectedOutput = "0^'Closed'flag removed.^PICSRF";
        
        XMXEDITClosedRequest request = new XMXEDITClosedRequest();
        
        request.setXmz("700");        
        request.setXminstr("P");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null))
            .thenThrow(new VistaWebServiceFault("Expected Mockito ERROR"));
        
        //  Set up Endpoint
        XMXEDITClosedEndpoint endpoint = new XMXEDITClosedEndpointImpl(this.getVistaLinkContext(),
                new XMXEDITResponseFactory());
        
        //  Execute request
        XMXEDITClosedResponse response = endpoint.closed(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getRawResponse());
        
    }
    
    
}

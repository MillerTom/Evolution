/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITConfirmEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITConfirmEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfirmRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfirmResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXEDITConfirmTest extends VistaLinkContextTestParent {

    private static final String RPCCALL = "XMWSOA CONFIRM TOGGLE";
    

    @Test
    public void testCondirmToggle() throws VistaWebServiceFault {
        
        String expectedOutput = "0^'Confirm Receipt Requested' flag removed.^PIXCSF";
        
        XMXEDITConfirmRequest request = new XMXEDITConfirmRequest();
        
        request.setXmz(".6");       
        request.setXminstr("P");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXEDITConfirmEndpoint endpoint = new XMXEDITConfirmEndpointImpl(this.getVistaLinkContext(),
                new XMXEDITResponseFactory());
        
        //  Execute request
        XMXEDITConfirmResponse response = endpoint.confirm(request);        
        assertNotNull(response);          
    }
    
    
    @Test(expected=VistaWebServiceFault.class)
    public void testConfirmError() throws VistaWebServiceFault {
        
        String expectedOutput = "0^'Confirm Receipt Requested' flag removed.^PIXCSF";
        
        XMXEDITConfirmRequest request = new XMXEDITConfirmRequest();
        
        request.setXmz("7000");       
        request.setXminstr("P");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null))
            .thenThrow(new VistaWebServiceFault("Expected Mockito ERROR"));
        
        //  Set up Endpoint
        XMXEDITConfirmEndpoint endpoint = new XMXEDITConfirmEndpointImpl(this.getVistaLinkContext(),
                new XMXEDITResponseFactory());
        
        //  Execute request
        XMXEDITConfirmResponse response = endpoint.confirm(request);        
        assertNotNull(response);  
        assertEquals(expectedOutput, response.getRawResponse());
    }

}

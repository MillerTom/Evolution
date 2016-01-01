/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILBsktnameEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBsktnameEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXUTILBsktnameTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XMWSOA BASKET NAME";
    

    @Test
    public void testBasketName() throws VistaWebServiceFault {
        
        String expectedOutput = "0";
        
        XMXUTILBsktnameRequest request = new XMXUTILBsktnameRequest();
        
        request.setXmduz(".5");
        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTILBsktnameEndpoint endpoint = new XMXUTILBsktnameEndpointImpl(this.getVistaLinkContext(),
                new XMXUTILResponseFactory());
        
        //  Execute request
        XMXUTILBsktnameResponse response = endpoint.bsktname(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getBsktIEN());
        
    }
    
    
    @Test(expected=VistaWebServiceFault.class)
    public void testBasketNameError() throws VistaWebServiceFault {
        
        XMXUTILBsktnameRequest request = new XMXUTILBsktnameRequest();
        
        request.setXmduz(".5");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenThrow(new VistaWebServiceFault("Mockito Error"));
        
        //  Set up Endpoint
        XMXUTILBsktnameEndpoint endpoint = new XMXUTILBsktnameEndpointImpl(this.getVistaLinkContext(),
                new XMXUTILResponseFactory());
        
        //  Execute request
        XMXUTILBsktnameResponse response = endpoint.bsktname(request); 
        assertNotNull(response);
        
    }
}

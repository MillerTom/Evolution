/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.XUSRBResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.XUSRBSetupEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBSetupEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBSetupResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XUSRBSetupTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XUS SIGNON SETUP";
    

    @Test
    public void testSetup() throws VistaWebServiceFault {
        
        String expectedOutput = "DBITTEST\nEVOLUTION\nEVOLUTION\n//./nul:4756\n5\n0\nDBITTEST.DBITPRO.COM\n0";
              
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up endpoint
        XUSRBSetupEndpoint endpoint = new XUSRBSetupEndpointImpl(this.getVistaLinkContext(), 
                new XUSRBResponseFactory());
        
        XUSRBSetupResponse response = endpoint.setup();
        
        assertNotNull(response);        
    }
    
    @Test(expected = VistaWebServiceFault.class)
    public void testSetupFail() throws VistaWebServiceFault {
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenThrow(new VistaWebServiceFault("Mockit Error"));
                
        
        //  Set up endpoint
        XUSRBSetupEndpoint endpoint = new XUSRBSetupEndpointImpl(this.getVistaLinkContext(), 
                new XUSRBResponseFactory());
        
        XUSRBSetupResponse response = endpoint.setup();
        
        assertNotNull(response);        
    }
    
}

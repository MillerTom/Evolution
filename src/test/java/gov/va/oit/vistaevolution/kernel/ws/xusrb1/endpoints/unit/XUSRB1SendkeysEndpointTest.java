/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.XUSRB1ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.XUSRB1SendkeysEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1SendkeysEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1SendkeysRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1SendkeysResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XUSRB1SendkeysEndpointTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XUS SEND KEYS";
    
    @Test
    public void testPendingAlerts() throws VistaWebServiceFault {
        
        String expectedOutput = "Some output";
        
        XUSRB1SendkeysRequest request = new XUSRB1SendkeysRequest();
        
        request.setRoot("some root");       
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        XUSRB1SendkeysEndpoint endpoint = new XUSRB1SendkeysEndpointImpl(this.getVistaLinkContext(),
                new XUSRB1ResponseFactory());
        
        XUSRB1SendkeysResponse response = endpoint.sendkeys(request);
        
        assertNotNull(response);
    }

}

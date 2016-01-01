/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusclean.enpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xusclean.XUSCLEANResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusclean.enpoints.XUSCLEANLoutEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xusclean.enpoints.interfaces.XUSCLEANLoutEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusclean.model.XUSCLEANLoutRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusclean.model.XUSCLEANLoutResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XUSCLEANLoutEndpointTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "";

    @Test
    public void testUserList() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        XUSCLEANLoutRequest request = new XUSCLEANLoutRequest();
        
        request.setDa(".5");        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        XUSCLEANLoutEndpoint endpoint = new XUSCLEANLoutEndpointImpl(this.getVistaLinkContext(),
                new XUSCLEANResponseFactory());
        
        XUSCLEANLoutResponse response = endpoint.lout(request);
        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResponse());
    }
}

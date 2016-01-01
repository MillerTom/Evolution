/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.XUSKAAJResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.XUSKAAJSignoffEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces.XUSKAAJSignoffEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJSignoffRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJSignoffResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XUSKAAJSignoffTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XUS KAAJEE LOGOUT";    

    @Test
    public void testSetup() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        XUSKAAJSignoffRequest request = new XUSKAAJSignoffRequest();
        
        request.setDa(".5");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up endpoint
        XUSKAAJSignoffEndpoint endpoint = new XUSKAAJSignoffEndpointImpl(this.getVistaLinkContext(), 
                new XUSKAAJResponseFactory());
        
        XUSKAAJSignoffResponse response = endpoint.signoff(request);
        
        assertNotNull(response);        
        assertEquals(expectedOutput, response.getRet());
    }

}

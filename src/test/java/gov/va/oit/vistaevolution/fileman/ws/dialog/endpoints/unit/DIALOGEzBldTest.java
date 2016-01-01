/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dialog.DIALOGResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.DIALOGEzBldEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGEzBldEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGEzBldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGEzBldResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class DIALOGEzBldTest extends VistaLinkContextTestParent {

    private static final String RPCCALL = "DDR SOA DIALOG EXTRACTOR";

    @Test
    public void ezBldTest() throws VistaWebServiceFault {
        
        String expectedOutput = "this is a message";
        
        DIALOGEzBldRequest request = new DIALOGEzBldRequest();
        
        request.setDialog("099");
        request.setText(null);   //  optional              
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        DIALOGEzBldEndpoint endpoint = new DIALOGEzBldEndpointImpl(this.getVistaLinkContext(),
                new DIALOGResponseFactory());
        
        DIALOGEzBldResponse response = endpoint.ezbld(request);
        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResponse());
    }
    
    @Test(expected = VistaWebServiceFault.class)
    public void ezBldTestError() throws VistaWebServiceFault {
        
        String expectedOutput = "this is a message";
        
        DIALOGEzBldRequest request = new DIALOGEzBldRequest();
        
        request.setDialog("099");
        request.setText(null);   //  optional              
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null))
                .thenThrow(new VistaWebServiceFault("MOCKITO ERROR"));
        
        DIALOGEzBldEndpoint endpoint = new DIALOGEzBldEndpointImpl(this.getVistaLinkContext(),
                new DIALOGResponseFactory());
        
        DIALOGEzBldResponse response = endpoint.ezbld(request);
        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResponse());
    }
}

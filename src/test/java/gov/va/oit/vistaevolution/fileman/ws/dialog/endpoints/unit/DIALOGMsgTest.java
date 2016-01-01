/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dialog.DIALOGResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.DIALOGMsgEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGMsgEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGMsgRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGMsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class DIALOGMsgTest extends VistaLinkContextTestParent {

    private static final String RPCCALL = "";

    @Test
    public void msgTest() throws VistaWebServiceFault {
        
        String expectedOutput = "this is a message";
        
        DIALOGMsgRequest request = new DIALOGMsgRequest();
        
        request.setFlags("");        // Optional
        request.setInputRoot(null);  // Optional
        request.setLeftMargin("");   // Optional
        request.setTextWidth("");    // Optional
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        DIALOGMsgEndpoint endpoint = new DIALOGMsgEndpointImpl(this.getVistaLinkContext(),
                new DIALOGResponseFactory());
        
        DIALOGMsgResponse response = endpoint.msg(request);
        
        assertNotNull(response);
    }
    
}

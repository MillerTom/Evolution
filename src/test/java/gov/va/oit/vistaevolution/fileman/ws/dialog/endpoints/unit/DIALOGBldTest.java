/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import gov.va.oit.vistaevolution.fileman.ws.dialog.DIALOGResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.DIALOGBldEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGBldEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class DIALOGBldTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "";

    @Test
    public void testBldAlerts() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        DIALOGBldRequest request = new DIALOGBldRequest();
        
        request.setDialogNum("099");
		request.setFlags("");
		// request.setFlags("");  // Optional
        List<String> textParam = new ArrayList<String>();
        textParam.add("");
        request.setTextParam(textParam);  // Optional
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        DIALOGBldEndpoint endpoint = new DIALOGBldEndpointImpl(this.getVistaLinkContext(),
                new DIALOGResponseFactory());
        
        DIALOGBldResponse response = endpoint.bld(request);
        
        assertNotNull(response);
    }
}

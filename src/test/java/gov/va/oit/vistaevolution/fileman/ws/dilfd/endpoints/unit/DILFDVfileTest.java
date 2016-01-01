/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.DILFDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.DILFDVfileEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfileEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class DILFDVfileTest extends VistaLinkContextTestParent {
    

    private static final String RPCCALL = "";

    @Test
    public void rootTest() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        DILFDVfileRequest request = new DILFDVfileRequest();
        
        request.setFile("5");        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        DILFDVfileEndpoint endpoint = new DILFDVfileEndpointImpl(this.getVistaLinkContext(),
                new DILFDResponseFactory());
        
        DILFDVfileResponse response = endpoint.vfile(request);
        
        assertNotNull(response);
    }
    

}

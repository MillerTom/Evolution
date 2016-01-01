/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.DILFDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.DILFDVfieldEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfieldEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class DILFDVfieldTest extends VistaLinkContextTestParent {
    

    private static final String RPCCALL = "";

    @Test
    public void rootTest() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        DILFDVfieldRequest request = new DILFDVfieldRequest();
        
        request.setFile("5");
        request.setField(".01");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        DILFDVfieldEndpoint endpoint = new DILFDVfieldEndpointImpl(this.getVistaLinkContext(),
                new DILFDResponseFactory());
        
        DILFDVfieldResponse response = endpoint.vfield(request);
        
        assertNotNull(response);
    }
    
}

/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.DILFDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.DILFDRootEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDRootEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDRootRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDRootResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class DILFDRootTest extends VistaLinkContextTestParent {
    

    private static final String RPCCALL = "";

    @Test
    public void rootTest() throws VistaWebServiceFault {
        
        String expectedOutput = "DIZ(999000)";
        
        DILFDRootRequest request = new DILFDRootRequest();
        
        request.setFile("999000");
        request.setIens("1");       // Optional
        request.setFlags("0");      // Optional
        request.setErrorFlag("1");  // Optional
        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        DILFDRootEndpoint endpoint = new DILFDRootEndpointImpl(this.getVistaLinkContext(),
                new DILFDResponseFactory());
        
        DILFDRootResponse response = endpoint.root(request);
        
        assertNotNull(response);
    }
}

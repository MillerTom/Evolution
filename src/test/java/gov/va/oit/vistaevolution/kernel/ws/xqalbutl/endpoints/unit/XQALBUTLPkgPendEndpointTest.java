/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.XQALBUTLResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.XQALBUTLPkgPendEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLPkgPendEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPkgPendRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPkgPendResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XQALBUTLPkgPendEndpointTest extends VistaLinkContextTestParent {

    private static final String RPCCALL = "XU SOA PKGPEND";

    @Test
    public void testPendingAlerts() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        XQALBUTLPkgPendRequest request = new XQALBUTLPkgPendRequest();
        
        request.setXuien(".5");
        request.setXupkg("Package");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        XQALBUTLPkgPendEndpoint endpoint = new XQALBUTLPkgPendEndpointImpl(this.getVistaLinkContext(),
                new XQALBUTLResponseFactory());
        
        XQALBUTLPkgPendResponse response = endpoint.pkgpend(request);
        
        assertNotNull(response);
    }
    
}

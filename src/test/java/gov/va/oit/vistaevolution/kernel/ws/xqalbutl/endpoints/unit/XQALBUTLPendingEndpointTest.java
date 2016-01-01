/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.XQALBUTLResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.XQALBUTLPendingEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLPendingEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPendingRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPendingResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XQALBUTLPendingEndpointTest extends VistaLinkContextTestParent {
    

    private static final String RPCCALL = "XU SOA PENDING";
    
    @Test
    public void testPendingAlerts() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        XQALBUTLPendingRequest request = new XQALBUTLPendingRequest();
        
        request.setXuien(".5");
        request.setXuaid("100");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        XQALBUTLPendingEndpoint endpoint = new XQALBUTLPendingEndpointImpl(this.getVistaLinkContext(),
                new XQALBUTLResponseFactory());
        
        XQALBUTLPendingResponse response = endpoint.pending(request);
        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getReturns());
    }
    
}

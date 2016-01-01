/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.XQALBUTLResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.XQALBUTLUserdataEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLUserdataEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserdataRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserdataResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XQALBUTLUserdataEndpointTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XU SOA USERDAT";

    @Test
    public void testPendingAlerts() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        XQALBUTLUserdataRequest request = new XQALBUTLUserdataRequest();
        
        request.setXuien(".6");
        request.setXqaid("NO-ID;1;3140212.104945");       
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        XQALBUTLUserdataEndpoint endpoint = new XQALBUTLUserdataEndpointImpl(this.getVistaLinkContext(),
                new XQALBUTLResponseFactory());
        
        XQALBUTLUserdataResponse response = endpoint.userdata(request);
        
        assertNotNull(response);
    }
    
}

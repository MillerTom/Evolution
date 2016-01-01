/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.XQALBUTLResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.XQALBUTLUserlistEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLUserlistEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserlistRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserlistResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XQALBUTLUserlistEndpointTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XU SOA USERLST";

    @Test
    public void testUserList() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        XQALBUTLUserlistRequest request = new XQALBUTLUserlistRequest();
        
        request.setXqaid(".5");        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        XQALBUTLUserlistEndpoint endpoint = new XQALBUTLUserlistEndpointImpl(this.getVistaLinkContext(),
                new XQALBUTLResponseFactory());
        
        XQALBUTLUserlistResponse response = endpoint.userlist(request);
        
        assertNotNull(response);
    }
    
}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xma21.XMA21ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.XMA21ChkEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21ChkEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMA21ChkTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XMWSOA CHK";
    
    @Test
    public void testAddressLookup() throws VistaWebServiceFault {
        
        String expectedOutput = "1^User is a member";
        
        XMA21ChkRequest request = new XMA21ChkRequest();        
        
        request.setXmduz("1");
        request.setIen("1");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMA21ChkEndpoint endpoint = new XMA21ChkEndpointImpl(this.getVistaLinkContext(),
                new XMA21ResponseFactory());
        
        //  Execute request
        XMA21ChkResponse response = endpoint.chk(request);        
        assertNotNull(response);      
        assertTrue(response.getReturnCode().equalsIgnoreCase("1"));
    }
}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2RespEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2RespEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2RespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2RespResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXUTIL2RespTest extends VistaLinkContextTestParent {
    

    private static final String RPCCALL = "XMWSOA NO OF RESPONSES";
    
    @Test
    public void testResp001() {        
        
        String expectedOutput = "1";
        
        XMXUTIL2RespRequest request = new XMXUTIL2RespRequest();
        
        request.setXmz(".5");
        
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XMXUTIL2RespEndpoint endpoint = new XMXUTIL2RespEndpointImpl(this.getVistaLinkContext(), new XMXUtil2ResponseFactory());
        
        XMXUTIL2RespResponse response = endpoint.resp(request);
        
        assertNotNull(response);      
        assertEquals(expectedOutput, response.getResponses());        
    }
    
    @Test
    public void testResp002() {        
        
        String expectedOutput = "-1^Message not found";
        
        XMXUTIL2RespRequest request = new XMXUTIL2RespRequest();
        
        request.setXmz(".5");
        
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XMXUTIL2RespEndpoint endpoint = new XMXUTIL2RespEndpointImpl(this.getVistaLinkContext(), new XMXUtil2ResponseFactory());
        
        XMXUTIL2RespResponse response = endpoint.resp(request);
        
        assertNotNull(response);      
        assertEquals("-1", response.getResponses());
        assertEquals("Message not found", response.getMessage());
    }
    
    @Test(expected = VistaWebServiceFault.class)
    public void testRespError() {        
        
        XMXUTIL2RespRequest request = new XMXUTIL2RespRequest();
        
        request.setXmz(".5");
        
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL)
            , null)).thenThrow(new VistaWebServiceFault("MOCKITO ERROR"));

        XMXUTIL2RespEndpoint endpoint = new XMXUTIL2RespEndpointImpl(this.getVistaLinkContext(), new XMXUtil2ResponseFactory());
        
        XMXUTIL2RespResponse response = endpoint.resp(request);
        
        assertNotNull(response);        
    }

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xms1.XMS1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.XMS1SrvTimeEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces.XMS1SrvTimeEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1SrvTimeRequest;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1SrvTimeResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMS1SrvTimeTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XMWSOA SRVTIME";
    
    @Test
    public void testSrvTest001() {
        
        String expectedOutput = "-1^Message not found";
        
        XMS1SrvTimeRequest request = new XMS1SrvTimeRequest(); 
        
        request.setXmz("9999");
        request.setXmser("S.XU");
        request.setStatus("SRVTIME");
        
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XMS1SrvTimeEndpoint endpoint = new XMS1SrvTimeEndpointImpl(this.getVistaLinkContext(), new XMS1ResponseFactory());
        
        XMS1SrvTimeResponse response = endpoint.srvtime(request);
        
        assertNotNull(response);
        assertEquals("-1", response.getResponse());
        assertEquals("Message not found", response.getMessage());
        
        System.out.println(response.toString());
        
    }
    
    @Test(expected = VistaWebServiceFault.class)
    public void testSrvTest002() {
                
        XMS1SrvTimeRequest request = new XMS1SrvTimeRequest(); 
        
        request.setXmz("9999");
        request.setXmser("S.XU");
        request.setStatus("SRVTIME");
        
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null))
            .thenThrow(new VistaWebServiceFault("MOCKITO ERR"));

        XMS1SrvTimeEndpoint endpoint = new XMS1SrvTimeEndpointImpl(this.getVistaLinkContext(), new XMS1ResponseFactory());
        
        XMS1SrvTimeResponse response = endpoint.srvtime(request);
        
        assertNotNull(response);
        
        System.out.println(response.toString());
        
    }
}

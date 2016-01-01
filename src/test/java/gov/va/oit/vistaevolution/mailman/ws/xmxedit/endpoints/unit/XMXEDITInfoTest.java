/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITInfoEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITInfoEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITInfoRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITInfoResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXEDITInfoTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XMWSOA INFO TOGGLE";


    @Test
    public void testInfoToggleMessage() throws VistaWebServiceFault {
        
        String expectedOutput = "-1^Error in required input";
        
        XMXEDITInfoRequest request = new XMXEDITInfoRequest();
        
        request.setXmz(".6");       
        request.setXminstr("P");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXEDITInfoEndpoint endpoint = new XMXEDITInfoEndpointImpl(this.getVistaLinkContext(),
                new XMXEDITResponseFactory());
        
        //  Execute request
        XMXEDITInfoResponse response = endpoint.info(request);        
        assertNotNull(response);     
        System.out.println(response);
        
    }
    
    
    @Test
    public void testInfoToggleMessageWithFlag() throws VistaWebServiceFault {
        
        String expectedOutput = "-1^Error in required input";
        
        XMXEDITInfoRequest request = new XMXEDITInfoRequest();
        
        request.setXmz(".6");       
        request.setXminstr("P");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXEDITInfoEndpoint endpoint = new XMXEDITInfoEndpointImpl(this.getVistaLinkContext(),
                new XMXEDITResponseFactory());
        
        //  Execute request
        XMXEDITInfoResponse response = endpoint.info(request);        
        assertNotNull(response);     
        System.out.println(response);
        
    }
    
}

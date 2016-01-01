/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2Inmsg2EndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg2Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg2Request;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg2Response;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXUTIL2Inmsg2Test extends VistaLinkContextTestParent {
    
private static final String RPCCALL = "XMWSOA INMSG2";
    
    @Test
    public void testInmsg2() throws VistaWebServiceFault {
        
        String expectedOutput = "XMIM(\"RECIPS\")=1\nXMINSTR(\"FLAGS\")=\nXMINSTR(\"TYPE\")=\nXMIU(\"ORIGN8\")=1";
        
        XMXUTIL2Inmsg2Request request = new XMXUTIL2Inmsg2Request();
        
        request.setXmduz(".5");
        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTIL2Inmsg2Endpoint endpoint = new XMXUTIL2Inmsg2EndpointImpl(this.getVistaLinkContext(),
                new XMXUtil2ResponseFactory());
        
        //  Execute request
        XMXUTIL2Inmsg2Response response = endpoint.inmsg2(request);        
        assertNotNull(response);
        System.out.println(response);
       
        
    }
    
    @Test
    public void testInmsg2RPCMessage() throws VistaWebServiceFault {
        
        String expectedOutput = "-1^Error in required input";
        
        XMXUTIL2Inmsg2Request request = new XMXUTIL2Inmsg2Request();
        
        request.setXmduz(".5");
        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTIL2Inmsg2Endpoint endpoint = new XMXUTIL2Inmsg2EndpointImpl(this.getVistaLinkContext(),
                new XMXUtil2ResponseFactory());
        
        //  Execute request
        XMXUTIL2Inmsg2Response response = endpoint.inmsg2(request);        
        assertNotNull(response);
        System.out.println(response);        
    }

    
    @Test(expected = VistaWebServiceFault.class)
    public void testInmsg2RPCError() throws VistaWebServiceFault {
        
        String expectedOutput = "-1^Error in required input";
        
        XMXUTIL2Inmsg2Request request = new XMXUTIL2Inmsg2Request();
        
        request.setXmduz(".5");        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenThrow(new VistaWebServiceFault("MOCKITO ERROR"));
        
        //  Set up Endpoint
        XMXUTIL2Inmsg2Endpoint endpoint = new XMXUTIL2Inmsg2EndpointImpl(this.getVistaLinkContext(),
                new XMXUtil2ResponseFactory());
        
        //  Execute request
        XMXUTIL2Inmsg2Response response = endpoint.inmsg2(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getRawResponse());
        System.out.println(response);        
    }

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2Inmsg1EndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg1Response;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXUTIL2Inmsg1Test extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XMWSOA INMSG1";
    
    @Test
    public void testInmsg1() throws VistaWebServiceFault {
        
        String expectedOutput = "XMIM(\"CRE8\")=3140321\n"
                + "XMIM(\"CRE8 MM\")=03/21/14\nXMIM(\"DATE\")=3140321.122226\nX"
                + "MIM(\"DATE MM\")=03/21/14@12:22\nXMIM(\"FROM\")=1\nXMIM(\"FROM DUZ\")=1\n"
                + "XMIM(\"FROM NAME\")=PROGRAMMER,ONE\nXMIM(\"LINES\")=2\n"
                + "XMIM(\"RESPS\")=0\nXMIM(\"SENDR\")=\nXMIM(\"SUBJ\")=INFO TOGGLE TEST\n"
                + "XMIM(\"XMZ\")=76878\nXMIU(\"IEN\")=0\nXMIU(\"RESP\")=";
        
        XMXUTIL2Inmsg1Request request = new XMXUTIL2Inmsg1Request();
        
        request.setXmduz(".5");
        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTIL2Inmsg1Endpoint endpoint = new XMXUTIL2Inmsg1EndpointImpl(this.getVistaLinkContext(),
                new XMXUtil2ResponseFactory());
        
        //  Execute request
        XMXUTIL2Inmsg1Response response = endpoint.inmsg1(request);        
        assertNotNull(response);
        System.out.println(response);
       
        
    }
    
    @Test
    public void testInmsg1RPCMessage() throws VistaWebServiceFault {
        
        String expectedOutput = "-1^Error in required input";
        
        XMXUTIL2Inmsg1Request request = new XMXUTIL2Inmsg1Request();
        
        request.setXmduz(".5");
        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTIL2Inmsg1Endpoint endpoint = new XMXUTIL2Inmsg1EndpointImpl(this.getVistaLinkContext(),
                new XMXUtil2ResponseFactory());
        
        //  Execute request
        XMXUTIL2Inmsg1Response response = endpoint.inmsg1(request);        
        assertNotNull(response);
        System.out.println(response);        
    }

    
    @Test(expected = VistaWebServiceFault.class)
    public void testInmsg1RPCError() throws VistaWebServiceFault {
        
        String expectedOutput = "-1^Error in required input";
        
        XMXUTIL2Inmsg1Request request = new XMXUTIL2Inmsg1Request();
        
        request.setXmduz(".5");        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenThrow(new VistaWebServiceFault("MOCKITO ERROR"));
        
        //  Set up Endpoint
        XMXUTIL2Inmsg1Endpoint endpoint = new XMXUTIL2Inmsg1EndpointImpl(this.getVistaLinkContext(),
                new XMXUtil2ResponseFactory());
        
        //  Execute request
        XMXUTIL2Inmsg1Response response = endpoint.inmsg1(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getRawResponse());
        System.out.println(response);        
    }

    
    
    
}

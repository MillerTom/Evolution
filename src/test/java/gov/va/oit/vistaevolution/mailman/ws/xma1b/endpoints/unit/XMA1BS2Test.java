/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.XMA1BResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.XMA1BS2EndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BS2Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Request;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Response;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMA1BS2Test extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	@Test
	public void putMsgInBsktTest() throws VistaWebServiceFault {
        String expectedOutput = "0^Successful";
        
        XMA1BS2Request request = new XMA1BS2Request(); 
        
        request.setXmduz(".5");
        request.setXmkm("");  
        request.setXmz("CODE GENERATED MAIL MESSAGE #10");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
        		expectedOutput);

        XMA1BS2Endpoint endpoint = new XMA1BS2EndpointImpl(new XMA1BResponseFactory(),  
        		this.getVistaLinkContext());

        XMA1BS2Response response = endpoint.s2(request);

        assertNotNull(response);
        assertTrue(response.getResponse().equalsIgnoreCase("0^Successful"));
	}

}

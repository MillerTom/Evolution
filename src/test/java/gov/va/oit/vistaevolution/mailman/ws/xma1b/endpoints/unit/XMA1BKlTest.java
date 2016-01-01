/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.XMA1BResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.XMA1BKlEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BKlEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMA1BKlTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

    @Test
    public void deleteMessageTest() throws VistaWebServiceFault {
        
        String expectedOutput = "0^Successful";
        
        XMA1BKlRequest request = new XMA1BKlRequest(); 
        
        request.setXmduz(".5");
        request.setXmk("");  
        request.setXmz("CODE GENERATED MAIL MESSAGE #10");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
        		expectedOutput);

        XMA1BKlEndpoint endpoint = new XMA1BKlEndpointImpl(new XMA1BResponseFactory(),  
        		this.getVistaLinkContext());

        XMA1BKlResponse response = endpoint.kl(request);

        assertNotNull(response);
        assertTrue(response.getResponse().equalsIgnoreCase("0^Successful"));
    }

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xma21.XMA21ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.XMA21WhoEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21WhoEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XMA21WhoTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "XMWSOA WHO";

	@Autowired
	private XMA21ResponseFactory responseFactory;

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.XMA21WhoEndpointImpl#who(gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoRequest)}.
	 */
	@Test
	public void testWho() throws VistaWebServiceFault {
        String expectedOutput = "REMOTE^ via FORUM.VA.GOV\nREMOTE^48^FORUM.VA.GOV\nADDRESS^postmaster@VA.GOV";
        
        XMA21WhoRequest request = new XMA21WhoRequest();
        
        request.setX("postmaster@va.gov");
        request.setXmdf(""); // Optional
        request.setXmduz(".5");
        // request.setXmloc("true");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMA21WhoEndpoint endpoint = new XMA21WhoEndpointImpl(new XMA21ResponseFactory(),
                this.getVistaLinkContext());
        
        //  Execute request
        XMA21WhoResponse response = endpoint.who(request);        
        assertNotNull(response);      
        assertTrue(response.getResponse().size() == 2);
	}

}

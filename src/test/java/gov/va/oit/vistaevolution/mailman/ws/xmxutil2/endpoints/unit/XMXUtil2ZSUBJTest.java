/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUtil2ZSUBJEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZSUBJEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZSUBJRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZSUBJResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMXUtil2ZSUBJTest extends VistaLinkContextTestParent {

    /**
     * <em>Retrieve subject for the specified message XMX</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,MSG=58880
     * 
     * Procedure Call:
     * 
     * > D ZSUBJ^XMWSOA07(.DATA,MSG)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="LEX*2.0*69 Installation"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveSubjectForXmx() throws VistaWebServiceFault {
	String expectedResult = "LEX*2.0*69 Installation";

	// Use Mockito to set up vistaLinkContext from parent class to return
	// proper string.
	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedResult);

	XMXUtil2ZSUBJRequest request = new XMXUtil2ZSUBJRequest("58880");

	// Setup the endpoint for testing.
	XMXUtil2ZSUBJEndpoint service = new XMXUtil2ZSUBJEndpointImpl(
		getVistaLinkContext(), new XMXUtil2ResponseFactory());

	// Execute request against mocked object backend.
	XMXUtil2ZSUBJResponse response = service.zsubj(request);

	assertEquals(expectedResult, response.getSubject());

    }

    /**
     * <em> Retrieve subject for the specified message IEN, but the IEN is not a valid message IEN.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,MSG=58777
     * 
     * Procedure Call:
     * 
     * > D ZSUBJ^XMWSOA07(.DATA,MSG)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Message not found"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveSubjectForInvalidXmx() throws VistaWebServiceFault {
	String expectedResult = "-1^Message not found";

	// Use Mockito to set up vistaLinkContext from parent class to return
	// proper string.
	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedResult);

	XMXUtil2ZSUBJRequest request = new XMXUtil2ZSUBJRequest("58777");

	// Setup the endpoint for testing.
	XMXUtil2ZSUBJEndpoint service = new XMXUtil2ZSUBJEndpointImpl(
		getVistaLinkContext(), new XMXUtil2ResponseFactory());

	XMXUtil2ZSUBJResponse response = service.zsubj(request);

	assertNotNull(response.getErrors());

    }
}

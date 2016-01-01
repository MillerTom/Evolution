/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUtil2LineEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2LineEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2LineRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2LineResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMXUTIL2LineTest extends VistaLinkContextTestParent {

    /**
     * <em> Retrieve number of lines in the specified mail message IEN</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,MSG=55906
     * 
     * Procedure Call:
     * 
     * >S DATA=$$LINE^XMXUTIL2(MSG)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA=4
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveNumberOfLines() throws VistaWebServiceFault {
	String expectedResult = "4";

	// Use Mockito to set up vistaLinkContext from parent class to return
	// proper string.
	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedResult);

	XMXUtil2LineRequest request = new XMXUtil2LineRequest("55906");

	// Setup the endpoint for testing.
	XMXUtil2LineEndpoint service = new XMXUtil2LineEndpointImpl(
		getVistaLinkContext(), new XMXUtil2ResponseFactory());

	// Execute request against mocked object backend.
	XMXUtil2LineResponse response = service.line(request);

	assertNotNull(response.getNumOfLines());

    }

    /**
     * <em>Retrieve number of lines in the specified mail message IEN, this IEN does not correspond to a message</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,MSG=55921
     * 
     * Procedure Call:
     * 
     * > D LINE^XMWSOA07(.DATA,MSG)
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
    public void testRetrieveWithBadID() throws VistaWebServiceFault {
	String expectedResult = "-1^Message not found";

	// Use Mockito to set up vistaLinkContext from parent class to return
	// proper string.
	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedResult);

	XMXUtil2LineRequest request = new XMXUtil2LineRequest("55906");

	// Setup the endpoint for testing.
	XMXUtil2LineEndpoint service = new XMXUtil2LineEndpointImpl(
		getVistaLinkContext(), new XMXUtil2ResponseFactory());

	// Execute request against mocked object backend.
	XMXUtil2LineResponse response = service.line(request);

	assertNotNull(response.getErrors());

    }
}

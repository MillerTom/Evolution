/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUtil2KSeqNEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2KSeqNEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2KSeqNRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2KSeqNResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMXUtil2KSEQNTest extends VistaLinkContextTestParent {

    /**
     * <em>Retrieve the sequence number of the message XMZ for the user DUZ and basket XMK</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=53467,XMK=1,XMZ=55639
     * 
     * Procedure Call:
     * 
     * > S DATA=$$KSEQN^XMXUTIL2(DUZ,XMK,XMZ)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA=11
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testSuccessfulSend() throws VistaWebServiceFault {
	String expectedResult = "11";

	// Use Mockito to set up vistaLinkContext from parent class to return
	// proper string.
	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedResult);

	XMXUtil2KSeqNRequest request = new XMXUtil2KSeqNRequest();

	// Setup the endpoint for testing.
	XMXUtil2KSeqNEndpoint service = new XMXUtil2KSeqNEndpointImpl(
		getVistaLinkContext(), new XMXUtil2ResponseFactory());

	// Execute request against mocked object backend.
	XMXUtil2KSeqNResponse response = service.kseqn(request);

	assertEquals(expectedResult, response.getSequenceNumber());

    }
}

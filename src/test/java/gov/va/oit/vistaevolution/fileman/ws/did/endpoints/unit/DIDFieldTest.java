/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.did.DIDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.DIDFieldEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldRequest;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * This is a pure unit test of the
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class DIDFieldTest extends VistaLinkContextTestParent {

	/**
	 * Retrieve LABEL Attribute from the .01 field and file 80.
	 * 
	 * >DO FIELD^DID(80,.01,"","LABEL","TEST") >ZW TEST
	 * TEST("LABEL")="CODE NUMBER"
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test
	public void testGetLabelAttributeForFieldInFile()
			throws VistaWebServiceFault {

		// Set up the request object
		ArrayList<String> attributes = new ArrayList<String>();
		attributes.add("LABEL");
		DIDFieldRequest request = new DIDFieldRequest("80", ".01", attributes);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn("CODE NUMBER");

		// Setup the endpoint for testing.
		DIDFieldEndpointImpl fieldDIDEndpoint = new DIDFieldEndpointImpl(
				getVistaLinkContext(), new DIDResponseFactory());

		// Execute request against mocked object backend.
		DIDFieldResponse response = fieldDIDEndpoint.field(request);

		assertNotNull(response);
		assertEquals("CODE NUMBER", response.getDidAttributes().get(0)
				.toString());
	}

}

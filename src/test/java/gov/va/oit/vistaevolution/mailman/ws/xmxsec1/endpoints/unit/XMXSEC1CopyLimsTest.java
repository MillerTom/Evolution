package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.XMXSEC1CopyLimsEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1CopyLimsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyLimsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyLimsResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XMXSEC1CopyLimsTest extends VistaLinkContextTestParent {

	public XMXSEC1CopyLimsTest() {
		super();
	}
	
	/**
	 * <em>Test Case #1    Look up limits 
	 * 
	 * 					   Function returns copy limits string.
	 * 						limits:  # recipients^# responses^# lines
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
				

			Procedure Call:
				>S RETURN=$$XMXSEC1^COPYLIMS()

			Expected Output:
				>ZW RETURN
				RETURN="100^200^3000"

	 * </pre>
	 * 
	 */

	@Test
	public void testCopyLims001() throws VistaWebServiceFault {
		String testResponse = "100^200^3000";
		String testResponseRecipients = "100";
		String testResponseResponses = "200";
		String testResponseLines = "3000";
		
		
		
		XMXSEC1CopyLimsRequest request = new XMXSEC1CopyLimsRequest();

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSEC1CopyLimsEndpoint service = new XMXSEC1CopyLimsEndpointImpl(
				new XMXSEC1ResponseFactory(), getVistaLinkContext());

		XMXSEC1CopyLimsResponse response = service.CopyLims(request);

		assertNotNull(response);
		assertEquals(testResponseRecipients, response.getNumRecipeints());
		assertEquals(testResponseResponses, response.getNumResponses());
		assertEquals(testResponseLines, response.getNumLines());
	}

}

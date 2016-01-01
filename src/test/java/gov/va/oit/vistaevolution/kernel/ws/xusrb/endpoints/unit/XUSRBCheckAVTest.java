package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.XUSRBResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.XUSRBCheckAVEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.XUSRBValidAVEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBCheckAVEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBValidAVEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBCheckAVRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBCheckAVResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class XUSRBCheckAVTest extends VistaLinkContextTestParent {


	@Test
	public void testEnt001() throws VistaWebServiceFault {

		String expectedOutput =  "0";

		// Set up the request object
		String ret = "TEST;TEST";

		XUSRBCheckAVRequest request = new XUSRBCheckAVRequest(ret);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA CHECK ACCESS"),
						null)).thenReturn(expectedOutput);

		// Setup the endpoint for testing.
		XUSRBCheckAVEndpoint service = new XUSRBCheckAVEndpointImpl(
				new XUSRBResponseFactory(), getVistaLinkContext());

		// Execute request
		XUSRBCheckAVResponse response = service.checkAV(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getRet());

	}

}

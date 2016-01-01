/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.XQALBUTLResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.XQALBUTLAhistoryEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAhistoryRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAhistoryResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Leisa Martella
 * 
 */
/**
 * XU SOA ALERT
 *
 * This RPC returns information from the ALERT TRACKING (#8992.1) file
 * for the alert XUAID in the array specified by XURET.  If the specified
 * alert is not present, the array root is returned with a NULL value.
 * 
 * Input Variables	
 * 		XUAID:	(required) This is the value XUAID which is the alert identifier.  
 * 				It is passed to the routine or option which is run when the alert 
 * 				is selected.  It can also be obtained from a listing of all of the 
 * 				XUAIDs for a specified user and/or patient.
 * 
 * Response
 * 		Returns data elements at the top level of the ALERT TRACKING (#8992.1)
 * 		file subscripted by the field numbers.  This subscript is sufficient to
 * 		obtain the data.  The values are shown as internal^external if the
 * 		internal and external forms are different.  The next subscript after
 * 		the field number will provide the field names if they are desired.  Use
 * 		XQALERTD as the return root to simulate calling the API with a null
 * 		root.
 *		
 *		array(.01)="NO-ID;83194;3140107.141502"
 *		array(.01,"NAME")=""
 *		array(.02)="3140107.141502^JAN 07, 2014@14:15:02"
 *		array(.02,"DATE CREATED")=""
 *		array(.03)="NO-ID"
 *		array(.03,"PKG ID")=""
 *		array(.04)=""
 *		array(.04,"PATIENT")=""
 * 
 */
public class XQALBUTLAhistoryTest extends VistaLinkContextTestParent {

	@Test
	//TODO: Implement this test when the RPC Broker call is fixed
	public void testAhistory() throws VistaWebServiceFault {
		ArrayList <String> results = new ArrayList <String>();
		results.add("LA7-MESSAGE-416570;.5;3030226.111106^3030226.111106^LA7-MESSAGE-416570^^.5^1");
		results.add("Lab Messaging error #37 on message #416570^^DIS^LA7UXQA");
		results.add("7143^3030303.083623^3030303.083657");

		String testResponse = "LA7-MESSAGE-416570;.5;3030226.111106^3030226.111106^LA7-MESSAGE-416570^^.5^1\n" 
				+ "Lab Messaging error #37 on message #416570^^DIS^LA7UXQA\n" 
				+ "7143^3030303.083623^3030303.083657\n";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Setup the endpoint for testing.
		XQALBUTLAhistoryEndpointImpl service = new XQALBUTLAhistoryEndpointImpl(
				getVistaLinkContext(), new XQALBUTLResponseFactory());

		XQALBUTLAhistoryRequest request = new XQALBUTLAhistoryRequest();

		// Execute request against mocked object backend.
		request.setXuaID("LA7-MESSAGE-416570;.5;3030226.111106");

		XQALBUTLAhistoryResponse response = service.ahistory(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
		assertEquals(results.get(1), response.getDataList().get(1));
		assertEquals(results.get(2), response.getDataList().get(2));
	}
}

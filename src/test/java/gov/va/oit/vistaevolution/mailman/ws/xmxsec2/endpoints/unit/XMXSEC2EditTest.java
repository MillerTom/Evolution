package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.XMXSEC2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.XMXSEC2EditEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.interfaces.XMXSEC2EditEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2EditRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2EditResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XMXSEC2EditTest extends VistaLinkContextTestParent {

	public XMXSEC2EditTest() {
		super();
	}

	
	/**
	 * <em>Test Case #1    XMXSEC2^EDIT 
	 * 					 May the user edit the message? (1=may, 0=may not)
	 * 
	 * 					  Look up bogus message and return 0 (user may not edit)
	 * 
	 * 					  
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 			>S XMDUZ="123"
				>S XMZ="999999999"
				>S XMZREC="0"

			Procedure Call:
				>S RETURN=$$XMXSEC2^EDIT(XMDUZ,XMZ,XMZREC)

			Expected Output:
				>ZW RETURN
				RETURN="0"

	 * </pre>
	 * 
	 */

	@Test
	public void jtestXMXSECEdit001() throws VistaWebServiceFault {
		String testResponse = "0\\n";
		String xmDuz = "123";
		String xmz = "999999999";
		String xmzRec = "0";
		
		XMXSEC2EditRequest request = new XMXSEC2EditRequest(xmDuz, xmz, xmzRec);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSEC2EditEndpoint service = new XMXSEC2EditEndpointImpl(
				new XMXSEC2ResponseFactory(), getVistaLinkContext());

		XMXSEC2EditResponse response = service.Edit(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getUserMayEdit());
	}
	
	
	/**
	 * <em>Test Case #2    XMXSEC2^EDIT 
	 * 					 May the user edit the message? (1=may, 0=may not)
	 * 
	 * 					  Look up correct message, but user cannot edit
	 * 					  and return 0 (user may not edit)
	 * 
	 * 					  
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 			>S XMDUZ="123"
				>S XMZ="456"
				>S XMZREC="0"

			Procedure Call:
				>S RETURN=$$XMXSEC2^EDIT(XMDUZ,XMZ,XMZREC)

			Expected Output:
				>ZW RETURN
				RETURN="0"

	 * </pre>
	 * 
	 */

	@Test
	public void jtestXMXSECEdit002() throws VistaWebServiceFault {
		String testResponse = "0\\n";
		String xmDuz = "123";
		String xmz = "456";
		String xmzRec = "0";
		
		XMXSEC2EditRequest request = new XMXSEC2EditRequest(xmDuz, xmz, xmzRec);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSEC2EditEndpoint service = new XMXSEC2EditEndpointImpl(
				new XMXSEC2ResponseFactory(), getVistaLinkContext());

		XMXSEC2EditResponse response = service.Edit(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getUserMayEdit());
	}
	
	/**
	 * <em>Test Case #3    XMXSEC2^EDIT 
	 * 					  May the user edit the message? (1=may, 0=may not)
	 * 
	 * 					  Look up correct message, and user can edit
	 * 					  and return 1 (user may edit)
	 * 
	 * 					  
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 			>S XMDUZ="123"
				>S XMZ="789"
				>S XMZREC="0"

			Procedure Call:
				>S RETURN=$$XMXSEC2^EDIT(XMDUZ,XMZ,XMZREC)

			Expected Output:
				>ZW RETURN
				RETURN="1"

	 * </pre>
	 * 
	 */

	@Test
	public void jtestXMXSECEdit003() throws VistaWebServiceFault {
		String testResponse = "1\\n";
		String xmDuz = "123";
		String xmz = "456";
		String xmzRec = "0";
		
		XMXSEC2EditRequest request = new XMXSEC2EditRequest(xmDuz, xmz, xmzRec);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSEC2EditEndpoint service = new XMXSEC2EditEndpointImpl(
				new XMXSEC2ResponseFactory(), getVistaLinkContext());

		XMXSEC2EditResponse response = service.Edit(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getUserMayEdit());
	}
}

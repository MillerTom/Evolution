package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.XMXSEC1CopyRecpEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1CopyRecpEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyRecpRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyRecpResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XMXSEC1CopyRecpTest extends VistaLinkContextTestParent {

	public XMXSEC1CopyRecpTest() {
		super();
	}
	
	/**
	 * <em>Test Case #1    Look up bogus message and return null
	 * 
	 * 			Checks total number of recipients to see if it's 
	 * 			OK to list them in the copy text and send the copy to them, too.
  				Function returns 1 if OK; 0 if not OK.
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
				>S XMZ="999999"

			Procedure Call:
				>S RETURN=$$XMXSEC1^COPYRECP(XMZ)

			Expected Output:
				>ZW RETURN
				RETURN=""

	 * </pre>
	 * 
	 */

	@Test
	public void testCopyRecp001() throws VistaWebServiceFault {
		String testResponse = null;
		String xmz = "999999";
		
		
		
		XMXSEC1CopyRecpRequest request = new XMXSEC1CopyRecpRequest(xmz);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSEC1CopyRecpEndpoint service = new XMXSEC1CopyRecpEndpointImpl(
				new XMXSEC1ResponseFactory(), getVistaLinkContext());

		XMXSEC1CopyRecpResponse response = service.CopyRecp(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getMsgOK());
		
	}
	
	/**
	 * <em>Test Case #2   Look up valid message but return 0 for not OK
	 * 
	 * 			Checks total number of recipients to see if it's 
	 * 			OK to list them in the copy text and send the copy to them, too.
  				Function returns 1 if OK; 0 if not OK.
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
				>S XMZ="123"

			Procedure Call:
				>S RETURN=$$XMXSEC1^COPYRECP(XMZ)

			Expected Output:
				>ZW RETURN
				RETURN="0"

	 * </pre>
	 * 
	 */

	@Test
	public void testCopyRecp002() throws VistaWebServiceFault {
		String testResponse = "0";
		String xmz = "123";
		
		
		
		XMXSEC1CopyRecpRequest request = new XMXSEC1CopyRecpRequest(xmz);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSEC1CopyRecpEndpoint service = new XMXSEC1CopyRecpEndpointImpl(
				new XMXSEC1ResponseFactory(), getVistaLinkContext());

		XMXSEC1CopyRecpResponse response = service.CopyRecp(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getMsgOK());
		
	}
	
	/**
	 * <em>Test Case #2   Look up valid message and return 1 for OK
	 * 
	 * 			Checks total number of recipients to see if it's 
	 * 			OK to list them in the copy text and send the copy to them, too.
  				Function returns 1 if OK; 0 if not OK.
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
				>S XMZ="1234"

			Procedure Call:
				>S RETURN=$$XMXSEC1^COPYRECP(XMZ)

			Expected Output:
				>ZW RETURN
				RETURN="1"

	 * </pre>
	 * 
	 */

	@Test
	public void testCopyRecp003() throws VistaWebServiceFault {
		String testResponse = "1";
		String xmz = "1234";
		
		
		
		XMXSEC1CopyRecpRequest request = new XMXSEC1CopyRecpRequest(xmz);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSEC1CopyRecpEndpoint service = new XMXSEC1CopyRecpEndpointImpl(
				new XMXSEC1ResponseFactory(), getVistaLinkContext());

		XMXSEC1CopyRecpResponse response = service.CopyRecp(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getMsgOK());
		
	}



}

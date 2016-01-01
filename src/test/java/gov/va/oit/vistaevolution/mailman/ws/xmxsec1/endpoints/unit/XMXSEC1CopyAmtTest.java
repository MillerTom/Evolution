package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.XMXSEC1CopyAmtEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1CopyAmtEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyAmtRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyAmtResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XMXSEC1CopyAmtTest extends VistaLinkContextTestParent {

	public XMXSEC1CopyAmtTest() {
		super();
	}
	
	/**
	 * <em>Test Case #1    Look up bogus message and return null
	 * 
	 * 					   Checks total number of lines to be copied and total number of responses to be copied.
  						   Function returns 1 if OK; 0 if not OK.
  						   XMZ is message/message id
  						   XMWHICH string of which responses to copy (0=original msg).
  						   Default = original msg and all responses.
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
				>S XMZ="999999999"
				>S XMWHICH="0"

			Procedure Call:
				>S RETURN=$$XMXSEC1^COPYAMT(XMZ)

			Expected Output:
				>ZW RETURN
				RETURN=""

	 * </pre>
	 * 
	 */

	@Test
	public void testCopyAmt001() throws VistaWebServiceFault {
		String testResponse = null;
		String xmz = "999999999";
		String xmWhich = "0";
		
		XMXSEC1CopyAmtRequest request = new XMXSEC1CopyAmtRequest(xmz, xmWhich);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSEC1CopyAmtEndpoint service = new XMXSEC1CopyAmtEndpointImpl(
				new XMXSEC1ResponseFactory(), getVistaLinkContext());

		XMXSEC1CopyAmtResponse response = service.CopyAmt(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getCopyAmountOK());
	}
	
	/**
	 * <em>Test Case #2    Look up message, with xmxWhich = 0 and return ok (1)
	 * 
	 * 					   Checks total number of lines to be copied and total number of responses to be copied.
  						   Function returns 1 if OK; 0 if not OK.
  						   XMZ is message/message id
  						   XMWHICH string of which responses to copy (0=original msg).
  						   Default = original msg and all responses.
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
				>S XMZ="123"
				>S XMWHICH="0"

			Procedure Call:
				>S RETURN=$$XMXSEC1^COPYAMT(XMZ)

			Expected Output:
				>ZW RETURN
				RETURN="1"

	 * </pre>
	 * 
	 */

	@Test
	public void testCopyAmt002() throws VistaWebServiceFault {
		String testResponse = "1";
		String xmz = "123";
		String xmWhich = "0";
		
		XMXSEC1CopyAmtRequest request = new XMXSEC1CopyAmtRequest(xmz, xmWhich);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSEC1CopyAmtEndpoint service = new XMXSEC1CopyAmtEndpointImpl(
				new XMXSEC1ResponseFactory(), getVistaLinkContext());

		XMXSEC1CopyAmtResponse response = service.CopyAmt(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getCopyAmountOK());
	}
	
	/**
	 * <em>Test Case #3    Look up message, with xmxWhich = 1,2,3 and return ok (1)
	 * 
	 * 					   Checks total number of lines to be copied and total number of responses to be copied.
  						   Function returns 1 if OK; 0 if not OK.
  						   XMZ is message/message id
  						   XMWHICH string of which responses to copy (0=original msg).
  						   Default = original msg and all responses.
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
				>S XMZ="123"
				>S XMWHICH="1,2,3"

			Procedure Call:
				>S RETURN=$$XMXSEC1^COPYAMT(XMZ)

			Expected Output:
				>ZW RETURN
				RETURN="1"

	 * </pre>
	 * 
	 */

	@Test
	public void testCopyAmt003() throws VistaWebServiceFault {
		String testResponse = "1";
		String xmz = "123";
		String xmWhich = "1,2,3";
		
		XMXSEC1CopyAmtRequest request = new XMXSEC1CopyAmtRequest(xmz, xmWhich);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSEC1CopyAmtEndpoint service = new XMXSEC1CopyAmtEndpointImpl(
				new XMXSEC1ResponseFactory(), getVistaLinkContext());

		XMXSEC1CopyAmtResponse response = service.CopyAmt(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getCopyAmountOK());
	}
	
	/**
	 * <em>Test Case #4    Look up message, with xmxWhich = -1 and return ok (0)
	 * 
	 * 					   Checks total number of lines to be copied and total number of responses to be copied.
  						   Function returns 1 if OK; 0 if not OK.
  						   XMZ is message/message id
  						   XMWHICH string of which responses to copy (0=original msg).
  						   Default = original msg and all responses.
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
				>S XMZ="123"
				>S XMWHICH="-1"

			Procedure Call:
				>S RETURN=$$XMXSEC1^COPYAMT(XMZ)

			Expected Output:
				>ZW RETURN
				RETURN="0"

	 * </pre>
	 * 
	 */

	@Test
	public void testCopyAmt004() throws VistaWebServiceFault {
		String testResponse = "0";
		String xmz = "123";
		String xmWhich = "-1";
		
		XMXSEC1CopyAmtRequest request = new XMXSEC1CopyAmtRequest(xmz, xmWhich);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// set up endpoint for testing
		XMXSEC1CopyAmtEndpoint service = new XMXSEC1CopyAmtEndpointImpl(
				new XMXSEC1ResponseFactory(), getVistaLinkContext());

		XMXSEC1CopyAmtResponse response = service.CopyAmt(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getCopyAmountOK());
	}



}

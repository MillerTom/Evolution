/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPIFiltrMsgEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

/**
 * Test for Xmz function of XMA2 Webservice
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
/* XMWSOA FLTRMSGM
 * 
 * This RPC filters messages in a basket.
 * 
 *  NOTE: Only the user or a surrogate can use this API.
 *  
 *  Input Parameters
 * 
 *  DUZ		(Required) String - User's DUZ
 *  XMDUZ   (Required) String -The user (DUZ or name) whose messages are to be filtered.
 *  XMKZA   (Required) List - Identifies messages, using a list array of
 *  						  message numbers (xmz) in the MESSAGE file (#3.9) (xmk must not be
 *  						  specified and ranges are not allowed):
 *  
 *  							List array: ARRAY(1234567)=""
 *  				                        ARRAY(9763213)=""
 *  
 *  Returns (String):
 *  		
 *  <number of messages> filtered or
 *  -1^[error text]
 * 
 */
public class XMXAPIFiltrMsgTest extends VistaLinkContextTestParent {

	/**
	 * 
	 * Filter messages
	 * 
	 * >S MSGARR(62950)="",MSGARR(63686)="",MSGARR(63689)=""
	 * >D FLTRMSGM^XMWSOA03(.RESULT,1,1,.MSGARR)
	 * 
	 * >ZW RESULT
	 * RESULT="0^3 messages filtered."
	 * 
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testfiltrMsg() throws VistaWebServiceFault {

		String testResponse = "0^3 messages filtered";

		// Set up the request object
		XMXAPIFiltrMsgRequest request = new XMXAPIFiltrMsgRequest();
		HashMap <String, String> xmkzas = new HashMap<String, String>();
		
		request.setDuz("1");
		request.setXmDuz("1");
	
		xmkzas.put("62950","");
		xmkzas.put("63686","");
		xmkzas.put("63689","");
		request.setXmkzas(xmkzas);
	
		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
		testResponse);

		// Setup the endpoint for testing.
		XMXAPIFiltrMsgEndpointImpl service = new XMXAPIFiltrMsgEndpointImpl(
				getVistaLinkContext(), new XMXAPIResponseFactory());

		// Execute request against mocked object backend.
		XMXAPIFiltrMsgResponse response = service.filtrMsg(request);

		assertEquals(testResponse, response.getResults());
	}

}

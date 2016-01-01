/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuser.XUSERResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuser.endpoints.XUSERDiv4EndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Request;
import gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Response;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * Test for GetUpn function of XUSER Webservice
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
public class XUSERDiv4Test extends VistaLinkContextTestParent {

	/**
	 * XU SOA DIV4
	 * 
	 *    Returns the Divisions a user is assigned to. Returns '0' if no institution
	 *    for user. Returns '1' if user has institution entry. Institution entry is
	 *    in the NEW PERSON file (#200) field DIVISION (#16).
	 *    
	 * Input Parameters:
	 * 		XUROOT	(Required) Local variable the is passed by reference.
	 * 
	 * 		XUDUZ	(Optional) IEN to the NEW PERSON (#200) file. If not passed defaults to
	 * 				the current DUZ.
	 * 
	 * Response:
	 * 				Returns 1 to indicate that the array of pointers to the INSTITUTION (#4)
	 * 				has been defined and 0 to indicate that the array of pointer to the
	 * 				INSTITUTION (#4) file has not been defined. The format is
	 * 				ARRAY([^DIC(4 IEN]).
	 *   
	 */
	
	/** TODO: Cannot pass a reference to a local variable (Leisa)
	 * Test Case #1 
	 * 
	 * Call for a user without any divisions set
	 * 
	 * >D DIV41^XUSOAK1(.RESULT,.XX,.5)
	 * 
	 * >ZW RESULT
	 * RESULT=0
	 * >ZW XX
	 *	
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDiv4() throws VistaWebServiceFault {
		String testResponse = "0";

		// Set up the request object
		XUSERDiv4Request request = new XUSERDiv4Request();
		
		request.setField(".XX");
		request.setIens(".5");
		

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Setup the endpoint for testing.
		XUSERDiv4EndpointImpl xuserDiv4Endpoint = new XUSERDiv4EndpointImpl(
				getVistaLinkContext(), new XUSERResponseFactory());

		// Execute request against mocked object backend.
		XUSERDiv4Response response = xuserDiv4Endpoint.div4(request);

		assertEquals(testResponse, response.getDataList().get(0));
	}

}

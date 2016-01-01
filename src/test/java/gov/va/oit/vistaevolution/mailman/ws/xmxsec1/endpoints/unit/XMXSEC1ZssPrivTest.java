package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.XMXSEC1ZssPrivEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1ZssPrivEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1ZssPrivRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1ZssPrivResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Test;

public class XMXSEC1ZssPrivTest extends VistaLinkContextTestParent {
	public XMXSEC1ZssPrivTest() { } 
	
	/**
	 * <em>These test cases will check whether a user 
	 * is authorized to conduct a Super Search.</em>
	 * 
	 * 		RETURN PARAMETER DESCRIPTION:   
   			 
   				1-User can conduct a Super Search.
   				0-User cannot conduct a Super Search.



	 * 
	 * <b>User can conduct Super Search</b>
	 * 
	 * <pre>
				Input Data:
				None.
				
				Procedure Call:
				>D ZSSPRIV^XMWSOA07(.RETURN)
				
				Expected Output:
				>ZW RETURN
				RETURN=1

	</pre>
	 */
	
	@Test
	public void testUserCanConductSuperSearch() {
		String testResponse = "1"; 	
		
		XMXSEC1ZssPrivRequest request = new XMXSEC1ZssPrivRequest();
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXSEC1ZssPrivEndpoint service = new XMXSEC1ZssPrivEndpointImpl(new XMXSEC1ResponseFactory(), getVistaLinkContext() );

		XMXSEC1ZssPrivResponse response = service.ZssPriv(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getUserCanDoSuperSearch());	 
	}	// end test 

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1ZssPrivEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1ZssPrivRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1ZssPrivResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import org.junit.Test;

/**
 * @author sorleski
 *
 */
public class XMXSEC1ZssPrivIT extends EvolutionIT<XMXSEC1ZssPrivEndpoint> {
	private XMXSEC1ZssPrivRequest request;
	private XMXSEC1ZssPrivResponse response;
	
	@Override
	protected Class<XMXSEC1ZssPrivEndpoint> getType() {
		return XMXSEC1ZssPrivEndpoint.class;
	}
	
	
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
		
		request = new XMXSEC1ZssPrivRequest();
		response = service.ZssPriv(request);		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getUserCanDoSuperSearch());	 
	}	// end test 
}

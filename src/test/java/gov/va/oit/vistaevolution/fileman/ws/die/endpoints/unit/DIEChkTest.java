/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.die.DIEResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.die.endpoints.DIEChkEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEChkRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEChkResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Leisa Martella
 * 
 */
public class DIEChkTest extends VistaLinkContextTestParent {

	/**
	 * 
	 * <pre>
	 *	>S FILE=2,FIELD=.02,FLAG="E",VALUE="MALE"
	 *	>D CHK^DIE(FILE,FIELD,FLAG,VALUE,.RESULT,"ERR")
	 *
	 *	>ZW RESULT
	 *	RESULT="M"
	 *	RESULT(0)="MALE"
	 *
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.02,DDR("FLAGS")="E",DDR("VALUE")="MALE"
	 *		>D CHKR^DDR5(.RESULT,.DDR)
	 *		NCHD03:NCHZW RESULT                                                            "
	 *
	 *		RESULT(0)="MALE"
	 *
	 * </pre>
	 */
	@Test
	public void testDIEChk() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("MALE");

		String testResponse = "MALE";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		// Setup the endpoint for testing.
		DIEChkEndpointImpl dieChkEndpoint = new DIEChkEndpointImpl(
				getVistaLinkContext(), new DIEResponseFactory());

		DIEChkRequest dieChkRequest = new DIEChkRequest();

		dieChkRequest.setFile("2");
		dieChkRequest.setField(".02");
		List<String> flags = new ArrayList<String>();
		flags.add("E");
		dieChkRequest.setFlags(flags);
		dieChkRequest.setValue("MALE");
		
		// Execute request against mocked object backend.
		DIEChkResponse dieChkResponse = dieChkEndpoint.chk(dieChkRequest);
		//TODO rearrange test to process one assertion
		assertNotNull(dieChkResponse);
		assertEquals(results.get(0), dieChkResponse.getData().get(0));
	}
}

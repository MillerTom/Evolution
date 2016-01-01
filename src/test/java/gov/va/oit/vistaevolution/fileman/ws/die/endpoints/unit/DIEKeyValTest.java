/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.die.DIEResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.die.endpoints.DIEKeyValEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEKeyValRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEKeyValResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Leisa Martella
 * 
 */
public class DIEKeyValTest extends VistaLinkContextTestParent {

	/**
	 * <pre>
	 *			 
	 *	>S FILE=2,FIELD=.01,FLAG="?",IENS=""
 	 *	
	 *	>D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT")
 	 *	
	 *	>ZW RESULT
	 *	RESULT("DIHELP")=3
	 *	RESULT("DIHELP",1)="Answer with PATIENT NAME, or SOCIAL SECURITY NUMBER, or WARD
 	 *	LOCATION, or ROOM-BED, or LODGER WARD LOCATION, or CV DATE EDITED, or CURRENT P
	 *	H INDICATOR, or CURRENT PURPLE HEART STATUS."
	 *	RESULT("DIHELP",2)=""
	 *	RESULT("DIHELP",3)="Enter name in 'LAST,FIRST MIDDLE SUFFIX' format, must be 3-30 characters in length."
	 *
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.21,DDR("FLAGS")="?"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *                                        
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="2^.01^?^4"
	 *		RESULT(3)="Answer with "
	 *		RESULT(4)="PATIENT NAME, or SOCIAL SECURITY NUMBER, or WARD LOCATION, or ROOM-BE
	 *			D, or LODGER WARD LOCATION, or PHONE NUMBER [RESIDENCE], or CV DATE EDITED, or C
	 *			URRENT PH INDICATOR, or CURRENT PURPLE HEART STATUS, or COGNITIVE RISK DATE UPDA
	 *			ED, or , etc."
	 *		RESULT(5)=""
	 *		RESULT(6)="Enter name in 'LAST,FIRST MIDDLE SUFFIX' format, must be 3-30 charact
	 *					ers in length."
	 *		RESULT(7)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testDIEHelp() throws VistaWebServiceFault {

		String result = "1";

		ArrayList<String> values = new ArrayList<String>();

		values.add("20^+1^.01");
		values.add("200");
		values.add("20^+1^.02");
		values.add(".01");
		values.add("20^+1^.03");
		values.add(".5");

		DIEKeyValRequest dieKeyValRequest = new DIEKeyValRequest();
		dieKeyValRequest.setValues(values);
		
		// Setup the endpoint for testing.
		DIEKeyValEndpointImpl dieKeyValEndpoint = new DIEKeyValEndpointImpl(
				new DIEResponseFactory(), getVistaLinkContext());
		
		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				result);

		 
		// Execute request against mocked object backend.
		DIEKeyValResponse dieKeyValResponse = dieKeyValEndpoint.keyVal(dieKeyValRequest);

		assertNotNull(dieKeyValResponse);
		assertEquals(result, dieKeyValResponse.getDataList().get(0));
	}
}

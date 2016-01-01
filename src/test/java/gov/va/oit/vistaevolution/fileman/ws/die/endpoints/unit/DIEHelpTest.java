/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.die.DIEResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.die.endpoints.DIEHelpEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEHelpRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEHelpResponse;
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
public class DIEHelpTest extends VistaLinkContextTestParent {

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
	//TODO Note that this class should test the parsing logic of the business class, 
	//     and should not try to mirror an implementation test
	public void testDIEHelp() throws VistaWebServiceFault {

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("2^.01^?^4");
		results.add("Answer with ");
		results.add("PATIENT NAME, or SOCIAL SECURITY NUMBER, or WARD LOCATION, or ROOM-BED, or LODGER WARD LOCATION, or PHONE NUMBER [RESIDENCE], or CV DATE EDITED, or CURRENT PH INDICATOR, or CURRENT PURPLE HEART STATUS, or COGNITIVE RISK DATE UPDAED, or , etc.");
		results.add("Enter name in 'LAST,FIRST MIDDLE SUFFIX' format, must be 3-30 characters in length.");
		results.add("[END_diHELP]");
		
		String testResponse = "[BEGIN_diHELP]\n" 
				+ "2^.01^?^4\n" 
				+ "Answer with \n"
				+ "PATIENT NAME, or SOCIAL SECURITY NUMBER, or WARD LOCATION, or ROOM-BED, or LODGER WARD LOCATION, or PHONE NUMBER [RESIDENCE], or CV DATE EDITED, or CURRENT PH INDICATOR, or CURRENT PURPLE HEART STATUS, or COGNITIVE RISK DATE UPDAED, or , etc.\n"
				+ "Enter name in 'LAST,FIRST MIDDLE SUFFIX' format, must be 3-30 characters in length.\n"
				+ "[END_diHELP]\n";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Setup the endpoint for testing.
		DIEHelpEndpointImpl dieHelpEndpoint = new DIEHelpEndpointImpl(
				getVistaLinkContext(), new DIEResponseFactory());

		DIEHelpRequest dieHelpRequest = new DIEHelpRequest();

		// Execute request against mocked object backend.
		dieHelpRequest.setFile("2");
		dieHelpRequest.setField(".01");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("?");
		dieHelpRequest.setFlags(flags);

		DIEHelpResponse response = dieHelpEndpoint.help(dieHelpRequest);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
		assertEquals(results.get(1), response.getDataList().get(1));
		assertEquals(results.get(2), response.getDataList().get(2));
		assertEquals(results.get(3), response.getDataList().get(3));
		assertEquals(results.get(4), response.getDataList().get(4));
		assertEquals(results.get(5), response.getDataList().get(5));
	}
}

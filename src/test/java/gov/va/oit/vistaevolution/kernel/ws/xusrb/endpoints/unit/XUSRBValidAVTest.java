package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.XUSRBResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.XUSRBValidAVEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBValidAVEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for VALIDAV method of XUSRB Webservice
 */
public class XUSRBValidAVTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XUSRBValidAVTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. "Not a valid ACCESS CODE/VERIFY CODE pair."
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S AV="123,456"
	 * >D SETUP^XUSRB(.RETURN)
	 * 
	 * Procedure Call:
	 * >D VALIDAV^XUSRB(.RETURN,AV)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(0)=0
	 * RETURN(1)=0
	 * RETURN(2)=0
	 * RETURN(3)="Not a valid ACCESS CODE/VERIFY CODE pair."
	 * RETURN(4)=0
	 * RETURN(5)=0
	 * RETURN(6)="VAHACG.FO-ALBANY.MED.VA.GOV"
	 * RETURN(7)=0
	 * </pre>
	 */
	@Test
	public void testValidAV001() throws VistaWebServiceFault {

		List<String> results = new ArrayList<String>();
		results.add("0");
		results.add("0");
		results.add("0");
		results.add("Not a valid ACCESS CODE/VERIFY CODE pair.");
		results.add("0");
		results.add("0");
		results.add("VAHACG.FO-ALBANY.MED.VA.GOV");
		results.add("0");

		String expectedOutput = "0\n" + "0\n" + "0\n"
				+ "Not a valid ACCESS CODE/VERIFY CODE pair.\n" + "0\n" + "0\n"
				+ "VAHACG.FO-ALBANY.MED.VA.GOV\n" + "0";

		XUSRBValidAVRequest request = new XUSRBValidAVRequest();
		request.setAvcode("123,456");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XUSRBValidAVEndpoint service = new XUSRBValidAVEndpointImpl(
				new XUSRBResponseFactory(), getVistaLinkContext());

		XUSRBValidAVResponse response = service.validAV(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Successful silent Log-on after validating the User’s access/verify codes.
	 * Display any messages that user might have after logon.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S AV=" RPC1234;RPC#1234 "
	 * >D SETUP^XUSRB(.RETURN)
	 * 
	 * Procedure Call:
	 * >D VALIDAV^XUSRB(.RETURN,AV)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(0)=53467
	 * RETURN(1)=0
	 * RETURN(2)=0
	 * RETURN(3)=""
	 * RETURN(4)=0
	 * RETURN(5)=0
	 * RETURN(6)=""
	 * RETURN(7)="Good morning DAOU,PATCHUSER"
	 * RETURN(8)="     You last signed on today at 04:17"
	 * RETURN(9)="You have 43 new messages. (43 in the 'IN' basket)"
	 * RETURN(10)=""
	 * RETURN(11)="Enter '^NML' to read your new messages."
	 * RETURN(12)=$c(27)_"[7mYou've got PRIORITY mail!"_$c(27)_"[27m"
	 * 
	 * </pre>
	 */
	@Test
	public void testValidAV003() throws VistaWebServiceFault {

		List<String> results = new ArrayList<String>();
		results.add("53467");
		results.add("0");
		results.add("0");
		results.add("");
		results.add("0");
		results.add("0");
		results.add("");
		results.add("Good morning DAOU,PATCHUSER");
		results.add("     You last signed on today at 04:17");
		results.add("You have 43 new messages. (43 in the 'IN' basket)");
		results.add("");
		results.add("Enter '^NML' to read your new messages.");
		results.add("Enter '^NML' to read your new messages.");
		results.add("$c(27)_\"[7mYou've got PRIORITY mail!\"_$c(27)_\"[27m\"");

		String expectedOutput = "53467\n" + "0\n" + "0\n" + "\n" + "0\n"
				+ "0\n" + "\n" + "Good morning DAOU,PATCHUSER\n"
				+ "     You last signed on today at 04:17\n"
				+ "You have 43 new messages. (43 in the 'IN' basket)\n" + ""
				+ "Enter '^NML' to read your new messages.\n" + "$c(27)_"
				+ "[7mYou've got PRIORITY mail!" + "_$c(27)_" + "[27m";

		XUSRBValidAVRequest request = new XUSRBValidAVRequest();
		request.setAvcode(" xxxxxxxx;yyyyyyyy ");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XUSRBValidAVEndpoint service = new XUSRBValidAVEndpointImpl(
				new XUSRBResponseFactory(), getVistaLinkContext());

		XUSRBValidAVResponse response = service.validAV(request);

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}
}

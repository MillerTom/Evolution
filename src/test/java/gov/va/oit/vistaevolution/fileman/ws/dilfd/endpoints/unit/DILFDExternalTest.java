package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.DILFDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.DILFDExternalEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDExternalEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDExternalRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDExternalResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for External method of DILFD Webservice
 */
public class DILFDExternalTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public DILFDExternalTest() {
		super();
	}

	/**
	 * <em>Test Case 1</em>
	 * 
	 * Top-level file
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FILE”)=.84,DDR(“FIELD”)=3,DDR(“FLAGS”)="",DDR(“INTERNAL”)="y"
	 * 
	 * >DEXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA="YES"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testExternal001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("YES");

		String expectedOutput = "YES";

		DILFDExternalRequest request = new DILFDExternalRequest();
		List<String> flags = new ArrayList<String>();
		request.setFile(".84");
		request.setField("3");
		request.setFlags(flags);
		request.setInternal("y");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DILFDExternalEndpoint service = new DILFDExternalEndpointImpl(
				new DILFDResponseFactory(), getVistaLinkContext());

		DILFDExternalResponse response = service.external(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputData().get(0));

	}

	/**
	 * <em>Test Case 2</em>
	 * 
	 * 501 error
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FILE”)=.84,DDR(“FIELD”)=9,DDR(“FLAGS”)="",DDR(“INTERNAL”)="DIE"
	 * 
	 * >D EXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=""
	 * DDRDATA("ERROR","DIERR",1)=501
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=3
	 * DDRDATA("ERROR","DIERR",1,"PARAM",1)=9
	 * DDRDATA("ERROR","DIERR",1,"PARAM","FIELD")=9
	 * DDRDATA("ERROR","DIERR",1,"PARAM","FILE")=.84
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="File #.84 does not contain a field 9."
	 * DDRDATA("ERROR","DIERR","E",501,1)=""
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testExternal002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("501");
		results.add("3");
		results.add("9");
		results.add("9");
		results.add(".84");
		results.add("File #.84 does not contain a field 9.");
		results.add("");

		String expectedOutput = "\n" + "501\n" + "3\n" + "9\n" + "9\n"
				+ ".84\n" + "File #.84 does not contain a field 9.\n" + "";

		DILFDExternalRequest request = new DILFDExternalRequest();
		List<String> flags = new ArrayList<String>();
		request.setFile(".84");
		request.setField("9");
		request.setFlags(flags);
		request.setInternal("DIE");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DILFDExternalEndpoint service = new DILFDExternalEndpointImpl(
				new DILFDResponseFactory(), getVistaLinkContext());

		DILFDExternalResponse response = service.external(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputData().get(0));

	}

}

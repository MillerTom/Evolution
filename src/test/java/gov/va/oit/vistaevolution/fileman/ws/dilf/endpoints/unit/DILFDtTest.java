package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.DILFDtEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFDtEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDtRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDtResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for dT method of DILF Webservice
 */
public class DILFDtTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public DILFDtTest() {
		super();
	}

	/**
	 * <em>Test Case 1</em>
	 * 
	 * Show Internal and External formats for current date.
	 * 
	 * <pre>
	 * 	>K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”E”
	 * >S DDR(“IN_DATE”)=”NOW”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=3140130
	 * DDRDATA(0)="JAN 30, 2014"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDt001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("3140130");
		results.add("JAN 30, 2014");

		String expectedOutput = "3140130\n" + "JAN 30, 2014";

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		DILFDtRequest request = new DILFDtRequest();
		request.setFlags(flags);
		request.setInDate("NOW");
		request.setLimit("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DILFDtEndpoint service = new DILFDtEndpointImpl(
				new DILFResponseFactory(), getVistaLinkContext());

		DILFDtResponse response = service.dt(request);

		assertNotNull(response);
		assertEquals(results.get(1), response.getOutputDataList().get(1));

	}

	/**
	 * <em>Test Case 6</em>
	 * 
	 * Show Internal format for current date and time; generate error msg 330
	 * for invalid input.
	 * 
	 * <pre>
	 * 	>K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”ST”
	 * >S DDR(“IN_DATE”)=”$H”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=-1
	 * DDRDATA("ERROR","DIERR")="1^1"
	 * DDRDATA("ERROR","DIERR",1)=330
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=2
	 * DDRDATA("ERROR","DIERR",1,"PARAM",1)="$H"
	 * DDRDATA("ERROR","DIERR",1,"PARAM",2)="date/time"
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="The value '$H' is not a valid date/time."
	 * DDRDATA("ERROR","DIERR","E",330,1)=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDt002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("1^1");
		results.add("330");
		results.add("2");
		results.add("$H");
		results.add("date/time");
		results.add("The value '$H' is not a valid date/time.");
		results.add("");

		String expectedOutput = "-1\n" + "1^1\n" + "330\n" + "2\n" + "$H\n"
				+ "date/time\n" + "The value '$H' is not a valid date/time.\n"
				+ "";

		List<String> flags = new ArrayList<String>();
		flags.add("S");
		flags.add("T");
		DILFDtRequest request = new DILFDtRequest();
		request.setFlags(flags);
		request.setInDate("$H");
		request.setLimit("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DILFDtEndpoint service = new DILFDtEndpointImpl(
				new DILFResponseFactory(), getVistaLinkContext());

		DILFDtResponse response = service.dt(request);

		assertNotNull(response);
		assertEquals(results.get(1), response.getOutputDataList().get(1));

	}

}

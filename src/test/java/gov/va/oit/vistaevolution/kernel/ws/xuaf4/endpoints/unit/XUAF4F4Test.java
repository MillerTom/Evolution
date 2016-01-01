package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4F4EndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4F4Endpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4F4Request;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4F4Response;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.TestUtils;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

public class XUAF4F4Test extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XUAF4F4Test() {
		super();
	}

	/**
	 * <em>Test Case #1    Look Up active Station  Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 			>S STA="528A8"
	 * 			>S ARRAY=""
	 * 			>S FLAG="A"
	 * 			>S ONDT=""
	 * 		
	 * 		Procedure Call:
	 * 			>D F4^XUAF4(STA,.ARRAY,FLAG,ONDT)
	 * 		
	 * 		Expected Output:
	 * 			>ZW ARRAY
	 * 			ARRAY=6584
	 * 			ARRAY("INACTIVE")=0
	 * 			ARRAY("NAME")="ALBANY, NY VAMC"
	 * 			ARRAY("REALIGNED FROM")="500^500^3000701"
	 * 			ARRAY("STATION NUMBER")="528A8"
	 * 			ARRAY("TYPE")="VAMC"
	 * 			ARRAY("VA NAME")="VA HEALTHCARE NETWORK UPSTATE NEW YORK SYSTEM VISN 2 – ALBANY DIVISION"
	 * </pre>
	 * 
	 */

	@Test
	public void testF4001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("6584");
		results.add("0");
		results.add("ALBANY, NY VAMC");
		results.add("500^500^3000701");
		results.add("528A8");
		results.add("VAMC");
		results.add("VA HEALTHCARE NETWORK UPSTATE NEW YORK SYSTEM VISN 2 – ALBANY DIVISION");

		String testResponse = TestUtils
				.createFormattedTestResponse("6584;0;ALBANY, NY VAMC;500^500^3000701;528A8;VAMC;VA HEALTHCARE NETWORK UPSTATE NEW YORK SYSTEM VISN 2 – ALBANY DIVISION");

		XUAF4F4Request request = new XUAF4F4Request();
		request.setSta("528A8");
		request.setFlag("A");
		request.setInDate("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(null),
						null)).thenReturn(testResponse);

		XUAF4F4Endpoint service = new XUAF4F4EndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4F4Response response = service.F4(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #2   Look Up inactive Station  Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 			>S STA="455"
	 * 			>S ARRAY=""
	 * 			>S FLAG="A"
	 * 			>S ONDT=""
	 * 		
	 * 		Procedure Call:
	 * 			>D F4^XUAF4(STA,.ARRAY,FLAG,ONDT)
	 * 		
	 * 		Expected Output:
	 * 			>ZW ARRAY
	 * 			ARRAY="0^inactive facility"
	 * </pre>
	 * 
	 */

	@Test
	public void testF4002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^inactive facility");

		String testResponse = TestUtils
				.createFormattedTestResponse("0^inactive facility");

		XUAF4F4Request request = new XUAF4F4Request();
		request.setSta("455");
		request.setFlag("A");
		request.setInDate("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(null),
						null)).thenReturn(testResponse);

		XUAF4F4Endpoint service = new XUAF4F4EndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4F4Response response = service.F4(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

}

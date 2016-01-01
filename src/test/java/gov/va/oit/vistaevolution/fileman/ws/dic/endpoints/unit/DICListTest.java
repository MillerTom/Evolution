package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dic.DICResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.DICListEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.DICListEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICListRequest;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICListResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for List function of DIC Webservice
 */
public class DICListTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public DICListTest() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Return a list of 5 Dialog entries.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")=""
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^120^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)=101
	 * RETURN(5)=110
	 * RETURN(6)=111
	 * RETURN(7)=112
	 * RETURN(8)=120
	 * 
	 * </pre>
	 */
	@Test
	public void testList001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^120^");
		results.add("[Data]");
		results.add("101");
		results.add("110");
		results.add("111");
		results.add("112");
		results.add("120");

		String expectedOutput = "[Misc]\n" + "MORE^120^\n" + "[Data]\n"
				+ "101\n" + "110\n" + "111\n" + "112\n" + "120";

		DICListRequest request = new DICListRequest();
		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DICListEndpoint service = new DICListEndpointImpl(
				new DICResponseFactory(), getVistaLinkContext());

		DICListResponse response = service.list(request);

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * Return a list of 5 Dialog entries. Suppress the default values, use the
	 * values from its index, and returndata from fields .01, 1, 1.2 and 3.
	 * (“@;IX;FID;.01;1;1.2;3”).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")="@;.01;1;1.2;3"
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^120^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)="101^101^ERROR^VA FILEMAN^"
	 * RETURN(5)="110^110^ERROR^VA FILEMAN^"
	 * RETURN(6)="111^111^ERROR^VA FILEMAN^YES"
	 * RETURN(7)="112^112^ERROR^VA FILEMAN^YES"
	 * RETURN(8)="120^120^ERROR^VA FILEMAN^YES"
	 * 
	 * </pre>
	 */
	@Test
	public void testList002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^120^");
		results.add("[Data]");
		results.add("101^101^ERROR^VA FILEMAN^");
		results.add("110^110^ERROR^VA FILEMAN^");
		results.add("111^111^ERROR^VA FILEMAN^YES");
		results.add("112^112^ERROR^VA FILEMAN^YES");
		results.add("120^120^ERROR^VA FILEMAN^YES");

		String expectedOutput = "[Misc]\n" + "MORE^120^\n" + "[Data]\n"
				+ "101^101^ERROR^VA FILEMAN^\n" + "110^110^ERROR^VA FILEMAN^\n"
				+ "111^111^ERROR^VA FILEMAN^YES\n"
				+ "112^112^ERROR^VA FILEMAN^YES\n"
				+ "120^120^ERROR^VA FILEMAN^YES";

		DICListRequest request = new DICListRequest();
		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1");
		fields.add("1.2");
		fields.add("3");
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DICListEndpoint service = new DICListEndpointImpl(
				new DICResponseFactory(), getVistaLinkContext());

		DICListResponse response = service.list(request);

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

}

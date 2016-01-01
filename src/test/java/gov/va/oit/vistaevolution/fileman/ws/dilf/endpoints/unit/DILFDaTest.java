package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.DILFDaEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFDaEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDaRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDaResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for dA method of DILF Webservice
 */
public class DILFDaTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public DILFDaTest() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Pass in IENS, display output in MYDA array
	 * 
	 * <pre>
	 * >K MYDA
	 * >S IENS="5,51,1," 
	 * >D DAR^DDR5(.MYDA,IENS) 
	 * >ZW MYDA
	 * MYDA=5
	 * MYDA(1)=51
	 * MYDA(2)=1
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDa001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("5");
		results.add("51");
		results.add("1");

		String expectedOutput = "5\n" + "51\n" + "1";

		DILFDaRequest request = new DILFDaRequest();
		request.setIens("5,51,1,");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DILFDaEndpoint dilfDaEndpoint = new DILFDaEndpointImpl(
				new DILFResponseFactory(), getVistaLinkContext());

		DILFDaResponse response = dilfDaEndpoint.da(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDa().get(0));
	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Pass in null, display no output in MYDA array
	 * 
	 * <pre>
	 * >K MYDA
	 * >S IENS="" 
	 * >D DAR^DDR5(.MYDA,IENS) 
	 * >ZW MYDA
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDa002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();

		String expectedOutput = "";

		DILFDaRequest request = new DILFDaRequest();
		request.setIens("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DILFDaEndpoint dilfDaEndpoint = new DILFDaEndpointImpl(
				new DILFResponseFactory(), getVistaLinkContext());

		DILFDaResponse response = dilfDaEndpoint.da(request);

		assertNotNull(response);
		assertNotNull(response.getDa());
	}
}

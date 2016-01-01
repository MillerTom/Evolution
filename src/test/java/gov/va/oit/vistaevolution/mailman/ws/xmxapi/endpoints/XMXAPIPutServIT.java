package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIPutServEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPutServRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPutServResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class XMXAPIPutServIT extends EvolutionIT<XMXAPIPutServEndpoint> {

	private XMXAPIPutServRequest request;

	@Override
	protected Class<XMXAPIPutServEndpoint> getType() {
		return XMXAPIPutServEndpoint.class;
	}

	@Before
	public void setUp() {
		request = new XMXAPIPutServRequest();

	}

	/**
	 * <em>Put a Message in a Server Basket</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET XMKN="S.EVOLUTION"
	 * >SET XMZ=55771
	 * 
	 * Procedure Call:
	 * 
	 * >D PUTSERV^XMWSOA03(.RETURN,XMKN,XMZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="0^No errors"
	 * </pre>
	 * 
	 */
	@Test
	@Ignore
	public void testPutMessage() throws VistaWebServiceFault {
		String expectedResponse = "0^No errors";

		request.setMkn("S.EVOLUTION");
		request.setMz("55771");

		XMXAPIPutServResponse response = service.putMsg(request);

		assertNotNull(response);
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getResult());

	}

	/**
	 * <em>Error returned by the API</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET XMKN="S.CLEVELAND.MED.VA.GOV"
	 * >SET XMZ=55771
	 * 
	 * Procedure Call:
	 * 
	 * >D PUTSERV^XMWSOA03(.RETURN,XMKN,XMZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="="-1^Server basket 'S.CLEVELAND.MED.VA.GOV' not found.^Name must be exact."
	 * </pre>
	 * 
	 */
	@Test
	@Ignore
	public void testBasketNotFound() throws VistaWebServiceFault {
		String expectedResponse = "-1^Server basket 'S.CLEVELAND.MED.VA.GOV' not found.^Name must be exact.";

		request.setMkn("S.CLEVELAND.MED.VA.GOV");
		request.setMz("55771");

		XMXAPIPutServResponse response = service.putMsg(request);

		assertNotNull(response);
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(2, response.getErrors().size());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));

	}

	/**
	 * <em>Missing Message ID</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET XMKN="S.CLEVELAND.MED.VA.GOV"
	 * >SET XMZ=""
	 * 
	 * Procedure Call:
	 * 
	 * >D PUTSERV^XMWSOA03(.RETURN,XMKN,XMZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="="-1^Error in required input"
	 * </pre>
	 * 
	 */
	@Test
	public void testMissingMessageId() throws VistaWebServiceFault {
		String expectedResponse = "-1^Error in required input";

		request.setMkn("S.EVOLUTION");
		request.setMz("");

		XMXAPIPutServResponse response = service.putMsg(request);

		assertNotNull(response);
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));

	}

	/**
	 * <em>Missing Basket Name</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET XMKN=""
	 * >SET XMZ=55771
	 * 
	 * Procedure Call:
	 * 
	 * >D PUTSERV^XMWSOA03(.RETURN,XMKN,XMZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="="-1^Error in required input"
	 * </pre>
	 * 
	 */
	@Test
	public void testMissingBasket() throws VistaWebServiceFault {
		String expectedResponse = "-1^Error in required input";

		request.setMkn("");
		request.setMz("55771");

		XMXAPIPutServResponse response = service.putMsg(request);

		assertNotNull(response);
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));

	}

}

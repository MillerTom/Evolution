package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1EncodeupEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Bill Blackmon <bill.blackmon@medsphere.com>
 * 
 * 
 */

public class XMXUTIL1EncodeupTestIT extends EvolutionIT<XMXUTIL1EncodeupEndpoint> {
	XMXUTIL1EncodeupRequest request;

	@Before
	public void setUp() {
		request = new XMXUTIL1EncodeupRequest();

	}

	@After
	public void tearDown() {
		request = null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
	 */
	@Override
	protected Class<XMXUTIL1EncodeupEndpoint> getType() {
		return XMXUTIL1EncodeupEndpoint.class;
	}
	
	/**
	 * <em> Encode string with an up caret </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set STRING=”String Containing ^ is converted”
	 * 
	 * Procedure Call:
	 * 
	 * >ENCODEUP^XMWSOA06(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="String Containing ~U~ is converted"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeup() throws VistaWebServiceFault {

		String expectedResponse = "String Containing ~U~ is converted";

		request.setInput("String Containing ^ is converted");
		XMXUTIL1EncodeupResponse response = service.encodeUp(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}
	
	/**
	 * <em> Encode string that does not contain an up caret </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set STRING=”String Containing no up caret”
	 * 
	 * Procedure Call:
	 * 
	 * >ENCODEUP^XMWSOA06(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="String Containing no up caret"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeupNoCaret() throws VistaWebServiceFault {

		String expectedResponse = "String Containing no up caret";

		request.setInput("String Containing no up caret");
		XMXUTIL1EncodeupResponse response = service.encodeUp(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}
	
	/**
	 * <em> Encode string that is empty </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set STRING=””
	 * 
	 * Procedure Call:
	 * 
	 * >ENCODEUP^XMWSOA06(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="-1^Error in required input"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore("Not working")
	public void testEncodeupEmptyString() throws VistaWebServiceFault {

		String expectedResponse = "";

		request.setInput("");
		XMXUTIL1EncodeupResponse response = service.encodeUp(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());
		

	}
	
	/**
	 * <em> Encode string that contains an up caret </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set STRING=”^”
	 * 
	 * Procedure Call:
	 * 
	 * >ENCODEUP^XMWSOA06(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="~U~”
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeupOnlyCaret() throws VistaWebServiceFault {

		String expectedResponse = "~U~";
		request.setInput("^");
		XMXUTIL1EncodeupResponse response = service.encodeUp(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}
	
	/**
	 * <em> Encode string that contains multiple fields and up carets </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set STRING="^ONE^two^^^Five^"
	 * 
	 * Procedure Call:
	 * 
	 * >ENCODEUP^XMWSOA06(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="~U~ONE~U~two~U~~U~~U~Five~U~"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeupMultipleFieldsAndCarets() throws VistaWebServiceFault {

		String expectedResponse = "~U~ONE~U~two~U~~U~~U~Five~U~";

		request.setInput("^ONE^two^^^Five^");
		XMXUTIL1EncodeupResponse response = service.encodeUp(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}
	
}	// end class	
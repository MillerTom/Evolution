package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFHtmlEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFHtmlRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFHtmlResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author rob.carlson
 * 
 */
public class DILFHtmlTestIT extends EvolutionIT<DILFHtmlEndpoint> {
	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
	 */
	@Override
	protected Class<DILFHtmlEndpoint> getType() {
		return DILFHtmlEndpoint.class;
	}

	DILFHtmlRequest request;

	@Before
	public void setUp() {
		request = new DILFHtmlRequest();

	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em>Encoding a string that contains a “^” character</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="NAME^JANE DOE"
	 * >SET DDR(“ACTION”)=1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=”NAME&#94;JANE DOE”
	 * </pre>
	 * 
	 */
	@Test
	public void testEncodeCaret() throws VistaWebServiceFault {
		String testResponse = "NAME&#94;JANE DOE";

		request.setAaction("1");
		request.setString("NAME^JANE DOE");

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}

	/**
	 * <em>Decoding a string that contains a “^” character</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="NAME&#94;JANE DOE"
	 * >SET DDR(“ACTION”)=-1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=”NAME^JANE DOE”
	 * </pre>
	 * 
	 */
	@Test
	public void testDecodeCaret() throws VistaWebServiceFault {
		String testResponse = "NAME^JANE DOE";

		request.setAaction("-1");
		request.setString("NAME&#94;JANE DOE");

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}

	/**
	 * <em>Attempting to decode an decoded string</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="NAME^JANE DOE"
	 * >SET DDR(“ACTION”)=-1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=”NAME^JANE DOE”
	 * </pre>
	 * 
	 */
	@Test
	public void testDecodeDecoded() throws VistaWebServiceFault {
		String testResponse = "NAME^JANE DOE";

		request.setAaction("-1");
		request.setString("NAME^JANE DOE");

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}

	/**
	 * <em>- Attempting to encode an already encoded string</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="NAME&#94;JANE DOE"
	 * >SET DDR(“ACTION”)=1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=”NAME&amp;#94;JANE DOE”
	 * </pre>
	 * 
	 */
	@Test
	public void testEncodeEncoded() throws VistaWebServiceFault {
		String testResponse = "NAME&amp;#94;JANE DOE";

		request.setAaction("1");
		request.setString("NAME&#94;JANE DOE");

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}

	/**
	 * <em>Attempting to encode a string > 255 characters</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="P($G(^ICD9(12443,1)),"^")_"^"_$P($G(^ICD9(12443,68,3,1)),"^")"
	 * >SET DDR(“ACTION”)=1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=””
	 * </pre>
	 * 
	 */
	@Test
	@Ignore
	public void testEncode255() throws VistaWebServiceFault {
		String testResponse = "";

		request.setAaction("1");
		request.setString("$P($G(^ICD9(12443,1)),\"^\")_\"^\"_$P($G(^ICD9(12443,68,3,1)),\"^\")");

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}

	/**
	 * <em>Attempting to encode a NULL string</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)=""
	 * >SET DDR(“ACTION”)=1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=””
	 * </pre>
	 * 
	 */
	@Test
	public void testEncodeNullString() throws VistaWebServiceFault {
		String testResponse = "";

		request.setAaction("1");
		request.setString("");

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}

	/**
	 * <em>Attempting to decode a NULL string</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)=""
	 * >SET DDR(“ACTION”)=-1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=””
	 * </pre>
	 * 
	 */
	@Test
	public void testDecodeNullString() throws VistaWebServiceFault {
		String testResponse = "";

		request.setAaction("-1");
		request.setString("");

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}

	/**
	 * <em>Attempting to encode a string > 255 characters</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="P($G(^ICD9(12443,1)),"^")_"^"_$P($G(^ICD9(12443,68,3,1)),"^")"
	 * >SET DDR(“ACTION”)=1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA="HYPERTENSIVE HEART AND CHRONIC KIDNEY DISEASE, UNSPECIFIED, WITHOUT HEART FAILURE AND WITH CHRONIC KIDNEY DISEASE STAGE I THROUGH STAGE IV, OR UNSPECIFIED^HYPERTENSIVE HEART AND CHRONIC KIDNEY DISEASE, UNSPECIFIED, WITHOUT HEART FAILURE AND WITH CHRONIC KIDNEYDISEASE STAGE I THROUGH STAGE IV, OR UNSPECIFIED"
	 * </pre>
	 * 
	 */
	@Test
	@Ignore
	public void testDecode255() throws VistaWebServiceFault {
		String testResponse = "HYPERTENSIVE HEART AND CHRONIC KIDNEY DISEASE, UNSPECIFIED, WITHOUT HEART FAILURE AND WITH CHRONIC KIDNEY DISEASE STAGE I THROUGH STAGE IV, OR UNSPECIFIED^HYPERTENSIVE HEART AND CHRONIC KIDNEY DISEASE, UNSPECIFIED, WITHOUT HEART FAILURE AND WITH CHRONIC KIDNEYDISEASE STAGE I THROUGH STAGE IV, OR UNSPECIFIED";

		request.setAaction("-1");
		request.setString("$P($G(^ICD9(12443,1)),\"^\")_\"^\"_$P($G(^ICD9(12443,68,3,1)),\"^\")");

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}
} // end class

package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.XMCU1StranEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1StranRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1StranResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for Stran function of XMCU1 Webservice
 */
public class XMCU1StranIT extends EvolutionIT<XMCU1StranEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XMCU1StranIT.class);

	private XMCU1StranResponse response;
	private XMCU1StranRequest request;

	@Override
	protected Class<XMCU1StranEndpoint> getType() {
		return XMCU1StranEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMCU1StranRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMCU1StranIT() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Pass in the ASCII control character (Start of Header) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(1)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~A"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran001() throws VistaWebServiceFault {

		String result = "~A";

		char ctrlChar = 1;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Pass in the ASCII control character (Start of Text) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(2)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~B"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran002() throws VistaWebServiceFault {

		String result = "~B";

		char ctrlChar = 2;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * Pass in the ASCII control character (End of Text) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(3)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~C"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran003() throws VistaWebServiceFault {

		String result = "~C";

		char ctrlChar = 3;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * Pass in the ASCII control character (End of Transmission) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(4)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~D"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran004() throws VistaWebServiceFault {

		String result = "~D";

		char ctrlChar = 4;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * Pass in the ASCII control character (Enquiry) and return “~” concatenated
	 * with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(5)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~E"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran005() throws VistaWebServiceFault {

		String result = "~E";

		char ctrlChar = 5;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #6</em>
	 * 
	 * Pass in the ASCII control character (Acknowledgment) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(6)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~F"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran006() throws VistaWebServiceFault {

		String result = "~F";

		char ctrlChar = 6;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #7</em>
	 * 
	 * Pass in the ASCII control character (Bell) and return “~” concatenated
	 * with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(7)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~G"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran007() throws VistaWebServiceFault {

		String result = "~G";

		char ctrlChar = 7;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #8</em>
	 * 
	 * Pass in the ASCII control character (Backspace) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(8)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~H"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran008() throws VistaWebServiceFault {

		String result = "~H";

		char ctrlChar = 8;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #9</em>
	 * 
	 * Pass in the ASCII control character (Horizontal Tab) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(9)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~I"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran009() throws VistaWebServiceFault {

		String result = "~I";

		char ctrlChar = 9;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #10</em>
	 * 
	 * Pass in the ASCII control character (Line feed) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(10)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~J"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0010() throws VistaWebServiceFault {

		String result = "~J";

		char ctrlChar = 10;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #11</em>
	 * 
	 * Pass in the ASCII control character (Vertical Tab) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(11)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~K"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0011() throws VistaWebServiceFault {

		String result = "~K";

		char ctrlChar = 11;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #12</em>
	 * 
	 * Pass in the ASCII control character (Form feed) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(12)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~L"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0012() throws VistaWebServiceFault {

		String result = "~L";

		char ctrlChar = 12;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #13</em>
	 * 
	 * Pass in the ASCII control character (Carriage return) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(13)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~M"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0013() throws VistaWebServiceFault {

		String result = "~M";

		char ctrlChar = 13;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #14</em>
	 * 
	 * Pass in the ASCII control character (Shift Out) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(14)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~N"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0014() throws VistaWebServiceFault {

		String result = "~N";

		char ctrlChar = 14;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #15</em>
	 * 
	 * Pass in the ASCII control character (Shift In) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(15)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~O"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0015() throws VistaWebServiceFault {

		String result = "~O";

		char ctrlChar = 15;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #16</em>
	 * 
	 * Pass in the ASCII control character (Data Link Escape) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(16)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~P"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0016() throws VistaWebServiceFault {

		String result = "~P";

		char ctrlChar = 16;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #17</em>
	 * 
	 * Pass in the ASCII control character (Device Control 1 - XON) and return
	 * “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(17)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~Q"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0017() throws VistaWebServiceFault {

		String result = "~Q";

		char ctrlChar = 17;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #18</em>
	 * 
	 * Pass in the ASCII control character (Device Control 2) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(18)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~R"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0018() throws VistaWebServiceFault {

		String result = "~R";

		char ctrlChar = 18;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #19</em>
	 * 
	 * Pass in the ASCII control character (Device Control 3 - XOFF) and return
	 * “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(19)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~S"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0019() throws VistaWebServiceFault {

		String result = "~S";

		char ctrlChar = 19;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #20</em>
	 * 
	 * Pass in the ASCII control character (Device Control 4) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(20)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~T"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0020() throws VistaWebServiceFault {

		String result = "~T";

		char ctrlChar = 20;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #21</em>
	 * 
	 * Pass in the ASCII control character (Negative Acknowledgement) and return
	 * “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(21)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~U"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0021() throws VistaWebServiceFault {

		String result = "~U";

		char ctrlChar = 21;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #22</em>
	 * 
	 * Pass in the ASCII control character (Synchronous idle) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(22)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~V"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0022() throws VistaWebServiceFault {

		String result = "~V";

		char ctrlChar = 22;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #23</em>
	 * 
	 * Pass in the ASCII control character (End of Transmission Block) and
	 * return “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(23)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~W"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0023() throws VistaWebServiceFault {

		String result = "~W";

		char ctrlChar = 23;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #24</em>
	 * 
	 * Pass in the ASCII control character (Cancel) and return “~” concatenated
	 * with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(24)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~X"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0024() throws VistaWebServiceFault {

		String result = "~X";

		char ctrlChar = 24;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #25</em>
	 * 
	 * Pass in the ASCII control character (End of Medium) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(25)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~Y"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0025() throws VistaWebServiceFault {

		String result = "~Y";

		char ctrlChar = 25;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #26</em>
	 * 
	 * Pass in the ASCII control character (Substitute) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(26)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~Z"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0026() throws VistaWebServiceFault {

		String result = "~Z";

		char ctrlChar = 26;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #27</em>
	 * 
	 * Pass in the ASCII control character (Escape) and return “~” concatenated
	 * with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(27)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~["
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0027() throws VistaWebServiceFault {

		String result = "~[";

		char ctrlChar = 27;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #28</em>
	 * 
	 * Pass in the ASCII control character (File Separator) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(28)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~\"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0028() throws VistaWebServiceFault {

		String result = "~\\";

		char ctrlChar = 28;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #29</em>
	 * 
	 * Pass in the ASCII control character (Group Separator) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(29)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~]"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0029() throws VistaWebServiceFault {

		String result = "~]";

		char ctrlChar = 29;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #30</em>
	 * 
	 * Pass in the ASCII control character (Record Separator) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(30)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~^"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0030() throws VistaWebServiceFault {

		String result = "~^";

		char ctrlChar = 30;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #31</em>
	 * 
	 * Pass in the ASCII control character (Unit Separator) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(31)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~_"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0031() throws VistaWebServiceFault {

		String result = "~_";

		char ctrlChar = 31;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #32</em>
	 * 
	 * Pass in the ASCII control character (Delete) and return “~” concatenated
	 * with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(127)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~?"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0032() throws VistaWebServiceFault {

		String result = "~?";

		char ctrlChar = 127;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #33</em>
	 * 
	 * Pass in the ASCII control character (Null character) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(0)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~@"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0033() throws VistaWebServiceFault {

		String result = "~@";

		char ctrlChar = 0;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #34</em>
	 * 
	 * Pass in all ASCII control characters from decimal 0 through 31 and
	 * decimal 127 and return “~” concatenated with the printable control
	 * characters.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(0)_$C(1)_$C(2)_$C(3)_$C(4)_$C(5)_$C(6)_$C(7)_$C(8)_$C(9)_$C(10)
	 * >S STRING=STRING_$C(11)_$C(12)_$C(13)_$C(14)_$C(15)_$C(16)_$C(17)_$C(18)_$C(19)
	 * >S STRING=STRING_$C(20)_$C(21)_$C(22)_$C(23)_$C(24)_$C(25)_$C(26)_$C(27)_$C(28)
	 * >S STRING=STRING_$C(29)_$C(30)_$C(31)_$C(127)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~@~A~B~C~D~E~F~G~H~I~J~K~L~M~N~O~P~Q~R~S~T~U~V~W~X~Y~Z~[~\~]~^~_~?"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0034() throws VistaWebServiceFault {

		String result = "~@~A~B~C~D~E~F~G~H~I~J~K~L~M~N~O~P~Q~R~S~T~U~V~W~X~Y~Z~[~\\~]~^~_~?";

		StringBuilder expectedResult = new StringBuilder();
		for (int i = 0; i < 32; i++) {
			char ctrlChar = (char) i;
			String expectedResult1 = Character.toString(ctrlChar);
			expectedResult.append(expectedResult1);
		}

		char ctrlChar127 = 127;
		String result127 = Character.toString(ctrlChar127);
		expectedResult.append(result127);

		request.setInputString(expectedResult.toString());

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #35</em>
	 * 
	 * Pass in the non-control character “A” and the printable character “A” is
	 * returned.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”A”
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="A"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0035() throws VistaWebServiceFault {

		String result = "A";

		request.setInputString("A");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #36</em>
	 * 
	 * Pass in the non-control character null (“”) and an Error Message is
	 * returned..
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=""
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0036() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		request.setInputString("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());
	}

	/**
	 * <em>Test Case #37</em>
	 * 
	 * Pass in the non-control character decimal 65 (“A”) and the printable
	 * character “A” is returned.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(65)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="A"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0037() throws VistaWebServiceFault {

		String result = "A";

		char ctrlChar = 65;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #38</em>
	 * 
	 * Pass in the non-control character decimal 34 (“”) and the printable
	 * character “” (null) is returned.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(34)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=""""
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0038() throws VistaWebServiceFault {

		String result = "\"";

		char ctrlChar = 34;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	// Test cases for C1 control characters decimals 128 through 159

	/**
	 * <em>Test Case #39</em>
	 * 
	 * Pass in the C1 control character (unassigned, "Padding Character”) and
	 * return “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(128)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~@"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0039() throws VistaWebServiceFault {

		String result = "~@";

		char ctrlChar = 128;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #40</em>
	 * 
	 * Pass in the C1 control character (unassigned, "High Octet Preset") and
	 * return “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(129)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~A"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0040() throws VistaWebServiceFault {

		String result = "~A";

		char ctrlChar = 129;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #41</em>
	 * 
	 * Pass in the C1 control character (Break Permitted Here) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(130)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~B"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0041() throws VistaWebServiceFault {

		String result = "~B";

		char ctrlChar = 130;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #42</em>
	 * 
	 * Pass in the C1 control character (No Break Here) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(131)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~C"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0042() throws VistaWebServiceFault {
		;

		String result = "~C";

		char ctrlChar = 131;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #43</em>
	 * 
	 * Pass in the C1 control character (Index) and return “~” concatenated with
	 * the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(132)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~D"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0043() throws VistaWebServiceFault {

		String result = "~D";

		char ctrlChar = 132;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #44</em>
	 * 
	 * Pass in the C1 control character (Next Line) and return “~” concatenated
	 * with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(133)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~E"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0044() throws VistaWebServiceFault {

		String result = "~E";

		char ctrlChar = 133;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #45</em>
	 * 
	 * Pass in the C1 control character (Start of Selected Area) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(134)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~F"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0045() throws VistaWebServiceFault {

		String result = "~F";

		char ctrlChar = 134;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #46</em>
	 * 
	 * Pass in the C1 control character (End of Selected Area) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(135)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~G"
	 * 
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0046() throws VistaWebServiceFault {

		String result = "~G";

		char ctrlChar = 135;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #47</em>
	 * 
	 * Pass in the C1 control character (Horizontal Tabulation Set, Character
	 * Tabulation Set) and return “~” concatenated with the printable control
	 * character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(136)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~H"
	 * 
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0047() throws VistaWebServiceFault {

		String result = "~H";

		char ctrlChar = 136;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #48</em>
	 * 
	 * Pass in the C1 control character (Horizontal Tabulation with
	 * Justification, Character Tabulation with Justification) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(137)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~I"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0048() throws VistaWebServiceFault {

		String result = "~I";

		char ctrlChar = 137;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #49</em>
	 * 
	 * Pass in the C1 control character (Vertical Tabulation Set, Line
	 * Tabulation Set) and return “~” concatenated with the printable control
	 * character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(138)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~J"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0049() throws VistaWebServiceFault {

		String result = "~J";

		char ctrlChar = 138;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #50</em>
	 * 
	 * Pass in the C1 control character (Partial Line Down, Partial Line
	 * Forward) and return “~” concatenated with the printable control
	 * character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(139)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~K"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0050() throws VistaWebServiceFault {

		String result = "~K";

		char ctrlChar = 139;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #51</em>
	 * 
	 * Pass in the C1 control character (Partial Line Up, Partial Line Backward)
	 * and return “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(140)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~L"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0051() throws VistaWebServiceFault {

		String result = "~L";

		char ctrlChar = 140;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #52</em>
	 * 
	 * Pass in the C1 control character (Reverse Index, Reverse Line Feed) and
	 * return “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(141)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~M"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0052() throws VistaWebServiceFault {

		String result = "~M";

		char ctrlChar = 141;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #53</em>
	 * 
	 * Pass in the C1 control character (Single Shift Two) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(142)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~N"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0053() throws VistaWebServiceFault {

		String result = "~N";

		char ctrlChar = 142;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #54</em>
	 * 
	 * Pass in the C1 control character (Single Shift Three) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(143)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~O"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0054() throws VistaWebServiceFault {

		String result = "~O";

		char ctrlChar = 143;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #55</em>
	 * 
	 * Pass in the C1 control character (Device Control String) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(144)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~P"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0055() throws VistaWebServiceFault {

		String result = "~P";

		char ctrlChar = 144;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #56</em>
	 * 
	 * Pass in the C1 control character (Private Use One) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(145)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~Q"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0056() throws VistaWebServiceFault {

		String result = "~Q";

		char ctrlChar = 145;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #57</em>
	 * 
	 * Pass in the C1 control character (Private Use Two) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(146)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~R"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0057() throws VistaWebServiceFault {

		String result = "~R";

		char ctrlChar = 146;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #58</em>
	 * 
	 * Pass in the C1 control character (Set Transmit State) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(147)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~S"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0058() throws VistaWebServiceFault {

		String result = "~S";

		char ctrlChar = 147;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #59</em>
	 * 
	 * Pass in the C1 control character (Cancel Character) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(148)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~T"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0059() throws VistaWebServiceFault {

		String result = "~T";

		char ctrlChar = 148;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #60</em>
	 * 
	 * Pass in the C1 control character (Message Waiting) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(149)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~U"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0060() throws VistaWebServiceFault {

		String result = "~U";

		char ctrlChar = 149;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #61</em>
	 * 
	 * Pass in the C1 control character (Start of Guarded Protected Area, Start
	 * of Protected Area, Start of Guarded Area) and return “~” concatenated
	 * with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(150)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~V"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0061() throws VistaWebServiceFault {

		String result = "~V";

		char ctrlChar = 150;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #62</em>
	 * 
	 * Pass in the C1 control character (End of Guarded Protected Area, End of
	 * Protected Area, End of Guarded Area) and return “~” concatenated with the
	 * printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(151)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~W"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0062() throws VistaWebServiceFault {

		String result = "~W";

		char ctrlChar = 151;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #63</em>
	 * 
	 * Pass in the C1 control character (Start of String) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(152)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~X"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0063() throws VistaWebServiceFault {

		String result = "~X";

		char ctrlChar = 152;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #64</em>
	 * 
	 * Pass in the C1 control character (unassigned,
	 * "Single Graphic Character Introducer") and return “~” concatenated with
	 * the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(153)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~Y"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0064() throws VistaWebServiceFault {

		String result = "~Y";

		char ctrlChar = 153;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #65</em>
	 * 
	 * Pass in the C1 control character (Single Character Introducer) and return
	 * “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(154)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~Z"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0065() throws VistaWebServiceFault {

		String result = "~Z";

		char ctrlChar = 154;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #66</em>
	 * 
	 * Pass in the C1 control character (Control Sequence Introducer) and return
	 * “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(155)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~["
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0066() throws VistaWebServiceFault {

		String result = "~[";

		char ctrlChar = 155;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #67</em>
	 * 
	 * Pass in the C1 control character (String Terminator) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(156)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~\"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0067() throws VistaWebServiceFault {

		String result = "~\\";

		char ctrlChar = 156;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #68</em>
	 * 
	 * Pass in the C1 control character (Operating System Command) and return
	 * “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(157)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~]"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0068() throws VistaWebServiceFault {

		String result = "~]";

		char ctrlChar = 157;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #69</em>
	 * 
	 * Pass in the C1 control character (Privacy Message) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(158)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~^"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0069() throws VistaWebServiceFault {

		String result = "~^";

		char ctrlChar = 158;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #70</em>
	 * 
	 * Pass in the C1 control character (Application Program Command) and return
	 * “~” concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(159)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~_"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0070() throws VistaWebServiceFault {

		String result = "~_";

		char ctrlChar = 159;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());
	}

	/**
	 * <em>Test Case #71</em>
	 * 
	 * Pass in all C1 control characters from decimal 128 through 159 and return
	 * a string with “~” concatenated with the each printable control character.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=$C(128)_$C(129)_$C(130)_$C(131)_$C(132)_$C(133)_$C(134)_$C(135)_$C(136)_$C(137)_$C(138)
	 * >S STRING=STRING_$C(139)_$C(140)_$C(141)_$C(142)_$C(143)_$C(144)_$C(145)_$C(146)_$C(147)_$C(148)
	 * >S STRING=STRING_$C(149)_$C(150)_$C(151)_$C(152)_$C(153)_$C(154)_$C(155)_$C(156)_$C(157)_$C(158)_$C(159)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~@~A~B~C~D~E~F~G~H~I~J~K~L~M~N~O~P~Q~R~S~T~U~V~W~X~Y~Z~[~\~]~^~_"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0071() throws VistaWebServiceFault {

		String result = "~@~A~B~C~D~E~F~G~H~I~J~K~L~M~N~O~P~Q~R~S~T~U~V~W~X~Y~Z~[~\\~]~^~_";

		StringBuilder expectedResult = new StringBuilder();
		for (int i = 128; i < 160; i++) {
			char ctrlChar = (char) i;
			String expectedResult1 = Character.toString(ctrlChar);
			expectedResult.append(expectedResult1);
		}

		request.setInputString(expectedResult.toString());

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #72</em>
	 * 
	 * Pass in the C1 non-control character "¡" that will return the printable
	 * character "¡".
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING="¡"
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="¡"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran0072() throws VistaWebServiceFault {

		String result = "i";

		request.setInputString("i");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #73</em>
	 * 
	 * Pass in the C1 non-control character decimal 159 that will return the
	 * printable character "~_".
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(159)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~_"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testStran0073() throws VistaWebServiceFault {

		String result = "~_";

		char ctrlChar = 159;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.stran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());
	}
}

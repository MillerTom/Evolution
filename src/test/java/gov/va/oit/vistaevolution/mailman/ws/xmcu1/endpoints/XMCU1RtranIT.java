package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.XMCU1RtranEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1RtranRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1RtranResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for Rtran method of XMCU1 Webservice
 */
public class XMCU1RtranIT extends EvolutionIT<XMCU1RtranEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XMCU1RtranIT.class);

	private XMCU1RtranResponse response;
	private XMCU1RtranRequest request;

	@Override
	protected Class<XMCU1RtranEndpoint> getType() {
		return XMCU1RtranEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMCU1RtranRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XMCU1RtranIT() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Start of Header).
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”~A”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=1
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran001() throws VistaWebServiceFault {
		
		String result = "1";

		request.setInputString("~A");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Start of Text).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING="~B"
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=2
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran002() throws VistaWebServiceFault {

		String result = "2";

		request.setInputString("~B");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (End of Text).
	 * 
	 * 
	 * <pre>
	 *  	Input Data:
	 * >S STRING=”~C”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=3
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran003() throws VistaWebServiceFault {

		String result = "3";

		request.setInputString("~C");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (End of Transmission).
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”~D”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=4
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran004() throws VistaWebServiceFault {

		String result =  "4";

		request.setInputString("~D");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Enquiry).
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”~E”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=5
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran005() throws VistaWebServiceFault {

		String result =  "5";

		request.setInputString("~E");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #6</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Acknowledgment).
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”~F”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=6
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran006() throws VistaWebServiceFault {

		String result =  "6";

		request.setInputString("~F");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #7</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Bell).
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”~G”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=7
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran007() throws VistaWebServiceFault {

		String result =  "7";

		request.setInputString("~G");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #8</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Backspace).
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”~H”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=8
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran008() throws VistaWebServiceFault {

		String result =  "8";

		request.setInputString("~H");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #9</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Horizontal Tab).
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”~I”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=9
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran009() throws VistaWebServiceFault {

		String result =  "9";

		request.setInputString("~I");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #10</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Line feed).
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”~J”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=10
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0010() throws VistaWebServiceFault {

		String result =  "10";

		request.setInputString("~J");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #11</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Vertical Tab).
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”~K”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=11
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0011() throws VistaWebServiceFault {

		String result =  "11";

		request.setInputString("~K");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #12</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Form feed).
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”~L”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=12
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0012() throws VistaWebServiceFault {

		String result =  "12";

		request.setInputString("~L");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #13</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Carriage return).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~M”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=13
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0013() throws VistaWebServiceFault {

		String result =  "13";

		request.setInputString("~M");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #14</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Shift Out).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~N”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=14
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0014() throws VistaWebServiceFault {

		String result =  "14";

		request.setInputString("~N");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #15</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Shift In).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~O”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=15
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0015() throws VistaWebServiceFault {

		String result =  "15";

		request.setInputString("~O");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #16</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Data Link Escape).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~P”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=16
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0016() throws VistaWebServiceFault {

		String result =  "16";

		request.setInputString("~P");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #17</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Device Control 1 - XON).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~Q”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=17
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0017() throws VistaWebServiceFault {

		String result =  "17";

		request.setInputString("~Q");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #18</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Device Control 2).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~R”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=18
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0018() throws VistaWebServiceFault {

		String result =  "18";

		request.setInputString("~R");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #19</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Device Control 3 - XOFF).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~S”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=19
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0019() throws VistaWebServiceFault {

		String result =  "19";

		request.setInputString("~S");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #20</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Device Control 4).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~T”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=20
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0020() throws VistaWebServiceFault {

		String result =  "20";

		request.setInputString("~T");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #21</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Negative Acknowledgement).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~U”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=21
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0021() throws VistaWebServiceFault {
		
		String result =  "21";

		request.setInputString("~U");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #22</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Synchronous idle).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~V”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=22
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0022() throws VistaWebServiceFault {

		String result =  "22";

		request.setInputString("~V");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #23</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (End of Transmission Block).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~W”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=23
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0023() throws VistaWebServiceFault {

		String result =  "23";

		request.setInputString("~W");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #24</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Cancel).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~X”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=24
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0024() throws VistaWebServiceFault {

		String result =  "24";

		request.setInputString("~X");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #25</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (End of Medium).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~Y”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=25
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0025() throws VistaWebServiceFault {

		String result =  "25";

		request.setInputString("~Y");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #26</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Substitute).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~Z”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=26
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0026() throws VistaWebServiceFault {

		String result =  "26";

		request.setInputString("~Z");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #27</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Escape).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~[”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=27
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0027() throws VistaWebServiceFault {

		String result =  "27";

		request.setInputString("~[");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #28</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (File Separator).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~\”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=28
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0028() throws VistaWebServiceFault {

		String result =  "28";

		request.setInputString("~\\");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #29</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Group Separator).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~]”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=29
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0029() throws VistaWebServiceFault {

		String result =  "29";

		request.setInputString("~]");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #30</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Record Separator).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~^”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=30
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0030() throws VistaWebServiceFault {

		String result =  "30";

		request.setInputString("~^");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #31</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Unit Separator).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~_”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=31
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0031() throws VistaWebServiceFault {

		String result =  "31";

		request.setInputString("~_");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #32</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Delete).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~?”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=127
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0032() throws VistaWebServiceFault {

		String result =  "127";

		request.setInputString("~?");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #33</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Null character).
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=”~@”
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >W $A(RETURN)
	 * RETURN=0
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0033() throws VistaWebServiceFault {

		String result =  "0";

		request.setInputString("~@");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #34</em>
	 * 
	 * Pass in “~” concatenated with all the printable control characters and
	 * return all ASCII control characters from decimal 0 through 31 and decimal
	 * 127.
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING="~@~A~B~C~D~E~F~G~H~I~J~K~L~M~N~O~P~Q~R~S~T~U~V~W~X~Y~Z~[~\~]~^~_~?"
	 * 
	 * >S STRING2=$C(0)_$C(1)_$C(2)_$C(3)_$C(4)_$C(5)_$C(6)_$C(7)_$C(8)_$C(9)_$C(10)
	 * >S STRING2=STRING2_$C(11)_$C(12)_$C(13)_$C(14)_$C(15)_$C(16)_$C(17)_$C(18)_$C(19)
	 * >S STRING2=STRING2_$C(20)_$C(21)_$C(22)_$C(23)_$C(24)_$C(25)_$C(26)_$C(27)_$C(28)
	 * >S STRING2=STRING2_$C(29)_$C(30)_$C(31)_$C(127)
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >I RETURN=STRING2 W "YES"
	 * YES
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0034() throws VistaWebServiceFault {

		// convert control character to string
		StringBuilder expectedResult = new StringBuilder();
		for (int i = 0; i < 32; i++) {
			char ctrlChar = (char) i;
			String result = Integer.toString(ctrlChar);
			expectedResult.append(result);
		}

		char ctrlChar127 = 127;
		String result127 = Integer.toString(ctrlChar127);
		expectedResult.append(result127);

		request.setInputString("~@~A~B~C~D~E~F~G~H~I~J~K~L~M~N~O~P~Q~R~S~T~U~V~W~X~Y~Z~[~\\~]~^~_~?");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(expectedResult.toString(), response.getResult());

	}

	/**
	 * <em>Test Case #35</em>
	 * 
	 * Pass in a null string and return an error message.
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=""
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0035() throws VistaWebServiceFault {

		String result = "-1^Error in required input";

		request.setInputString("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());
	}

	/**
	 * <em>Test Case #36</em>
	 * 
	 * Pass in a string with no “~” characters and return an error message.
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING="A"
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^String does not need to be converted"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran0036() throws VistaWebServiceFault {

		String result = "-1^String does not need to be converted";

		request.setInputString("A");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.rtran(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

}

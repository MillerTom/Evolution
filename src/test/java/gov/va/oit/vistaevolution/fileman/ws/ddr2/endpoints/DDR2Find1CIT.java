package gov.va.oit.vistaevolution.fileman.ws.ddr2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.endpoints.interfaces.DDR2Find1CEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CRequest;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class DDR2Find1CIT extends EvolutionIT<DDR2Find1CEndpoint> {
	private static Logger logger = Logger.getLogger(DDR2Find1CIT.class);

	private DDR2Find1CRequest request;
	private DDR2Find1CResponse response;

	@Override
	protected Class<DDR2Find1CEndpoint> getType() {
		return DDR2Find1CEndpoint.class;
	}
	
	@Before
	public void setup(){
		request = new DDR2Find1CRequest();
	}
	@After
	public void tearDown() {
		request = null;
	}
	
	/**
	 * <em>Test Case #1</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=5
	 * >S DDR("FLAGS")="MX"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="VA"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 *  >ZW DATA
	 *  DATA(1)=51
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("51");

		request.setFile("5");
		request.setIens("");
		request.setValue("VA");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=54355
	 * >S DDR("FLAGS")="MX"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="VA"
	 * >S DDR("XREF")=""
	 * 
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)=""
	 * DATA(2)="[BEGIN_diERRORS]"
	 * DATA(3)="401^1^54355^^^1"
	 * DATA(4)="FILE^54355"
	 * DATA(5)="File #54355 does not exist."
	 * DATA(6)="[END_diERRORS]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("[BEGIN_diERRORS]");
		results.add("401^1^54355^^^1");
		results.add("FILE^54355");
		results.add("File #54355 does not exist.");
		results.add("[END_diERRORS]");

		request.setFile("54355");
		request.setIens("");
		request.setValue("VA");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);

		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=5
	 * >S DDR("FLAGS")="MX"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="NORTHERN VIRGINIA"
	 * >S DDR("XREF")=""
	 * 
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=0
	 * </pre>
	 */
	@Test
	public void testFind1C003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0");

		request.setFile("5");
		request.setIens("");
		request.setValue("NORTHERN VIRGINIA");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="MX"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C004() throws VistaWebServiceFault {

		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}

	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="AO"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C005() throws VistaWebServiceFault {

		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("O");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #6</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="AX"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C006() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #7</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="ABO"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C007() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("O");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #8</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="ABX"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 * 
	 */
	@Test
	public void testFind1C008() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #9</em>
	 * 
	 * <pre>
	 * 
	 *  >S DDR("FILE")=19
	 *  >S DDR("FLAGS")="ABCO"
	 *  >S DDR("IENS")=""
	 *  >S DDR("SCREEN")=""
	 *  >S DDR("VALUE")="DIFG"
	 *  >S DDR("XREF")=""
	 *  >D FIND1C^DDR2(.DATA,.DDR)
	 *  >ZW DATA
	 *  DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C009() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("O");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #10</em>
	 * 
	 * <pre>
	 * 
	 *  >S DDR("FILE")=19
	 *  >S DDR("FLAGS")="ABCX"
	 *  >S DDR("IENS")=""
	 *  >S DDR("SCREEN")=""
	 *  >S DDR("VALUE")="DIFG"
	 *  >S DDR("XREF")=""
	 *  >D FIND1C^DDR2(.DATA,.DDR)
	 *  >ZW DATA
	 *  DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C010() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #11</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="ABCKO"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C011() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("K");
		flags.add("O");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #12</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="ABCKX"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C012() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("K");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #13</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="ABCKMO"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C013() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("K");
		flags.add("M");
		flags.add("O");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #14</em>
	 * 
	 * <pre>
	 * 
	 *  >S DDR("FILE")=19
	 *  >S DDR("FLAGS")="ABCKMX"
	 *  >S DDR("IENS")=""
	 *  >S DDR("SCREEN")=""
	 *  >S DDR("VALUE")="DIFG"
	 *  >S DDR("XREF")=""
	 *  >D FIND1C^DDR2(.DATA,.DDR)
	 *  >ZW DATA
	 *  DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C014() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("K");
		flags.add("M");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #15</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="ABCKMOQ"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C015() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("K");
		flags.add("M");
		flags.add("O");
		flags.add("Q");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #16</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="ABCKMOU"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C016() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("K");
		flags.add("M");
		flags.add("O");
		flags.add("U");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #17</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="ABCKMOX"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C017() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("K");
		flags.add("M");
		flags.add("O");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #18</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="ABCKMOQU"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C018() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("K");
		flags.add("M");
		flags.add("O");
		flags.add("Q");
		flags.add("U");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #19</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="ABCKMOQX"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C019() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("K");
		flags.add("M");
		flags.add("O");
		flags.add("Q");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #20</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="ABCKMOQUX"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=5159
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C020() throws VistaWebServiceFault {
		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		flags.add("B");
		flags.add("C");
		flags.add("K");
		flags.add("M");
		flags.add("O");
		flags.add("Q");
		flags.add("U");
		flags.add("X");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		// Check to make sure the returned value is greater than 0
		try {
			assertTrue(Integer.parseInt(response.getDataList().get(0)) > 0);
		} catch (NumberFormatException e) {
			// expecting a numerical value
			fail("The value returned was not a numeric string.");
		}
	}

	/**
	 * <em>Test Case #21</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=19
	 * >S DDR("FLAGS")="M"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="DIFG"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)=""
	 * DATA(2)="[BEGIN_diERRORS]"
	 * DATA(3)="299^1^19^^^2"
	 * DATA(4)="1^DIFG"
	 * DATA(5)="FILE^19"
	 * DATA(6)="More than one entry matches the value(s) 'DIFG'."
	 * DATA(7)="[END_diERRORS]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C021() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("[BEGIN_diERRORS]");
		results.add("299^1^19^^^2");
		results.add("1^DIFG");
		results.add("FILE^19");
		results.add("More than one entry matches the value(s) 'DIFG'.");
		results.add("[END_diERRORS]");

		request.setFile("19");
		request.setIens("");
		request.setValue("DIFG");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		request.setFlags(flags);
		
		response = service.find1C(request);

		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #22</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=””
	 * >S DDR("FLAGS")="M"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="VA"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)=""
	 * DATA(2)="[BEGIN_diERRORS]"
	 * DATA(3)="202^1^^^^1"
	 * DATA(4)="1^file"
	 * DATA(5)="The input parameter that identifies the file is missing or invalid."
	 * DATA(6)="[END_diERRORS]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C022() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("[BEGIN_diERRORS]");
		results.add("202^1^^^^1");
		results.add("1^file");
		results.add("The input parameter that identifies the file is missing or invalid.");
		results.add("[END_diERRORS]");

		request.setFile("");
		request.setIens("");
		request.setValue("VA");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #23</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=”5”
	 * >S DDR("FLAGS")="M"
	 * >S DDR("IENS")="5"
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="VA"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)=""
	 * DATA(2)="[BEGIN_diERRORS]"
	 * DATA(3)="304^1^^5^^1"
	 * DATA(4)="IENS^5"
	 * DATA(5)="The IENS '5' lacks a final comma."
	 * DATA(6)="[END_diERRORS]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C023() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("[BEGIN_diERRORS]");
		results.add("304^1^^5^^1");
		results.add("IENS^5");
		results.add("The IENS '5' lacks a final comma.");
		results.add("[END_diERRORS]");

		request.setFile("5");
		request.setIens("5");
		request.setValue("VA");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #24</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=”5”
	 * >S DDR("FLAGS")="M"
	 * >S DDR("IENS")=",5,"
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="VA"
	 * >S DDR("XREF")=""
	 * 
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)=""
	 * DATA(2)="[BEGIN_diERRORS]"
	 * DATA(3)="205^1^^^^"
	 * DATA(4)="File# 5 and IEN string ,5, represent different subfile levels."
	 * DATA(5)="[END_diERRORS]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C024() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("[BEGIN_diERRORS]");
		results.add("205^1^^^^");
		results.add("File# 5 and IEN string ,5, represent different subfile levels.");
		results.add("[END_diERRORS]");

		request.setFile("5");
		request.setIens(",5,");
		request.setValue("VA");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #26</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=.84
	 * >S DDR("FLAGS")="Z"
	 * >S DDR("IENS")="120,"
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="VA"
	 * >S DDR("XREF")=""
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=""
	 * DATA(2)="[BEGIN_diERRORS]"
	 * DATA(3)="306^1^^120,^^1"
	 * DATA(4)="IENS^120,"
	 * DATA(5)="The first comma-piece of IENS '120,' should be empty."
	 * DATA(6)="[END_diERRORS]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C026() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("[BEGIN_diERRORS]");
		results.add("306^1^^120,^^1");
		results.add("IENS^120,");
		results.add("The first comma-piece of IENS '120,' should be empty.");
		results.add("[END_diERRORS]");

		request.setFile(".84");
		request.setIens("120,");
		request.setValue("VA");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("Z");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #27</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=5
	 * >S DDR("FLAGS")="Z"
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="VA"
	 * >S DDR("XREF")=""
	 * 
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)=""
	 * DATA(2)="[BEGIN_diERRORS]"
	 * DATA(3)="301^1^^^^1"
	 * DATA(4)="1^Z"
	 * DATA(5)="The passed flag(s) 'Z' are unknown or inconsistent."
	 * DATA(6)="[END_diERRORS]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C027() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("[BEGIN_diERRORS]");
		results.add("301^1^^^^1");
		results.add("1^Z");
		results.add("The passed flag(s) 'Z' are unknown or inconsistent.");
		results.add("[END_diERRORS]");

		request.setFile("5");
		request.setIens("");
		request.setValue("VA");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("Z");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #28</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=80
	 * >S DDR("FLAGS")=""
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="102.4"
	 * >S DDR("XREF")=""
	 * 
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 *  >ZW DATA
	 *  DATA(1)=0
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C028() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0");

		request.setFile("80");
		request.setIens("");
		request.setValue("102.4");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #29</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=80
	 * >S DDR("FLAGS")=""
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="102.4"
	 * >S DDR("XREF")="BA"
	 * 
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)=7
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C029() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("7");

		request.setFile("80");
		request.setIens("");
		request.setValue("102.4");
		request.setScreen("");
		request.setXref("BA");
		List<String> flags = new ArrayList<String>();
		flags.add("");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #30</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=80
	 * >S DDR("FLAGS")=""
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")="I Y<5"
	 * >S DDR("VALUE")="102.4"
	 * >S DDR("XREF")="BA"
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)=0
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C030() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0");

		request.setFile("80");
		request.setIens("");
		request.setValue("102.4");
		request.setScreen("I Y<5");
		request.setXref("BA");
		List<String> flags = new ArrayList<String>();
		flags.add("");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #31</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=80
	 * >S DDR("FLAGS")=""
	 * >S DDR("IENS")=""
	 * >S DDR("SCREEN")="I Y<10"
	 * >S DDR("VALUE")="102.4"
	 * >S DDR("XREF")="BA"
	 * 
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)=7
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C031() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("7");

		request.setFile("80");
		request.setIens("");
		request.setValue("102.4");
		request.setScreen("I Y<10");
		request.setXref("BA");
		List<String> flags = new ArrayList<String>();
		flags.add("");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/**
	 * <em>Test Case #32</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=8994.02
	 * >S DDR("FLAGS")="QXK"
	 * >S DDR("IENS")=",4,"
	 * >S DDR("SCREEN")=""
	 * >S DDR("VALUE")="ARRAY"
	 * >S DDR("XREF")=""
	 * 
	 * >D FIND1C^DDR2(.DATA,.DDR)
	 * >ZW DATA
	 * DATA(1)=2
	 * 
	 * </pre>
	 */
	@Test
	public void testFind1C032() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("2");

		request.setFile("8994.02");
		request.setIens(",4,");
		request.setValue("ARRAY");
		request.setScreen("");
		request.setXref("");
		List<String> flags = new ArrayList<String>();
		flags.add("Q");
		flags.add("X");
		flags.add("K");
		request.setFlags(flags);

		response = service.find1C(request);
		
		logger.debug(request);
		logger.debug(response);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

}

package gov.va.oit.vistaevolution.fileman.ws.ddr3.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.ddr3.endpoints.interfaces.DDR3ValCEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.ddr3.model.DDR3ValCRequest;
import gov.va.oit.vistaevolution.fileman.ws.ddr3.model.DDR3ValCResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 */
public class DDR3ValCIT extends EvolutionIT<DDR3ValCEndpoint> {

	@Override
	protected Class<DDR3ValCEndpoint> getType() {
		return DDR3ValCEndpoint.class;
	}

	private DDR3ValCRequest request;
	private DDR3ValCResponse response;

	@Before
	public void setUp() throws Exception {
		request = new DDR3ValCRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * 
	 * >S DDR("FILE")=2.98
	 * >S DDR("IENS")="64576,"
	 * >S DDR("VALUE")=""
	 * >S DDR("FIELD")="9.5"
	 * >D VALC^DDR3(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)=""
	 * DATA(4)=""
	 * </pre>
	 */
	@Test
	public void testValC001() throws VistaWebServiceFault {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("");
		expectedResult.add("");

		request.setFile("2.98");
		request.setIens("64576,");
		request.setValue("");
		request.setField("9.5");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
	}
	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * 	>S DDR("FILE")=2.98
	 * 	>S DDR("FIELD")="9.5"
	 * 	>S DDR("IENS")=",64576,"
	 * 	>S DDR("VALUE")=""
	 * 	>D VALC^DDR3(.DATA,.DDR)
	 * 	 
	 * 	>ZW DATA
	 * 	DATA(1)="[FILLER]"
	 * 	DATA(2)="[Data]"
	 * 	DATA(3)="^"
	 * 	DATA(4)=""
	 * 	DATA(5)="[BEGIN_diERRORS]"
	 * 	DATA(6)="308^1^^^^"
	 * 	DATA(7)="The IENS ',64576,' is syntactically incorrect."
	 * 	DATA(8)="[END_diERRORS]"
	 * </pre>
	 */
	@Test
	public void testValC002() throws VistaWebServiceFault {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("^");
		expectedResult.add("");
		expectedResult.add("[BEGIN_diERRORS]");
		expectedResult.add("308^1^^^^");
		expectedResult.add("The IENS ',64576,' is syntactically incorrect.");
		expectedResult.add("[END_diERRORS]");

		request.setFile("2.98");
		request.setField("9.5");
		request.setIens(",64576,");
		request.setValue("");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
		assertEquals(expectedResult.get(4), response.getDataList().get(4));
		assertEquals(expectedResult.get(5), response.getDataList().get(5));
		assertEquals(expectedResult.get(6), response.getDataList().get(6));
		assertEquals(expectedResult.get(7), response.getDataList().get(7));
	}

	/**
	 * <em>Use Case #3</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")="2"
	 * >S DDR("FIELD")="9.5"
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")="REG" 
	 * >D VALC^DDR3(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)="^"
	 * DATA(4)=""
	 * DATA(5)="[BEGIN_diERRORS]"
	 * DATA(6)="501^1^2^^9.5^3"
	 * DATA(7)="1^9.5"
	 * DATA(8)="FIELD^9.5"
	 * DATA(9)="FILE^2"
	 * DATA(10)="File #2 does not contain a field 9.5."
	 * DATA(11)="[END_diERRORS]"
	 * </pre>
	 */
	@Test
	public void testValC003() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("^");
		expectedResult.add("");
		expectedResult.add("[BEGIN_diERRORS]");
		expectedResult.add("501^1^2^^9.5^3");
		expectedResult.add("1^9.5");
		expectedResult.add("FIELD^9.5");
		expectedResult.add("FILE^2");
		expectedResult.add("File #2 does not contain a field 9.5.");
		expectedResult.add("[END_diERRORS]");

		request.setFile("2");
		request.setField("9.5");
		request.setIens("");
		request.setValue("REG");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
		assertEquals(expectedResult.get(4), response.getDataList().get(4));
		assertEquals(expectedResult.get(5), response.getDataList().get(5));
		assertEquals(expectedResult.get(6), response.getDataList().get(6));
		assertEquals(expectedResult.get(7), response.getDataList().get(7));
		assertEquals(expectedResult.get(8), response.getDataList().get(8));
		assertEquals(expectedResult.get(9), response.getDataList().get(9));
		assertEquals(expectedResult.get(10), response.getDataList().get(10));
	}

	/**
	 * <em>Use Case #4</em>
	 * 
	 * <pre>
	 * 	>S DDR("FILE")=2
	 * 	>S DDR("FIELD")=.08
	 * 	>S DDR("IENS")=""
	 * 	>S DDR("VALUE")="FRIENDS"
	 * 	>D VALC^DDR3(.DATA,.DDR)
	 * 			 
	 * >ZW DATA
	 * 	DATA(1)="[FILLER]"
	 * 	DATA(2)="[Data]"
	 * 	DATA(3)=17
	 * 	DATA(4)="FRIENDS"
	 * </pre>
	 */
	@Test
	public void testValC004() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("17");
		expectedResult.add("FRIENDS");

		request.setFile("2");
		request.setField(".08");
		request.setIens("");
		request.setValue("FRIENDS");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
	}

	/**
	 * <em>Use Case #5</em>
	 * 
	 * <pre>
	 * 	>S DDR("FILE")=2
	 * 	>S DDR("FIELD")=.01
	 * 	>S DDR("VALUE")="FRIENDS, JOHN"
	 * 	>S DDR("IENS")="43,"
	 *  >D VALC^DDR3(.DATA,.DDR)
	 * 			 
	 * 	>ZW DATA
	 * 	DATA(1)="[FILLER]"
	 * 	DATA(2)="[Data]"
	 * 	DATA(3)="FRIENDS, JOHN"
	 * 	DATA(4)="FRIENDS, JOHN"
	 * </pre>
	 */
	@Test
	public void testValC005() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("FRIENDS,JOHN");
		expectedResult.add("FRIENDS,JOHN");

		request.setFile("2");
		request.setField(".01");
		request.setValue("FRIENDS, JOHN");
		request.setIens("43,");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
	}

	/**
	 * <em>Use Case #6</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2
	 * >S DDR("FIELD")=.01
	 * >S DDR("IENS")="43,"
	 * >S DDR("VALUE")="FRIENDS"
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)="^"
	 * DATA(4)=""
	 * DATA(5)="[BEGIN_diERRORS]"
	 * DATA(6)="701^1^2^43,^.01^4"
	 * DATA(7)="3^FRIENDS"
	 * DATA(8)="FIELD^.01"
	 * DATA(9)="FILE^2"
	 * DATA(10)="IENS^43,"
	 * DATA(11)="The value 'FRIENDS' for field NAME in file PATIENT is not valid."
	 * DATA(12)="[END_diERRORS]"
	 * DATA(13)="[BEGIN_diHELP]"
	 * DATA(14)="2^.01^?^3"
	 * DATA(15)="Answer with PATIENT NAME, or SOCIAL SECURITY NUMBER, or WARD LOCATION,
	 *  or ROOM-BED, or LODGER WARD LOCATION, or CV DATE EDITED, or CURRENT PH INDICATO
	 * R, or CURRENT PURPLE HEART STATUS."
	 * DATA(16)=""
	 * DATA(17)="Enter name in 'LAST,FIRST MIDDLE SUFFIX' format, must be 3-30 characte
	 * rs in length."
	 * DATA(18)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testValC006() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("^");
		expectedResult.add("");
		expectedResult.add("[BEGIN_diERRORS]");
		expectedResult.add("701^1^2^43,^.01^4");
		expectedResult.add("3^FRIENDS");
		expectedResult.add("FIELD^.01");
		expectedResult.add("FILE^2");
		expectedResult.add("IENS^43,");
		expectedResult
				.add("The value 'FRIENDS' for field NAME in file PATIENT is not valid.");
		expectedResult.add("[END_diERRORS]");
		expectedResult.add("[BEGIN_diHELP]");
		expectedResult.add("2^.01^?^3");
		expectedResult
				.add("Answer with PATIENT NAME, or SEX, or SOCIAL SECURITY NUMBER, or WARD LOCATION, or ROOM-BED, or LODGER WARD LOCATION, or CV DATE EDITED, or CURRENT PH INDICATOR.");
		expectedResult.add("");
		expectedResult
				.add("Enter name in 'LAST,FIRST MIDDLE SUFFIX' format, must be 3-30 characters in length.");
		expectedResult.add("[END_diHELP]");

		request.setFile("2");
		request.setField(".01");
		request.setIens("43,");
		request.setValue("FRIENDS");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
		assertEquals(expectedResult.get(4), response.getDataList().get(4));
		assertEquals(expectedResult.get(5), response.getDataList().get(5));
		assertEquals(expectedResult.get(6), response.getDataList().get(6));
		assertEquals(expectedResult.get(7), response.getDataList().get(7));
		assertEquals(expectedResult.get(8), response.getDataList().get(8));
		assertEquals(expectedResult.get(9), response.getDataList().get(9));
		assertEquals(expectedResult.get(10), response.getDataList().get(10));
		assertEquals(expectedResult.get(11), response.getDataList().get(11));
		assertEquals(expectedResult.get(12), response.getDataList().get(12));
		assertEquals(expectedResult.get(13), response.getDataList().get(13));
		assertEquals(expectedResult.get(14), response.getDataList().get(14));
		assertEquals(expectedResult.get(15), response.getDataList().get(15));
		assertEquals(expectedResult.get(16), response.getDataList().get(16));
		assertEquals(expectedResult.get(17), response.getDataList().get(17));
	}

	/**
	 * <em>Use Case #7</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2
	 * >S DDR("FIELD")=.01
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")="FRIENDS"
	 *  
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)="^"
	 * DATA(4)=""
	 * DATA(5)="[BEGIN_diERRORS]"
	 * DATA(6)="701^1^2^^.01^3"
	 * DATA(7)="3^FRIENDS"
	 * DATA(8)="FIELD^.01"
	 * DATA(9)="FILE^2"
	 * DATA(10)="The value 'FRIENDS' for field NAME in file PATIENT is not valid."
	 * DATA(11)="[END_diERRORS]"
	 * DATA(12)="[BEGIN_diHELP]"
	 * DATA(13)="2^.01^?^3"
	 * DATA(14)="Answer with PATIENT NAME, or SOCIAL SECURITY NUMBER, or WARD LOCATION,
	 *  or ROOM-BED, or LODGER WARD LOCATION, or CV DATE EDITED, or CURRENT PH INDICATO
	 * R, or CURRENT PURPLE HEART STATUS."
	 * DATA(15)=""
	 * DATA(16)="Enter name in 'LAST,FIRST MIDDLE SUFFIX' format, must be 3-30 characte
	 * rs in length."
	 * DATA(17)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testValC007() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("^");
		expectedResult.add("");
		expectedResult.add("[BEGIN_diERRORS]");
		expectedResult.add("701^1^2^^.01^3");
		expectedResult.add("3^FRIENDS");
		expectedResult.add("FIELD^.01");
		expectedResult.add("FILE^2");
		expectedResult
				.add("The value 'FRIENDS' for field NAME in file PATIENT is not valid.");
		expectedResult.add("[END_diERRORS]");
		expectedResult.add("[BEGIN_diHELP]");
		expectedResult.add("2^.01^?^3");
		expectedResult
				.add("Answer with PATIENT NAME, or SEX, or SOCIAL SECURITY NUMBER, or WARD LOCATION, or ROOM-BED, or LODGER WARD LOCATION, or CV DATE EDITED, or CURRENT PH INDICATOR.");
		expectedResult.add("");
		expectedResult
				.add("Enter name in 'LAST,FIRST MIDDLE SUFFIX' format, must be 3-30 characters in length.");
		expectedResult.add("[END_diHELP]");

		request.setFile("2");
		request.setField(".01");
		request.setIens("");
		request.setValue("FRIENDS");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
		assertEquals(expectedResult.get(4), response.getDataList().get(4));
		assertEquals(expectedResult.get(5), response.getDataList().get(5));
		assertEquals(expectedResult.get(6), response.getDataList().get(6));
		assertEquals(expectedResult.get(7), response.getDataList().get(7));
		assertEquals(expectedResult.get(8), response.getDataList().get(8));
		assertEquals(expectedResult.get(9), response.getDataList().get(9));
		assertEquals(expectedResult.get(10), response.getDataList().get(10));
		assertEquals(expectedResult.get(11), response.getDataList().get(11));
		assertEquals(expectedResult.get(12), response.getDataList().get(12));
		assertEquals(expectedResult.get(13), response.getDataList().get(13));
		assertEquals(expectedResult.get(14), response.getDataList().get(14));
		assertEquals(expectedResult.get(15), response.getDataList().get(15));
		assertEquals(expectedResult.get(16), response.getDataList().get(16));
	}

	/**
	 * <em>Use Case #8</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2
	 * >S DDR("FIELD")=".08"
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")="6"
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)=6
	 * DATA(4)="PRESBYTERIAN"
	 * </pre>
	 */
	@Test
	public void testValC008() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("6");
		expectedResult.add("PRESBYTERIAN");

		request.setFile("2");
		request.setField(".08");
		request.setIens("");
		request.setValue("6");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
	}

	/**
	 * <em>Use Case #9</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2
	 * >S DDR("FIELD")=".08"
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")="6"
	 *  
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)="^"
	 * DATA(4)=""
	 * DATA(5)="[BEGIN_diERRORS]"
	 * DATA(6)="701^1^2^56,^.05^4"
	 * DATA(7)="3^6"
	 * DATA(8)="FIELD^.05"
	 * DATA(9)="FILE^2"
	 * DATA(10)="IENS^56,"
	 * DATA(11)="The value '6' for field MARITAL STATUS in file PATIENT is not valid."
	 * DATA(12)="[END_diERRORS]"
	 * DATA(13)="[BEGIN_diHELP]"
	 * DATA(14)="2^.05^?^5"
	 * DATA(15)="Select from the available listing this patients current marital status."
	 * DATA(16)=" "
	 * DATA(17)="Answer with MARITAL STATUS NAME, or ABBREVIATION."
	 * DATA(18)=""
	 * DATA(19)="ANSWER MUST BE 2-15 CHARACTERS IN LENGTH"
	 * DATA(20)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testValC009() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("^");
		expectedResult.add("");
		expectedResult.add("[BEGIN_diERRORS]");
		expectedResult.add("701^1^2^^.05^3");
		expectedResult.add("3^6");
		expectedResult.add("FIELD^.05");
		expectedResult.add("FILE^2");
		expectedResult
				.add("The value '6' for field MARITAL STATUS in file PATIENT is not valid.");
		expectedResult.add("[END_diERRORS]");
		expectedResult.add("[BEGIN_diHELP]");
		expectedResult.add("2^.05^?^5");
		expectedResult
				.add("Select from the available listing this patients current marital status.");
		expectedResult.add(" ");
		expectedResult.add("Answer with MARITAL STATUS NAME, or ABBREVIATION.");
		expectedResult.add("");
		expectedResult.add("ANSWER MUST BE 2-15 CHARACTERS IN LENGTH");
		expectedResult.add("[END_diHELP]");
	
		request.setFile("2");
		request.setField(".05");
		request.setIens("");
		request.setValue("6");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
		assertEquals(expectedResult.get(4), response.getDataList().get(4));
		assertEquals(expectedResult.get(5), response.getDataList().get(5));
		assertEquals(expectedResult.get(6), response.getDataList().get(6));
		assertEquals(expectedResult.get(7), response.getDataList().get(7));
		assertEquals(expectedResult.get(8), response.getDataList().get(8));
		assertEquals(expectedResult.get(9), response.getDataList().get(9));
		assertEquals(expectedResult.get(10), response.getDataList().get(10));
		assertEquals(expectedResult.get(11), response.getDataList().get(11));
		assertEquals(expectedResult.get(12), response.getDataList().get(12));
		assertEquals(expectedResult.get(13), response.getDataList().get(13));
		assertEquals(expectedResult.get(14), response.getDataList().get(14));
		assertEquals(expectedResult.get(15), response.getDataList().get(15));
		assertEquals(expectedResult.get(16), response.getDataList().get(16));
		assertEquals(expectedResult.get(17), response.getDataList().get(17));
		assertEquals(expectedResult.get(18), response.getDataList().get(18));
	}

	/**
	 * <em>Use Case #10</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2
	 * >S DDR("FIELD")=".05"
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")="S"
	 *  
	 * >D VALC^DDR3(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)=5
	 * DATA(4)="SEPARATED"
	 * </pre>
	 */
	@Test
	public void testValC010() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("5");
		expectedResult.add("SEPARATED");

		request.setFile("2");
		request.setField(".05");
		request.setIens("");
		request.setValue("S");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
	}

	/**
	 * <em>Use Case #11</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2
	 * >S DDR("IENS")=""
	 * >S DDR("FIELD")=".05"  
	 * >S DDR("VALUE")="WIDOWED"
	 * 
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)=4
	 * DATA(4)="WIDOWED"
	 * </pre>
	 */
	@Test
	public void testValC011() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("4");
		expectedResult.add("WIDOWED");

		request.setFile("2");
		request.setField(".05");
		request.setIens("");
		request.setValue("WIDOWED");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
	}

	/**
	 * <em>Use Case #12</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2
	 * >S DDR("FIELD")=".08"
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")=13
	 *  
	 * >S DDR("FIELD")=".08"
	 *  
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)=13
	 * DATA(4)="CHURCH OF CHRIST"
	 * </pre>
	 */
	@Test
	public void testValC012() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("13");
		expectedResult.add("CHURCH OF CHRIST");

		request.setFile("2");
		request.setField(".08");
		request.setIens("");
		request.setValue("13");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
	}

	/**
	 * <em>Use Case #13</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2
	 * >S DDR("FIELD")=".05"
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")=988
	 *  
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)="^"
	 * DATA(4)=""
	 * DATA(5)="[BEGIN_diERRORS]"
	 * DATA(6)="701^1^2^^.08^3"
	 * DATA(7)="3^988"
	 * DATA(8)="FIELD^.08"
	 * DATA(9)="FILE^2"
	 * DATA(10)="The value '988' for field RELIGIOUS PREFERENCE in file PATIENT is not valid."
	 * DATA(11)="[END_diERRORS]"
	 * DATA(12)="[BEGIN_diHELP]"
	 * DATA(13)="2^.08^?^5"
	 * DATA(14)="Select from the available list this patients religious preference."
	 * DATA(15)=" "
	 * DATA(16)="Answer with RELIGION NAME, or CODE."
	 * DATA(17)=""
	 * DATA(18)="ANSWER MUST BE 3-30 CHARACTERS IN LENGTH"
	 * DATA(19)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testValC013() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("^");
		expectedResult.add("");
		expectedResult.add("[BEGIN_diERRORS]");
		expectedResult.add("701^1^2^^.05^3");
		expectedResult.add("3^988");
		expectedResult.add("FIELD^.05");
		expectedResult.add("FILE^2");
		expectedResult
				.add("The value '988' for field MARITAL STATUS in file PATIENT is not valid.");
		expectedResult.add("[END_diERRORS]");
		expectedResult.add("[BEGIN_diHELP]");
		expectedResult.add("2^.05^?^5");
		expectedResult
				.add("Select from the available listing this patients current marital status.");
		expectedResult.add(" ");
		expectedResult.add("Answer with MARITAL STATUS NAME, or ABBREVIATION.");
		expectedResult.add("");
		expectedResult.add("ANSWER MUST BE 2-15 CHARACTERS IN LENGTH");
		expectedResult.add("[END_diHELP]");

		request.setFile("2");
		request.setField(".05");
		request.setIens("");
		request.setValue("988");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
		assertEquals(expectedResult.get(4), response.getDataList().get(4));
		assertEquals(expectedResult.get(5), response.getDataList().get(5));
		assertEquals(expectedResult.get(6), response.getDataList().get(6));
		assertEquals(expectedResult.get(7), response.getDataList().get(7));
		assertEquals(expectedResult.get(8), response.getDataList().get(8));
		assertEquals(expectedResult.get(9), response.getDataList().get(9));
		assertEquals(expectedResult.get(10), response.getDataList().get(10));
		assertEquals(expectedResult.get(11), response.getDataList().get(11));
		assertEquals(expectedResult.get(12), response.getDataList().get(12));
		assertEquals(expectedResult.get(13), response.getDataList().get(13));
		assertEquals(expectedResult.get(14), response.getDataList().get(14));
		assertEquals(expectedResult.get(15), response.getDataList().get(15));
		assertEquals(expectedResult.get(16), response.getDataList().get(16));
		assertEquals(expectedResult.get(17), response.getDataList().get(17));
		assertEquals(expectedResult.get(18), response.getDataList().get(18));
	}

	/**
	 * <em>Use Case #14</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2.98
	 * >S DDR("FIELD")="9.5"
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")="REG"
	 *  
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)=9
	 * DATA(4)="REGULAR"
	 * </pre>
	 */
	@Test
	public void testValC014() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("9");
		expectedResult.add("REGULAR");

		request.setFile("2.98");
		request.setField("9.5");
		request.setValue("REG");
		request.setIens("");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
	}

	/**
	 * <em>Use Case #15</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2
	 * >S DDR("FIELD")=".02"
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")="REG"
	 *  
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)="^"
	 * DATA(4)=""
	 * DATA(5)="[BEGIN_diERRORS]"
	 * DATA(6)="701^1^2^^.02^3"
	 * DATA(7)="3^REG"
	 * DATA(8)="FIELD^.02"
	 * DATA(9)="FILE^2"
	 * DATA(10)="The value 'REG' for field SEX in file PATIENT is not valid."
	 * DATA(11)="[END_diERRORS]"
	 * DATA(12)="[BEGIN_diHELP]"
	 * DATA(13)="2^.02^?^5"
	 * DATA(14)="Enter 'M' for MALE, or 'F' for FEMALE."
	 * DATA(15)=" "
	 * DATA(16)="Choose from:"
	 * DATA(17)="M        MALE"
	 * DATA(18)="F        FEMALE"
	 * DATA(19)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testValC015() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("^");
		expectedResult.add("");
		expectedResult.add("[BEGIN_diERRORS]");
		expectedResult.add("701^1^2^^.02^3");
		expectedResult.add("3^REG");
		expectedResult.add("FIELD^.02");
		expectedResult.add("FILE^2");
		expectedResult
				.add("The value 'REG' for field SEX in file PATIENT is not valid.");
		expectedResult.add("[END_diERRORS]");
		expectedResult.add("[BEGIN_diHELP]");
		expectedResult.add("2^.02^?^5");
		expectedResult.add("Enter 'M' for MALE, or 'F' for FEMALE.");
		expectedResult.add(" ");
		expectedResult.add("Choose from:");
		expectedResult.add("M        MALE");
		expectedResult.add("F        FEMALE");
		expectedResult.add("[END_diHELP]");

		request.setFile("2");
		request.setField(".02");
		request.setIens("");
		request.setValue("REG");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
		assertEquals(expectedResult.get(4), response.getDataList().get(4));
		assertEquals(expectedResult.get(5), response.getDataList().get(5));
		assertEquals(expectedResult.get(6), response.getDataList().get(6));
		assertEquals(expectedResult.get(7), response.getDataList().get(7));
		assertEquals(expectedResult.get(8), response.getDataList().get(8));
		assertEquals(expectedResult.get(9), response.getDataList().get(9));
		assertEquals(expectedResult.get(10), response.getDataList().get(10));
		assertEquals(expectedResult.get(11), response.getDataList().get(11));
		assertEquals(expectedResult.get(12), response.getDataList().get(12));
		assertEquals(expectedResult.get(13), response.getDataList().get(13));
		assertEquals(expectedResult.get(14), response.getDataList().get(14));
		assertEquals(expectedResult.get(15), response.getDataList().get(15));
		assertEquals(expectedResult.get(16), response.getDataList().get(16));
		assertEquals(expectedResult.get(17), response.getDataList().get(17));
		assertEquals(expectedResult.get(18), response.getDataList().get(18));
	}

	/**
	 * <em>Use Case #16</em>
	 * 
	 * >S DDR("FILE")=2 >S DDR("FIELD")=.033 >S DDR("IENS")="" >S
	 * DDR("VALUE")=43
	 * 
	 * >D VALC^DDR3(.DATA,.DDR)
	 * 
	 * >ZW DATA DATA(1)="[FILLER]" DATA(2)="[Data]" DATA(3)="^" DATA(4)=""
	 * DATA(5)="[BEGIN_diERRORS]" DATA(6)="520^1^2^^.033^2" DATA(7)="FIELD^.033"
	 * DATA(8)="FILE^2"
	 * DATA(9)="A computed field cannot be processed by this utility."
	 * DATA(10)="[END_diERRORS]" </pre>
	 */
	@Test
	public void testValC016() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("^");
		expectedResult.add("");
		expectedResult.add("[BEGIN_diERRORS]");
		expectedResult.add("520^1^2^^.033^2");
		expectedResult.add("FIELD^.033");
		expectedResult.add("FILE^2");
		expectedResult
				.add("A computed field cannot be processed by this utility.");
		expectedResult.add("[END_diERRORS]");

		request.setFile("2");
		request.setField(".033");
		request.setIens("");
		request.setValue("43");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
		assertEquals(expectedResult.get(4), response.getDataList().get(4));
		assertEquals(expectedResult.get(5), response.getDataList().get(5));
		assertEquals(expectedResult.get(6), response.getDataList().get(6));
		assertEquals(expectedResult.get(7), response.getDataList().get(7));
		assertEquals(expectedResult.get(8), response.getDataList().get(8));
	}

	/**
	 * <em>Use Case #17</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2
	 * >S DDR("FIELD")=.03
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")="@"
	 * 
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)="^"
	 * DATA(4)=""
	 * DATA(5)="[BEGIN_diERRORS]"
	 * DATA(6)="712^1^2^^.03^2"
	 * DATA(7)="FIELD^.03"
	 * DATA(8)="FILE^2"
	 * DATA(9)="The value of field DATE OF BIRTH in file PATIENT cannot be deleted."
	 * DATA(10)="[END_diERRORS]"
	 * </pre>
	 */
	@Test
	public void testValC017() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("^");
		expectedResult.add("");
		expectedResult.add("[BEGIN_diERRORS]");
		expectedResult.add("712^1^2^^.03^2");
		expectedResult.add("FIELD^.03");
		expectedResult.add("FILE^2");
		expectedResult
				.add("The value of field DATE OF BIRTH in file PATIENT cannot be deleted.");
		expectedResult.add("[END_diERRORS]");

		request.setFile("2");
		request.setField(".03");
		request.setIens("");
		request.setValue("@");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
		assertEquals(expectedResult.get(4), response.getDataList().get(4));
		assertEquals(expectedResult.get(5), response.getDataList().get(5));
		assertEquals(expectedResult.get(6), response.getDataList().get(6));
		assertEquals(expectedResult.get(7), response.getDataList().get(7));
		assertEquals(expectedResult.get(8), response.getDataList().get(8));
		assertEquals(expectedResult.get(9), response.getDataList().get(9));
	}

	/**
	 * <em>Use Case #18</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=2
	 * >S DDR("FIELD")=.09
	 * >S DDR("IENS")="43"
	 * >S DDR("VALUE")="111111111"
	 * 
	 * >D VALC^DDR3(.DATA,.DDR)
	 * 
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)=111111111
	 * DATA(4)=111111111
	 * </pre>
	 */
	@Test
	public void testValC018() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("111111111");
		expectedResult.add("111111111");

		request.setFile("2");
		request.setField(".09");
		request.setIens("43");
		request.setValue("111111111");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
	}

	/**
	 * <em>Use Case #19</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=24385739
	 * >S DDR("FIELD")=.09
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")="111111111"
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)="^"
	 * DATA(4)=""
	 * DATA(5)="[BEGIN_diERRORS]"
	 * DATA(6)="401^1^24385739^^^1"
	 * DATA(7)="FILE^24385739"
	 * DATA(8)="File #24385739 does not exist."
	 * DATA(9)="[END_diERRORS]"
	 * </pre>
	 */
	@Test
	public void testValC019() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("^");
		expectedResult.add("");
		expectedResult.add("[BEGIN_diERRORS]");
		expectedResult.add("401^1^24385739^^^1");
		expectedResult.add("FILE^24385739");
		expectedResult.add("File #24385739 does not exist.");
		expectedResult.add("[END_diERRORS]");

		request.setFile("24385739");
		request.setField(".09");
		request.setIens("");
		request.setValue("111111111");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
		assertEquals(expectedResult.get(4), response.getDataList().get(4));
		assertEquals(expectedResult.get(5), response.getDataList().get(5));
		assertEquals(expectedResult.get(6), response.getDataList().get(6));
		assertEquals(expectedResult.get(7), response.getDataList().get(7));
		assertEquals(expectedResult.get(8), response.getDataList().get(8));
	}

	/**
	 * <em>Use Case #20</em>
	 * 
	 * <pre>
	 * >S DDR("FILE")=24
	 * >S DDR("FIELD")=.09
	 * >S DDR("IENS")=""
	 * >S DDR("VALUE")=111111111
	 * 
	 *  
	 * >D VALC^DDR3(.DATA,.DDR)
	 *  
	 * >ZW DATA
	 * DATA(1)="[FILLER]"
	 * DATA(2)="[Data]"
	 * DATA(3)="^"
	 * DATA(4)=""
	 * DATA(5)="[BEGIN_diERRORS]"
	 * DATA(6)="501^1^24^^.09^3"
	 * DATA(7)="1^.09"
	 * DATA(8)="FIELD^.09"
	 * DATA(9)="FILE^24"
	 * DATA(10)="File #24 does not contain a field .09."
	 * DATA(11)="[END_diERRORS]"
	 * </pre>
	 */
	@Test
	public void testValC020() throws VistaWebServiceFault  {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("[FILLER]");
		expectedResult.add("[Data]");
		expectedResult.add("^");
		expectedResult.add("");
		expectedResult.add("[BEGIN_diERRORS]");
		expectedResult.add("501^1^24^^.09^3");
		expectedResult.add("1^.09");
		expectedResult.add("FIELD^.09");
		expectedResult.add("FILE^24");
		expectedResult.add("File #24 does not contain a field .09.");
		expectedResult.add("[END_diERRORS]");

		request.setFile("24");
		request.setField(".09");
		request.setIens("");
		request.setValue("111111111");

		// Execute request against mocked object backend.
		response = service.valC(request);

		assertNotNull(response);
		assertEquals(expectedResult.get(0), response.getDataList().get(0));
		assertEquals(expectedResult.get(1), response.getDataList().get(1));
		assertEquals(expectedResult.get(2), response.getDataList().get(2));
		assertEquals(expectedResult.get(3), response.getDataList().get(3));
		assertEquals(expectedResult.get(4), response.getDataList().get(4));
		assertEquals(expectedResult.get(5), response.getDataList().get(5));
		assertEquals(expectedResult.get(6), response.getDataList().get(6));
		assertEquals(expectedResult.get(7), response.getDataList().get(7));
		assertEquals(expectedResult.get(8), response.getDataList().get(8));
		assertEquals(expectedResult.get(9), response.getDataList().get(9));
		assertEquals(expectedResult.get(10), response.getDataList().get(10));
	}

}

package gov.va.oit.vistaevolution.fileman.ws.die.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.DIEHelpEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEHelpRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEHelpResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class DIEHelpIT extends EvolutionIT<DIEHelpEndpoint> {

	@Override
	protected Class<DIEHelpEndpoint> getType() {
		// TODO Auto-generated method stub
		return DIEHelpEndpoint.class;
	}

	private DIEHelpRequest dieHelpRequest;
	private DIEHelpResponse dieHelpResponse;

	@Before
	public void setUp() {
		dieHelpRequest = new DIEHelpRequest();
	}

	@After
	public void tearDown() {
		dieHelpRequest = null;
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * <pre>
	 *	>S FILE=2,FIELD=.02,FLAG="Z",IENS=""
	 *			
	 *	>D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT")
	 *	
	 *	API Results:		 
	 *	>ZW RESULT
	 *	RESULT("DIERR")="1^1"
	 *	RESULT("DIERR",1)=301
	 *	RESULT("DIERR",1,"PARAM",0)=1
	 *	RESULT("DIERR",1,"PARAM",1)="Z"
	 *	RESULT("DIERR",1,"TEXT",1)="The passed flag(s) 'Z' are unknown or inconsistent."
	 *	RESULT("DIERR","E",301,1)=""
	 *
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.02,DDR("FLAGS")="Z"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *                                        
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testHelp001() throws VistaWebServiceFault {

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("[END_diHELP]");

		dieHelpRequest.setFile("2");
		dieHelpRequest.setField(".02");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("Z");
		dieHelpRequest.setFlags(flags);

		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * <pre>
	 * >S FILE=2,FIELD=.21,FLAG="?",IENS=""
 	 * 
	 * >D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT")
 	 * 
	 * >ZW RESULT
	 * RESULT("DIERR")="1^1"
	 * RESULT("DIERR",1)=501
	 * RESULT("DIERR",1,"PARAM",0)=3
	 * RESULT("DIERR",1,"PARAM",1)=.21
	 * RESULT("DIERR",1,"PARAM","FIELD")=.21
	 * RESULT("DIERR",1,"PARAM","FILE")=2
	 * RESULT("DIERR",1,"TEXT",1)="File #2 does not contain a field .21."
	 * RESULT("DIERR","E",501,1)=""
	 *
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.21,DDR("FLAGS")="?"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *                                        
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="[END_diHELP]"
	 *			 
	 * </pre>
	 */
	@Test
	public void testHelp002() throws VistaWebServiceFault {

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("[END_diHELP]");

		dieHelpRequest.setFile("2");
		dieHelpRequest.setField(".21");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("?");
		dieHelpRequest.setFlags(flags);

		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
	}

	/**
	 * <pre>
	 *			 
	 *	>S FILE=2,FIELD=.01,FLAG="?",IENS=""
 	 *	
	 *	>D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT")
 	 *	
	 *	>ZW RESULT
	 *	RESULT("DIHELP")=3
	 *	RESULT("DIHELP",1)="Answer with PATIENT NAME, or SOCIAL SECURITY NUMBER, or WARD
 	 *	LOCATION, or ROOM-BED, or LODGER WARD LOCATION, or CV DATE EDITED, or CURRENT P
	 *	H INDICATOR, or CURRENT PURPLE HEART STATUS."
	 *	RESULT("DIHELP",2)=""
	 *	RESULT("DIHELP",3)="Enter name in 'LAST,FIRST MIDDLE SUFFIX' format, must be 3-30 characters in length."
	 *
	 *	RPC Results:
	 *		>S DDR("FILE")=.84,DDR("FIELD")=.01,DDR("FLAGS")="?"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *                                        
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)=".84^.01^?^3"
	 *		RESULT(3)="Answer with DIALOG DIALOG NUMBER, or PACKAGE, or SHORT DESCRIPTION."
	 *		RESULT(4)=""
	 *		RESULT(5)="Type a Number between 10000.001 and 9999999999.999, up to 3 Decimal Digits"
	 *		RESULT(6)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testHelp003() throws VistaWebServiceFault {

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add(".84^.01^?^3");
		results.add("Answer with DIALOG DIALOG NUMBER, or PACKAGE, or SHORT DESCRIPTION.");
		results.add("");
		results.add("Type a Number between 10000.001 and 9999999999.999, up to 3 Decimal Digits");
		results.add("[END_diHELP]");
		
		dieHelpRequest.setFile(".84");
		dieHelpRequest.setField(".01");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("?");
		dieHelpRequest.setFlags(flags);

		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
		assertEquals(results.get(4), dieHelpResponse.getDataList().get(4));
		assertEquals(results.get(5), dieHelpResponse.getDataList().get(5));
	}
	
	/**
	 * <em>Test Case #4</em>
	 * 
	 * <pre>
	 *
	 * >S DDR("FILE")=.84,DDR("FIELD")=.01,DDR("FLAGS")="??"
	 * >D GETHLPC^DDR2(.RESULT,.DDR)
	 *
	 *	RPC Results:
	 *
	 * >S DDR("FILE")=.84,DDR("FIELD")=.01,DDR("FLAGS")="??"
	 * >D GETHLPC^DDR2(.RESULT,.DDR)
	 * 
	 *  Successful result
	 *  >ZW RESULT
	 *  RESULT(1)="[BEGIN_diHELP]"
	 *  RESULT(2)=".84^.01^?^3"
	 *  RESULT(3)="Answer with DIALOG DIALOG NUMBER, or PACKAGE, or SHORT DESCRIPTION."
	 *  RESULT(4)=""
	 *  RESULT(5)="The dialogue number is used to uniquely identify a message."
	 *  RESULT(6)="[END_diHELP]"
	 *  
	 * </pre>
	 */
	@Test
	public void testHelp004() throws VistaWebServiceFault {
		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add(".84^.01^?^3");
		results.add("Answer with DIALOG DIALOG NUMBER, or PACKAGE, or SHORT DESCRIPTION.");
		results.add("");
		results.add("The dialogue number is used to uniquely identify a message.");
		results.add("[END_diHELP]");
		
		dieHelpRequest.setFile(".84");
		dieHelpRequest.setField(".01");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("?");
		flags.add("?");
		dieHelpRequest.setFlags(flags);

		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
		assertEquals(results.get(4), dieHelpResponse.getDataList().get(4));
		assertEquals(results.get(5), dieHelpResponse.getDataList().get(5));
	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * <pre>
	 *			 
 	 *	>S DDR("FILE")=.84,DDR("FIELD")=.01,DDR("FLAGS")="A"
 	 *	>D GETHLPC^DDR2(.RESULT,.DDR)
 	 *
 	 *	Successful result
 	 *	>ZW RESULT
 	 *	RESULT(1)="[BEGIN_diHELP]"
 	 *	RESULT(2)=".84^.01^?^5"
 	 *	RESULT(3)="Answer with DIALOG DIALOG NUMBER, or PACKAGE, or SHORT DESCRIPTION."
 	 *	RESULT(4)=""
 	 *	RESULT(5)="Type a Number between 10000.001 and 9999999999.999, up to 3 Decimal Digits"
 	 *	RESULT(6)=""
 	 *	RESULT(7)="The dialogue number is used to uniquely identify a message."
 	 *	RESULT(8)="[END_diHELP]"
 	 *
	 * </pre>
	 */
	@Test
	public void testHelp005() throws VistaWebServiceFault {
		dieHelpRequest.setFile(".84");
		dieHelpRequest.setField(".01");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add(".84^.01^?^5");
		results.add("Answer with DIALOG DIALOG NUMBER, or PACKAGE, or SHORT DESCRIPTION.");
		results.add("");
		results.add("Type a Number between 10000.001 and 9999999999.999, up to 3 Decimal Digits");
		results.add("");
		results.add("The dialogue number is used to uniquely identify a message.");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
		assertEquals(results.get(4), dieHelpResponse.getDataList().get(4));
		assertEquals(results.get(5), dieHelpResponse.getDataList().get(5));
		assertEquals(results.get(6), dieHelpResponse.getDataList().get(6));
		assertEquals(results.get(7), dieHelpResponse.getDataList().get(7));
	}

	/**
	 * <em>Test Case #6</em>
	 *			 
	 * <pre>
	 * 
	 * >S FILE=8984.1,FIELD=.02,FLAG="B",IENS="" 
	 * >D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT") 
	 * >ZW RESULT
	 * RESULT("DIHELP")=1
	 * RESULT("DIHELP",1)="To see the entries in any particular file, type <Prefix.?>."
	 * 
	 *	RPC Results:
	 *		>S DDR("FILE")=8984.1,DDR("FIELD")=.02,DDR("FLAGS")="B"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *                                             
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="8984.1^.02^?^1"
	 *		RESULT(3)="To see the entries in any particular file, type <Prefix.?>."
	 *		RESULT(4)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testHelp006() throws VistaWebServiceFault {
		dieHelpRequest.setFile("8984.1");
		dieHelpRequest.setField(".02");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("B");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("8984.1^.02^?^1");
		results.add("To see the entries in any particular file, type <Prefix.?>.");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
	}
	
	/**
	 * <em>Test Case #7</em>
	 * 
	 * <pre>
	 *			 
	 *	>S FILE=1.1,FIELD=.02,FLAG="b",IENS="" 
	 *	
	 *	RPC Results:
	 *		>S DDR("FILE")=1.1,DDR("FIELD")=.02,DDR("FLAGS")="b"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *                                          
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testHelp007() throws VistaWebServiceFault {

		dieHelpRequest.setFile("1.1");
		dieHelpRequest.setField(".02");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("b");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
	}

	/**
	 * <em>Test Case #8</em>
	 * 
	 * <pre>
	 *			 
	 *	>S FILE=52.91,FIELD=3,FLAG="C",IENS="" 
	 *	>D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT") 
	 *	>ZW RESULT
	 *	RESULT("DIHELP")=1
	 *	RESULT("DIHELP",1)="Only these codes are allowed for manual entry."
	 *	
	 *	RPC Results:
	 *		>S DDR("FILE")=52.91,DDR("FIELD")=3,DDR("FLAGS")="C"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *                                          
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="52.91^3^?^1"
	 *		RESULT(3)="Only these codes are allowed for manual entry."
	 *		RESULT(4)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testHelp008() throws VistaWebServiceFault {
		dieHelpRequest.setFile("52.91");
		dieHelpRequest.setField("3");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("C");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("52.91^3^?^1");
		results.add("Only these codes are allowed for manual entry.");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
	}

	/**
	 * <em>Test Case #9</em>
	 * 
	 * <pre>
	 *			 
	 *	>S FILE=2,FIELD=.01,FLAG="D",IENS=""
 	 *	
	 *	>D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT")
 	 *	
	 *	>ZW RESULT
	 *	RESULT("DIHELP")=4
	 *	RESULT("DIHELP",1)="Enter the patient's name in 'LAST,FIRST MIDDLE SUFFIX' format."
	 *	RESULT("DIHELP",2)="This value must be 3-30 characters in length and may contain only uppercase"
	 *	RESULT("DIHELP",3)="alpha characters, spaces, apostrophes, hyphens and one comma.  All other"
	 *	RESULT("DIHELP",4)="characters and parenthetical text will be removed."
	 *	
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.01,DDR("FLAGS")="D"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *                                        
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="2^.01^?^4"
	 *		RESULT(3)="Enter the patient's name in 'LAST,FIRST MIDDLE SUFFIX' format."
	 *		RESULT(4)="This value must be 3-30 characters in length and may contain only upp
	 *			ercase"
	 *		RESULT(5)="alpha characters, spaces, apostrophes, hyphens and one comma.  All ot
	 *			her"
	 *		RESULT(6)="characters and parenthetical text will be removed."
	 *		RESULT(7)="[END_diHELP]"
	 *
	 * </pre>
	 */
	@Test
	public void testHelp009() throws VistaWebServiceFault {
		dieHelpRequest.setFile("2");
		dieHelpRequest.setField(".01");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("D");
		dieHelpRequest.setFlags(flags);


		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("2^.01^?^4");
		results.add("Enter the patient's name in 'LAST,FIRST MIDDLE SUFFIX' format.");
		results.add("This value must be 3-30 characters in length and may contain only uppercase");
		results.add("alpha characters, spaces, apostrophes, hyphens and one comma.  All other");
		results.add("characters and parenthetical text will be removed.");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
		assertEquals(results.get(4), dieHelpResponse.getDataList().get(4));
		assertEquals(results.get(5), dieHelpResponse.getDataList().get(5));
		assertEquals(results.get(6), dieHelpResponse.getDataList().get(6));
	}

	/**
	 * <em>Test Case #10</em>
	 * 
	 * <pre>
	 *
	 *	>S DDR("FILE")=.84,DDR("FIELD")=.01,DDR("FLAGS")="F"
	 *	>D GETHLPC^DDR2(.RESULT,.DDR)
	 *
	 * Successful result
	 * >ZW RESULT
	 * RESULT(1)="[BEGIN_diHELP]"
	 * RESULT(2)=".84^.01^?^1"
	 * RESULT(3)="Answer with DIALOG DIALOG NUMBER, or PACKAGE, or SHORT DESCRIPTION."
	 * RESULT(4)="[END_diHELP]"
	 * 	
	 * </pre>
	 */
	@Test
	public void testHelp010() throws VistaWebServiceFault {
		dieHelpRequest.setFile(".84");
		dieHelpRequest.setField(".01");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("F");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add(".84^.01^?^1");
		results.add("Answer with DIALOG DIALOG NUMBER, or PACKAGE, or SHORT DESCRIPTION.");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
	}

	/**
	 * <em>Test Case #11</em>
	 * 
	 * <pre>
	 *	>S DDR("FILE")=.84,DDR("FIELD")=1.2,DDR("FLAGS")="GH"
	 *	>D GETHLPC^DDR2(.RESULT,.DDR)
	 *
	 *	>ZW RESULT
	 *	RESULT(1)="[BEGIN_diHELP]"
	 *	RESULT(2)=".84^1.2^?^3"
	 *	RESULT(3)="Enter the name of the Package that owns and distributes this entry."
	 *	RESULT(4)=""
	 *	RESULT(5)="Please enter the name of this PACKAGE (4-30 characters)."
	 *	RESULT(6)="[END_diHELP]"
	 *
	 * </pre>
	 */
	@Test
	public void testHelp011() throws VistaWebServiceFault {
		dieHelpRequest.setFile(".84");
		dieHelpRequest.setField("1.2");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("GH");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add(".84^1.2^?^3");
		results.add("Enter the name of the Package that owns and distributes this entry.");
		results.add("");
		results.add("Please enter the name of this PACKAGE (4-30 characters).");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
		assertEquals(results.get(4), dieHelpResponse.getDataList().get(4));
		assertEquals(results.get(5), dieHelpResponse.getDataList().get(5));
	}
	
	/**
	 * <em>Test Case #12</em>
	 * 
	 * <pre>
	 *	>S DDR("FILE")=.84,DDR("FIELD")=1.2,DDR("FLAGS")="H"
	 *	>K RESULT D GETHLPC^DDR2(.RESULT,.DDR)
	 *
	 *	Successful result
	 *	>ZW RESULT
	 *	RESULT(1)="[BEGIN_diHELP]"
	 *	RESULT(2)=".84^1.2^?^1"
	 *	RESULT(3)="Enter the name of the Package that owns and distributes this entry."
	 *	RESULT(4)="[END_diHELP]"
	 *
	 * </pre>
	 */
	@Test
	public void testHelp012() throws VistaWebServiceFault {
		dieHelpRequest.setFile(".84");
		dieHelpRequest.setField("1.2");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("H");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add(".84^1.2^?^1");
		results.add("Enter the name of the Package that owns and distributes this entry.");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
	}

	/**
	 * <em>Test Case #13</em>
	 * 
	 * <pre>
	 *			 
	 *	>S FILE=8984.1,FIELD=.02,FLAG="M",IENS="" 
	 *	>D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT") 
	 *	>ZW RESULT
	 *	RESULT("DIHELP")=15
	 *	RESULT("DIHELP",1)="If you enter just a name, the system will search each of the"
	 *	RESULT("DIHELP",2)="above files for the name you have entered.  If a match is found,"
	 *	RESULT("DIHELP",3)="the system will ask you if it is the entry you desire."
	 *	RESULT("DIHELP",4)=" "
	 *	RESULT("DIHELP",5)="However, if you know the file the entry should be in, you can"
	 *	RESULT("DIHELP",6)="speed processing by using the following syntax to select an entry:"
	 *	RESULT("DIHELP",7)=" "
	 *	RESULT("DIHELP",8)="     <Prefix>.<entry name>"
	 *	RESULT("DIHELP",9)="             or"
	 *	RESULT("DIHELP",10)="     <Message>.<entry name>"
	 *	RESULT("DIHELP",11)="             or"
	 *	RESULT("DIHELP",12)="     <File Name>.<entry name>"
	 *	RESULT("DIHELP",13)=" "
	 *	RESULT("DIHELP",14)="You do not need to enter the entire file name or message."
	 *	RESULT("DIHELP",15)="The first few characters will suffice."
	 *	
	 *	RPC Results:
	 *		>S DDR("FILE")=8984.1,DDR("FIELD")=.02,DDR("FLAGS")="M"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="8984.1^.02^?^15"
	 *		RESULT(3)="If you enter just a name, the system will search each of the "
	 *		RESULT(4)="above files for the name you have entered.  If a match is found,"
	 *		RESULT(5)="the system will ask you if it is the entry you desire."
	 *		RESULT(6)=" "
	 *		RESULT(7)="However, if you know the file the entry should be in, you can"
	 *		RESULT(8)="speed processing by using the following syntax to select an entry:"
	 *		RESULT(9)=" "
	 *		RESULT(10)="     <Prefix>.<entry name>"
	 *		RESULT(11)="             or"
	 *		RESULT(12)="     <Message>.<entry name>"
	 *		RESULT(13)="             or"
	 *		RESULT(14)="     <File Name>.<entry name>"
	 *		RESULT(15)=" "
	 *		RESULT(16)="You do not need to enter the entire file name or message."
	 *		RESULT(17)="The first few characters will suffice."
	 *		RESULT(18)="[END_diHELP]"
	 *
	 * </pre>
	 */
	@Test
	public void testHelp013() throws VistaWebServiceFault {
		dieHelpRequest.setFile("8984.1");
		dieHelpRequest.setField(".02");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("8984.1^.02^?^15");
		results.add("If you enter just a name, the system will search each of the ");
		results.add("above files for the name you have entered.  If a match is found,");
		results.add("the system will ask you if it is the entry you desire.");
		results.add(" ");
		results.add("However, if you know the file the entry should be in, you can");
		results.add("speed processing by using the following syntax to select an entry:");
		results.add(" ");
		results.add("     <Prefix>.<entry name>");
		results.add("             or");
		results.add("     <Message>.<entry name>");
		results.add("             or");
		results.add("     <File Name>.<entry name>");
		results.add(" ");
		results.add("You do not need to enter the entire file name or message.");
		results.add("The first few characters will suffice.");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
		assertEquals(results.get(4), dieHelpResponse.getDataList().get(4));
		assertEquals(results.get(5), dieHelpResponse.getDataList().get(5));
		assertEquals(results.get(6), dieHelpResponse.getDataList().get(6));
		assertEquals(results.get(7), dieHelpResponse.getDataList().get(7));
		assertEquals(results.get(8), dieHelpResponse.getDataList().get(8));
		assertEquals(results.get(9), dieHelpResponse.getDataList().get(9));
		assertEquals(results.get(10), dieHelpResponse.getDataList().get(10));
		assertEquals(results.get(11), dieHelpResponse.getDataList().get(11));
		assertEquals(results.get(12), dieHelpResponse.getDataList().get(12));
		assertEquals(results.get(13), dieHelpResponse.getDataList().get(13));
		assertEquals(results.get(14), dieHelpResponse.getDataList().get(14));
		assertEquals(results.get(15), dieHelpResponse.getDataList().get(15));
		assertEquals(results.get(16), dieHelpResponse.getDataList().get(16));
		assertEquals(results.get(17), dieHelpResponse.getDataList().get(17));
	}

	/**
	 * <em>Test Case #14</em>
	 * 
	 * <pre>
	 *			 
	 *	>S FILE=2,FIELD=.102,FLAG="P",IENS=""
	 * 
	 *	>D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT")
	 * 
	 *	>ZW RESULT
	 *	RESULT("DIHELP")=1
	 *	RESULT("DIHELP",1)="Allows only movements for patient"
	 *
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.102,DDR("FLAGS")="P"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT                                         
	 *
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="2^.102^?^1"
	 *		RESULT(3)="Allows only movements for patient"
	 *		RESULT(4)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testHelp014() throws VistaWebServiceFault {
		dieHelpRequest.setFile("2");
		dieHelpRequest.setField(".102");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("P");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("2^.102^?^1");
		results.add("Allows only movements for patient");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
	}

	/**
	 * <em>Test Case #15</em>
	 * 
	 * <pre>
	 *			 
	 *	>S FILE=2,FIELD=.02,FLAG="S",IENS=""
 	 *	
	 *	>D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT")
 	 *	
	 *	>ZW RESULT
	 *	RESULT("DIHELP")=3
	 *	RESULT("DIHELP",1)="Choose from:"
	 *	RESULT("DIHELP",2)="M        MALE"
	 *	RESULT("DIHELP",3)="F        FEMALE"
	 *	
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.02,DDR("FLAGS")="S"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *                                        
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="2^.02^?^3"
	 *		RESULT(3)="Choose from:"
	 *		RESULT(4)="M        MALE"
	 *		RESULT(5)="F        FEMALE"
	 *		RESULT(6)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testHelp015() throws VistaWebServiceFault {
		dieHelpRequest.setFile("2");
		dieHelpRequest.setField(".02");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("S");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("2^.02^?^3");
		results.add("Choose from:");
		results.add("M        MALE");
		results.add("F        FEMALE");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
		assertEquals(results.get(4), dieHelpResponse.getDataList().get(4));
		assertEquals(results.get(5), dieHelpResponse.getDataList().get(5));
	}

	/**
	 * <em>Test Case #16</em>
	 * 
	 * <pre>
	 *			 
	 *	>S FILE=2.98,FIELD=.001,FLAG="T",IENS=""
 	 *	
	 *	>D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT")
 	 *	
	 *	>ZW RESULT
	 *	RESULT("DIHELP")=11
	 *	RESULT("DIHELP",1)="Examples of Valid Dates:"
	 *	RESULT("DIHELP",2)="   JAN 20 1957 or 20 JAN 57 or 1/20/57 or 012057"
	 *	RESULT("DIHELP",3)="   T   (for TODAY),  T+1 (for TOMORROW),  T+2,  T+7, etc."
	 *	RESULT("DIHELP",4)="   T-1 (for YESTERDAY),  T-3W (for 3 WEEKS AGO), etc."
	 *	RESULT("DIHELP",5)="If the year is omitted, the computer uses CURRENT YEAR.  Two
 	 *	digit year"
	 *	RESULT("DIHELP",6)="  assumes no more than 20 years in the future, or 80 years i
	 *	n the past."
	 *	RESULT("DIHELP",7)=" "
	 *	RESULT("DIHELP",8)="If the date is omitted, the current date is assumed."
	 *	RESULT("DIHELP",9)="Follow the date with a time, such as JAN 20@10, T@10AM, 10:3
	 *	0, etc."
	 *	RESULT("DIHELP",10)="You may enter NOON, MIDNIGHT, or NOW to indicate the time."
	 *	RESULT("DIHELP",11)="Time is REQUIRED for this response."
	 *	
	 *	RPC Results:
	 *		>S FILE=2.98,FIELD=.001,DDR("FLAGS")="T"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="2.98^.001^?^11"
	 *		RESULT(3)="Examples of Valid Dates:"
	 *		RESULT(4)="   JAN 20 1957 or 20 JAN 57 or 1/20/57 or 012057"
	 *		RESULT(5)="   T   (for TODAY),  T+1 (for TOMORROW),  T+2,  T+7, etc."
	 *		RESULT(6)="   T-1 (for YESTERDAY),  T-3W (for 3 WEEKS AGO), etc."
	 *		RESULT(7)="If the year is omitted, the computer uses CURRENT YEAR.  Two digit ye
	 *			ar"
	 *		RESULT(8)="  assumes no more than 20 years in the future, or 80 years in the pas
	 *			t."
	 *		RESULT(9)=" "
	 *		RESULT(10)="If the date is omitted, the current date is assumed."
	 *		RESULT(11)="Follow the date with a time, such as JAN 20@10, T@10AM, 10:30, etc."
	 *		RESULT(12)="You may enter NOON, MIDNIGHT, or NOW to indicate the time."
	 *		RESULT(13)="Time is REQUIRED for this response."
	 *		RESULT(14)="[END_diHELP]"
	 *
	 * </pre>
	 */
	@Test
	public void testHelp016() throws VistaWebServiceFault {
		dieHelpRequest.setFile("2.98");
		dieHelpRequest.setField(".001");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("T");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("2.98^.001^?^11");
		results.add("Examples of Valid Dates:");
		results.add("   JAN 20 1957 or 20 JAN 57 or 1/20/57 or 012057");
		results.add("   T   (for TODAY),  T+1 (for TOMORROW),  T+2,  T+7, etc.");
		results.add("   T-1 (for YESTERDAY),  T-3W (for 3 WEEKS AGO), etc.");
		results.add("If the year is omitted, the computer uses CURRENT YEAR.  Two digit year");
		results.add("  assumes no more than 20 years in the future, or 80 years in the past.");
		results.add(" ");
		results.add("If the date is omitted, the current date is assumed.");
		results.add("Follow the date with a time, such as JAN 20@10, T@10AM, 10:30, etc.");
		results.add("You may enter NOON, MIDNIGHT, or NOW to indicate the time.");
		results.add("Time is REQUIRED for this response.");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
		assertEquals(results.get(4), dieHelpResponse.getDataList().get(4));
		assertEquals(results.get(5), dieHelpResponse.getDataList().get(5));
		assertEquals(results.get(6), dieHelpResponse.getDataList().get(6));
		assertEquals(results.get(7), dieHelpResponse.getDataList().get(7));
		assertEquals(results.get(8), dieHelpResponse.getDataList().get(8));
		assertEquals(results.get(9), dieHelpResponse.getDataList().get(9));
		assertEquals(results.get(10), dieHelpResponse.getDataList().get(10));
		assertEquals(results.get(11), dieHelpResponse.getDataList().get(11));
		assertEquals(results.get(12), dieHelpResponse.getDataList().get(12));
		assertEquals(results.get(13), dieHelpResponse.getDataList().get(13));
	}
	
	/**
	 * <em>Test Case #17</em>
	 * 
	 * <pre>
	 *			 
	 *	>S FILE=2,FIELD=.083,FLAG="U",IENS=""
	 * 
	 *	>D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT")
	 * 
	 *>ZW RESULT
	 *	RESULT("DIHELP")=2
	 *	RESULT("DIHELP",1)="Choose from:"
	 *	RESULT("DIHELP",2)="1        YES"
	 *
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.083,DDR("FLAGS")="U"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *                                         
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="2^.083^?^2"
	 *		RESULT(3)="Choose from:"
	 *		RESULT(4)="1        YES"
	 *		RESULT(5)="[END_diHELP]"
	 * </pre>
	 */
	@Test
	public void testHelp017() throws VistaWebServiceFault {

		dieHelpRequest.setFile("2");
		dieHelpRequest.setField(".083");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("U");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();
		results.add("[BEGIN_diHELP]");
		results.add("2^.083^?^2");
		results.add("Choose from:");
		results.add("1        YES");
		results.add("[END_diHELP]");
		
		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
		assertEquals(results.get(4), dieHelpResponse.getDataList().get(4));
	}

	/**
	 * <em>Test Case #18</em>
	 * 
	 * <pre>
	 *			 
	 *	>S FILE=100.21,FIELD=3,FLAG="V",IENS="" 
	 *	>D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT") 
	 *	>ZW RESULT
	 *	RESULT("DIHELP")=7
	 *	RESULT("DIHELP",1)="Enter one of the following:"
	 *	RESULT("DIHELP",2)=" "
	 *	RESULT("DIHELP",3)="W.EntryName to select a WARD."
	 *	RESULT("DIHELP",4)="R.EntryName to select a ROOM-BED."
	 *	RESULT("DIHELP",5)="P.EntryName to select a PROVIDER."
	 *	RESULT("DIHELP",6)="S.EntryName to select a SPECIALTY."
	 *	RESULT("DIHELP",7)="C.EntryName to select a CLINIC."
	 *	
	 *	RPC Results:
	 *		>S DDR("FILE")=100.21,DDR("FIELD")=3,DDR("FLAGS")="V"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *                                           
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="100.21^3^?^7"
	 *		RESULT(3)="Enter one of the following:"
	 *		RESULT(4)=" "
	 *		RESULT(5)="W.EntryName to select a WARD."
	 *		RESULT(6)="R.EntryName to select a ROOM-BED."
	 *		RESULT(7)="P.EntryName to select a PROVIDER."
	 *		RESULT(8)="S.EntryName to select a SPECIALTY."
	 *		RESULT(9)="C.EntryName to select a CLINIC."
	 *		RESULT(10)="[END_diHELP]"
	 *
	 * </pre>
	 */
	@Test
	public void testHelp018() throws VistaWebServiceFault {
		ArrayList <String> results = new ArrayList <String>();

		results.add("[BEGIN_diHELP]");
		results.add("100.21^3^?^7");
		results.add("Enter one of the following:");
		results.add(" ");
		results.add("W.EntryName to select a WARD.");
		results.add("R.EntryName to select a ROOM-BED.");
		results.add("P.EntryName to select a PROVIDER.");
		results.add("S.EntryName to select a SPECIALTY.");
		results.add("C.EntryName to select a CLINIC.");
		results.add("[END_diHELP]");

		dieHelpRequest.setFile("100.21");
		dieHelpRequest.setField("3");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("V");
		dieHelpRequest.setFlags(flags);

		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
		assertEquals(results.get(2), dieHelpResponse.getDataList().get(2));
		assertEquals(results.get(3), dieHelpResponse.getDataList().get(3));
		assertEquals(results.get(4), dieHelpResponse.getDataList().get(4));
		assertEquals(results.get(5), dieHelpResponse.getDataList().get(5));
		assertEquals(results.get(6), dieHelpResponse.getDataList().get(6));
		assertEquals(results.get(7), dieHelpResponse.getDataList().get(7));
		assertEquals(results.get(8), dieHelpResponse.getDataList().get(8));
		assertEquals(results.get(9), dieHelpResponse.getDataList().get(9));
	}

	/**
	 * <em>Test Case #19</em>
	 * 
	 * <pre>
	 *			 
	 * >S FILE=1.1,FIELD=.02,FLAG="X",IENS="" 
	 * >D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT") 
	 * 
	 *	RPC Results:
	 *		>S DDR("FILE")=1.1,DDR("FIELD")=.02,DDR("FLAGS")="X"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *                       
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="[END_diHELP]"
</pre>
	 */
	@Test
	public void testHelp019() throws VistaWebServiceFault {
		dieHelpRequest.setFile("1.1");
		dieHelpRequest.setField(".02");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("X");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();

		results.add("[BEGIN_diHELP]");
		results.add("[END_diHELP]");

		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
	}

	/**
	 * <em>Test Case #20</em>
	 * 
	 * <pre>
	 *			 
	 * >S FILE=1.1,FIELD=.02,FLAG="g",IENS="" 
	 * >D HELP^DIE(FILE,"",FIELD,FLAG,"RESULT") 
	 * >ZW RESULT
	 * 
	 *	RPC Results:
	 *		>S DDR("FILE")=1.1,DDR("FIELD")=.02,DDR("FLAGS")="g"
	 *		>D GETHLPC^DDR2(.RESULT,.DDR)
	 *		>ZW RESULT
	 *
	 *		RESULT(1)="[BEGIN_diHELP]"
	 *		RESULT(2)="[END_diHELP]"
	 *
	 * </pre>
	 */
	@Test
	public void testHelp020() throws VistaWebServiceFault {
		dieHelpRequest.setFile("1.1");
		dieHelpRequest.setField(".02");
		dieHelpRequest.setIens("");
		List<String> flags = new ArrayList<String>();
		flags.add("g");
		dieHelpRequest.setFlags(flags);

		ArrayList <String> results = new ArrayList <String>();

		results.add("[BEGIN_diHELP]");
		results.add("[END_diHELP]");

		// Execute request against mocked object backend.
		dieHelpResponse = service.help(dieHelpRequest);

		assertNotNull(dieHelpResponse);
		assertEquals(results.get(0), dieHelpResponse.getDataList().get(0));
		assertEquals(results.get(1), dieHelpResponse.getDataList().get(1));
	}

}

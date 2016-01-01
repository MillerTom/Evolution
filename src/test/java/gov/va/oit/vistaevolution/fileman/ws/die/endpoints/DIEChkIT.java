package gov.va.oit.vistaevolution.fileman.ws.die.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.DIEChkEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEChkRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEChkResponse;
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
public class DIEChkIT extends EvolutionIT<DIEChkEndpoint> {

	@Override
	protected Class<DIEChkEndpoint> getType() {
			return DIEChkEndpoint.class;
	}

	private DIEChkRequest dieChkRequest;
	private DIEChkResponse dieChkResponse;

	@Before
	public void setUp() {
		dieChkRequest = new DIEChkRequest();
	}

	@After
	public void tearDown() {
		dieChkRequest = null;
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * <pre>
	 *
	 *	RPC Results:
	 *
	 *	>S DDR("FILE")=2,DDR("FIELD")=.02,DDR("FLAGS")="E",DDR("VALUE")="T"
	 *	>D CHKR^DDR5(.RESULT,.DDR)
	 *	>ZW RESULT
	 *
	 *	RESULT="^"
	 *	RESULT("ERROR","DIERR")="1^1"
	 *	RESULT("ERROR","DIERR",1)=701
	 *	RESULT("ERROR","DIERR",1,"PARAM",0)=3
	 *	RESULT("ERROR","DIERR",1,"PARAM",3)="T"
	 *	RESULT("ERROR","DIERR",1,"PARAM","FIELD")=.02
	 *	RESULT("ERROR","DIERR",1,"PARAM","FILE")=2
	 *	RESULT("ERROR","DIERR",1,"TEXT",1)="The value 'T' for field SEX in file PATIENT
	 *			is not valid."
	 *	RESULT("ERROR","DIERR","E",701,1)=""
	 *
	 * </pre>
	 */
	@Test
	public void testChk001() throws VistaWebServiceFault {
		ArrayList<String> results = new ArrayList<String>();

		results.add("1^1");
		results.add("701");
		results.add("3");
		results.add("T");
		results.add(".02");
		results.add("2");
		results.add("The value 'T' for field SEX in file PATIENT is not valid.");
		results.add("");
		results.add("^");

		dieChkRequest.setFile("2");
		dieChkRequest.setField(".02");
		List<String> flags = new ArrayList<String>();
		flags.add("E");
		dieChkRequest.setFlags(flags);
		dieChkRequest.setValue("T");

		// Execute request against mocked object backend.
		dieChkResponse = service.chk(dieChkRequest);
		assertNotNull(dieChkResponse);
		assertEquals(results.get(0), dieChkResponse.getData().get(0));
		assertEquals(results.get(1), dieChkResponse.getData().get(1));
		assertEquals(results.get(2), dieChkResponse.getData().get(2));
		assertEquals(results.get(3), dieChkResponse.getData().get(3));
		assertEquals(results.get(4), dieChkResponse.getData().get(4));
		assertEquals(results.get(5), dieChkResponse.getData().get(5));
		assertEquals(results.get(6), dieChkResponse.getData().get(6));
		assertEquals(results.get(7), dieChkResponse.getData().get(7));
		assertEquals(results.get(8), dieChkResponse.getData().get(8));
	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * <pre>
	 *	>S FILE=2,FIELD=.02,FLAG="E",VALUE="MALE"
	 *	>D CHK^DIE(FILE,FIELD,FLAG,VALUE,.RESULT,"ERR")
	 *
	 *	>ZW RESULT
	 *	RESULT="M"
	 *	RESULT(0)="MALE"
	 *
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.02,DDR("FLAGS")="E",DDR("VALUE")="MALE"
	 *		>D CHKR^DDR5(.RESULT,.DDR)
	 *		NCHD03:NCHZW RESULT                                                            "
	 *
	 *		RESULT="M"
	 *		RESULT(0)="MALE"
	 *
	 * </pre>
	 */
	@Test
	public void testChk002() throws VistaWebServiceFault {
		ArrayList<String> results = new ArrayList<String>();

		results.add("MALE");

		dieChkRequest.setFile("2");
		dieChkRequest.setField(".02");
		List<String> flags = new ArrayList<String>();
		flags.add("E");
		dieChkRequest.setFlags(flags);
		dieChkRequest.setValue("MALE");

		// Execute request against mocked object backend.
		dieChkResponse = service.chk(dieChkRequest);
		
		assertNotNull(dieChkResponse);
		assertEquals(results.get(0), dieChkResponse.getData().get(0));

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * <pre>
	 *	>S FILE=2,FIELD=.02,FLAG="E",VALUE="M"
 	 *	
	 *	>D CHK^DIE(FILE,FIELD,FLAG,VALUE,.RESULT,"ERR")
 	 *	
	 *	>ZW RESULT
	 *	RESULT="M"
	 *	RESULT(0)="MALE"
	 *
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.02,DDR("FLAGS")="E",DDR("VALUE")="M"
	 *		>D CHKR^DDR5(.RESULT,.DDR)
	 *		>ZW RESULT
	 *
	 *		RESULT="M"
	 *		RESULT(0)="MALE"
	 *	
	 * </pre>
	 */
	@Test
	public void testChk003() throws VistaWebServiceFault {
		ArrayList<String> results = new ArrayList<String>();

		results.add("MALE");

		dieChkRequest.setFile("2");
		dieChkRequest.setField(".02");
		List<String> flags = new ArrayList<String>();
		flags.add("E");
		dieChkRequest.setFlags(flags);
		dieChkRequest.setValue("M");

		// Execute request against mocked object backend.
		dieChkResponse = service.chk(dieChkRequest);
		
		assertNotNull(dieChkResponse);
		assertEquals(results.get(0), dieChkResponse.getData().get(0));

	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * <pre>
	 *	>S FILE=2,FIELD=.05,FLAG="",VALUE="M"
 	 *	
	 *	>D CHK^DIE(FILE,FIELD,FLAG,VALUE,.RESULT,"ERR")
 	 *	
	 *	>ZW ERR
	 *	 
	 *	>ZW RESULT
	 *	RESULT=2
	 *
	 *	RPCResults
	 *		>S DDR("FILE")=2,DDR("FIELD")=.05,DDR("FLAGS")="",DDR("VALUE")="M"
	 *		>D CHKR^DDR5(.RESULT,.DDR)
	 *		>ZW RESULT
	 *
	 *		RESULT=2
	 *			 
	 * </pre>
	 */
	@Test
	public void testChk004() throws VistaWebServiceFault {
		ArrayList<String> results = new ArrayList<String>();

		results.add("2");
/* TODO: RPC CALL IS RETURNING NOTHING - RETEST WHEN RPC BROKER CALL IS FIXED
 * RPC DDR SOA DATA CHECKER Result Test Case:
 *
 * Results Length: 0
*/
		dieChkRequest.setFile("2");
		dieChkRequest.setField(".05");
//		List<String> flags = new ArrayList<String>();
//		flags.add("");
//		dieChkRequest.setFlags(flags);
		dieChkRequest.setValue("M");

		// Execute request against mocked object backend.
		dieChkResponse = service.chk(dieChkRequest);

		assertNotNull(dieChkResponse);
		assertEquals(results.get(0), dieChkResponse.getData().get(0));

	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * <pre>
	 *	>S FILE=2,FIELD=.05,FLAG="E",VALUE="M"
 	 *	
	 *	>D CHK^DIE(FILE,FIELD,FLAG,VALUE,.RESULT,"ERR")
	 *	 
	 *	>ZW RESULT
	 *	RESULT=2
	 *	RESULT(0)="MARRIED"
	 *
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.05,DDR("FLAGS")="E",DDR("VALUE")="M"
	 *		>D CHKR^DDR5(.RESULT,.DDR)
	 *		>ZW RESULT
	 *		
	 *		RESULT=2
	 *		RESULT(0)="MARRIED"
	 *	
	 * </pre>
	 */
	@Test
	public void testChk005() throws VistaWebServiceFault {
		ArrayList<String> results = new ArrayList<String>();

		results.add("MARRIED");

		dieChkRequest.setFile("2");
		dieChkRequest.setField(".05");
		List<String> flags = new ArrayList<String>();
		flags.add("E");
		dieChkRequest.setFlags(flags);
		dieChkRequest.setValue("M");

		// Execute request against mocked object backend.
		dieChkResponse = service.chk(dieChkRequest);
		
		assertNotNull(dieChkResponse);
		assertEquals(results.get(0), dieChkResponse.getData().get(0));

	}

	/**
	 * <em>Test Case #6</em>
	 * 
	 * <pre>
	 *	>S FILE=2,FIELD=.05,FLAG="E",VALUE="X"
 	 *	
	 *	>D CHK^DIE(FILE,FIELD,FLAG,VALUE,.RESULT,"ERR")
 	 *	
	 *	>ZW RESULT
	 *	RESULT="^"
 	 *	
	 *	>ZW ERR
	 *	ERR("DIERR")="1^1"
	 *	ERR("DIERR",1)=701
	 *	ERR("DIERR",1,"PARAM",0)=3
	 *	ERR("DIERR",1,"PARAM",3)="X"
	 *	ERR("DIERR",1,"PARAM","FIELD")=.05
	 *	ERR("DIERR",1,"PARAM","FILE")=2
	 *	ERR("DIERR",1,"TEXT",1)="The value 'X' for field MARITAL STATUS in file PATIENT is not valid."
	 *	ERR("DIERR","E",701,1)=""
	 *
	 *
	 *	RPC Results:
	 *		>S DDR("FILE")=2,DDR("FIELD")=.05,DDR("FLAGS")="E",DDR("VALUE")="X"
	 *		>D CHKR^DDR5(.RESULT,.DDR)
	 *		>ZW RESULT
	 *
	 *		RESULT="^"
	 *		RESULT("ERROR","DIERR")="1^1"
	 *		RESULT("ERROR","DIERR",1)=701
	 *		RESULT("ERROR","DIERR",1,"PARAM",0)=3
	 *		RESULT("ERROR","DIERR",1,"PARAM",3)="X"
	 *		RESULT("ERROR","DIERR",1,"PARAM","FIELD")=.05
	 *		RESULT("ERROR","DIERR",1,"PARAM","FILE")=2
	 *		RESULT("ERROR","DIERR",1,"TEXT",1)="The value 'X' for field MARITAL STATUS in file PATIENT is not valid."
	 *		RESULT("ERROR","DIERR","E",701,1)=""
	 *				 
	 * </pre>
	 */
	@Test
	public void testChk006() throws VistaWebServiceFault {
		ArrayList<String> results = new ArrayList<String>();

		results.add("1^1");
		results.add("701");
		results.add("3");
		results.add("X");
		results.add(".05");
		results.add("2");
		results.add("The value 'X' for field MARITAL STATUS in file PATIENT is not valid.");
		results.add("");
		results.add("^");

		dieChkRequest.setFile("2");
		dieChkRequest.setField(".05");
		List<String> flags = new ArrayList<String>();
		flags.add("E");
		dieChkRequest.setFlags(flags);
		dieChkRequest.setValue("X");

		// Execute request against mocked object backend.
		dieChkResponse = service.chk(dieChkRequest);
		assertNotNull(dieChkResponse);
		assertEquals(results.get(0), dieChkResponse.getData().get(0));
		assertEquals(results.get(1), dieChkResponse.getData().get(1));
		assertEquals(results.get(2), dieChkResponse.getData().get(2));
		assertEquals(results.get(3), dieChkResponse.getData().get(3));
		assertEquals(results.get(4), dieChkResponse.getData().get(4));
		assertEquals(results.get(5), dieChkResponse.getData().get(5));
		assertEquals(results.get(6), dieChkResponse.getData().get(6));
		assertEquals(results.get(7), dieChkResponse.getData().get(7));
		assertEquals(results.get(8), dieChkResponse.getData().get(8));

	}

	/**
	 * <em>Test Case #7</em>
	 * 
	 * <pre>
	 *
	 *	RPC Reslts
	 *		>S DDR("FILE")=2,DDR("FIELD")=.05,DDR("FLAGS")="H",DDR("VALUE")="X"
	 *		>D CHKR^DDR5(.RESULT,.DDR)
	 *		>ZW RESULT
	 *
	 *		RESULT="^"
	 *		RESULT("ERROR","DIERR")="1^1"
	 *		RESULT("ERROR","DIERR",1)=701
	 *		RESULT("ERROR","DIERR",1,"PARAM",0)=3
	 *		RESULT("ERROR","DIERR",1,"PARAM",3)="X"
	 *		RESULT("ERROR","DIERR",1,"PARAM","FIELD")=.05
	 *		RESULT("ERROR","DIERR",1,"PARAM","FILE")=2
	 *		RESULT("ERROR","DIERR",1,"TEXT",1)="The value 'X' for field MARITAL STATUS in file PATIENT is not valid."
	 *		RESULT("ERROR","DIERR","E",701,1)=""
	 *		RESULT("ERROR","DIHELP")=5
	 *		RESULT("ERROR","DIHELP",1)="Select from the available listing this patients current marital status."
	 *		RESULT("ERROR","DIHELP",2)=" "
	 *		RESULT("ERROR","DIHELP",3)="Answer with MARITAL STATUS NAME, or ABBREVIATION."
	 *		RESULT("ERROR","DIHELP",4)=""
	 *		RESULT("ERROR","DIHELP",5)="ANSWER MUST BE 2-15 CHARACTERS IN LENGTH"
	 *			 
	 * </pre>
	 */
	@Test
	public void testChk007() throws VistaWebServiceFault {
		ArrayList<String> results = new ArrayList<String>();

		results.add("1^1");
		results.add("701");
		results.add("3");
		results.add("X");
		results.add(".05");
		results.add("2");
		results.add("The value 'X' for field MARITAL STATUS in file PATIENT is not valid.");
		results.add("");
		results.add("5");
		results.add("Select from the available listing this patients current marital status.");
		results.add(" ");
		results.add("Answer with MARITAL STATUS NAME, or ABBREVIATION.");
		results.add("");
		results.add("ANSWER MUST BE 2-15 CHARACTERS IN LENGTH");
		results.add("^");

		dieChkRequest.setFile("2");
		dieChkRequest.setField(".05");
		List<String> flags = new ArrayList<String>();
		flags.add("H");
		dieChkRequest.setFlags(flags);
		dieChkRequest.setValue("X");

		// Execute request against mocked object backend.
		dieChkResponse = service.chk(dieChkRequest);
		assertNotNull(dieChkResponse);
		assertEquals(results.get(0), dieChkResponse.getData().get(0));
		assertEquals(results.get(1), dieChkResponse.getData().get(1));
		assertEquals(results.get(2), dieChkResponse.getData().get(2));
		assertEquals(results.get(3), dieChkResponse.getData().get(3));
		assertEquals(results.get(4), dieChkResponse.getData().get(4));
		assertEquals(results.get(5), dieChkResponse.getData().get(5));
		assertEquals(results.get(6), dieChkResponse.getData().get(6));
		assertEquals(results.get(7), dieChkResponse.getData().get(7));
		assertEquals(results.get(8), dieChkResponse.getData().get(8));
		assertEquals(results.get(9), dieChkResponse.getData().get(9));
		assertEquals(results.get(10), dieChkResponse.getData().get(10));
		assertEquals(results.get(11), dieChkResponse.getData().get(11));
		assertEquals(results.get(12), dieChkResponse.getData().get(12));
		assertEquals(results.get(13), dieChkResponse.getData().get(13));
		assertEquals(results.get(14), dieChkResponse.getData().get(14));

	}

}

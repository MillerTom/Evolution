package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDExternalEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDExternalRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDExternalResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for EXTERNAL method of DILFD Webservice
 */
public class DILFDExternalIT extends EvolutionIT<DILFDExternalEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(DILFDExternalIT.class);

	private DILFDExternalRequest request;
	private DILFDExternalResponse response;

	@Override
	protected Class<DILFDExternalEndpoint> getType() {
		return DILFDExternalEndpoint.class;
	}

	@Before
	public void setup() {
		request = new DILFDExternalRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public DILFDExternalIT() {
		super();
	}

	/**
	 * <em>Test Case 1</em>
	 * 
	 * Top-level file
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FILE”)=.84,DDR(“FIELD”)=3,DDR(“FLAGS”)="",DDR(“INTERNAL”)="y"
	 * 
	 * >DEXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA="YES"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testExternal001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("YES");

		List<String> flags = new ArrayList<String>();
		request.setFile(".84");
		request.setField("3");
		request.setFlags(flags);
		request.setInternal("y");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.external(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputData());

	}

	/**
	 * <em>Test Case 2</em>
	 * 
	 * Sub-file
	 * 
	 * <pre>
	 * 	>K DDRDATA,DDR
	 * >S DDR(“FILE”)=.841,DDR(“FIELD”)=.01,DDR(“FLAGS”)="",DDR(“INTERNAL”)=”DIE”
	 * 
	 * >D EXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=”DIE”
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testExternal002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("DIE");

		List<String> flags = new ArrayList<String>();
		request.setFile(".841");
		request.setField(".01");
		request.setFlags(flags);
		request.setInternal("DIE");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.external(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputData());

	}

	/**
	 * <em>Test Case 3</em>
	 * 
	 * 501 error
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FILE”)=.84,DDR(“FIELD”)=9,DDR(“FLAGS”)="",DDR(“INTERNAL”)="DIE"
	 * 
	 * >D EXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=""
	 * DDRDATA("ERROR","DIERR",1)=501
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=3
	 * DDRDATA("ERROR","DIERR",1,"PARAM",1)=9
	 * DDRDATA("ERROR","DIERR",1,"PARAM","FIELD")=9
	 * DDRDATA("ERROR","DIERR",1,"PARAM","FILE")=.84
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="File #.84 does not contain a field 9."
	 * DDRDATA("ERROR","DIERR","E",501,1)=""
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testExternal003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("501");
		results.add("3");
		results.add("9");
		results.add("9");
		results.add(".84");
		results.add("File #.84 does not contain a field 9.");
		results.add("");

		List<String> flags = new ArrayList<String>();
		request.setFile(".84");
		request.setField("9");
		request.setFlags(flags);
		request.setInternal("DIE");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.external(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputData());
	}

	/**
	 * <em>Test Case 4</em>
	 * 
	 * 401 error
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * 
	 * >S DDR(“FILE”)="TEST",DDR(“FIELD”)=.01,DDR(“FLAGS”)="",DDR(“INTERNAL”)=2090101.1234
	 * 
	 * >D EXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=""
	 * DDRDATA("ERROR","DIERR",1)=401
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=1
	 * DDRDATA("ERROR","DIERR",1,"PARAM","FILE")="TEST"
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="File #TEST does not exist."
	 * DDRDATA("ERROR","DIERR","E",401,1)=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testExternal004() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("401");
		results.add("1");
		results.add("TEST");
		results.add("File #TEST does not exist.");
		results.add("");

		List<String> flags = new ArrayList<String>();
		request.setFile("TEST");
		request.setField(".01");
		request.setFlags(flags);
		request.setInternal("2090101.1234");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.external(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputData());

	}

	/**
	 * <em>Test Case 5</em>
	 * 
	 * 330 error
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FILE”)=.84,DDR(“FIELD”)=1.2,DDR(“FLAGS”)=””,DDR(“INTERNAL”)=0
	 * 
	 * >D EXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=""
	 * DDRDATA("ERROR","DIERR",1)=330
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=2
	 * DDRDATA("ERROR","DIERR",1,"PARAM",1)=0
	 * DDRDATA("ERROR","DIERR",1,"PARAM",2)="pointer"
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="The value '0' is not a valid pointer."
	 * DDRDATA("ERROR","DIERR","E",330,1)=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testExternal005() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("330");
		results.add("2");
		results.add("0");
		results.add("pointer");
		results.add("The value '0' is not a valid pointer.");
		results.add("");

		List<String> flags = new ArrayList<String>();
		request.setFile(".84");
		request.setField("1.2");
		request.setFlags(flags);
		request.setInternal("0");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.external(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputData());

	}

	/**
	 * <em>Test Case 6</em>
	 * 
	 * 301 error
	 * 
	 * <pre>
	 * 	>K DDRDATA,DDR
	 * >S DDR(“FILE”)=.84,DDR(“FIELD”)=3,DDR(“FLAGS”)="G",DDR(“INTERNAL”)="y"
	 * 
	 * >D EXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=""
	 * DDRDATA("ERROR","DIERR",1)=301
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=1
	 * DDRDATA("ERROR","DIERR",1,"PARAM",1)="G"
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="The passed flag(s) 'G' are unknown or inconsistent."
	 * DDRDATA("ERROR","DIERR","E",301,1)=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testExternal006() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("301");
		results.add("1");
		results.add("G");
		results.add("The passed flag(s) 'G' are unknown or inconsistent.");
		results.add("");

		List<String> flags = new ArrayList<String>();
		flags.add("G");
		request.setFile(".84");
		request.setField("3");
		request.setFlags(flags);
		request.setInternal("y");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.external(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputData());

	}

	/**
	 * <em>Test Case 7</em>
	 * 
	 * Pointer field
	 * 
	 * <pre>
	 * 	 >K DDRDATA,DDR
	 * >S DDR(“FILE”)=.84,DDR(“FIELD”)=1.2,DDR(“FLAGS”)="",DDR(“INTERNAL”)=335
	 * 
	 * >D EXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA="VA FILEMAN"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testExternal007() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("VA FILEMAN");

		List<String> flags = new ArrayList<String>();
		request.setFile(".84");
		request.setField("1.2");
		request.setFlags(flags);
		request.setInternal("335");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.external(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputData());

	}

	/**
	 * <em>Test Case 8</em>
	 * 
	 * ‘U’ flag on a pointer field
	 * 
	 * NOTE: The variable D0 must be set to prevent a fatal error.
	 * 
	 * 
	 * <pre>
	 * 	>K DDRDATA,DDR
	 * >S DDR(“FILE”)=50,DDR(“FIELD”)=22,DDR(“INTERNAL”)=11222,DDR(“FLAGS”)="U",D0=525
	 * 
	 * >D EXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA="ABSORBTIVE DRESSING 6GM #740036"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testExternal008() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ABSORBTIVE DRESSING 6GM #740036");

		List<String> flags = new ArrayList<String>();
		flags.add("U");
		request.setFile("50");
		request.setField("22");
		request.setFlags(flags);
		request.setInternal("11222");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.external(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputData());

	}

	/**
	 * <em>Test Case 9</em>
	 * 
	 * ‘F’ flag on a pointer field
	 * 
	 * NOTE: The variable D0 must be set to prevent a fatal error.
	 * 
	 * 
	 * <pre>
	 * 	>K DDRDATA,DDR
	 * >S DDR(“FILE”)=50,DDR(“FIELD”)=22,DDR(“INTERNAL”)=11222,DDR(“FLAGS”)="F",D0=525
	 * 
	 * >D EXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA                                                                    
	 * DDRDATA=11222
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testExternal009() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("11222");

		List<String> flags = new ArrayList<String>();
		flags.add("F");
		request.setFile("50");
		request.setField("22");
		request.setFlags(flags);
		request.setInternal("11222");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.external(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputData());

	}

	/**
	 * <em>Test Case 10</em>
	 * 
	 * ‘L’ flag on a pointer field
	 * 
	 * 
	 * <pre>
	 * 	>K DDRDATA,DDR
	 * >S DDR(“FILE”)=50,DDR(“FIELD”)=22,DDR(“INTERNAL”)=11222,DDR(“FLAGS”)="L"
	 * 
	 * >D EXTERNLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA                                                                    
	 * DDRDATA=”ABSORBTIVE DRESSING 6GM #740036”
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testExternal0010() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ABSORBTIVE DRESSING 6GM #740036");

		List<String> flags = new ArrayList<String>();
		flags.add("L");
		request.setFile("50");
		request.setField("22");
		request.setFlags(flags);
		request.setInternal("11222");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.external(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputData());

	}

}

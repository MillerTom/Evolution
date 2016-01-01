package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4F4Endpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4F4Request;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4F4Response;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XUAF4F4IT extends EvolutionIT<XUAF4F4Endpoint> {

	private static final Logger LOGGER = Logger.getLogger(XUAF4F4IT.class);

	private XUAF4F4Request request;
	private XUAF4F4Response response;

	@Override
	protected Class<XUAF4F4Endpoint> getType() {
		return XUAF4F4Endpoint.class;
	}

	@Before
	public void setup() {
		request = new XUAF4F4Request();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XUAF4F4IT() {
		super();
	}

	/**
	 * <em>Test Case #1    Look Up active Station  Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 		>S STA="528A8"
	 * 		>S FLAG="A"
	 * 		>S ONDT=""
	 * 		
	 * 		Procedure Call:
	 * 		>D F4^XUAF4(STA,.ARRAY,FLAG,ONDT)
	 * 		
	 * 		Expected Output:
	 * 		>ZW ARRAY
	 * 		ARRAY=6563
	 * 		ARRAY("INACTIVE")=0
	 * 		ARRAY("NAME")="ALBANY, NY VAMC"
	 * 		ARRAY("REALIGNED FROM")="500^500^3000701"
	 * 		ARRAY("STATION NUMBER")="528A8"
	 * 		ARRAY("TYPE")="VAMC"
	 * 		ARRAY("VA NAME")="VA HEALTHCARE NETWORK UPSTATE NEW YORK SYSTEM VISN 2 – ALBANY DIVISION"
	 * </pre>
	 * 
	 */

	@Test
	public void testF4001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("6563");
		results.add("0");
		results.add("ALBANY, NY VAMC");
		results.add("500^500^3000701");
		results.add("528A8");
		results.add("VAMC");
		results.add("VA HEALTHCARE NETWORK UPSTATE NEW YORK SYSTEM VISN 2 – ALBANY DIVISION");

		request.setSta("528A8");
		request.setFlag("A");
		request.setInDate("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.F4(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #2   Look Up inactive Station  Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 			>S STA="455"
	 * 			>S FLAG="A"
	 * 			>S ONDT=""
	 * 		
	 * 		Procedure Call:
	 * 			>D F4^XUAF4(STA,FLAG,ONDT)
	 * 		
	 * 		Expected Output:
	 * 			>ZW ARRAY
	 * 			ARRAY="0^inactive facility"
	 * </pre>
	 * 
	 */

	@Test
	public void testF4002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^inactive facility");

		request.setSta("455");
		request.setFlag("A");
		request.setInDate("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.F4(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #3    Enter a blank or null Station Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    	Input Data:
	 * 			>S STA=""
	 * 			>S FLAG="A"
	 * 			>S ONDT=""
	 * 			
	 * 			Procedure Call:
	 * 			>D F4R^XUSOAR(.RETURN,STA,FLAG,ONDT)
	 * 			
	 * 			Expected Output:
	 * 			>ZW RETURN
	 * 			RETURN="0^invalid input STA - required"
	 * </pre>
	 * 
	 */

	@Test
	public void testF4003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^invalid input STA - required");

		request.setSta("");
		request.setFlag("A");
		request.setInDate("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.F4(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #4    Look Up Bogus Station Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 		>S STA="999999999"
	 * 		>S FLAG="A"
	 * 		>S ONDT=""
	 * 		
	 * 		Procedure Call:
	 * 		>D F4R^XUSOAR(.RETURN,STA,FLAG,ONDT)
	 * 		
	 * 		Expected Output:
	 * 		>ZW RETURN
	 * 		RETURN="0^station number does not exist"
	 * </pre>
	 * 
	 */

	@Test
	public void testF4004() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^station number does not exist");

		request.setSta("999999999");
		request.setFlag("A");
		request.setInDate("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.F4(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>
	 * Test Case #5 Lookup Station Number that is “Not a Medical Treatment Facility”.
	 *  Use lower Case m
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 			>S STA="776"
	 * 			>S ARRAY=""
	 * 			>S FLAG="m"
	 * 			>S ONDT=""
	 * 			
	 * 		Procedure Call:
	 * 			>D F4^XUAF4(STA,.ARRAY,FLAG,ONDT)
	 * 		
	 * 		Expected Output:
	 * 			>ZW ARRAY
	 * 			ARRAY=468
	 * 			ARRAY("INACTIVE")=0
	 * 			ARRAY("NAME")="OFFICE OF INFORMATION SRV CNTR"
	 * 			ARRAY("STATION NUMBER")=776
	 * 			ARRAY("TYPE")="OTHER"
	 * 			ARRAY("VA NAME")="OFFICE OF INFORMATION SERVICE CENTER"
	 * </pre>
	 * 
	 */

	@Test
	public void testF4005() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("468");
		results.add("0");
		results.add("OFFICE OF INFORMATION SRV CNTR");
		results.add("776");
		results.add("OTHER");
		results.add("OFFICE OF INFORMATION SERVICE CENTER");

		request.setSta("776");
		request.setFlag("m");
		request.setInDate("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.F4(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList().get(0));

	}

	/**
	 * <em>
	 * Test Case #6 Lookup Station Number that is “Not a Medical Treatment Facility”.
	 * Use Upper Case M
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 			>S STA="776"
	 * 			>S ARRAY=""
	 * 			>S FLAG="M"
	 * 			>S ONDT=""
	 * 		
	 * 		Procedure Call:
	 * 			>D F4^XUAF4(STA,.ARRAY,FLAG,ONDT)
	 * 		
	 * 		Expected Output:
	 * 			>ZW ARRAY
	 * 			ARRAY="0^not a treating facility"
	 * </pre>
	 * 
	 */

	@Test
	public void testF4006() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^not a treating facility");

		request.setSta("776");
		request.setFlag("M");
		request.setInDate("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.F4(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>
	 * Test Case #7 Lookup Station Number that is “Not a Medical Treatment Facility”.
	 * Use Upper Case M
	 * </em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 			>S STA="665"
	 * 			>S ARRAY=""
	 * 			>S FLAG=""
	 * 			>S ONDT=""
	 * 		
	 * 		Procedure Call:
	 * 			>D F4^XUAF4(STA,.ARRAY,FLAG,ONDT)
	 * 		
	 * 		Expected Output:
	 * 			>ZW ARRAY
	 * 			ARRAY=665
	 * 			ARRAY("INACTIVE")=2981001
	 * 			ARRAY("NAME")="ZZ SEPULVEDA"
	 * 			ARRAY("REALIGNED FROM")="752^752^2970701"
	 * 			ARRAY("REALIGNED TO")="7760^691A4^2981001"
	 * 			ARRAY("STATION NUMBER")=665
	 * 			ARRAY("TYPE")="VAMC"
	 * 			ARRAY("VA NAME")="ZZ SEPULVEDA DIVISION"
	 * </pre>
	 * 
	 */

	@Test
	public void testF4007() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("665");
		results.add("2981001");
		results.add("ZZ SEPULVEDA");
		results.add("752^752^2970701");
		results.add("7760^691A4^2981001");
		results.add("665");
		results.add("VAMC");
		results.add("ZZ SEPULVEDA DIVISION");

		request.setSta("665");
		request.setFlag("");
		request.setInDate("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.F4(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}
}

package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4LKUPEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XUAF4LKUPIT extends EvolutionIT<XUAF4LKUPEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XUAF4LKUPIT.class);

	private XUAF4LKUPRequest request;
	private XUAF4LKUPResponse response;

	@Override
	protected Class<XUAF4LKUPEndpoint> getType() {
		return XUAF4LKUPEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XUAF4LKUPRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XUAF4LKUPIT() {
		super();
	}

	/**
	 * <em>Test Case #1    Look Up Institution by Station Name</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 				>S INST="OFFICE OF INFORMATION SRV CNTR"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$LKUP^XUAF4(INST)
	 * 
	 * 			Expected Output: (IEN)
	 * 				>ZW RETURN
	 * 				RETURN=468
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testLKUP001() throws VistaWebServiceFault {

		String testResponse = "468";

		request.setInst("OFFICE OF INFORMATION SRV CNTR");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}
		response = service.LKUP(request);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getIen());

	}

	/**
	 * <em>Test Case #2    Look Up Institution by IEN</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 				>S INST="`468"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$LKUP^XUAF4(INST)
	 * 
	 * 			Expected Output: (IEN)
	 * 				>ZW RETURN
	 * 				RETURN=468
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testLKUP002() throws VistaWebServiceFault {

		String testResponse = "468";

		request.setInst("`468");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}
		response = service.LKUP(request);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getIen());

	}

	/**
	 * <em>Test Case #3    Look Up Institution by Station Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 				>S INST="776"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$LKUP^XUAF4(INST)
	 * 
	 * 			Expected Output: (IEN)
	 * 				>ZW RETURN
	 * 				RETURN=468
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testLKUP003() throws VistaWebServiceFault {

		String testResponse = "468";

		request.setInst("776");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}
		response = service.LKUP(request);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getIen());

	}

	/**
	 * <em>Test Case #4   Look Up Institution by invalid Station Number</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 				>S INST="999999999"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$LKUP^XUAF4(INST)
	 * 
	 * 			Expected Output: (IEN)
	 * 				>ZW RETURN
	 * 				RETURN=0
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testLKUP004() throws VistaWebServiceFault {

		String testResponse = "0";

		request.setInst("999999999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}
		response = service.LKUP(request);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(testResponse, response.getIen());

	}

	/**
	 * <em>Test Case #5   Look Up Institution by invalid Name</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 				>S INST="ZTESTZ"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$LKUP^XUAF4(INST)
	 * 
	 * 			Expected Output: (IEN)
	 * 				>ZW RETURN
	 * 				RETURN=0
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testLKUP005() throws VistaWebServiceFault {

		String testResponse = "0";

		request.setInst("ZTESTZ");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}
		response = service.LKUP(request);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(testResponse, response.getIen());

	}

	/**
	 * <em>Test Case #6   Look Up Institution by invalid IEN</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	    Input Data:
	 * 				>S INST="999999999"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$LKUP^XUAF4(INST)
	 * 
	 * 			Expected Output: (IEN)
	 * 				>ZW RETURN
	 * 				RETURN=0
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testLKUP006() throws VistaWebServiceFault {

		String testResponse = "0";

		request.setInst("999999999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}
		response = service.LKUP(request);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(testResponse, response.getIen());

	}

}

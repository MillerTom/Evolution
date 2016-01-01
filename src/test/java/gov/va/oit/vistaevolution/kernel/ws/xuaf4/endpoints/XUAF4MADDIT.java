package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4MADDEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4MADDRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4MADDResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XUAF4MADDIT extends EvolutionIT<XUAF4MADDEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XUAF4MADDIT.class);

	private XUAF4MADDRequest request;
	private XUAF4MADDResponse response;

	@Override
	protected Class<XUAF4MADDEndpoint> getType() {
		return XUAF4MADDEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XUAF4MADDRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	public XUAF4MADDIT() {
		super();
	}

	/**
	 * <em>Test Case #1  Look up Institution by IEN and return address</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 			>S XUIEN=6712
	 * 			
	 * 			Procedure Call:
	 * 			>D MADDR^XUSOAR(.RETURN,XUIEN)
	 * 			
	 * 			Expected Output:
	 * 			>ZW RETURN
	 * 			RETURN=" 407 N SALEM AVE^SUMTER^SC^29150-4115"
	 * 
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testMADD001() throws VistaWebServiceFault {

		String result = " 407 N SALEM AVE^SUMTER^SC^29150-4115";

		request.setIen("6712");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.MADD(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getResult());

	}

	/**
	 * <em>Test Case #2 Lookup an Institution with a bogus IEN and return a null value.</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 			>S INST="999999999"
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$MADD^XUAF4(INST)
	 * 			
	 * 			Expected Output:
	 * 				>ZW RETURN
	 * 				RETURN=""
	 * 
	 * 
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testMADD002() throws VistaWebServiceFault {

		String result = "";

		request.setIen("999999999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.MADD(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());

	}

	/**
	 * <em>Test Case #3 Lookup an Institution with null IEN and return a null value.</em>
	 * 
	 * 
	 * <pre>
	 * 
	 * 	   	Input Data:
	 * 				>S INST=""
	 * 
	 * 			Procedure Call:
	 * 				>S RETURN=$$MADD^XUAF4(INST)
	 * 			
	 * 			Expected Output:
	 * 				>ZW RETURN
	 * 				RETURN=""
	 * 
	 * </pre>
	 * 
	 */

	@Test
	public void testMADD003() throws VistaWebServiceFault {

		String result = "";

		request.setIen("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.MADD(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(result, response.getResult());
	}

}

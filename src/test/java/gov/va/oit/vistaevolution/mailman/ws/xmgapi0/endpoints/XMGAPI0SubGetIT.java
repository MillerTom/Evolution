package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.XMGAPI0SubGetEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubGetResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubgetRequest;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMGAPI0SubGetIT extends EvolutionIT<XMGAPI0SubGetEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(XMGAPI0SubGetIT.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
	 */
	@Override
	protected Class<XMGAPI0SubGetEndpoint> getType() {
		return XMGAPI0SubGetEndpoint.class;
	}

	/**
	 * Submits a known successful request to the web service and validated that
	 * the subject is not null and the status is correct.
	 * 
	 * @param request
	 */
	public void submitSuccessfulRequest(XMGAPI0SubgetRequest request) {
		XMGAPI0SubGetResponse response = service.subGet(request);

		LOGGER.debug(request);
		LOGGER.debug(response);

		assertNotNull(response.getSubject());
		assertEquals("0", response.getStatus());
	}

	/**
	 * Submits a known failing request to the web service and validated that the
	 * errors array is not null and the status is correct.
	 * 
	 * @param request
	 */
	public void submitFailingRequest(XMGAPI0SubgetRequest request) {
		XMGAPI0SubGetResponse response = service.subGet(request);

		LOGGER.debug(request);
		LOGGER.debug(response);

		assertNotNull(response.getErrors());
		assertEquals("-1", response.getStatus());
	}

	/**
	 * Test case returns the subject of the message number passed into the
	 * function.
	 * 
	 * >S U="^" Input >S ZZ=3
	 * 
	 * Function call > D SUBGET^XMWSOA01 (.OUTPUT,ZZ)
	 * 
	 * Output >ZW OUTPUT OUTPUT="0^NEW USER ADDED TO SYSTEM"
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test
	public void testGetMessageSubject() throws VistaWebServiceFault {
		XMGAPI0SubgetRequest request = new XMGAPI0SubgetRequest("58880");

		submitSuccessfulRequest(request);
	}

	/**
	 * Pass a non-existent message number to the function.
	 * 
	 * >S U="^" Input: >S ZZ=9 Function call > D SUBGET^XMWSOA01 (.OUTPUT,ZZ)
	 * Output: >ZW OUTPUT OUTPUT="-1^Message not found"
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test
	public void testGetWithBadMessageNumber() throws VistaWebServiceFault {
		XMGAPI0SubgetRequest request = new XMGAPI0SubgetRequest("9");

		submitFailingRequest(request);
	}

	/**
	 * 
	 * Pass a non-numeric as the message number to the procedure. >S U="^"
	 * Input: >S ZZ=”A” Function call > D SUBGET^XMWSOA01 (.OUTPUT,ZZ) Output:
	 * >ZW OUTPUT OUTPUT= "-1^Error in required input"
	 */
	@Test
	public void testGetWithNonNumeric() throws VistaWebServiceFault {
		XMGAPI0SubgetRequest request = new XMGAPI0SubgetRequest("A");

		submitFailingRequest(request);
	}

}

package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBCheckAVEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBCheckAVRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBCheckAVResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;


import org.junit.Test;


public class XUSRBCheckAVIT extends EvolutionIT<XUSRBCheckAVEndpoint> {

	private final String FAILCODE = "0";
	private XUSRBCheckAVRequest request;
	private XUSRBCheckAVResponse response;

	/**
	 * negative test, access/verify code not found, return 0
	 */
	@Test
	public void testCheckAV001() throws VistaWebServiceFault {

		request = new XUSRBCheckAVRequest("");

		response = service.checkAV(request);

		assertNotNull(response);
		assertEquals(FAILCODE, response.getRet());
		
	}

	@Override
	protected Class<XUSRBCheckAVEndpoint> getType() {
		return XUSRBCheckAVEndpoint.class;
	}

}

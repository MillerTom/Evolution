/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusbse1.endpoints;

import static org.junit.Assert.*;
import gov.va.oit.vistaevolution.kernel.ws.xusap.endpoints.interfaces.XUSAPActiveEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusap.model.XUSAPActiveRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusap.model.XUSAPActiveResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusbse1.endpoints.interfaces.XUSBSE1GetVisitEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusbse1.model.XUSBSE1GetVisitRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusbse1.model.XUSBSE1GetVisitResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.endpoints.interfaces.XUSER2GetUpnEndpoint;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Stephen Combs
 *
 */
/**
 * @author 0G4976SEC
 *
 */
public class XUSBSE1GetVisitIT extends EvolutionIT<XUSBSE1GetVisitEndpoint> {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger( XUSBSE1GetVisitIT.class);
	
	private XUSBSE1GetVisitRequest xusbse1GetVisitRequest;
	private XUSBSE1GetVisitResponse xusbse1GetVisitResponse;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpBeforeClass() throws Exception {
		xusbse1GetVisitRequest = new XUSBSE1GetVisitRequest();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDownAfterClass() throws Exception {
		xusbse1GetVisitResponse = null;
	}

	protected Class<XUSBSE1GetVisitEndpoint> getType()
	{
		return XUSBSE1GetVisitEndpoint.class;
	}
	
	/**
	 * A test to validate a non-successful capture of user information.
	 * An empty string is expected.
	 * @throws VistaWebServiceFault 
	 * 
	 */
	@Test
	public void jTestGetVisit001() throws VistaWebServiceFault {
		
		String testResult = "";
		xusbse1GetVisitRequest.setToken("XUSBSE1202-66939_6");
		xusbse1GetVisitResponse = service.getVisit(xusbse1GetVisitRequest);
			LOGGER.debug("Test for unfound user token. Expected result is an empty string."
					+ "\nInput value 'token' = " + xusbse1GetVisitRequest.getToken() 
					+ "	\nGetVisitService executed. Result is \"" + xusbse1GetVisitResponse.getRet() + "\"");
		
		assertNotNull(xusbse1GetVisitResponse.getRet());
		assertEquals(testResult, xusbse1GetVisitResponse.getRet());
	}
	
	//TODO once RPCs are added to allow for the setting of the DUZ and Setting the Visitor, then tests may be implemented for positive results
	//Note: a null entry test will not work, as the SOAP request input for "token" is required.

}

/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusap.endpoints;

import static org.junit.Assert.*;
import gov.va.oit.vistaevolution.kernel.ws.xusap.endpoints.interfaces.XUSAPActiveEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusap.model.XUSAPActiveRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusap.model.XUSAPActiveResponse;
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
public class XUSAPActiveIT extends EvolutionIT<XUSAPActiveEndpoint> {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(XUSAPActiveIT.class);
	
	private XUSAPActiveRequest xusapActiveRequest;
	private XUSAPActiveResponse xusapActiveResponse;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpBeforeClass() throws Exception {
		xusapActiveRequest = new XUSAPActiveRequest();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDownAfterClass() throws Exception {
		xusapActiveResponse = null;
	}

	protected Class<XUSAPActiveEndpoint> getType()
	{
		return XUSAPActiveEndpoint.class;
	}
	
	/**
	 * @throws VistaWebServiceFault 
	 * 
	 */
	@Test
	public void jTestActiveXUSAP001() throws VistaWebServiceFault {
		
		String testResult = "1";
		xusapActiveRequest.setDuz(".5");
		xusapActiveResponse = service.active(xusapActiveRequest);
		
		assertNotNull(xusapActiveResponse.getRet());
		assertEquals(testResult, xusapActiveResponse.getRet());
	}

	@Test
	public void jTestActiveXUSAP002() throws VistaWebServiceFault {
		
		String testResult = "1";
		xusapActiveRequest.setDuz("DUZ");
		xusapActiveResponse = service.active(xusapActiveRequest);
		
		assertNotNull(xusapActiveResponse.getRet());
		assertEquals(testResult, xusapActiveResponse.getRet());
	}
	
	@Test
	public void jTestActiveXUSAP003() throws VistaWebServiceFault {
		
		String testResult = "0^TERMINATED^2940519";
		xusapActiveRequest.setDuz("100");
		xusapActiveResponse = service.active(xusapActiveRequest);
		
		assertNotNull(xusapActiveResponse.getRet());
		//assertEquals(testResult, xusapActiveResponse.getRet());
	}
	
	@Test
	public void jTestActiveXUSAP004() throws VistaWebServiceFault {
		
		String testResult = "0^TERMINATED^2940824";
		xusapActiveRequest.setDuz("980");
		xusapActiveResponse = service.active(xusapActiveRequest);
		
		assertNotNull(xusapActiveResponse.getRet());
		//assertEquals(testResult, xusapActiveResponse.getRet());
	}
}

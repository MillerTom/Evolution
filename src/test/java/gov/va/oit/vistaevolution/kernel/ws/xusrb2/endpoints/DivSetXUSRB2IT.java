/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

import gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.DivSetXUSRB2Endpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivSetXUSRB2Request;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivSetXUSRB2Response;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Stephen Combs <Stephen.Combs@synaptekcorp.com>
 *
 */
public class DivSetXUSRB2IT extends VistaLinkContextITParent {

	private final String EXPECTED_SUCCESS_MESSAGE = "1";
	private final String EXPECTED_FAILURE_MESSAGE = "0";
	
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(DivSetXUSRB2IT.class);

	@Autowired
	private DivSetXUSRB2Endpoint divSetXUSRB2Endpoint;

	private DivSetXUSRB2Request divSetXUSRB2Request;
	private DivSetXUSRB2Response divSetXUSRB2Response;

	@Before
	public void setUp() {
		divSetXUSRB2Request = new DivSetXUSRB2Request();
	}

	@After
	public void tearDown() {
		divSetXUSRB2Request = null;
	}
	
	@Test
	public void jTestDivsetXUSRB2001() throws VistaWebServiceFault{
		
		divSetXUSRB2Request.setDiv("");
		divSetXUSRB2Response = divSetXUSRB2Endpoint.divset(divSetXUSRB2Request);
		
		assertNotNull(divSetXUSRB2Response);
		assertEquals(EXPECTED_FAILURE_MESSAGE,divSetXUSRB2Response.getRet());
		
		
	}

	@Test
	public void jTestDivsetXUSRB2002() throws VistaWebServiceFault{
		
		divSetXUSRB2Request.setDiv("BRONX VAMC");
		divSetXUSRB2Response = divSetXUSRB2Endpoint.divset(divSetXUSRB2Request);
		
		assertNotNull(divSetXUSRB2Response);
		assertEquals(EXPECTED_FAILURE_MESSAGE,divSetXUSRB2Response.getRet());
		
		
	}
	
	@Test
	public void jTestDivsetXUSRB2003() throws VistaWebServiceFault{
		
		divSetXUSRB2Request.setDiv("`526");
		divSetXUSRB2Response = divSetXUSRB2Endpoint.divset(divSetXUSRB2Request);
		
		assertNotNull(divSetXUSRB2Response);
		assertEquals(EXPECTED_FAILURE_MESSAGE,divSetXUSRB2Response.getRet());
		
		
	}
	
	@Test
	@Ignore
	public void jTestDivsetXUSRB2004() throws VistaWebServiceFault{
		
		divSetXUSRB2Request.setDiv("`518");
		divSetXUSRB2Response = divSetXUSRB2Endpoint.divset(divSetXUSRB2Request);
		
		assertNotNull(divSetXUSRB2Response);
		assertEquals(EXPECTED_SUCCESS_MESSAGE,divSetXUSRB2Response.getRet());
		
		
	}
	
	@Test
	@Ignore
	public void jTestDivsetXUSRB2005() throws VistaWebServiceFault{
		
		divSetXUSRB2Request.setDiv("BEDFORD VAMC");
		divSetXUSRB2Response = divSetXUSRB2Endpoint.divset(divSetXUSRB2Request);
		
		assertNotNull(divSetXUSRB2Response);
		assertEquals(EXPECTED_SUCCESS_MESSAGE,divSetXUSRB2Response.getRet());
		
		
	}
	
	@Test
	@Ignore
	public void jTestDivsetXUSRB2006() throws VistaWebServiceFault{
		
		divSetXUSRB2Request.setDiv("BRONX VAMC");
		divSetXUSRB2Response = divSetXUSRB2Endpoint.divset(divSetXUSRB2Request);
		
		assertNotNull(divSetXUSRB2Response);
		assertEquals(EXPECTED_SUCCESS_MESSAGE,divSetXUSRB2Response.getRet());
		
		
	}
	
	@Test
	@Ignore
	public void jTestDivsetXUSRB2007() throws VistaWebServiceFault{
		
		divSetXUSRB2Request.setDiv("`500");
		divSetXUSRB2Response = divSetXUSRB2Endpoint.divset(divSetXUSRB2Request);
		
		assertNotNull(divSetXUSRB2Response);
		assertEquals(EXPECTED_FAILURE_MESSAGE,divSetXUSRB2Response.getRet());
		
		
	}
	
	@Test
	@Ignore
	public void jTestDivsetXUSRB2008() throws VistaWebServiceFault{
		
		divSetXUSRB2Request.setDiv("`526");
		divSetXUSRB2Response = divSetXUSRB2Endpoint.divset(divSetXUSRB2Request);
		
		assertNotNull(divSetXUSRB2Response);
		assertEquals(EXPECTED_SUCCESS_MESSAGE,divSetXUSRB2Response.getRet());
		
		
	}
	
	@Test
	@Ignore
	public void jTestDivsetXUSRB2009() throws VistaWebServiceFault{
		
		divSetXUSRB2Request.setDiv("SAN ANTONIO NHC");
		divSetXUSRB2Response = divSetXUSRB2Endpoint.divset(divSetXUSRB2Request);
		
		assertNotNull(divSetXUSRB2Response);
		assertEquals(EXPECTED_SUCCESS_MESSAGE,divSetXUSRB2Response.getRet());
		
		
	}
	
	@Test
	public void jTestDivsetXUSRB2010() throws VistaWebServiceFault{
		
		divSetXUSRB2Request.setDiv("`501");
		divSetXUSRB2Response = divSetXUSRB2Endpoint.divset(divSetXUSRB2Request);
		
		assertNotNull(divSetXUSRB2Response);
		assertEquals(EXPECTED_FAILURE_MESSAGE,divSetXUSRB2Response.getRet());
		
		
	}
	
	@Test
	public void jTestDivsetXUSRB2011() throws VistaWebServiceFault{
		
		divSetXUSRB2Request.setDiv("NEW MEXICO HCS");
		divSetXUSRB2Response = divSetXUSRB2Endpoint.divset(divSetXUSRB2Request);
		
		assertNotNull(divSetXUSRB2Response);
		assertEquals(EXPECTED_FAILURE_MESSAGE,divSetXUSRB2Response.getRet());
		
		
	}
}

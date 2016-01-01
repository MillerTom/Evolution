/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNameEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNameResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
public class XMXUTILNameIT extends EvolutionIT<XMXUTILNameEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTILNameIT.class);

	@Override
	protected Class<XMXUTILNameEndpoint> getType() {
		return XMXUTILNameEndpoint.class;
	}
    
	private XMXUTILNameRequest request;
	private XMXUTILNameResponse response;

	@Before
	public void setUp() {
		request = new XMXUTILNameRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

    
    
    /**
     * Test Case 1
     *
     * Check for information on MDUZ of 1 without XMINFO flag
     * 
     * >D NAME^XMWSOA07(.RESULT,1)
     * >ZW RESULT
     * RESULT="PROGRAMMER,ONE"
     * 
     */
    @Test
    public void testName001() throws VistaWebServiceFault {

    	request.setXmDuz("1");
    	request.setXmInfo("");
	
		
		// Execute request against mocked object backend.
		response = service.name(request);
	
		assertNotNull(response);
		assertEquals("PROGRAMMER,ONE", response.getResults());
        
    }
    
    /**
     * Test Case 2
     * 
     * Check for information on MDUZ of 1 with XMINFO flag
     * 
     * >D NAME^XMWSOA07(.RESULT,1,1)
     * >ZW RESULT
     * RESULT="PROGRAMMER,ONE - COMPUTER SPECIALIST (VISTA EVOLUTION PORTOL)"
     * 
     */
    @Test
    public void testName002() throws VistaWebServiceFault {

    	request.setXmDuz("1");
    	request.setXmInfo("1");
	
		
		// Execute request against mocked object backend.
		response = service.name(request);
	
		assertNotNull(response);
		assertEquals("PROGRAMMER,ONE - COMPUTER SPECIALIST (VISTA EVOLUTION PORTOL)", response.getResults());
    
    }
    
    /**
     * Test Case 3
     * 
     *  Check for information on MDUZ of .5 without XMINFO flag
     *  
     *  >D NAME^XMWSOA07(.RESULT,.5,0)
     *  
     *   >ZW RESULT
     *   RESULT="POSTMASTER"
     *   
     */
    @Test
    public void testName003() throws VistaWebServiceFault {

    	request.setXmDuz(".5");
    	request.setXmInfo("0");

		
		// Execute request against mocked object backend.
		response = service.name(request);
	
		assertNotNull(response);
		assertEquals("POSTMASTER", response.getResults());
        
    }
    
    /**
     * Test Case 4
     * 
     * Check for information on MDUZ of .5 with XMINFO flag
     * 
     * >D NAME^XMWSOA07(.RESULT,.5,1)
     * >ZW RESULT
     * RESULT="POSTMASTER - POSTMASTER"
     * 
     */
    @Test
    public void testName004() throws VistaWebServiceFault {

    	request.setXmDuz(".5");
    	request.setXmInfo("1");
	
		
		// Execute request against mocked object backend.
		response = service.name(request);
	
		assertNotNull(response);
		assertEquals("POSTMASTER - POSTMASTER", response.getResults());
        
    }
    
    /**
     * Test Case 5
     * 
     * Check for information on MDUZ of .6 without XMINFO flag
     * 
     * >D NAME^XMWSOA07(.RESULT,.6,0)
     * >ZW RESULT
     * RESULT="SHARED,MAIL"
     */
    @Test
    public void testName005() throws VistaWebServiceFault {

    	request.setXmDuz(".6");
    	request.setXmInfo("0");
	
		
		// Execute request against mocked object backend.
		response = service.name(request);
	
		assertNotNull(response);
		assertEquals("SHARED,MAIL", response.getResults());
        
    }
    
    /**
     * Test Case 6
     * 
     * Check for information on MDUZ that does not exist with XMINFO flag
     * 
     * >D NAME^XMWSOA07(.RESULT,99999,1)
     * >ZW RESULT
     * RESULT="* User #99999 *"
     * 
     */
    @Test
    public void testName006() throws VistaWebServiceFault {

    	request.setXmDuz("99999");
    	request.setXmInfo("1");
	
		
		// Execute request against mocked object backend.
		response = service.name(request);
	
		assertNotNull(response);
		assertEquals("* User #99999 *", response.getResults());
    }

}

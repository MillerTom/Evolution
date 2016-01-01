/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNewsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNewsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNewsResponse;
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
public class XMXUTILNewsIT extends EvolutionIT<XMXUTILNewsEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTILNewsIT.class);

	@Override
	protected Class<XMXUTILNewsEndpoint> getType() {
		return XMXUTILNewsEndpoint.class;
	}
    
	private XMXUTILNewsRequest request;
	private XMXUTILNewsResponse response;

	@Before
	public void setUp() {
		request = new XMXUTILNewsRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

    /**
     * Test Case 1
     *
     * Look up for a user without any messages
     * 
     * >D NEWS^XMWSOA07(.RESULT,10000000222,1)
     * >ZW RESULT
     * RESULT=0
     * 
     */
    @Test
    public void testNews001() throws VistaWebServiceFault {

    	request.setXmDuz("10000000222");
    	request.setXmTest("1");
		
		// Execute request against mocked object backend.
		response = service.news(request);
	
		assertNotNull(response);
		assertEquals("0", response.getResults());
        
    }
    
    /**
     * Test Case 2
     * 
     * Look up for a user .5 without XMTEST
     * 
     * >D NEWS^XMWSOA07(.RESULT,.5,0)
     * >ZW RESULT
     * RESULT="242^1^242^3111002.101407^0^242^1^IN"
     * 
     */
    @Test
    public void testNews002() throws VistaWebServiceFault {

    	request.setXmDuz(".5");
    	request.setXmTest("0");
		
		// Execute request against mocked object backend.
		response = service.news(request);
	
		assertNotNull(response);
		// Dynamic Data
		//assertEquals("242^1^242^3111002.101407^0^242^1^IN", response.getResults());
		String failMsg = String.format("Expected string to contain: '%s', Actual string: %s", "^IN", response.getResults());
		assertTrue(failMsg, response.getResults().contains("^IN"));
        
    }
    
    /**
     * Test Case 3
     *
     * Look up for a user .5 with XMTEST
     * 
     * >D NEWS^XMWSOA07(.RESULT,.5,1)
     * >ZW RESULT
     * RESULT="242^1^242^3111002.101407^0^242^1^IN"
     * 
     */
    @Test
    public void testNews003() throws VistaWebServiceFault {

    	request.setXmDuz(".5");
    	request.setXmTest("1");
	
		
		// Execute request against mocked object backend.
		response = service.news(request);
	
		assertNotNull(response);
		// Dynamic Data
		//assertEquals("242^1^242^3111002.101407^0^242^1^IN", response.getResults());
		String failMsg = String.format("Expected string to contain: '%s', Actual string: %s", "^IN", response.getResults());
		assertTrue(failMsg, response.getResults().contains("^IN"));
        
    }
    
    /**
     * Test Case 4
     * 
     * Look up for a user .6 without XMTEST
     * 
     * >D NEWS^XMWSOA07(.RESULT,.6,0)
     * >ZW RESULT
     * RESULT="24^0^24^3140219.192058^1^24^1^IN"
     * 
     */
    @Test
    public void testNews004() throws VistaWebServiceFault {

    	request.setXmDuz(".6");
    	request.setXmTest("0");
	
		
		// Execute request against mocked object backend.
		response = service.news(request);
	
		assertNotNull(response);
		// Dynamic Data
		//assertEquals("24^0^24^3140219.192058^1^24^1^IN", response.getResults());
		String failMsg = String.format("Expected string to contain: '%s', Actual string: %s", "^IN", response.getResults());
		assertTrue(failMsg, response.getResults().contains("^IN"));
        
    }
    
    /**
     * Test Case 5
     * 
     * Look up for a user .6 with XMTEST
     * 
     * >D NEWS^XMWSOA07(.RESULT,.6,1)
     * >ZW RESULT
     * RESULT="24^0^24^3140219.192058^1^24^1^IN"
     * 
     */
    @Test
    public void testNews005() throws VistaWebServiceFault {

    	request.setXmDuz(".6");
       	request.setXmTest("1");
	
		
		// Execute request against mocked object backend.
		response = service.news(request);
	
		assertNotNull(response);
		// Dynamic Data
		//assertEquals("24^0^24^3140219.192058^1^24^1^IN", response.getResults());
		String failMsg = String.format("Expected string to contain: '%s', Actual string: %s", "^IN", response.getResults());
		assertTrue(failMsg, response.getResults().contains("^IN"));
        
    }
    
    /**
     * Test Case 6
     * 
     * Look up for a user that does not exist
     * 
     * >D NEWS^XMWSOA07(.RESULT,99999,0)
     * >ZW RESULT
     * RESULT=-1
     * 
     */
    @Test
    public void testNews006() throws VistaWebServiceFault {

    	request.setXmDuz("99999");
       	request.setXmTest("0");
	
		
		// Execute request against mocked object backend.
		response = service.news(request);
	
		assertNotNull(response);
		assertEquals("-1", response.getResults());
        
    }

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1MeldEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MeldRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MeldResponse;
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
/*
 * XMWSOA MELD STRING
 * This RPC combines a string and a number to form a new string of a given
 * length. The string will be right justified; the number left-justified,
 * with at least two spaces separating the string and number. The string will
 * be truncated, if necessary.  If there's an error, it returns an error
 * message.
 * 
 * Input Parameters:
 * 		XMSTRING	(Required) The input string.
 * 		XMNUMBER	(Optional) The number.
 * 		XMLEN		(Required) The length of the new string to be formed.
 * 
 * Response:
 * 		Returns the newly formed string.
 * 
 * 			Example 1
 * 				XMSTRING="Lotus blossom",XMNUM=123,XMLEN=10
 * 				Lotus 123
 * 			
 * 			Example 2
 * 				XMSTRING="Lotus blossom",XMNUM=123,XMLEN=15
 * 				Lotus blos 123
 * 
 */
public class XMXUTIL1MeldIT extends EvolutionIT<XMXUTIL1MeldEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTIL1MeldIT.class);

	@Override
	protected Class<XMXUTIL1MeldEndpoint> getType() {
		return XMXUTIL1MeldEndpoint.class;
	}

	private XMXUTIL1MeldRequest request;
	private XMXUTIL1MeldResponse response;

	@Before
	public void setUp() {
		request = new XMXUTIL1MeldRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}
    
    /**
     * Test Case 1
     * 
     * Combining the string EVOLUTION and number 200 with length 5
     * 
     * >D MELD^XMWSOA07(.RESULT,"EVOLUTION",200,5)
     * >ZW RESULT
     * RESULT="  200"
     * 
     */
    @Test
    public void testMeld001() throws VistaWebServiceFault {

    	request.setXmString("EVOLUTION");
    	request.setXmNumber("200");
    	request.setXmLen("5");
	
		
		// Execute request against mocked object backend.
		response = service.meld(request);
	
		assertNotNull(response);
		assertEquals("  200", response.getResults());
        
    }
    
    /**
     * Test Case 2
     * 
     * Combining the string EVOLUTION and number 200 with length 10
     * 
     * >D MELD^XMWSOA07(.RESULT,"EVOLUTION",200,10)
     * >ZW RESULT
     * RESULT="EVOLU  200"
     * 
     */
    @Test
    public void testMeld002() throws VistaWebServiceFault {

    	request.setXmString("EVOLUTION");
    	request.setXmNumber("200");
    	request.setXmLen("10");
	
		
		// Execute request against mocked object backend.
		response = service.meld(request);
	
		assertNotNull(response);
		assertEquals("EVOLU  200", response.getResults());
        
    }
    
    /**
     * Test Case 3
     * 
     * Combining the string EVOLUTION and number 200 with length 20
     * 
     * >D MELD^XMWSOA07(.RESULT,"EVOLUTION",200,20)
     * >ZW RESULT
     * RESULT="EVOLUTION        200"
     * 
     */
    @Test
    public void testMeld003() throws VistaWebServiceFault {

    	request.setXmString("EVOLUTION");
    	request.setXmNumber("200");
    	request.setXmLen("20");
	
		
		// Execute request against mocked object backend.
		response = service.meld(request);
	
		assertNotNull(response);
		assertEquals("EVOLUTION        200", response.getResults());
        
    }
    
    /**
     * Test Case 4
     * 
     * Combining the string THIS IS A TEST and number 543210 with length 10
     * 
     * >D MELD^XMWSOA07(.RESULT,"THIS IS A TEST",543210,10)
     * >ZW RESULT
     * RESULT="TH  543210"
     * 
     */
    @Test
    public void testMeld004() throws VistaWebServiceFault {

    	request.setXmString("THIS IS A TEST");
    	request.setXmNumber("543210");
    	request.setXmLen("10");
	
		
		// Execute request against mocked object backend.
		response = service.meld(request);
	
		assertNotNull(response);
		assertEquals("TH  543210", response.getResults());
        
    }
    
    /**
     * Test Case 5
     * 
     * Combining the string THIS IS A TEST and number 543210 with length 15
     * 
     * >D MELD^XMWSOA07(.RESULT,"THIS IS A TEST",543210,15)
     * >ZW RESULT
     * RESULT="THIS IS  543210"
     * 
     */
    @Test
    public void testMeld005() throws VistaWebServiceFault {

    	request.setXmString("THIS IS A TEST");
    	request.setXmNumber("543210");
    	request.setXmLen("15");
	
		
		// Execute request against mocked object backend.
		response = service.meld(request);
	
		assertNotNull(response);
		assertEquals("THIS IS  543210", response.getResults());
        
    }

}

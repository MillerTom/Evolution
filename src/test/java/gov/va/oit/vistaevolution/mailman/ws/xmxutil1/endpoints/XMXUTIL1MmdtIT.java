/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.interfaces.XMA2XmzEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1MmdtEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MmdtRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MmdtResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Leisa Martella
 *
 */
/*
 * XMWSOA FM2MM DT
 * 
 * This RPC takes a VA FileMan Date/Time input string and returns it as a
 * reformatted string:
 *     mm/dd/yy@hh:mm
 *     
 * If there's an error, it returns an error message.
 * 
 * Input Parameters:
 * 		XMDT		(Required) VA FileMan Date/Time input string.
 * 
 * Response:
 * 		Returns a reformatted VA FileMan Date/Time string:
 * 			mm/dd/yy@hh:mm
 * 		Example
 * 			XMDT=2940629.105744
 * 			Return:  06/29/94@10:57
 * 
 */

public class XMXUTIL1MmdtIT extends EvolutionIT<XMXUTIL1MmdtEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTIL1MmdtIT.class);

	@Override
	protected Class<XMXUTIL1MmdtEndpoint> getType() {
		return XMXUTIL1MmdtEndpoint.class;
	}
   
	private XMXUTIL1MmdtRequest request;
	private XMXUTIL1MmdtResponse response;

	@Before
	public void setUp() {
		request = new XMXUTIL1MmdtRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}
    /**
     * Test Case 1
     *
     * >D MMDT^XMWSOA07(.RESULT,3140221.0955)
     * >ZW RESULT
     * RESULT="02/21/14@09:55"
     * 
     */
    @Test
    public void testMmdt001() throws VistaWebServiceFault {

    	request.setXmDt("3140221.0955");
	
		
		// Execute request against mocked object backend.
		response = service.mmdt(request);
	
		assertNotNull(response);
		assertEquals("02/21/14@09:55", response.getResults());
        
    }
    
    /**
     * Test Case 2
     *
     *>D MMDT^XMWSOA07(.RESULT,2991130)
     *>ZW RESULT
     *RESULT="11/30/99"
     * 
     */
    @Test
    public void testMmdt002() throws VistaWebServiceFault {

    	request.setXmDt("2991130");
	
		
		// Execute request against mocked object backend.
		response = service.mmdt(request);
	
		assertNotNull(response);
		assertEquals("11/30/99", response.getResults());
        
    }
    
    /**
     * Test Case 3
     * 
     * >D MMDT^XMWSOA07(.RESULT,3000420.07)
     * >ZW RESULT
     * RESULT="04/20/00@07:00"
      * 
     */
    @Test
    public void testMmdt003() throws VistaWebServiceFault {

    	request.setXmDt("3000420.07");
	
		
		// Execute request against mocked object backend.
		response = service.mmdt(request);
	
		assertNotNull(response);
		assertEquals("04/20/00@07:00", response.getResults());
        
    }
    
    /**
     * Test Case 4
     *
     * >D MMDT^XMWSOA07(.RESULT,3140704.15)
     * >ZW RESULT
     * RESULT="07/04/14@15:00"
     * 
     */
    @Test
    public void testMmdt004() throws VistaWebServiceFault {

    	request.setXmDt("3140704.15");
	
		
		// Execute request against mocked object backend.
		response = service.mmdt(request);
	
		assertNotNull(response);
		assertEquals("07/04/14@15:00", response.getResults());
        
    }

}

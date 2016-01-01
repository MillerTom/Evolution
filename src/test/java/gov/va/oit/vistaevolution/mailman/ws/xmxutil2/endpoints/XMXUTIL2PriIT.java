/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.interfaces.XMA2XmzEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2PriEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2PriRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2PriResponse;
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
/**
 * XMWSOA PRIORITY MSG IND
 * 
 * This RPC returns a value indicating whether the message is priority or
 * not.  If there's an error, it returns an error message.
 * 
 * Input Parameters:
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *  Is the message marked as priority?
 *   0-No
 *   1-Yes
 *   
 */
public class XMXUTIL2PriIT extends EvolutionIT<XMXUTIL2PriEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTIL2PriIT.class);

	@Override
	protected Class<XMXUTIL2PriEndpoint> getType() {
		return XMXUTIL2PriEndpoint.class;
	}
    
	private XMXUTIL2PriRequest request;
	private XMXUTIL2PriResponse response;

	@Before
	public void setUp() {
		request = new XMXUTIL2PriRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

    /**
     * Test Case 1
     * 
     *  Testing of a message IEN that does not exist
     *  
     *  >D PRI^XMWSOA07(.RESULT,72522)
     *  >ZW RESULT
     *  RESULT="-1^Message not found"
     * 
     */
    @Test
    public void testPri001() throws VistaWebServiceFault {

    	request.setXmz("72522");
		
		// Execute request against mocked object backend.
		response = service.xmxutil2Pri(request);
	
		assertNotNull(response);
		assertEquals("-1^Message not found", response.getResults());
        
    }

    /**
     * Test Case 2
     * 
     * Testing of a message IEN that is a priority message
     * 
     * >D PRI^XMWSOA07(.RESULT,73766)
     * >ZW RESULT
     * RESULT=1
     * 
     */
    @Test
    public void testPri002() throws VistaWebServiceFault {

    	request.setXmz("73766");
		
		// Execute request against mocked object backend.
		response = service.xmxutil2Pri(request);
	
		assertNotNull(response);
		assertEquals("1", response.getResults());
        
    }
    
    /**
     * Test Case 3
     * 
     * Testing of a message IEN that is not a priority message
     * 
     * >D PRI^XMWSOA07(.RESULT,73209)
     * >ZW RESULT
     * RESULT=0
     * 
     */
    @Test
    public void testPri003() throws VistaWebServiceFault {

    	request.setXmz("73209");
		
		// Execute request against mocked object backend.
		response = service.xmxutil2Pri(request);
	
		assertNotNull(response);
		assertEquals("0", response.getResults());
        
    }

}

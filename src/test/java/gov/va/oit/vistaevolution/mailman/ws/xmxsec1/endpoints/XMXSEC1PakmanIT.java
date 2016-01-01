/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1PakmanEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanResponse;
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
/**
 * XMWSOA IS MSG PAKMAN
 * 
 * This RPC returns a value indicating whether a message is a PackMan message
 * or not (0 = No; 1 = Yes).  If there's an error, it returns an error
 * message.
 * 
 * Input Parameters:
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *   0-No, the message is not a PackMan message.
 *   1-Yes, the message is a PackMan message.
 *   
 */
public class XMXSEC1PakmanIT extends EvolutionIT<XMXSEC1PakmanEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXSEC1PakmanIT.class);

	@Override
	protected Class<XMXSEC1PakmanEndpoint> getType() {
		return XMXSEC1PakmanEndpoint.class;
	}
    
	private XMXSEC1PakmanRequest request;
	private XMXSEC1PakmanResponse response;

	@Before
	public void setUp() {
		request = new XMXSEC1PakmanRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

    /**
     * Test Case 1
     * 
     * Test with a message IEN that does not exist
     * 
     * >D PAKMAN^XMWSOA07(.RESULT,2)
     * >ZW RESULT
     * RESULT="-1^Message not found"
     * 
     */
    @Test
    public void testPakman001() throws VistaWebServiceFault {

    	request.setXmz("2");
		
		// Execute request against mocked object backend.
		response = service.xmxsec1Pakman(request);
	
		assertNotNull(response);
		assertEquals("-1^Message not found", response.getResults());
        
    }
    /**
     * Test Case 2
     * 
     * Test with a message IEN that is not a pakman message
     * 
     * >D PAKMAN^XMWSOA07(.RESULT,58880)
     * >ZW RESULT
     * RESULT=0
     * 
     */
    @Test
    public void testPakman002() throws VistaWebServiceFault {

    	request.setXmz("58880");
		
		// Execute request against mocked object backend.
		response = service.xmxsec1Pakman(request);
	
		assertNotNull(response);
		assertEquals("0", response.getResults());
        
    }

    /**
     * Test Case 3
     * 
     * Test with a message IEN that is a pakman message
     * 
     * >D PAKMAN^XMWSOA07(.RESULT,59022)
     * >ZW RESULT
     * RESULT=1
     * 
     */
    @Test
    public void testPakman003() throws VistaWebServiceFault {

    	request.setXmz("59022");
		
		// Execute request against mocked object backend.
		response = service.xmxsec1Pakman(request);
	
		assertNotNull(response);
		assertEquals("1", response.getResults());
        
    }

}

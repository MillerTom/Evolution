/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.interfaces.XMA2XmzEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2NewEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewResponse;
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
 * XMWSOA NEW MSG INDICATOR

 * This extrinsic function returns a value indicating whether or not a
 * message is new for this user in this basket.  If there's an error, it
 * returns an error message.
 * 
 * Input Parameters:
 *   XMDUZ	(Required) DUZ of user
 *   XMK	(Required) Internal Entry Number (IEN) of basket.
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *  0-No
 *  1-Yes
 *   
 */
public class XMXUTIL2NewIT extends EvolutionIT<XMXUTIL2NewEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTIL2NewIT.class);

	@Override
	protected Class<XMXUTIL2NewEndpoint> getType() {
		return XMXUTIL2NewEndpoint.class;
	}
    
	private XMXUTIL2NewRequest request;
	private XMXUTIL2NewResponse response;

	@Before
	public void setUp() {
		request = new XMXUTIL2NewRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

    /**
     * Test Case 1
     * 
     * Look for message 59111 in mailbox 1 of user .5
     * 
     * >D NEW^XMWSOA07(.RESULT,.5,1,59111)
     * >ZW RESULT
     * RESULT=1
     * 
     */
    @Test
    public void testNew001() throws VistaWebServiceFault {

    	request.setXmDuz(".5");
    	request.setXmk("1");
    	request.setXmz("59111");
		
		// Execute request against mocked object backend.
		response = service.xmxutil2New(request);
	
		assertNotNull(response);
		assertEquals("1", response.getResults());
        
    }
    
    /**
     * Test Case 2
     * 
     * Look for message 59111 in mailbox .5 of user .5
     * 
     * >D NEW^XMWSOA07(.RESULT,.5,.5,59111)
     * >ZW RESULT
     * RESULT=0
     * 
     */
    @Test
    public void testNew002() throws VistaWebServiceFault {

    	request.setXmDuz(".5");
    	request.setXmk(".5");
    	request.setXmz("59111");
		
		// Execute request against mocked object backend.
		response = service.xmxutil2New(request);
	
		assertNotNull(response);
		assertEquals("0", response.getResults());
        
    }
    /**
     * Test Case 3
     *
     * Look for message 59111 in mailbox 55 of user .5
     * 
     * >D NEW^XMWSOA07(.RESULT,.5,55,59111)
     * >ZW RESULT
     * RESULT=0
     * 
     */
    @Test
    public void testNew003() throws VistaWebServiceFault {

    	request.setXmDuz(".5");
    	request.setXmk("55");
    	request.setXmz("59111");
		
		// Execute request against mocked object backend.
		response = service.xmxutil2New(request);
	
		assertNotNull(response);
		assertEquals("0", response.getResults());
        
    }
    
    /**
     * Test Case 4
     *
     * Look for message 59111 in mailbox 55 of user 9999
     * 
     * >D NEW^XMWSOA07(.RESULT,9999,55,59111)
     * >ZW RESULT
     * RESULT=0
     * 
     */
    @Test
    public void testNew004() throws VistaWebServiceFault {

    	request.setXmDuz("9999");
    	request.setXmk("55");
    	request.setXmz("59111");
		
		// Execute request against mocked object backend.
		response = service.xmxutil2New(request);
	
		assertNotNull(response);
		assertEquals("0", response.getResults());
        
    }
    
    /**
     * Test Case 5
     * 
     * Look for message 59111 in mailbox 1 of user .6
     * 
     * >D NEW^XMWSOA07(.RESULT,.6,1,59111)
     * >ZW RESULT
     * RESULT=0
     * 
     */
    @Test
    public void testNew005() throws VistaWebServiceFault {

    	request.setXmDuz(".6");
    	request.setXmk("1");
    	request.setXmz("59111");
		
		// Execute request against mocked object backend.
		response = service.xmxutil2New(request);
	
		assertNotNull(response);
		assertEquals("0", response.getResults());
        
    }

}

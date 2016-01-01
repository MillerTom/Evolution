/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints.interfaces.XMRENTNetEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetResponse;
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
 * XMWSOA NET
 * 
 * This RPC  returns an ^-delimited string of information about a message. If
 * message does not exist, returns null.
 * 
 * Input Parameters:
 *		XMZ		(Required) Message Internal Entry Number (IEN) in the MESSAGE file (#3.9).
 *
 * Response:
 * 		Piece 1: Message date, in the following format: MAY 25, 1999@08:16:00, if
 * 				 local, or as sent, if remote.
 * 		Piece 2: Scramble hint, if any; otherwise null.
 * 		Piece 3: Message from (external).
 * 		Piece 4: Message ID at originating site (XMZ@sitename, if local).
 * 		Piece 5: Message sender, usually surrogate (external).
 * 		Piece 6: Message subject (external).
 * 		Piece 7: Message ID of original message, if this is a reply
 * 				 (XMZ@sitename, if local).
 * 		Piece 8: Message type (Piece 7 of the message's zero node).
 *  	-1^[error text]
 *   
 */
public class XMRENTNetIT extends EvolutionIT<XMRENTNetEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMRENTNetIT.class);

	@Override
	protected Class<XMRENTNetEndpoint> getType() {
		return XMRENTNetEndpoint.class;
	}

	private XMRENTNetRequest request;
	private XMRENTNetResponse response;

	@Before
	public void setUp() {
		request = new XMRENTNetRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

    /**
     * Test Case 1
     * 
     * Retrieve information for message IEN  58880
     * 
     * >D NET^XMWSOA03(.RESULT,58880)
     * 
     * >ZW RESULT
     * RESULT="MAY 04, 2010@20:59:02^^POSTMASTER^58880.3100504@DBITTEST.DBITPRO.COM^^LEX*2.0*69 Installation^^"
     * 
     */
    @Test
    public void testNet001() throws VistaWebServiceFault {

    	request.setXmz("58880");
		
		// Execute request against mocked object backend.
		response = service.xmrentNet(request);
	
		assertNotNull(response);
		assertEquals("MAY 04, 2010@20:59:02^^POSTMASTER^58880.3100504@DBITTEST.DBITPRO.COM^^LEX*2.0*69 Installation^^", response.getResults());
        
    }

    /**
     * Test Case 2
     * 
     * Retrieve information for message IEN  that does not exist
     * 
     * >D NET^XMWSOA03(.RESULT,588)
     * 
     * >ZW RESULT
     * RESULT="-1^Message not found"
     * 
     */
    @Test
    public void testNet002() throws VistaWebServiceFault {

    	request.setXmz("588");
		
		// Execute request against mocked object backend.
		response = service.xmrentNet(request);
	
		assertNotNull(response);
		assertEquals("-1^Message not found", response.getResults());
        
    }

    /**
     * Test Case 3
     * 
     * Retrieve information for message IEN 60024
     * 
     * >D NET^XMWSOA03(.RESULT,60024)
     * 
     * >ZW RESULT
     * RESULT="1 Oct 2010 10:30:23 -0400 (EDT)^^<""National Patch Module""@FORUM.VA.GOV>^52932027.3101001@FORUM.VA.GOV^^Released DG*5.3*817 SEQ #732^^K"
     * 
     */
    @Test
    public void testNet003() throws VistaWebServiceFault {

    	request.setXmz("60024");
		
		// Execute request against mocked object backend.
		response = service.xmrentNet(request);
	
		assertNotNull(response);
		assertEquals("1 Oct 2010 10:30:23 -0400 (EDT)^^<\"National Patch Module\"@FORUM.VA.GOV>^52932027.3101001@FORUM.VA.GOV^^Released DG*5.3*817 SEQ #732^^K", response.getResults());
        
    }

}

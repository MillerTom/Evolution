/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xma2.XMA2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.XMA2XmzEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * Test for Xmz function of XMA2 Webservice
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
public class XMA2XmzTest extends VistaLinkContextTestParent {

	/*
	 * NAME: XMWSOA EN1                        TAG: EN1
	 * 
	 * This RPC calls the XMZ^XMA2 API to create a message stub.  If this
	 * fails, the RPC returns an error message.  If the call was successful,
	 * the RPC then calls the API, EN1^XMD to add text and recipients and send
	 * the message.
	 * 
	 * Returns:
	 *   0^Successful
	 *   -1^Error in required input
	 *   -1^Failed to create message stub
	 *   -1^DUZ not found
	 *   -1^Subject names of this format (1"R"1.N) are RESERVED
	 *   -1^SUBJECT must be at least 3 characters long.
	 *   -1^Entered SUBJECT too long, <number> characters longer than 65.
	 *   -1^Subject cannot contain control characters.
	 *   
	 *   Input Parameters:
	 *   
	 *   DUZ	(Required String) Sender's DUZ.
	 *   MSG	(Required List) An array containing the text to be added to the message.
	 *   XMY    (Required List) Addressee array, XMY(x)="", where x can be:
	 *     			User's DUZ or enough of the user's name for a positive ID. For example:
	 *     	         XMY(1301)="" OR XMY("lastname,first")=""
	 *     		     G.group name (enough for positive ID). For example:
	 *         		 XMY("G.group name")=""
	 *         		 S.server name (enough for positive ID).
	 *         		 D.device name (enough for positive ID).
	 *              Prefix the above (except devices and servers) by:
	 *              	I: for "Information Only" recipient (cannot reply). For example:
	 *                        XMY("I:1301")="" or XMY("I:lastname,first")=""
	 *                  C: for "Copy" recipient (not expected to reply). For example:
	 *                        XMY("C:1301")="" or XMY("C:lastname,first")=""
	 *                  L@datetime: for when (in future) to send to this recipient (datetime
	 *                  	can be anything accepted by VA FileMan). For example:
	 *                  	    XMY("L@25 DEC@0500:1301")="" or XMY("L@1 JAN:lastname,first")="" or
	 *                            XMY("L@2981225.05:1301")=""
	 *                            (Can combine IL@datetime: or CL@datetime:)
	 *             To delete any recipient (including users, groups, devices, and
	 *              	servers, prefix with a hyphen/dash ("-"). For example:
	 *                        XMY(-1301)="" or XMY("-lastname,first")=""
	 *             To address any recipient (including users, groups, devices, and
	 *             		servers) at a remote site, just add the @site name. For example:
	 *             			  XMY(recipient@site name)=""
	 *  XMSUB	(Required String)Subject of the message.  It should be from 3 to 65 characters 
	 *  		in length. If it is less than 3 characters,then three dots ("...") will be appended
	 *  		to it.  If it is more than 65 characters, then it will be truncated.
	 *  		Subject 'Rnnn' is reserved.
	 *  XMSTRIP (Optional String) String containing characters that should be removed from 
	 *  		the message text. The default is none.
	 *  XMDF    (Optional String)If XMDF is defined, addressing restrictions are waived.
	 *  		Addressing restrictions are:
	 *  			> Restrict  "domain closed"
	 *  			> Restrict  "keys required for domain"
	 *  			> Restrict  "may not forward to domain"
	 *  			> Restrict  "may not forward priority mail to groups"
	 *  			> Restrict  "message length restrictions to remote addresses"
	 * 
	 */

	/**
	 * Test Case #2  Successful
	 *
	 * >S MSG(1)="A TEST MESSAGE"
	 * >S MSG(1)="A TEST MESSAGE",MSG(2)="REPEAT THIS IS ONLY A TEST"
	 * >S XMY(83320)="",XMY(83323)="",XMY(83324)=""
	 * >S XMSUB="A RPC CALL TEST MESSAGE"
	 * >D EN1^XMWSOA02(.RETURN,DUZ,.MSG,.XMY,XMSUB)
	 * 
	 * >ZW RETURN
	 * RETURN="0^Successful"
	 * 
	 * IN Basket, 6 messages (1-6), 5 new
	 * *=New/!=Priority.......Subject........................From.....................
	 * *1. DATA UPDATE FOR NDF                              NDF MANAGER
	 * *2. UPDATED INTERACTIONS                             NDF MANAGER
	 * !3. DRUGS UNMATCHED FROM NATIONAL DRUG FILE          NDF MANAGER
	 * *4. INTERACTIONS and ALLERGIES UPDATED               NDF MANAGER
	 * *5. Products with changed classes                    NDF MANAGER
	 *   6. A RPC CALL TEST MESSAGE                          CARPENTER,KEVIN
	 *   IN Basket Message: 1// 6
	 *   
	 *   Subj: A RPC CALL TEST MESSAGE  [#277737] 01/31/14@10:29:05  2 lines
	 *   From: CARPENTER,KEVIN  In 'IN' basket.   Page 1
	 *   -------------------------------------------------------------------------------
	 *   A TEST MESSAGE
	 *   REPEAT THIS IS ONLY A TEST
	 *   
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCreateMessageStub() throws VistaWebServiceFault {

		String testResponse = "0^Successful";

		// Set up the request object
		XMA2XmzRequest request = new XMA2XmzRequest();
		HashMap <String, String> xmys = new HashMap<String, String>();
		ArrayList <String>msgs = new ArrayList<String>();
		
		request.setDuz("10000000218");
	
		msgs.add("A TEST MESSAGE");
		msgs.add("REPEAT THIS IS ONLY A TEST");
		msgs.add("REPEAT T^^^HIS IS ONLY ");
		request.setMsgs(msgs);
	
		xmys.put("83320","");
		xmys.put("83323","");
		xmys.put("83324","");
		request.setXmys(xmys);
		
		request.setXmSub("A RPC CALL TEST MESSAGE");
		request.setXmStrip("");
		request.setXmDf("");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
		testResponse);

		// Setup the endpoint for testing.
		XMA2XmzEndpointImpl xma2XmzEndpoint = new XMA2XmzEndpointImpl(
				getVistaLinkContext(), new XMA2ResponseFactory());

		// Execute request against mocked object backend.
		XMA2XmzResponse response = xma2XmzEndpoint.xmz(request);

		assertEquals(testResponse, response.getResults());
	}

}

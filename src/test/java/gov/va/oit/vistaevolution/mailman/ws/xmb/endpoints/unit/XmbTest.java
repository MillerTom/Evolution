/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmb.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmb.XMBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmb.endpoints.XMBEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Test for XMB function of XMB Webservice
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
public class XmbTest extends VistaLinkContextTestParent {

	/**
	 * XMWSOA XMB
	 * 
	 * This RPC creates and sends a bulletin in the background. The message
	 * number (XMZ) is not returned. The bulletin is sent to the mail
	 * groups defined for the bulletin in the BULLETIN file (#3.6), as well as to
	 * any additional recipients defined in XMY.
	 * 
	 * Input Parameters:
	 * XMDUZ    (Required String)
	 * 			User's DUZ or FREE TEXT.  This is the sender of the message.  If it is
	 * 			not defined, it defaults to DUZ.  If it is FREE TEXT, it must not be more
	 * 			than 70 characters.
	 *
	 * MSG		(Optional List)
	 * 			This is text, in addition to the text defined in the bulletin, to
	 * 			append to the bulletin.
	 *
	 * XMY      (Required List)
	 * 			Recipients, in addition to those defined in the bulletin.
	 * 
	 * XMBULL   (Required String)
	 * 			Full, exact name, of the bulletin. Case is important.
	 * 
	 * XMB		(Optional list)
	 * 			Bulletin parameter(s). For example:
	 * 			XMB(1)=<parm 1>, XMB(2)=<parm 2>, etc.
	 * 
	 * XMDF		(Optional String)
	 * 			If XMDF is defined, addressing restrictions are waived.
	 * 			Addressing restrictions are:
	 * 			  > Restrict  "domain closed"
	 * 			  > Restrict  "keys required for domain"
	 * 			  > Restrict  "may not forward to domain"
	 * 			  > Restrict  "may not forward priority mail to groups"
	 * 			  > Restrict  "message length restrictions to remote addresses"
	 * 
	 * 	XMDT	(Optional String)
	 * 			Date/time (in any format understood by VA FileMan) to send the bulletin.
	 * 			The default is now.
	 * 
	 * Returns:
	 *    0^[Name of Bulletin] if successful
	 *    -1^Error in required input
	 *    -1^Bulletin does not exit
	 *    -1^Operation failed
	 *    
	 */
	
	/**
	 * Test Case #1 Success  
	 *
	 * xmbs (Required List):
	 * 	XMB(1)="JOHN SMITH"
	 * 	XMB(2)="AMY CARTER"
	 * 	XMB(3)="FARMERS INSURANCE"
	 * 
	 * xmys (Required List):
	 * 	XMY(53468)=""
	 * 
	 * 	xmDuz = 53468
	 * 	xmsgs = null
	 * 	xmys = .XMY
	 * 	xmBull = "XUSSPKI SAN"
	 * 	xmbs = .XMB
	 * 	xmDf = null
	 * 	xmDt = null
	 *  
	 * The expected result from RPC Broker is:
	 * 
	 *	RESULT="0^XUSSPKI SAN"
	 *
	 * @throws VistaWebServiceFault
	 */

	public void testResequenceBasket() throws VistaWebServiceFault {
		String testResponse = "0^XUSSPKI SAN";

		// Set up the request object
		XmbRequest xmbRequest = new XmbRequest();
		
		HashMap<String,String> xmyList = new HashMap<String,String>();
		ArrayList<String> xmbList = new ArrayList<String>();
		
		//Set xmys list
		xmyList.put("53468","");
		
		//Set xmbs list
		 xmbList.add("JOHN SMITH");
		 xmbList.add("AMY CARTER");
		 xmbList.add("FARMERS INSURANCE");
		
		//Set Request parameters
		xmbRequest.setXmDuz("53468");
		xmbRequest.setXmys(xmyList);
		xmbRequest.setXmBull("XUSSPKI SAN");
		xmbRequest.setXmbs(xmbList);
	

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Setup the endpoint for testing.
		XMBEndpointImpl xmbEndpoint = new XMBEndpointImpl(
				new XMBResponseFactory(), getVistaLinkContext());

		// Execute request against mocked object backend.
		XmbResponse response = xmbEndpoint.xmb(xmbRequest);

		assertEquals(testResponse, response.getResults());
	}

}

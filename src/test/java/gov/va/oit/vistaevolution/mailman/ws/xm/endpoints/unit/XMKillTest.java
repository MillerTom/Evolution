/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xm.XMResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.XMKillEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillRequest;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * Test for New function of XM Webservice
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
public class XMKillTest extends VistaLinkContextTestParent {

	/**
	 * 
	 * 	 This RPC KILLs any MailMan variables that may be left over from previous calls.
	 * 	 It always returns 0^Successful.
	 * 
	 *  XMWSOA KILL
	 *  
	 *  The variables killed by this RPC are listed below:
	 *  XMV,XMDISPI,XMDUN,XMDUZ,XMPRIV,XMNOSEND,XMERR
	 *  A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,V,W,X,Z,%,%0,%1,%2,%3,%4
	 *  XM,XMA,XMA0,XMAPBLOB,XMB,XMB0
	 *  XMC,XMC0,XMCH,XMCI,XMCL,XMCNT,XMCT
	 *  XMD,XMD0,XMDATE,XMDI,XMDT,XME,XME0,XMF,XMF0,XMG,XMG0
	 *  XMK,XMKM,XMKN,XMI,XMJ
	 *  XML,XMLOAD,XMLOC,XMLOCK,XMM,XMMG,XMN,XMOUT,XM
	 *  XMR,XMRES,XMS,XMSEN,XMSUB
	 *  XMT,XMTYPE,XMU,XMY,XMZ,XMZ1,XMZ2
	 * 
	 * Inputs:
	 *     None
	 *     
	 * Returns:
	 *    0^Successful
	 *  
	 */
	@Test
	public void testXMKill() throws VistaWebServiceFault {
		String testResponse = "0^Successful";

		// Set up the request object
		XMKillRequest request = new XMKillRequest();

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Setup the endpoint for testing.
		XMKillEndpointImpl xmKillEndpoint = new XMKillEndpointImpl(
				new XMResponseFactory(), getVistaLinkContext());

		// Execute request against mocked object backend.
		XMKillResponse response = xmKillEndpoint.kill(request);

		assertEquals(testResponse, response.getResults());
	}

}

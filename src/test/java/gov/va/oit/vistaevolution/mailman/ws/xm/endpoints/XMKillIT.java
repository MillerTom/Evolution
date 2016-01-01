/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints;

import static org.junit.Assert.*;
import gov.va.oit.vistaevolution.mailman.ws.xm.XMResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMKillEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMN1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillRequest;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkStrategy;


/**
 * @author Stephen Combs (stephen.combs@synaptekcorp.com)
 *
 */

/*
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

/**
 * Integration test to insure that the XMWSOA KILL Service is working.
 * 
 * */
public class XMKillIT extends EvolutionIT<XMKillEndpoint>{
	
	private final String EXPECTED_SUCCESS_MESSAGE = "0^Successful";
	private static final Logger LOG = Logger
			.getLogger(XMKillIT.class);
	
	protected Class<XMKillEndpoint> getType()
	{
		return XMKillEndpoint.class;
	}

	@Test
		public void testXMKill001() throws VistaWebServiceFault
		{
			String actual = "";
			
			XMKillRequest xmKillRequest = new XMKillRequest();
			
			try {
					LOG.debug("request object = " + xmKillRequest.toString());
				actual = service.kill(xmKillRequest).getResults();
					LOG.debug("response object = " + actual.toString());
				assertEquals(EXPECTED_SUCCESS_MESSAGE, actual);
			} catch (VistaWebServiceFault e) {

				fail("Failed due to internal error in running the Kill^XM Service.");
					LOG.error("Error encountered while running unit test,jTestKillXM001.",e);
			}
			finally
			{
				xmKillRequest = null;
				actual = "";
			}
		}
}

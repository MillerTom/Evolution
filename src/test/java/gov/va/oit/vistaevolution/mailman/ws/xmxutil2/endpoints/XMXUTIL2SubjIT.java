/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPIAddrNSndEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2SubjEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTIL2SubjIT extends EvolutionIT<XMXUTIL2SubjEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(XMXUTIL2SubjIT.class);
	
	// private static XMXAPIAddrNSndEndpoint msgService;
	
	private static XMXUTIL2SubjRequest request;
	
	// private static XMXAPIAddrNSndRequest msgRequest;

	@Override
	protected Class<XMXUTIL2SubjEndpoint> getType() {
		return XMXUTIL2SubjEndpoint.class;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		// IVistaLinkContext vistaLinkContext = (IVistaLinkContext)applicationContext.getBean("vistaLinkContext");
		
		// msgService = new XMXAPIAddrNSndEndpointImpl(new XMXAPIResponseFactory(), vistaLinkContext);
		
		request = new XMXUTIL2SubjRequest();
		// msgRequest = new XMXAPIAddrNSndRequest();
		// createMsgRequest();
	}

	/*
	private static void createMsgRequest() {
		ArrayList<String> msg = new ArrayList<String>();
		msg.add("ZZ BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios.");
		msg.add("ZZ BASE Test case for API XMXAPI-ADDRNSND");
		
		ArrayList<String> xmto = new ArrayList<String>();
		xmto.add("PROGRAMMER,ONE");
		
		String duz = "1";
		String xmDuz = "1";
		String xmSubj = "XMWSOA GET MSG SUBJECT TEST";
		String xmStrip = "";
		String xmInstr = "I";
		msgRequest  = new XMXAPIAddrNSndRequest();
		msgRequest.setDuz(duz);
		msgRequest.setXmDuz(xmDuz);
		msgRequest.setXmSubj(xmSubj);
		msgRequest.setXmz(msg);
		msgRequest.setXmStrip(xmStrip);
		msgRequest.setXmto(xmto);
		msgRequest.setXmInstr(xmInstr);
	}
	*/
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// msgService = null;
		request = null;
		// msgRequest = null;
	}
	
	@Test
	public void testSubj001() throws VistaWebServiceFault {
		request.setXmzrec("999");
		
		XMXUTIL2SubjResponse response = service.subj(request);
		
		LOGGER.debug("Msg subj: " + response.getSubj());
		
		assertNotNull(response);
		assertTrue(response.getSubj().equals("-1^Message not found"));
	}

	@Test
	public void testSubj002() throws VistaWebServiceFault {
		request.setXmzrec("");
		
		XMXUTIL2SubjResponse response = service.subj(request);
		
		LOGGER.debug("Msg subj: " + response.getSubj());
		
		assertNotNull(response);
		assertTrue(response.getSubj().equals("-1^Error in required input"));
	}

	@Ignore
	@Test
	public void testSubj003() throws VistaWebServiceFault {
		/*
		XMXAPIAddrNSndResponse msgResponse = msgService.AddrNSnd(msgRequest);

		request.setXmzrec(msgResponse.getMsgIen());
		
		XMXUTIL2SubjResponse response = service.subj(request);
		
		LOGGER.debug("Msg subj: " + response.getSubj());
		
		assertNotNull(response);
		assertTrue(response.getSubj().equals("XMWSOA GET MSG SUBJECT TEST"));
		*/
	}
}

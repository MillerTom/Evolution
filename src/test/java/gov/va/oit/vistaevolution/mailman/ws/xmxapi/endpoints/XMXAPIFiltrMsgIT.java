/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIFiltrMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/* XMWSOA FLTRMSGM
 * 
 * This RPC filters messages in a basket.
 * 
 *  NOTE: Only the user or a surrogate can use this API.
 *  
 *  Input Parameters
 * 
 *  DUZ		(Required) String - User's DUZ
 *  XMDUZ   (Required) String -The user (DUZ or name) whose messages are to be filtered.
 *  XMKZA   (Required) List - Identifies messages, using a list array of
 *  						  message numbers (xmz) in the MESSAGE file (#3.9) (xmk must not be
 *  						  specified and ranges are not allowed):
 *  
 *  							List array: ARRAY(1234567)=""
 *  				                        ARRAY(9763213)=""
 *  
 *  Returns (String):
 *  		
 *  <number of messages> filtered or
 *  -1^[error text]
 * 
 */
public class XMXAPIFiltrMsgIT extends EvolutionIT<XMXAPIFiltrMsgEndpoint> {

	@Override
	protected Class<XMXAPIFiltrMsgEndpoint> getType() {
		return XMXAPIFiltrMsgEndpoint.class;
	}

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXAPIFiltrMsgIT.class);

	private XMXAPIFiltrMsgRequest request;
	private XMXAPIFiltrMsgResponse response;

	@Before
	public void setUp() {
		request = new XMXAPIFiltrMsgRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * Test Case #1
	 *
	 * No filters defined
	 * 
	 * >S MSGARR(62950)="",MSGARR(63686)="",MSGARR(63689)=""
	 * >D FLTRMSGM^XMWSOA03(.RESULT,.5,.5,.MSGARR)
	 * 
	 * >ZW RESULT
	 * RESULT="-1^You have no message filters defined."
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testFilterMsg001() throws VistaWebServiceFault {

		HashMap <String, String> xmkzas = new HashMap<String, String>();
		
		request.setDuz(".5");
		request.setXmDuz(".5");
	
		xmkzas.put("62950","");
		xmkzas.put("63686","");
		xmkzas.put("63689","");
		request.setXmkzas(xmkzas);
		
		// Execute request against mocked object backend.
		response = service.filtrMsg(request);
	
		assertNotNull(response);
		assertEquals("-1^You have no message filters defined.", response.getResults());
	}

}

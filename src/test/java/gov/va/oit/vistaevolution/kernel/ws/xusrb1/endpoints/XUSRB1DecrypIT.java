/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1DecrypEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1EncrypEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1DecrypRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1DecrypResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1EncrypRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1EncrypResponse;
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
 * XU SOA ENCRYP
 * 
 * Kernel and the RPC Broker provide encryption functions that can be used to
 * encrypt messages sent between the client and the server.
 * 
 * 
 * Input Variables	
 * 		st1:	(required) The string that needs to be encrypted.
 * 
 * Response
 * 		Returns  Encrypted string.
 *		
 */

public class XUSRB1DecrypIT extends VistaLinkContextITParent {

	private static final Logger LOG = Logger
			.getLogger(XUSRB1DecrypIT.class);

	@Autowired
	private XUSRB1EncrypEndpoint service;

	@Autowired
	private XUSRB1DecrypEndpoint decrypService;

	private XUSRB1EncrypRequest request;
	private XUSRB1EncrypResponse response;

	private XUSRB1DecrypRequest decrypRequest;
	private XUSRB1DecrypResponse decrypResponse;

	@Before
	public void setUp() {
		request = new XUSRB1EncrypRequest();
		decrypRequest = new XUSRB1DecrypRequest();
	}

	@After
	public void tearDown() {
		request = null;
		decrypRequest = null;
	}

	/**
	 * Test Case #1  
	 *
	 * Encryption of HELLO WORLD
	 * 
	 * >D ENCRYP1^XUSOAK1(.RESULT,"HELLO WORLD")
	 * >ZW RESULT
	 * RESULT="$H4GG/0i/uG63"
	 * 
	 * >D DECRYP1^XUSOAK1(.RETURN,RESULT)
	 * >ZW RETURN
	 * RETURN="HELLO WORLD"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncryp001() throws VistaWebServiceFault {
		
		request.setSt1("HELLO WORLD");
        LOG.debug("Request Data: " + request.getSt1());

		// Execute request against mocked object backend.
		response = service.encryp(request);
        LOG.debug("Encrypted Response Data: " + response.getData());
		
		decrypRequest.setSt1(response.getData());
		decrypResponse = decrypService.decryp(decrypRequest);
        LOG.debug("Decrypted Response Data : " + decrypResponse.getData());

		assertNotNull(response);
		assertEquals(decrypResponse.getData(), request.getSt1());

	}

	/**
	 * Test Case #2  
	 *
	 * Enrypt "Sprint 4"
	 * 
	 * >D ENCRYP1^XUSOAK1(.RESULT,"SPRINT 4")
	 * >ZW RESULT
	 * RESULT=" kt=)m,%$'"
	 * 
	 * >D DECRYP1^XUSOAK1(.RETURN,RESULT)
	 * >ZW RETURN
	 * RETURN="SPRINT 4"
	 * 
 	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncryp002() throws VistaWebServiceFault {

		request.setSt1("SPRINT 4");
        LOG.debug("Request Data: " + request.getSt1());

		// Execute request against mocked object backend.
		response = service.encryp(request);
        LOG.debug("Encrypted Response Data: " + response.getData());
		
		decrypRequest.setSt1(response.getData());
		decrypResponse = decrypService.decryp(decrypRequest);
        LOG.debug("Decrypted Response Data : " + decrypResponse.getData());

		assertNotNull(response);
		assertEquals(decrypResponse.getData(), request.getSt1());

	}

	/**
	 * Test Case #3  
	 * 
	 * Encryption of 1234567
	 * 
	 * >D ENCRYP1^XUSOAK1(.RESULT,1234567)
	 * >ZW RESULT
	 * RESULT="&)5yG~qd."
	 * 
	 * >D DECRYP1^XUSOAK1(.RETURN,RESULT)
	 * >ZW RETURN
	 * RETURN=1234567
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncryp003() throws VistaWebServiceFault {

		request.setSt1("1234567");
        LOG.debug("Request Data: " + request.getSt1());

		// Execute request against mocked object backend.
		response = service.encryp(request);
        LOG.debug("Encrypted Response Data: " + response.getData());
		
		decrypRequest.setSt1(response.getData());
		decrypResponse = decrypService.decryp(decrypRequest);
        LOG.debug("Decrypted Response Data : " + decrypResponse.getData());

		assertNotNull(response);
		assertEquals(decrypResponse.getData(), request.getSt1());

	}

	/**
	 * Test Case #4  
	 * Encryption of A
	 * 
	 *  >D ENCRYP1^XUSOAK1(.RESULT,"A")
	 *  >ZW RESULT
	 *	RESULT="$Z,"
	 *	>D DECRYP1^XUSOAK1(.RETURN,RESULT)
	 *  >ZW RETURN
	 *  RETURN="A"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncryp004() throws VistaWebServiceFault {

		request.setSt1("A");
        LOG.debug("Request Data: " + request.getSt1());

		// Execute request against mocked object backend.
		response = service.encryp(request);
        LOG.debug("Encrypted Response Data: " + response.getData());
		
		decrypRequest.setSt1(response.getData());
		decrypResponse = decrypService.decryp(decrypRequest);
        LOG.debug("Decrypted Response Data : " + decrypResponse.getData());

		assertNotNull(response);
		assertEquals(decrypResponse.getData(), request.getSt1());
	}

}

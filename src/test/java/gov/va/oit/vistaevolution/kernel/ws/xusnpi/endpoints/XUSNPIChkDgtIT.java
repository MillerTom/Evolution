/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPIChkDgtEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtResponse;
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
 * XU SOA CHKDGT
 * 
 * This RPC call is used to validate the format of an NPI number, checking the length
 * and if numeric. Also whether the check digit is valid.
 * 
 *  
 * Input Variables	
 * 	XUSNPI1:	(required) The National Provider Identifier.
 * 
 * Response
 * 		If check digit is valid 1, else 0.
 * 
 */

public class XUSNPIChkDgtIT extends EvolutionIT<XUSNPIChkDgtEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSNPIChkDgtIT.class);

	@Override
	protected Class<XUSNPIChkDgtEndpoint> getType() {
		return XUSNPIChkDgtEndpoint.class;
	}

	private XUSNPIChkDgtRequest request;
	private XUSNPIChkDgtResponse response;

	@Before
	public void setUp() {
		request = new XUSNPIChkDgtRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * Test Case #1  
	 *
	 * >D CHKDGT1^XUSOAK1(.RESULT,1234567893)
	 * >ZW RESULT
	 * RESULT=1
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testChkDgt001() throws VistaWebServiceFault {
	String expectedResult = "1";

		request.setXusNpi("1234567893");

		// Execute request against mocked object backend.
		response = service.chkDgt(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getData());
	}
	/**
	 * Test Case #2
	 * 
	 * >D CHKDGT1^XUSOAK1(.RESULT,1234567890)
	 * >ZW RESULT
	 * RESULT=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testChkDgt002() throws VistaWebServiceFault {
	String expectedResult = "0";

		request.setXusNpi("1234567890");

		// Execute request against mocked object backend.
		response = service.chkDgt(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getData());
	}
	/**
	 * Test Case #3  
	 * 
	 * >D CHKDGT1^XUSOAK1(.RESULT,1234567890)
	 * >ZW RESULT
	 * RESULT=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testChkDgt003() throws VistaWebServiceFault {
	String expectedResult = "0";

		request.setXusNpi("1234567890");

		// Execute request against mocked object backend.
		response = service.chkDgt(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getData());
	}
	/**
	 * Test Case #4  
	 * 
	 * >D CHKDGT1^XUSOAK1(.RESULT,1234567891)
	 * >ZW RESULT
	 * RESULT=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testChkDgt004() throws VistaWebServiceFault {
	String expectedResult = "0";

		request.setXusNpi("1234567891");

		// Execute request against mocked object backend.
		response = service.chkDgt(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getData());
	}
	/**
	 * Test Case #5  
	 * 
	 * >D CHKDGT1^XUSOAK1(.RESULT,1234567892)
	 * >ZW RESULT
	 * RESULT=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testChkDgt005() throws VistaWebServiceFault {
	String expectedResult = "0";

		request.setXusNpi("1234567892");

		// Execute request against mocked object backend.
		response = service.chkDgt(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getData());
	}
	/**
	 * Test Case #6  
	 *
	 * >D CHKDGT1^XUSOAK1(.RESULT,1234567893)
	 * >ZW RESULT
	 * RESULT=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testChkDgt006() throws VistaWebServiceFault {
	String expectedResult = "1";

		request.setXusNpi("1234567893");

		// Execute request against mocked object backend.
		response = service.chkDgt(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getData());
	}
	/**
	 * Test Case #7  
	 *
	 * >D CHKDGT1^XUSOAK1(.RESULT,1234567894)
	 * >ZW RESULT
	 * RESULT=1
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testChkDgt007() throws VistaWebServiceFault {
	String expectedResult = "0";

		request.setXusNpi("1234567894");

		// Execute request against mocked object backend.
		response = service.chkDgt(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getData());
	}
	/**
	 * Test Case #8
	 *
	 * >D CHKDGT1^XUSOAK1(.RESULT,12345794)
	 * >ZW RESULT
	 * RESULT=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testChkDgt008() throws VistaWebServiceFault {
	String expectedResult = "0";

		request.setXusNpi("12345794");

		// Execute request against mocked object backend.
		response = service.chkDgt(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getData());
	}

}

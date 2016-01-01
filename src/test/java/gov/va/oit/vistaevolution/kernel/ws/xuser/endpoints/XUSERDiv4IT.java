/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xuser.endpoints.interfaces.XUSERDiv4Endpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Request;
import gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Response;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/**
 * XUS PKI GET UPN
 * 
 * This RPC gets the SUBJECT ALTERNATIVE NAME field from the New Person (#200) 
 * file field 501.2.  It is used to check that the correct PIV card has been 
 * put into the reader. 
 * 
 * Input Parameters:
 *   None
 * 
 * Returns:
 *   String Subject Alternative Name field
 *   
 */

public class XUSERDiv4IT extends EvolutionIT <XUSERDiv4Endpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSERDiv4IT.class);

	@Override
	protected Class<XUSERDiv4Endpoint> getType() {
		return XUSERDiv4Endpoint.class;
	}

	private XUSERDiv4Request request;
	private XUSERDiv4Response response;

	@Before
	public void setUp() {
		request = new XUSERDiv4Request();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/** TODO: AWAITING RPC MODIFICATIONS - Cannot pass a reference to a local variable in java (Leisa)
	 * Test Case #1 
	 * 
	 * Call for a user without any divisions set
	 * 
	 * >D DIV41^XUSOAK1(.RESULT,.XX,.5)
	 * 
	 * >ZW RESULT
	 * RESULT=0
	 * >ZW XX
	 *	
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDiv4001() throws VistaWebServiceFault {
		ArrayList <String> results = new ArrayList <String>();
		results.add("");

		request.setField(".XX");
		request.setIens(".5");

		// Execute request against mocked object backend.
		response = service.div4(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/** TODO: AWAITING RPC MODIFICATIONS - Cannot pass a reference to a local variable in java (Leisa)
	 * Test Case #2
	 * 
	 * Call of a user with multiple divisions
	 * >D DIV41^XUSOAK1(.RESULT,.XX,1)
	 * 
	 *  >ZW RESULT
	 *  RESULT=1
	 *  
	 *  >ZW XX
	 *  XX(500)=1
	 *  XX(515)=""
	 *  XX(526)=""
	 *  XX(578)=""
	 *  XX(664)=""
	 *  XX(758)=""
	 *	
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDiv4002() throws VistaWebServiceFault {
		ArrayList <String> results = new ArrayList <String>();
		results.add("");

		request.setField(".XX");
		request.setIens("1");

		// Execute request against mocked object backend.
		response = service.div4(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

	/** TODO: AWAITING RPC MODIFICATIONS - Cannot pass a reference to a local variable in java (Leisa)
	 * Test Case #3
	 *
	 * Call to a user with only one division
	 * 
	 *  >D DIV41^XUSOAK1(.RESULT,.XX,10000000187)
	 *  
	 *  >ZW RESULT
	 *  RESULT=1
	 *  
	 *  >ZW XX
	 *  XX(500)=""
	 *	
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDiv4003() throws VistaWebServiceFault {
		ArrayList <String> results = new ArrayList <String>();
		results.add("");

		request.setField(".XX");
		request.setIens("10000000187");

		// Execute request against mocked object backend.
		response = service.div4(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}

}

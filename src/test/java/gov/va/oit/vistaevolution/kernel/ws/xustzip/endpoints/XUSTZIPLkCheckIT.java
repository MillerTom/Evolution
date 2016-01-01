/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xustzip.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.endpoints.interfaces.XUSTZIPLkCheckEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckRequest;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
/**
 * 
 * XU SOA LKCHECK
 *
 *  This agreement allows the VistaLink package to use routine XUSTZIP
 *  to perform checks on Kernel IP/device locking during the VistaLink
 *  reauthentication process, which includes support for the login
 *  capabilities of FatKAAT and KAAJEE.
 *   
 * Input Parameters
 * 		LKCHECK1		(Required) IP Address
 * 
 * Response
 * 		Result on failure returns the FileMan date/time
 * 		that the IP address should be locked until.
 * 		
 * 		Result on success returns 0.
 *   
 */

public class XUSTZIPLkCheckIT extends EvolutionIT<XUSTZIPLkCheckEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSTZIPLkCheckIT.class);

	@Override
	protected Class<XUSTZIPLkCheckEndpoint> getType() {
		return XUSTZIPLkCheckEndpoint.class;
	}
	

	private XUSTZIPLkCheckRequest request;
	private XUSTZIPLkCheckResponse response;

	@Before
	public void setUp() {
		request = new XUSTZIPLkCheckRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * Test Case #1  
	 * 
	 *  Test with no parameters
	 *  >K RR D LKCHECK1^XUSOAK1(.RR)ZW RR
	 *  RR=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testLkCheck001() throws VistaWebServiceFault {

		request.setLcheck1("");

		// Execute request against mocked object backend.
		response = service.lkCheck(request);

		assertNotNull(response);
		assertEquals("0", response.getResults());
	}
	/**
	 * Test Case #2  
	 * 
	 * Test with valid IP address
	 * >K RR D LKCHECK1^XUSOAK1(.RR,"127.0.0.1") ZW RR
	 * RR=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testLkCheck002() throws VistaWebServiceFault {

		request.setLcheck1("127.0.0.1");

		// Execute request against mocked object backend.
		response = service.lkCheck(request);

		assertNotNull(response);
		assertEquals("0", response.getResults());
	}
	/**
	 * Test Case #3  
	 *
	 * Test with invalid IP address
	 * >K RR D LKCHECK1^XUSOAK1(.RR,"JUNK") ZW RR
	 * RR=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testLkCheck003() throws VistaWebServiceFault {

		request.setLcheck1("JUNK");

		// Execute request against mocked object backend.
		response = service.lkCheck(request);

		assertNotNull(response);
		assertEquals("0", response.getResults());
	}
	/**
	 * Test Case #4  
	 * 
	 * Test with locked IP address
	 * >D:'$D(DUZ) DUZ^XUP(1) S U="^"
	 * 
	 * >S DIC="^XUSEC(3,",DIC(0)="EZ"
	 * 
	 * >S X="LOCALHOST" D FILE^DICN S DA=+Y W DA
	 * 1
	 * >S DIE=DIC,DR="2///"_$$FMADD^XLFDT($$NOW^XLFDT,,,1) DO ^DIE
	 * 
	 * >K RR D LKCHECK1^XUSOAK1(.RR,"LOCALHOST") ZW RR
	 * RR=1
	 * >S DIK=DIC D ^DIK
	 * >K RR D LKCHECK1^XUSOAK1(.RR,"JUNK") ZW RR
	 * RR=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testLkCheck004() throws VistaWebServiceFault {
		//TODO: Set up test case that returns date/time
		request.setLcheck1("");

		// Execute request against mocked object backend.
		response = service.lkCheck(request);

		assertNotNull(response);
		assertEquals("0", response.getResults());
	}
	
}

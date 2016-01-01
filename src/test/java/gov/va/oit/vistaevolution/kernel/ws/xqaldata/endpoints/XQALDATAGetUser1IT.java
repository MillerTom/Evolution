/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.XQALDATAGetUser1Endpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetUser1Request;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetUser1Response;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/**
 * XU SOA GETUSER
 * 
 * This RPC returns a list of alerts a user needs to see.
 *  
 * Input Parameters
 * 		XUIEN		This is the internal entry number in file 200 (DUZ value) for the desired user.
 * 
 * Output
 * 	Returns a list of alerts that a user needs to see in the array specified by XURET.
 * 
 * array=6
 * array(1)="R  Your task #6752751 stopped because of an error^NO-ID;83194;3140108.154503"
 * array(2)="R  Your task #6752718 stopped because of an error^NO-ID;83194;3140108.151503"
 * array(3)="R  Your task #6752683 stopped because of an error^NO-ID;83194;3140108.144503"
 * array(4)="R  Your task #6752450 stopped because of an error^NO-ID;83194;3140108.141503"
 * array(5)="R  Your task #6752410 stopped because of an error^NO-ID;83194;3140108.134503"
 * array(6)="R  Your task #6752372 stopped because of an error^NO-ID;83194;3140108.131503"
 *   
 */

public class XQALDATAGetUser1IT extends EvolutionIT<XQALDATAGetUser1Endpoint> {

	@Override
	protected Class<XQALDATAGetUser1Endpoint> getType() {
		return XQALDATAGetUser1Endpoint.class;
	}
	
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XQALDATAGetUser1IT.class);

	private XQALDATAGetUser1Request xqaldataGetUser1Request;
	private XQALDATAGetUser1Response xqaldataGetUser1Response;

	@Before
	public void setUp() {
		xqaldataGetUser1Request = new XQALDATAGetUser1Request();
		xqaldataGetUser1Response = new XQALDATAGetUser1Response();
	}

	@After
	public void tearDown() {
		xqaldataGetUser1Request = null;
		xqaldataGetUser1Request = null;
	}

	/**
	 * Test Case #1  
	 *
	 * Test with no parameters
	 * 
	 * >K RR D GETUSER^XUSOAR(.RR)ZW RR
	 * RR=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testGetUser1001() throws VistaWebServiceFault {
		//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
	
		//Set Expected Results
		ArrayList<String> data = new ArrayList<String>();
		data.add("0");
		xqaldataGetUser1Response.setData(data );
		
		xqaldataGetUser1Request.setIen("");
		
	
		xqaldataGetUser1Response = service.getUser1(xqaldataGetUser1Request);
		
		assertNotNull(xqaldataGetUser1Response);
		assertEquals(data.get(0), xqaldataGetUser1Response.getData().get(0));
	}

	/**
	 * Test Case #2  
	 *
	 * Test with a DUZ
	 * 
	 * >S XMDUZ=.6  ; Use the DUZ of SHARED,MAIL
	 * >K RR D GETUSER^XUSOAR(.RR,XMDUZ)ZW RR
	 * RR=0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testGetUser1002() throws VistaWebServiceFault {
		//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)
	
		//Set Expected Results
		List<String> data = new ArrayList<String>();
		xqaldataGetUser1Response.setData(data );
		
		xqaldataGetUser1Request.setIen(".6");
	
		xqaldataGetUser1Response = service.getUser1(xqaldataGetUser1Request);
		
		assertNotNull(xqaldataGetUser1Response);
		assertEquals(data.get(0), xqaldataGetUser1Response.getData().get(0));
	}
	
}

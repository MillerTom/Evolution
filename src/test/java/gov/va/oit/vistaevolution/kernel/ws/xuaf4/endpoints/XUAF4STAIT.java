package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.xml.ws.soap.SOAPFaultException;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4STAEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4STARequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4STAResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XUAF4STAIT extends EvolutionIT<XUAF4STAEndpoint> {
	XUAF4STARequest request;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
	 */
	@Override
	protected Class<XUAF4STAEndpoint> getType() {
		return XUAF4STAEndpoint.class;
	}

	

	@Before
	public void setUp() {
		request = new XUAF4STARequest();

	}

	@After
	public void tearDown() {
		request = null;
	}
	
	/**
	 * – retrieve the station number
	 * 
	 * <pre>
	 * >SET XURET=""
	 * >SET XUIEN=632
	 * >SET U="^"
	 *  
	 * >D STAR^XUSOAR(.XURET,.XUIEN)
	 *  
	 * >ZW XURET
	 * XURET="632"
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveStationNumber() throws VistaWebServiceFault {
		String testResponse = "632";

		request.setIen("632");

		XUAF4STAResponse response = service.sta(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getStationNumber());

	}
	
	/**
	 * retrieve a blank station number from a defined station in the dictionary
	 * 
	 * <pre>
	 * >SET XURET=""
	 * >SET XUIEN=651
	 * >SET U="^"
	 *  
	 * >D STAR^XUSOAR(.XURET,.XUIEN)
	 *  
	 * >ZW XURET
	 * XURET=""
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveBlankStationNumber() throws VistaWebServiceFault {
		String testResponse = "";

		request.setIen("651");

		XUAF4STAResponse response = service.sta(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getStationNumber());

	}

	/**
	 * retrieve a station number using an undefined IEN
	 * 
	 * <pre>
	 * >SET XURET=""
	 * >SET U="^"
	 *  
	 * >D STAR^XUSOAR(.XURET,.XUIEN)
	 *  
	 * >ZW XURET
	 * XURET=""
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveUndefinedIEN() throws VistaWebServiceFault {
		try {
			service.sta(request);
			fail();
		} catch (SOAPFaultException f) {
			// expected
		}catch (VistaWebServiceFault f) {
			// expected
		} catch( Exception e ) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	 * retrieve a station number using an IEN of NULL
	 * 
	 * <pre>
	 * >SET XURET=""
	 * >SET XUIEN=""
	 * >SET U="^"
	 *  
	 * >D STAR^XUSOAR(.XURET,.XUIEN)
	 *  
	 * >ZW XURET
	 * XURET=""
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveNullIEN() throws VistaWebServiceFault {
		String testResponse = "";

		request.setIen("");
		XUAF4STAResponse response = service.sta(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getStationNumber());

	}
	
	/**
	 * retrieve a station number using an IEN that does not exist in the dictionary
	 * 
	 * <pre>
	 * >SET XURET=""
	 * >SET XUIEN=10000
	 * >SET U="^"
	 *  
	 * >D STAR^XUSOAR(.XURET,.XUIEN)
	 *  
	 * >ZW XURET
	 * XURET=""
	 * </pre>
	 * 
	 */
	@Test
	public void testRetrieveNonexistantIEN() throws VistaWebServiceFault {
		String testResponse = "";

		request.setIen("10000");
		XUAF4STAResponse response = service.sta(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getStationNumber());

	}


}

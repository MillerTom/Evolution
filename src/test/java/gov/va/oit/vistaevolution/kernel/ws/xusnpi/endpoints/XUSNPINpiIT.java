/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPINpiEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XUSNPINpiIT extends EvolutionIT<XUSNPINpiEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(XUSNPINpiIT.class);

	/**
	 *  <em>Use Case #1</em>
	 * 
	 * <pre>
	 * No NPI found for  an individual
	 * </pre>
	 */
	@Test
	public void testNpi001() throws VistaWebServiceFault {
		XUSNPINpiRequest request = new XUSNPINpiRequest("Individual_ID", ".6");
		
		XUSNPINpiResponse response = service.npi(request);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertNotNull(response);        
        assertEquals("-1^No NPI found", response.getResponse());
	}

	/**
	 *  <em>Use Case #2</em>
	 * 
	 * <pre>
	 * No NPI found for an organization
	 * </pre>
	 */
	@Test
	public void testNpi002() throws VistaWebServiceFault {
		XUSNPINpiRequest request = new XUSNPINpiRequest("Organization_ID", "999");
		
		XUSNPINpiResponse response = service.npi(request);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertNotNull(response);        
        assertEquals("-1^No NPI found", response.getResponse());
	}

	/**
	 *  <em>Use Case #3</em>
	 * 
	 * <pre>
	 * 
	 * </pre>
	 */
	@Test
	public void testNpi003() throws VistaWebServiceFault {
		XUSNPINpiRequest request = new XUSNPINpiRequest("Individual_ID", ".06");
		
		XUSNPINpiResponse response = service.npi(request);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertNotNull(response);        
        assertEquals("-1^Invalid IEN", response.getResponse());
	}

	/**
	 *  <em>Use Case #4</em>
	 * 
	 * <pre>
	 * Valid lookup for an individual
	 * </pre>
	 */
	@Test
	public void testNpi004() {
		XUSNPINpiRequest request = new XUSNPINpiRequest("Individual_ID", "1");
		
		XUSNPINpiResponse response = service.npi(request);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertNotNull(response);        
        assertEquals("9996611197^3140318^Active", response.getResponse());
	}

	/**
	 *  <em>Use Case #5</em>
	 * 
	 * <pre>
	 * Valid lookup for an organization
	 * </pre>
	 */
	@Test
	public void testNpi005() {
		XUSNPINpiRequest request = new XUSNPINpiRequest("Organization_ID", "21788");
		
		XUSNPINpiResponse response = service.npi(request);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertNotNull(response);        
        assertEquals("9996611205^3140318^Active", response.getResponse());
	}

	/**
	 *  <em>Use Case #6</em>
	 * 
	 * <pre>
	 * Valid lookup for an organization w/ date of interest
	 * </pre>
	 */
	@Test
	public void testNpi006() {
		XUSNPINpiRequest request = new XUSNPINpiRequest("Organization_ID", "21788", "3140318");
		
		XUSNPINpiResponse response = service.npi(request);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertNotNull(response);        
        assertEquals("9996611205^3140318^Active", response.getResponse());
	}

	@Override
	protected Class<XUSNPINpiEndpoint> getType() {
		return XUSNPINpiEndpoint.class;
	}
}

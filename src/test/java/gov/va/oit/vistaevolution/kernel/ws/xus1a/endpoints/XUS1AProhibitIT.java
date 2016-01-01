/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints.interfaces.XUS1AProhibitEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitRequest;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XUS1AProhibitIT extends EvolutionIT<XUS1AProhibitEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(XUS1AProhibitIT.class);
	
	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Indicate a prohibited login time. As long as the test is run between 8 AM and 11 PM, the result should be as indicated below.
	 * </pre>
	 */
	@Test
	public void testProhibit001() throws VistaWebServiceFault {
		XUS1AProhibitRequest request = new XUS1AProhibitRequest("1500", "0800-2300");
	
		XUS1AProhibitResponse response = service.prohibit(request);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertNotNull(response);        
        assertEquals("0^8:00 am thru 11:00 pm", response.getResponse());
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Indicate a non-prohibited login time. As long as this test is not run between 4 AM and 5 AM, the result should be as indicated below.
	 * </pre>
	 */
	@Test
	public void testProhibit002() {
		XUS1AProhibitRequest request = new XUS1AProhibitRequest("1500", "0400-0500");
		
		XUS1AProhibitResponse response = service.prohibit(request);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertNotNull(response);        
        assertEquals("0^4:00 am thru 5:00 am", response.getResponse());
	}

	@Override
	protected Class<XUS1AProhibitEndpoint> getType() {
		return XUS1AProhibitEndpoint.class;
	}
}

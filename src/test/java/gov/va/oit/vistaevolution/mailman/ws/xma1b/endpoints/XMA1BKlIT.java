/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BKlEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XMA1BKlIT extends EvolutionIT<XMA1BKlEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(XMA1BKlIT.class);
	
	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Delete a message from the ‘IN’ basket
	 * </pre>
	 */
	@Test
	public void testKl001() throws VistaWebServiceFault {
		XMA1BKlRequest request = new XMA1BKlRequest();
		
	    request.setXmduz("1");
        request.setXmk("");
        request.setXmz("73767");
        
        XMA1BKlResponse response = this.service.kl(request);
        assertNotNull(response);
        assertTrue(response.getResponse().equalsIgnoreCase("0^Successful"));
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Input Error
	 * </pre>
	 */
	@Test
	public void testKl002() throws VistaWebServiceFault {
		XMA1BKlRequest request = new XMA1BKlRequest();

		request.setXmduz("");
		request.setXmk("");
		request.setXmz("");
		
		XMA1BKlResponse response = service.kl(request);
		
		assertEquals("-1^Error in required input", response.getResponse());
	}

	/**
	 * <em>Use Case #3</em>
	 * 
	 * <pre>
	 * Message not found
	 * </pre>
	 */
	@Test
	public void testKl003() throws VistaWebServiceFault {
		XMA1BKlRequest request = new XMA1BKlRequest();

		request.setXmduz(".5");
        request.setXmk("999");
        request.setXmz("999");
        
        XMA1BKlResponse response = this.service.kl(request);
        assertNotNull(response);
        assertTrue(response.getResponse().equalsIgnoreCase("-1^There is no message in that basket for this user"));        
	}

	@Override
	protected Class<XMA1BKlEndpoint> getType() {
		return XMA1BKlEndpoint.class;
	}
}
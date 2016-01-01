/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBRseqbsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXAPIBRseqbsktIT extends EvolutionIT<XMXAPIBRseqbsktEndpoint> {
	
	private static final Logger LOGGER = Logger
			.getLogger(XMXAPIBRseqbsktIT.class);

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.XMXAPIBRseqbsktEndpointImpl#rseqbskt(gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktRequest)}.
	 */
	@Test
	public void testRseqbskt001() throws VistaWebServiceFault {
		XMXAPIBRseqbsktRequest request = new XMXAPIBRseqbsktRequest("1", "1", "1");
		
		XMXAPIBRseqbsktResponse response = service.rseqbskt(request);
		
		assertNotNull(response);
		
		LOGGER.debug("xmmsg: " + response.getXmmsg());
		
		assertTrue(response.getXmmsg().startsWith("Resequenced"));
	}

	@Test
	public void testRseqbskt002() throws VistaWebServiceFault {
		XMXAPIBRseqbsktRequest request = new XMXAPIBRseqbsktRequest("1", "1", "");
		
		XMXAPIBRseqbsktResponse response = service.rseqbskt(request);
		
		assertNotNull(response);
		
		LOGGER.debug("xmmsg: " + response.getXmmsg());
		
		assertTrue(response.getXmmsg().equalsIgnoreCase("-1^Error in required input"));
	}

	@Test
	public void testRseqbskt003() throws VistaWebServiceFault {
		XMXAPIBRseqbsktRequest request = new XMXAPIBRseqbsktRequest("-9999", "-9999", "1");
		
		XMXAPIBRseqbsktResponse response = service.rseqbskt(request);
		
		assertNotNull(response);
		
		LOGGER.debug("xmmsg: " + response.getXmmsg());
		
		assertTrue(response.getXmmsg().equalsIgnoreCase("-1^DUZ not found"));
	}

	@Override
	protected Class<XMXAPIBRseqbsktEndpoint> getType() {
		return XMXAPIBRseqbsktEndpoint.class;
	}

}

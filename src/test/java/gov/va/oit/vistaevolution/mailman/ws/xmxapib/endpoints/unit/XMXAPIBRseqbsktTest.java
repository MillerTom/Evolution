/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.XMXAPIBRseqbsktEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBRseqbsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

/**
 * @author Christopher Schuck
 *
 */
public class XMXAPIBRseqbsktTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.XMXAPIBRseqbsktEndpointImpl#rseqbskt(gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktRequest)}.
	 */
	@Test
	public void testRseqbskt() {
		String expectedOutput = "Resequenced from 1 to 1947.";
		
		XMXAPIBRseqbsktRequest request = new XMXAPIBRseqbsktRequest("1", "1", "1");
		
		//  Use Mockito to set up vistaLinkContext from parent class to return
		//  proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
				expectedOutput);

		XMXAPIBRseqbsktEndpoint endpoint = new XMXAPIBRseqbsktEndpointImpl(getVistaLinkContext(), new XMXAPIBResponseFactory());
		
		XMXAPIBRseqbsktResponse response = endpoint.rseqbskt(request);
		
		assertNotNull(response);
		assertEquals(expectedOutput, response.getXmmsg());
	}

}

/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2InrespEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InrespEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTIL2InrespTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2InrespEndpointImpl#inresp(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespRequest)}.
	 */
	@Test
	public void testInresp() throws VistaWebServiceFault {
		
		String expectedOutput = "Global ^TMP(\"XMLIST\",4388";
		
		XMXUTIL2InrespRequest request = new XMXUTIL2InrespRequest(".5", "999", "999");
		
		//  Use Mockito to set up vistaLinkContext from parent class to return
		//  proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
				expectedOutput);

		XMXUTIL2InrespEndpoint endpoint = new XMXUTIL2InrespEndpointImpl(getVistaLinkContext(), new XMXUtil2ResponseFactory());
		
		XMXUTIL2InrespResponse response = endpoint.inresp(request);
		
		assertNotNull(response);
		
		assertEquals(expectedOutput, response.getXmir().get(0));
	}

}

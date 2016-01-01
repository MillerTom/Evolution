/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.XMXSEC1SsPrivEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1SsPrivEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXSEC1SsPrivTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.XMXSEC1SsPrivEndpointImpl#sspriv(gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivRequest)}.
	 */
	@Test
	public void testSspriv() {
		String expectedOutput = "0";
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

		XMXSEC1SsPrivEndpoint endpoint = new XMXSEC1SsPrivEndpointImpl(this.getVistaLinkContext(), new XMXSEC1ResponseFactory());
		
		XMXSEC1SsPrivResponse response = endpoint.sspriv(null);
		
		assertNotNull(response);
	}

}

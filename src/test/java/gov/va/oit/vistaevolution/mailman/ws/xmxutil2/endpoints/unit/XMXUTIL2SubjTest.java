/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2SubjEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2SubjEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTIL2SubjTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2SubjEndpointImpl#subj(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjRequest)}.
	 */
	@Test
	public void testSubj() {
		String expectedOutput = "Test Msg";
		
		XMXUTIL2SubjRequest request = new XMXUTIL2SubjRequest("74113");
		
	       //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        XMXUTIL2SubjEndpoint endpoint = new XMXUTIL2SubjEndpointImpl(getVistaLinkContext(), new XMXUtil2ResponseFactory());
        
        XMXUTIL2SubjResponse response = endpoint.subj(request);
        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getSubj());
	}

}

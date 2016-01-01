/**
 * 
 */
package gov.va.oit.vistaevolution.utils.vistalink;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;

import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class IVistaLinkContextTest extends VistaLinkContextTestParent {

	@SuppressWarnings("rawtypes")
	@Test
	public void testInterfaceWithMocks() throws VistaWebServiceFault {
		String rpcName = null;
		LinkedList parameters = null;
		when(getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null))
				.thenReturn("TEST");
		assertEquals("TEST",
				getVistaLinkContext().makeRPCCall(new RPCIdentifier(rpcName), parameters));
		
		assertEquals("TEST",
				getVistaLinkContext().makeRPCCall(new RPCIdentifier(rpcName)));
	}

}

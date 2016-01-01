/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITSubjEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITSubjEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXEDITSubjTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITSubjEndpointImpl#subj(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjRequest)}.
	 */
	@Test
	public void testSubj() throws VistaWebServiceFault {
		String expectedOutput = "0^Successful";
		
		XMXEDITSubjRequest request = new XMXEDITSubjRequest(".5", "INFO TOGGLE TEST");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

		XMXEDITSubjEndpoint endpoint = new XMXEDITSubjEndpointImpl(getVistaLinkContext(), new XMXEDITResponseFactory());
		
		XMXEDITSubjResponse response = endpoint.subj(request);
		
		assertNotNull(response);
		assertTrue(response.getXmim().equals(expectedOutput));
	}

}

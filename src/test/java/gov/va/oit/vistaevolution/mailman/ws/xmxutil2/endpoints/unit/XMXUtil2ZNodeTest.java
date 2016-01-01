package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUtil2ZNodeEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZNodeEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZNodeRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZNodeResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

public class XMXUtil2ZNodeTest extends VistaLinkContextTestParent {
	
	public XMXUtil2ZNodeTest () { super(); }
	/**
	 * <em>What is the message date? 
	 * 
	 *  Get Date only, no time component</em>
	 * 
	 * 
	 * <pre>
				Input Data:
				>Set XMZREC="123"
				>Set XMTIME="0"
				
				Procedure Call:
				
				>S DATA=$$Date^XMXUTIL2(STRING)
				
				Expected Output:
				
				>ZW DATA
				DATA="01/01/2001"

	
	</pre>
	 */
	
	@Test
	public void jtestXMXUtil2ZNode001() throws VistaWebServiceFault {
		String testResponse = "0";	// this is the correct response - leave in ^s
		
		XMXUtil2ZNodeRequest request = new XMXUtil2ZNodeRequest("123");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUtil2ZNodeEndpoint service = new XMXUtil2ZNodeEndpointImpl(new XMXUtil2ResponseFactory(), getVistaLinkContext() );

		XMXUtil2ZNodeResponse response = service.ZNode(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getZeroNode());	// assertEquals(null == input) 
	}	// end test 1
}

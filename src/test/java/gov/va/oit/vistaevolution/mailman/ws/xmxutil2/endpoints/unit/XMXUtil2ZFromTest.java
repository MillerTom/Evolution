package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUtil2ZFromEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZFromEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZFromRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZFromResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XMXUtil2ZFromTest extends VistaLinkContextTestParent {

	
	public XMXUtil2ZFromTest() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	public void jtestXMXUtil2ZFrom001() throws VistaWebServiceFault {
		String testResponse = "From Me";	// this is the correct response - leave in ^s
		
		XMXUtil2ZFromRequest request = new XMXUtil2ZFromRequest("123");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUtil2ZFromEndpoint service = new XMXUtil2ZFromEndpointImpl(new XMXUtil2ResponseFactory(), getVistaLinkContext() );

		XMXUtil2ZFromResponse response = service.ZFrom(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getZfromInfo());	// assertEquals(null == input) 
	}	// end test 1
}

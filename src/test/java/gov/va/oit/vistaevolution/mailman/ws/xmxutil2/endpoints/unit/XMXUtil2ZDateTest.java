package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUtil2ZDateEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZDateEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XMXUtil2ZDateTest extends VistaLinkContextTestParent {

	
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
	public void jtestXMXUtil2ZDate001() throws VistaWebServiceFault {
		String testResponse = "01/01/2001";	// this is the correct response - leave in ^s
		
		XMXUtil2DateRequest request = new XMXUtil2DateRequest("123", "0");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUtil2ZDateEndpoint service = new XMXUtil2ZDateEndpointImpl(new XMXUtil2ResponseFactory(), getVistaLinkContext() );

		XMXUtil2DateResponse response = service.ZDate(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getMsgDate());	// assertEquals(null == input) 
	}	// end test 1
}

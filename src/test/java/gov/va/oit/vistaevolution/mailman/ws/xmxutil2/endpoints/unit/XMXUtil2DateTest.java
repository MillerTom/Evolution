package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUtil2DateEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2DateEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XMXUtil2DateTest extends VistaLinkContextTestParent {

	public XMXUtil2DateTest() {
		super();
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
	public void jtestXMXUtil2Date001() throws VistaWebServiceFault {
		String testResponse = "01/01/2001";	// this is the correct response - leave in ^s
		
		XMXUtil2DateRequest request = new XMXUtil2DateRequest("123", "0");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUtil2DateEndpoint service = new XMXUtil2DateEndpointImpl(new XMXUtil2ResponseFactory(), getVistaLinkContext() );

		XMXUtil2DateResponse response = service.Date(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getMsgDate());	// assertEquals(null == input) 
	}	// end test 1
	
	
	/**
	 * <em>What is the message date? 
	 * 
	 *  Get Date and time component</em>
	 * 
	 * 
	 * <pre>
				Input Data:
				>Set XMZREC="123"
				>Set XMTIME="1"
				
				Procedure Call:
				
				>S DATA=$$Date^XMXUTIL2(STRING)
				
				Expected Output:
				
				>ZW DATA
				DATA="01/01/2001 12:34:56"

	
	</pre>
	 */
	
	@Test
	public void jtestXMXUtil2Date002() throws VistaWebServiceFault {
		String testResponse = "01/01/2001";	// this is the correct response - leave in ^s
		
		XMXUtil2DateRequest request = new XMXUtil2DateRequest("123", "1");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUtil2DateEndpoint service = new XMXUtil2DateEndpointImpl(new XMXUtil2ResponseFactory(), getVistaLinkContext() );

		XMXUtil2DateResponse response = service.Date(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getMsgDate());	// assertEquals(null == input) 
	}	// end test 1
}

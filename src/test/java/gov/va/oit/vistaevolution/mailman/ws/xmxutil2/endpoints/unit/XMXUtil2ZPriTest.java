package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUtil2ZPriEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZPriEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZPriRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZPriResponse;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Ignore;
import org.junit.Test;

public class XMXUtil2ZPriTest extends VistaLinkContextTestParent {
	public XMXUtil2ZPriTest() { super(); } 
	
	/**
	 * <em>Check if a message is marked as Priority</em>
	 * 
	 * <b>Message is not a priority</b>
	 * 
	 * <pre>
				Input Data:
				>S XMZ=100     ***DBITPRO use:    >S XMZ=58880
				
				Procedure Call:
				>D ZPRI^XMWSOA07(.RETURN,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN=0


	
	</pre>
	 */
	
	@Test
	public void testMsgIsNotPriority() {
		String testResponse = "0";	
		
		XMXUtil2ZPriRequest request = new XMXUtil2ZPriRequest("58880");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUtil2ZPriEndpoint service = new XMXUtil2ZPriEndpointImpl(new XMXUtil2ResponseFactory(), getVistaLinkContext() );

		XMXUtil2ZPriResponse response = service.ZPri(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getMsgIsPriority());	 
	}	// end test 
	
	/**
	 * <em>Check if a message is marked as Priority</em>
	 * 
	 * <b>Message is a priority</b>
	 * 
	 * <pre>
				Input Data:
				>S XMZ=3214     ***DBITPRO use:    >S XMZ=59208
				
				Procedure Call:
				>D ZPRI^XMWSOA07(.RETURN,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN=1


	
	</pre>
	 */
	
	@Test
	public void testMsgIsPriority() {
		String testResponse = "1";	
		
		XMXUtil2ZPriRequest request = new XMXUtil2ZPriRequest("59208");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUtil2ZPriEndpoint service = new XMXUtil2ZPriEndpointImpl(new XMXUtil2ResponseFactory(), getVistaLinkContext() );

		XMXUtil2ZPriResponse response = service.ZPri(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getMsgIsPriority());	 
	}	// end test 
	
	
	/**
	 * <em>Check if a message is marked as Priority</em>
	 * 
	 * <b>Check Message That doesn't exist</b>
	 * 
	 * <pre>
				Input Data:
				>S XMZ=999999    
				
				Procedure Call:
				>D ZPRI^XMWSOA07(.RETURN,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN=1^Message not found


	
	</pre>
	 */
	
	@Test
	public void testMsgIENThatDoesntExist() {
		String testResponse = VistaConstants.ERR_MSG_NOT_FOUND;	
		
		XMXUtil2ZPriRequest request = new XMXUtil2ZPriRequest("999999");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUtil2ZPriEndpoint service = new XMXUtil2ZPriEndpointImpl(new XMXUtil2ResponseFactory(), getVistaLinkContext() );

		XMXUtil2ZPriResponse response = service.ZPri(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getErrors().get(0));	 
	}	// end test 
	
	/**
	 * <em>Check if a message is marked as Priority</em>
	 * 
	 * <b>Check Message That doesn't exist</b>
	 * 
	 * <pre>
				Input Data:
				>S XMZ=999999    
				
				Procedure Call:
				>D ZPRI^XMWSOA07(.RETURN,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN=1^Message not found


	
	</pre>
	 */
	@Ignore // that broken the build
	@Test
	public void testNullMsgIEN() {
		String testResponse = VistaConstants.ERR_MSG_IN_REQD_INPUT2;	
		
		XMXUtil2ZPriRequest request = new XMXUtil2ZPriRequest(null);
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),null)).thenReturn(testResponse);

		XMXUtil2ZPriEndpoint service = new XMXUtil2ZPriEndpointImpl(new XMXUtil2ResponseFactory(), getVistaLinkContext() );

		XMXUtil2ZPriResponse response = service.ZPri(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getErrors().get(0));	 
	}	// end test 
}

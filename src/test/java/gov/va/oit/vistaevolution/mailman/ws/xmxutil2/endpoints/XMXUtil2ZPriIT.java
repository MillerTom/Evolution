package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZPriEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZPriRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZPriResponse;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import org.junit.Test;

public class XMXUtil2ZPriIT extends EvolutionIT<XMXUtil2ZPriEndpoint> {
	public XMXUtil2ZPriIT() { super(); } 
	
	@Override
	protected Class<XMXUtil2ZPriEndpoint> getType() {
		return XMXUtil2ZPriEndpoint.class;
	}
	
	XMXUtil2ZPriRequest request;
	XMXUtil2ZPriResponse response;
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
		request = new XMXUtil2ZPriRequest("58880");
		response = service.ZPri(request);
		
		assertNotNull(response);
		assertEquals("0", response.getMsgIsPriority());
		
	}
	
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
		request = new XMXUtil2ZPriRequest("59208");
		response = service.ZPri(request);
		
		assertNotNull(response);
		assertEquals("1", response.getMsgIsPriority());
		
	}
	
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
				RETURN=-1^Message not found


	
	</pre>
	 */
	
	@Test
	public void testMsgIENThatDoesntExist() {
		String testResponse = VistaConstants.ERR_MSG_NOT_FOUND;	
		
		
		request = new XMXUtil2ZPriRequest("999999");
		response = service.ZPri(request);
		
		assertNotNull(response);
		assertEquals(testResponse, response.getErrors().get(0));	 
	}	// end test 
	
	/**
	 * <em>Check if a message is marked as Priority</em>
	 * 
	 * <b>Check Null Message IEN</b>
	 * 
	 * <pre>
				Input Data:
				>S XMZ=""    
				
				Procedure Call:
				>D ZPRI^XMWSOA07(.RETURN,XMZ)
				
				Expected Output:
				>ZW RETURN
				RETURN=-1^Error in required input


	
	</pre>
	 */
	
	@Test
	public void testNullMsgIEN() {
		String testResponse = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, "XMXUtil2ZPri");	
		testResponse = testResponse.replace(VistaConstants.PARAM, "XMZ");
		
		request = new XMXUtil2ZPriRequest("");
		response = service.ZPri(request);
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getErrors().get(0));	 
	}	// end test 
}

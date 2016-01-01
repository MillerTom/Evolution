/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import gov.va.oit.vistaevolution.kernel.ws.xusrb2.XUSRB2ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.XUSRB2UserinfoEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.XUSRB2UserinfoEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Christopher Schuck
 *
 */
public class XUSRB2UserinfoTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.XUSRB2UserinfoEndpointImpl#userinfo(gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoRequest)}.
	 */
	@Test
	public void testUserinfo() throws VistaWebServiceFault {
		
		List<String> ret = new ArrayList<String>();
		
		ret.add(".5");
		
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
        		ret.get(0));
        
        XUSRB2UserinfoEndpoint endpoint 
        	= new XUSRB2UserinfoEndpointImpl(this.getVistaLinkContext(), new XUSRB2ResponseFactory());
        
        XUSRB2UserinfoResponse response = endpoint.userinfo(null);
        
        assertNotNull(response);
        
	}

}

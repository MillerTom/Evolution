/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.apache.log4j.Logger;
import org.junit.Test;

import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.XUSKAAJResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.XUSKAAJUserinfoEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.XUSKAAJUserinfoIT;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces.XUSKAAJUserinfoEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJUserinfoRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJUserinfoResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Christopher Schuck
 *
 */
public class XUSKAAJUserinfoTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";
	
	private static final Logger LOGGER = Logger.getLogger(XUSKAAJUserinfoTest.class);

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.XUSKAAJUserinfoEndpointImpl#userinfo(gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJUserinfoRequest)}.
	 */
	@Test
	public void testUserinfo() throws VistaWebServiceFault {
        
		String expectedOutput = "1";
        
		XUSKAAJUserinfoRequest request = new XUSKAAJUserinfoRequest();
		request.setClientip("72.152.237.118");
		request.setServernm("SDVMRPMSDEV01");

        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
        		expectedOutput);
	
        XUSKAAJUserinfoEndpoint endpoint 
        	= new XUSKAAJUserinfoEndpointImpl(this.getVistaLinkContext(), new XUSKAAJResponseFactory());
        
        XUSKAAJUserinfoResponse response = endpoint.userinfo(request);
        
        assertNotNull(response);
		if (response.getRet() != null && !response.getRet().isEmpty()) {
			// LOGGER.info(response.getRet().get(0));
			for (int i = 0; i < response.getRet().size(); i++) {
				LOGGER.info("ret[" + i + "]: " + response.getRet().get(i));
			}
			assertTrue(response.getRet().get(0).equals("1"));
		} else {
			fail("no response received");
		}
	}

}

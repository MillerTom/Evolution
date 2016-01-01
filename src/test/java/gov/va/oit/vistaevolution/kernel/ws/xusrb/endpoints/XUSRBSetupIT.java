
package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBSetupEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBSetupResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 *
 */
public class XUSRBSetupIT extends VistaLinkContextITParent{
    
	@Autowired
	private XUSRBSetupEndpoint service;

	private XUSRBSetupResponse response;
	
    /**
     * Test Case 1 – Set up user partition for test user's IP address
     * >S XWBTIP="72.152.237.118" D SETUP^XUSRB(.RET)
     *
     * >ZW RET
	    [0]=DBITTEST
		[1]=EVOLUTION
		[2]=EVOLUTION
		[3]=//./nul:3860
		[4]=5
		[5]=0
		[6]=INNOVATION.DOMAIN.GOV
		[7]=0
     */
    
    @Test
    public void testSetup001() {
    	
        String expectedResponse0 = "DBITTEST";
    	String expectedResponse6 = "DBITTEST.DBITPRO.COM";
    	

		try {
			response = service.setup();
		} catch (VistaWebServiceFault e) {
			e.printStackTrace();
		}

		assertNotNull(response);
		assertEquals(expectedResponse0, response.getServerOptionName());
		assertEquals(expectedResponse6, response.getDomain());
		
        
    }
}
